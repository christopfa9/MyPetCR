
SELECT * FROM CLIENTES
SELECT * FROM ADMINISTRADORES
SELECT * FROM VETERINARIOS
GO
-- =============================================
-- Author:		Kristhel Cordero
-- Create date: 2024-05-06
-- Description:	Store Procedures 
-- NOTA: Las passwords se crean automaticamente con los usuarios
-- =============================================

-- ========================= USUARIOS =============================

CREATE PROCEDURE sp_GetUser
    /*
    DESCRIPCI�N: 
    Obtener toda la informaci�n sobre un usuario incluyendo su tipo(admin, cliente, vet, gerente)
    La contrase�a que se ingrese a este sp debe ir encriptada, pues en la bd todo est�
    encriptado.
	CUIDADO!!!!
	-> Dependiendo del tipo de usuario devuelve diferentes cosas
	-> Si el usuario no est� activo(ha sido eliminado) no aparece
	-> Si vamos a manejar esto asi, debemos asegurarnos que cuando se registre un nuevo usuario
	de cualquier tipo, no puede contener el mismo correo que otro
    */
    @Correo nvarchar(200)
	, @Contrase�a nvarchar(40)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @UserType nvarchar(50);
    DECLARE @UserID int;

    IF EXISTS (SELECT 1 FROM ADMINISTRADORES WHERE Correo = @Correo AND Contrase�aActual = @Contrase�a AND Activo=1)
    BEGIN
        SELECT @UserID = IDAdmin FROM ADMINISTRADORES WHERE Correo = @Correo AND Contrase�aActual = @Contrase�a AND Activo=1;
        IF EXISTS (SELECT 1 FROM ADMINISTRADORES WHERE Correo = @Correo AND Contrase�aActual = @Contrase�a AND Gerente = 1 AND Activo=1)
        BEGIN
            SET @UserType = 'Gerente';
        END
        ELSE
        BEGIN
            SET @UserType = 'Administrador';
        END
    END

    ELSE IF EXISTS (SELECT 1 FROM Clientes WHERE Correo = @Correo AND Contrase�aActual = @Contrase�a AND Activo=1)
    BEGIN
        SELECT @UserID = IDClientes FROM Clientes WHERE Correo = @Correo AND Contrase�aActual = @Contrase�a AND Activo=1;
        SET @UserType = 'Cliente';
    END

    ELSE IF EXISTS (SELECT 1 FROM Veterinarios WHERE Correo = @Correo AND Contrase�aActual = @Contrase�a AND Activo=1)
    BEGIN
        SELECT @UserID = IDVet FROM Veterinarios WHERE Correo = @Correo AND Contrase�aActual = @Contrase�a AND Activo=1;
        SET @UserType = 'Veterinario';
    END

    -- Si no se encuentra en ninguna tabla o no est� activo
    ELSE
    BEGIN
        RAISERROR('Usuario no encontrado o contrase�a incorrecta.', 16, 1);
        RETURN;
    END

    -- Seleccionar la informaci�n del usuario seg�n su tipo
    IF @UserType = 'Administrador' OR @UserType = 'Gerente'
    BEGIN
        SELECT @UserType TipoUsuario, * FROM Administradores WHERE IDAdmin = @UserID;
    END
    ELSE IF @UserType = 'Cliente'
    BEGIN
        SELECT @UserType TipoUsuario, * FROM Clientes WHERE IDClientes = @UserID;
    END
    ELSE IF @UserType = 'Veterinario'
    BEGIN
        SELECT @UserType TipoUsuario, * FROM Veterinarios WHERE IDVet = @UserID;
    END
END
GO

CREATE PROCEDURE sp_GetAllUserEmails
    /*
    DESCRIPCI�N: 
    Obtener todos los correos de usuarios registrados en la aplicaci�n 
    */
AS
BEGIN
    SET NOCOUNT ON;

	SELECT Correo
    FROM Administradores
    UNION
    SELECT Correo
    FROM Clientes
    UNION
    SELECT Correo
    FROM Veterinarios;

END
GO

-- CLIENTES =======================================================
CREATE PROCEDURE sp_CreateClient
	/*
	DESCRIPCI�N: 
	Recibe toda la informaci�n necesaria para a�adir un
	nuevo cliente a la base de datos 
	RECORDAR: La contrase�a que ingresa al sp ya debe estar
	encriptada, no ingresar la contrase�a sin encriptar

	*/
	@Nombre nvarchar(50),
	@Apellidos nvarchar(150),
	@Cedula int,
	@Contrase�a nvarchar(40),
	@Correo nvarchar(200),
	@Direccion nvarchar(1500),
	@Telefono int
AS
BEGIN
	
	SET NOCOUNT ON;

	INSERT INTO CLIENTES(Nombre,Apellidos,Cedula,Contrase�aActual,Correo,Direccion,Telefono) VALUES
	(@Nombre, @Apellidos, @Cedula, @Contrase�a, @Correo, @Direccion, @Telefono)
    
END
GO

CREATE PROCEDURE sp_GetClient
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n sobre un cliente incluyendo su contrase�a actual
	La �nica informaci�n que no se proporciona es la contrase�a anterior
	*/
	@IDCliente int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Direccion
	, Telefono 
	FROM CLIENTES 
	WHERE IDClientes=@IDCliente
    
END
GO

CREATE PROCEDURE sp_GetClientByID  --*********
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n sobre un cliente incluyendo su contrase�a actual
	La �nica informaci�n que no se proporciona es la contrase�a anterior
	*/
	@Cedula int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDClientes
	, Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Direccion
	, Telefono 
	FROM CLIENTES 
	WHERE Cedula=@Cedula
    
END
GO

ALTER PROCEDURE sp_GetAllClient
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n (excepto la contrase�a Anterior) sobre todos los clientes
	que posee MyPetCR actualmente
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDClientes
	, Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Direccion
	, Telefono 
	FROM CLIENTES 
	WHERE ACTIVO=1
    
END
GO

CREATE PROCEDURE sp_DeleteClient
	/*
	DESCRIPCI�N: 
	los clientes realmente no se eliminan, pues son FK de otras tablas
	entonces decidimos asignarles estados incactivos en caso de que se requiera eliminarlos
	Esta funcion hace eso, cambiar el estado activo a inactivo
	*/
	@IDCliente int 
AS
BEGIN
	
	SET NOCOUNT ON;

	UPDATE CLIENTES 
	SET ACTIVO=0
	WHERE IDClientes=@IDCliente
    
	UPDATE MASCOTAS
	SET ACTIVO=0
	WHERE IDCliente=@IDCliente
    
END
GO

CREATE PROCEDURE sp_UpdateClient
	/*
	DESCRIPCI�N: 
	Actualiza toda la informaci�n de un cliente excepto sus contrase�as e ID
	para ello existe el sp_UpdateClientPassword
	*/
	@IDCliente int,
	@Nombre nvarchar(50),
	@Apellidos nvarchar(150),
	@Cedula int,
	@Correo nvarchar(200),
	@Direccion nvarchar(1500),
	@Telefono int
AS
BEGIN
	
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE CLIENTES 
		SET Nombre=@Nombre
			, Apellidos=@Apellidos
			, Cedula=@Cedula
			, Correo=@Correo
			, Direccion=@Direccion
			, Telefono=@Telefono
		WHERE IDClientes=@IDCliente

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH

END
GO

CREATE PROCEDURE sp_GetClientPasswords
	/*
	DESCRIPCI�N: 
	Obtiene la contrase�a actual y la contrase�a anterior del cliente
	*/
	@IDCliente int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Contrase�aActual, Contrase�aAnterior
	FROM CLIENTES 
	WHERE IDClientes=@IDCliente
    
END
GO

CREATE PROCEDURE sp_UpdateClientPassword
	/*
	DESCRIPCI�N: 
	Actualiza la contrase�a de un cliente especifico
	*/
	@IDCliente int
	, @NuevaContrase�a nvarchar(40)
AS
BEGIN
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE CLIENTES 
		SET Contrase�aAnterior=Contrase�aActual
		, Contrase�aActual=@NuevaContrase�a
		WHERE IDClientes=@IDCliente

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH

END
GO

-- ADMINISTRADORES =======================================================
SELECT * FROM ADMINISTRADORES

GO

CREATE PROCEDURE sp_DisableAdminAccess
	/*
	DESCRIPCI�N: 
	Desactiva un permiso de un administrador en especifico
		1 -- Registro de usuarios
		2 -- Gesti�n de usuarios 
		3 -- Gesti�n general de veterinarios 
		4 -- Gesti�n general de productos
		5 -- Confirmaci�n y registro de citas 
		6 -- Asignaci�n de personal por cita
	*/
	@IDAdmin int, 
	@IDPermiso int
AS
BEGIN
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE PERMISOS 
		SET Habilitado=0
		WHERE IDAdmin=@IDAdmin AND IDPermiso=@IDPermiso

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH
    
END
GO

CREATE PROCEDURE sp_EnableAdminAccess
	/*
	DESCRIPCI�N: 
	Activa un permiso de un administrador en especifico
		1 -- Registro de usuarios
		2 -- Gesti�n de usuarios 
		3 -- Gesti�n general de veterinarios 
		4 -- Gesti�n general de productos
		5 -- Confirmaci�n y registro de citas 
		6 -- Asignaci�n de personal por cita
	*/
	@IDAdmin int, 
	@IDPermiso int
AS
BEGIN
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE PERMISOS 
		SET Habilitado=1
		WHERE IDAdmin=@IDAdmin AND IDPermiso=@IDPermiso

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH
    
END
GO

CREATE PROCEDURE sp_GetAdminAccess
	/*
	DESCRIPCI�N: 
	Obtener todos los permisos que tiene el administrador
	�nicamente aquellos permisos que si tenga habilitados
	*/
	@IDAdmin int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT TP.NombrePermiso
	FROM PERMISOS P
	INNER JOIN TIPOPERMISO TP ON P.IDPermiso=TP.IDPermiso
	WHERE P.IDAdmin=@IDAdmin AND P.Habilitado=1
    
END
GO

CREATE PROCEDURE sp_CreateAdmin
	/*
	DESCRIPCI�N: 
	Recibe toda la informaci�n necesaria para a�adir un
	nuevo administrador a la base de datos 
	RECORDAR: La contrase�a que ingresa al sp ya debe estar
	encriptada, no ingresar la contrase�a sin encriptar

	*/
	@Nombre nvarchar(50),
	@Apellidos nvarchar(150),
	@Cedula int,
	@Contrase�a nvarchar(40),
	@Correo nvarchar(200),
	@Telefono int
AS
BEGIN
	
	SET NOCOUNT ON;

	INSERT INTO ADMINISTRADORES(Nombre,Apellidos,Cedula,Contrase�aActual,Correo,Telefono,Gerente) VALUES
	(@Nombre, @Apellidos, @Cedula, @Contrase�a, @Correo, @Telefono, 0)

	DECLARE @IDAdmin int 
	SET @IDAdmin = SCOPE_IDENTITY()

	INSERT INTO PERMISOS(IDPermiso, IDAdmin, Habilitado) VALUES 
	(1, @IDAdmin, 1), -- Registro de usuarios
	(2, @IDAdmin, 1), -- Gesti�n de usuarios 
	(3, @IDAdmin, 1), -- Gesti�n general de veterinarios 
	(4, @IDAdmin, 1), -- Gesti�n general de productos
	(5, @IDAdmin, 1), -- Confirmaci�n y registro de citas 
	(6, @IDAdmin, 1) -- Asignaci�n de personal por cita
    
END
GO

CREATE PROCEDURE sp_GetAdmin
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n sobre un administrador incluyendo su contrase�a actual
	La �nica informaci�n que no se proporciona es la contrase�a anterior
	*/
	@IDAdmin int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Telefono
	, Gerente --1: Es el gerente, 0: No es un gerente
	FROM ADMINISTRADORES 
	WHERE IDAdmin=@IDAdmin
    
END
GO


CREATE PROCEDURE sp_GetAllAdmin
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n (excepto la contrase�a Anterior) sobre todos los administradores
	y gerentes que posee MyPetCR actualmente
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDAdmin
	, Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Telefono 
	, Gerente
	FROM ADMINISTRADORES 
	WHERE Activo=1
    
END
GO

CREATE PROCEDURE sp_DeleteAdmin
	/*
	DESCRIPCI�N: 
	los administradores realmente no se eliminan, pues son FK de otras tablas
	entonces decidimos asignarles estados inactivos en caso de que se requiera eliminarlos
	Esta funcion hace eso, cambiar el estado activo a inactivo
	*/
	@IDAdmin int 
AS
BEGIN
	
	SET NOCOUNT ON;

	UPDATE ADMINISTRADORES 
	SET Activo=0
	WHERE IDAdmin=@IDAdmin
    
END
GO

GO
CREATE PROCEDURE sp_UpdateAdmin
	/*
	DESCRIPCI�N: 
	Actualiza toda la informaci�n de un administradores excepto sus contrase�as e ID
	para ello existe el sp_UpdateClientPassword
	*/
	@IDAdmin int,
	@Nombre nvarchar(50),
	@Apellidos nvarchar(150),
	@Cedula int,
	@Correo nvarchar(200),
	@Telefono int
AS
BEGIN
	
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE ADMINISTRADORES 
		SET Nombre=@Nombre
			, Apellidos=@Apellidos
			, Cedula=@Cedula
			, Correo=@Correo
			, Telefono=@Telefono
		WHERE IDAdmin=@IDAdmin

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH

END
GO

CREATE PROCEDURE sp_GetAdminPasswords
	/*
	DESCRIPCI�N: 
	Obtiene la contrase�a actual y la contrase�a anterior del administrador
	*/
	@IDAdmin int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Contrase�aActual, Contrase�aAnterior
	FROM ADMINISTRADORES 
	WHERE IDAdmin=@IDAdmin
    
END
GO

CREATE PROCEDURE sp_UpdateAdminPassword
	/*
	DESCRIPCI�N: 
	Actualiza la contrase�a de un administrador especifico
	*/
	@IDAdmin int
	, @NuevaContrase�a nvarchar(40)
AS
BEGIN
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE ADMINISTRADORES 
		SET Contrase�aAnterior=Contrase�aActual
		, Contrase�aActual=@NuevaContrase�a
		WHERE IDAdmin=@IDAdmin

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH

END
GO

-- VETERINARIOS =======================================================
SELECT * FROM VETERINARIOS
GO

CREATE PROCEDURE sp_CreateVet
	/*
	DESCRIPCI�N: 
	Recibe toda la informaci�n necesaria para a�adir un
	nuevo veterinario a la base de datos 
	RECORDAR: La contrase�a que ingresa al sp ya debe estar
	encriptada, no ingresar la contrase�a sin encriptar

	*/
	@Nombre nvarchar(50),
	@Apellidos nvarchar(150),
	@Cedula int,
	@Contrase�a nvarchar(40),
	@Correo nvarchar(200),
	@Telefono int
AS
BEGIN
	
	SET NOCOUNT ON;

	INSERT INTO VETERINARIOS(Nombre,Apellidos,Cedula,Contrase�aActual,Correo,Telefono) VALUES
	(@Nombre, @Apellidos, @Cedula, @Contrase�a, @Correo, @Telefono)
    
END
GO

CREATE PROCEDURE sp_GetVet
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n sobre un veterinario incluyendo su contrase�a actual
	La �nica informaci�n que no se proporciona es la contrase�a anterior
	*/
	@IDVet int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Telefono 
	FROM VETERINARIOS 
	WHERE IDVet=@IDVet
    
END
GO

CREATE PROCEDURE sp_GetVetByID
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n sobre un veterinario incluyendo su contrase�a actual
	La �nica informaci�n que no se proporciona es la contrase�a anterior
	*/
	@Cedula int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Telefono 
	FROM VETERINARIOS 
	WHERE Cedula=@Cedula
    
END
GO

CREATE PROCEDURE sp_GetAllVet
	/*
	DESCRIPCI�N: 
	Obtener toda la informaci�n (excepto la contrase�a Anterior) sobre todos los veterinarios
	que posee MyPetCR actualmente
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDVet
	, Nombre
	, Apellidos
	, Cedula
	, Contrase�aActual
	, Correo
	, Telefono 
	FROM VETERINARIOS 
	WHERE Activo=1
    
END
GO

CREATE PROCEDURE sp_DeleteVet
	/*
	DESCRIPCI�N: 
	los veterinarios realmente no se eliminan, pues son FK de otras tablas
	entonces decidimos asignarles estados inactivos en caso de que se requiera eliminarlos
	Esta funcion hace eso, cambiar el estado activo a inactivo
	*/
	@IDVet int 
AS
BEGIN
	
	SET NOCOUNT ON;

	UPDATE VETERINARIOS 
	SET Activo=0
	WHERE IDVet=@IDVet
    
END
GO

CREATE PROCEDURE sp_UpdateVet
	/*
	DESCRIPCI�N: 
	Actualiza toda la informaci�n de un veterinario excepto sus contrase�as e ID
	para ello existe el sp_UpdateVetPassword
	*/
	@IDVet int,
	@Nombre nvarchar(50),
	@Apellidos nvarchar(150),
	@Cedula int,
	@Correo nvarchar(200),
	@Telefono int
AS
BEGIN
	
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE VETERINARIOS 
		SET Nombre=@Nombre
			, Apellidos=@Apellidos
			, Cedula=@Cedula
			, Correo=@Correo
			, Telefono=@Telefono
		WHERE IDVet=@IDVet

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH

END
GO

CREATE PROCEDURE sp_GetVetPasswords
	/*
	DESCRIPCI�N: 
	Obtiene la contrase�a actual y la contrase�a anterior del veterinario
	*/
	@IDVet int 
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Contrase�aActual, Contrase�aAnterior
	FROM VETERINARIOS 
	WHERE IDVet=@IDVet
    
END
GO

CREATE PROCEDURE sp_UpdateVetPassword
	/*
	DESCRIPCI�N: 
	Actualiza la contrase�a de un veterinario especifico
	*/
	@IDVet int
	, @NuevaContrase�a nvarchar(40)
AS
BEGIN
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE VETERINARIOS 
		SET Contrase�aAnterior=Contrase�aActual
		, Contrase�aActual=@NuevaContrase�a
		WHERE IDVet=@IDVet

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN
		
		DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH

END
GO

-- =========================== TIENDAS ===============================


CREATE PROCEDURE sp_CreateStore
	/*
	DESCRIPCI�N: 
	Crea una nueva sucursal en la base de datos
	*/
	@Nombre nvarchar(150)
	, @Ubicacion nvarchar(1500)
AS
BEGIN
	
	SET NOCOUNT ON;

	INSERT INTO SUCURSALES(Nombre, Ubicacion) VALUES (@Nombre, @Ubicacion)
    
END
GO

CREATE PROCEDURE sp_GetStore
	/*
	DESCRIPCI�N: 
	Obtiene los datos de una sucursal espec�fica 
	*/
	@IDStore int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT Nombre, Ubicacion 
	FROM SUCURSALES 
	WHERE IDSucursal=@IDStore
    
END
GO

CREATE PROCEDURE sp_GetAllStores
	/*
	DESCRIPCI�N: 
	Obtiene los datos de todas las sucursales con las
	que cuenta MyPetCR en este momento
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDSucursal,Nombre, Ubicacion 
	FROM SUCURSALES 
    WHERE Activo=1
END
GO

ALTER PROCEDURE sp_UpdateStore
	/*
	DESCRIPCI�N: 
	Actualiza todos los datos de una sucursal exceptuando su ID
	*/
	@IDStore int
	, @Nombre nvarchar(150)
	, @Ubicacion nvarchar(1500)
AS
BEGIN
	
	SET NOCOUNT ON;
	BEGIN TRY 
	BEGIN TRAN
		UPDATE SUCURSALES SET Nombre=@Nombre, Ubicacion=@Ubicacion WHERE IDSucursal=@IDStore
    COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN

	DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH
END
GO

CREATE PROCEDURE sp_DeleteStore
	/*
	DESCRIPCI�N: 
	Las tiendas no se eliminan como tal porque son FK de otras
	tablas, entonces decidimos colocarles un estado activo o inactivo 
	Este SP lo que hace es cambiar el estado de activo a inactivo
	*/
	@IDStore int
AS
BEGIN
	
	SET NOCOUNT ON;

	UPDATE SUCURSALES SET Activo=0 WHERE IDSucursal=@IDStore
    
END
GO

-- =========================== MASCOTAS ===============================
SELECT * FROM MASCOTAS

GO

CREATE PROCEDURE sp_CreatePet
	/*
	DESCRIPCI�N: 
	Registrar una nueva mascota en la base de datos
	*/
	@IDCliente int
	, @NombreMascota nvarchar(150)
	, @Edad int -- Con esto tengo duda**
	, @Sexo bit --0: Macho, 1:Hembra
AS
BEGIN
	
	SET NOCOUNT ON;

	INSERT INTO MASCOTAS(IDCliente,Nombre,Edad,Sexo) VALUES (@IDCliente,@NombreMascota,@Edad,@Sexo)
    
END
GO

CREATE PROCEDURE sp_GetPet
	/*
	DESCRIPCI�N: 
	Obtener toda la info de una mascota especifica
	*/
	@IDMascota int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDCliente, Nombre, Edad, Sexo FROM MASCOTAS WHERE IDMascota=@IDMascota
    
END
GO

CREATE PROCEDURE sp_GetClientsPets
	/*
	DESCRIPCI�N: 
	Obtener la info de todas las mascotas de un cliente
	*/
	@IDCliente int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDMascota
	, Nombre
	, Edad
	, Sexo --0: Macho, 1:Hembra
	FROM MASCOTAS 
	WHERE IDCliente=@IDCliente
    
END
GO

CREATE PROCEDURE sp_UpdatePet
	/*
	DESCRIPCI�N: 
	Actualiza toda la informaci�n de la mascota excepto su id y due�o
	*/
	@IDMascota int
	, @Nombre nvarchar(150)
	, @Edad int
	, @Sexo bit --0: Macho, 1:Hembra
AS
BEGIN
	
	SET NOCOUNT ON;
	BEGIN TRY 
	BEGIN TRAN

		UPDATE MASCOTAS SET Nombre=@Nombre, Edad=@Edad, Sexo=@Sexo
		WHERE IDMascota=@IDMascota

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN

	DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH
    
END
GO

CREATE PROCEDURE sp_DeletePet
	/*
	DESCRIPCI�N: 
	Las mascotas no se elminan como tal pues son FK de otras
	tablas entonces tienen un estado activo o inactivo
	Lo que hace este SP es poner a la mascota como inactiva
	*/
	@IDMascota int
AS
BEGIN
	
	SET NOCOUNT ON;

	UPDATE MASCOTAS SET Activo=0 WHERE IDMascota=@IDMascota
    
END
GO

-- =========================== NOTIFICACIONES ===============================
-- (NOTAS GENERALES)
SELECT * FROM NOTIFICACIONES

GO

CREATE PROCEDURE sp_CreateNotification
	/*
	DESCRIPCI�N: 
	Crea una nueva notificacion 
	Tipo de notificacion 
		1: Seguridad
		2: Nueva Cita
		3: Cancelaci�n de Cita
	Descripci�n: Lo que se le vaya a mostrar al user 
	en la pantalla de notificaciones
	*/
	@Tipo int,
	@Descripcion text, 
	@IDCliente int, --Aqui puede ir null en caso de que sea una notificaci�n de seguridad
	@IDVeterinario int --Aqui puede ir null en caso de que sea una notificaci�n de seguridad
AS
BEGIN
	
	SET NOCOUNT ON;

	INSERT INTO NOTIFICACIONES(IDTipo,Descripcion, IDCliente, IDVeterinario) VALUES (@Tipo, @Descripcion, @IDCliente, @IDVeterinario)
    
END
GO

CREATE PROCEDURE sp_GetAllNotifications
	/*
	DESCRIPCI�N: 
	Devuelve todas las notificaciones que se encuentren en ese momento en la Base de datos
	y no han sido leidas por el receptor 
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT N.IDNotificacion
	, T.Nombre Tipo
	, N.Descripcion
	FROM NOTIFICACIONES N
	INNER JOIN TIPOSNOTIFICACIONES T ON T.IDTipo=N.IDTipo
	WHERE Leido=0
    
END
GO

CREATE PROCEDURE sp_GetAllSecurityNotifications
	/*
	DESCRIPCI�N: 
	Devuelve todas las notificaciones de seguridad 
	que se encuentren en ese momento en la Base de datos
	y no han sido leidas por el receptor 
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT N.IDNotificacion
	, N.Descripcion
	FROM NOTIFICACIONES N
	WHERE Leido=0 and N.IDTipo=1
    
END
GO

CREATE PROCEDURE sp_GetAllNewAppointmentNotifications
	/*
	DESCRIPCI�N: 
	Devuelve todas las notificaciones de nueva cita 
	que se encuentren en ese momento en la Base de datos
	y no han sido leidas por el receptor 
	*/
	
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT N.IDNotificacion
	, N.Descripcion
	FROM NOTIFICACIONES N
	WHERE Leido=0 and N.IDTipo=2
    
END
GO

CREATE PROCEDURE sp_GetAllAppointmentCancelsNotifications
	/*
	DESCRIPCI�N: 
	Devuelve todas las notificaciones de cancelaci�n de cita
	que se encuentren en ese momento en la Base de datos
	y no han sido leidas por el receptor 
	*/
	
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT N.IDNotificacion
	, N.Descripcion
	FROM NOTIFICACIONES N
	WHERE Leido=0 and N.IDTipo=3
    
END
GO


CREATE PROCEDURE sp_MarkAsRead
	/*
	DESCRIPCI�N: 
	Las notificaciones no se eliminan como tal, solo se marcan como leidas
	o no leidas. Entonces eso es lo que hace esta funci�n marcar la notificaci�n
	como leida
	*/
	@IDNotificacion int
AS
BEGIN
	
	SET NOCOUNT ON;

	UPDATE NOTIFICACIONES SET Leido=1 WHERE IDNotificacion=@IDNotificacion
    
END
GO

CREATE PROCEDURE sp_UpdateNotification
	/*
	DESCRIPCI�N: 
	Actualiza el tipo y la descripcion de una nota espec�fica
	*/
	@IDNotificacion int
	, @Tipo int
	, @Descripcion text 
AS
BEGIN
	
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE NOTIFICACIONES SET IDTipo=@Tipo, Descripcion=@Descripcion 
		WHERE IDNotificacion=@IDNotificacion

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN

	DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH
    
END
GO

-- =========================== CITAS ===============================
SELECT * FROM CITAS

GO

-- sp que extraiga horas disponibles de un vet y una fecha especifica

ALTER PROCEDURE sp_CreateAppointment
    /*
    DESCRIPCI�N: 
    Agenda una nueva cita (agrega una nueva cita a la base de datos)
    */
    @FechaCita DATE,
    @HoraCita NVARCHAR(6),
    @IDMascota INT,
    @IDVet INT,
    @IDStore INT
AS
BEGIN
    SET NOCOUNT ON;

    BEGIN TRY
        BEGIN TRANSACTION;

        INSERT INTO CITAS (FechaCita, HoraCita, IDMascota, IDVeterinario, IDSucursal) 
        VALUES (@FechaCita, @HoraCita, @IDMascota, @IDVet, @IDStore);

        DECLARE @IDCita INT;
        SET @IDCita = SCOPE_IDENTITY();

        DECLARE @IDCliente INT;
        SELECT @IDCliente = IDCliente
        FROM MASCOTAS
        WHERE IDMascota = @IDMascota;

		DECLARE @Variable datetime
		SET @Variable=GETDATE();

        EXEC sp_CreateNewClientsHistoryEntry @IDCliente, 2, @Variable , @IDCita;

		EXEC sp_CreateNotification 2, 'Se agend� una nueva cita', @IDCliente, @IDVet

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        ROLLBACK TRANSACTION;

        -- Manejo de errores
        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT 
            @ErrorMessage = ERROR_MESSAGE(),
            @ErrorSeverity = ERROR_SEVERITY(),
            @ErrorState = ERROR_STATE();

        -- Lanza el error original para que pueda ser capturado por cualquier c�digo que llame a este procedimiento
        THROW @ErrorSeverity, @ErrorMessage, @ErrorState;
    END CATCH
END
GO

CREATE PROCEDURE sp_GetAppointment
	/*
	DESCRIPCI�N: 
	Extrae la informaci�n de una cita especifica
	*/
	@IDCita int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT FechaCita
	, HoraCita
	, IDMascota
	, IDVeterinario
	, IDSucursal 
	, Completada	--0: No se ha completado la cita 
					--1: Ya se completo la cita
	FROM CITAS 
	WHERE IDCita=@IDCita
    
END
GO

CREATE PROCEDURE sp_GetAllFutureAppointments
	/*
	DESCRIPCI�N: 
	Extrae todas las citas que aun no han sido completadas
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDCita
	, FechaCita
	, HoraCita
	, IDMascota
	, IDVeterinario
	, IDSucursal 
	FROM CITAS 
	WHERE Completada=0
    
END
GO

CREATE PROCEDURE sp_GetAllAppointments
	/*
	DESCRIPCI�N: 
	Extrae todas las citas tanto pasadas como sin completar 
	*/
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDCita
	, FechaCita
	, HoraCita
	, IDMascota
	, IDVeterinario
	, IDSucursal 
	FROM CITAS 
    
END
GO

CREATE PROCEDURE sp_GetAllFutureClientsAppointments
	/*
	DESCRIPCI�N: 
	Extrae todas las citas futuras de las mascotas de un
	cliente en espec�fico
	*/
	@IDCliente int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT C.IDCita
	, C.FechaCita
	, C.HoraCita
	, C.IDMascota
	, C.IDVeterinario
	, C.IDSucursal 
	FROM CITAS C
	INNER JOIN MASCOTAS M ON M.IDMascota=C.IDMascota
	WHERE M.IDCliente=@IDCliente AND Completada=0
    
END
GO

CREATE PROCEDURE sp_GetAllFutureVetsAppointments --***
	/*
	DESCRIPCI�N: 
	Extrae todas las citas futuras asignadas a un
	veterinario en espec�fico
	*/
	@IDVeterinario int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT C.IDCita
	, C.FechaCita
	, C.HoraCita
	, C.IDMascota
	, C.IDVeterinario
	, C.IDSucursal 
	FROM CITAS C
	WHERE C.IDVeterinario=@IDVeterinario AND Completada=0
    
END
GO

CREATE PROCEDURE sp_GetAllFuturePetsAppointments
	/*
	DESCRIPCI�N: 
	Extrae todas las citas futuras de una mascota
	en espec�fico
	*/
	@IDMascota int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDCita
	, FechaCita
	, HoraCita
	, IDMascota
	, IDVeterinario
	, IDSucursal 
	FROM CITAS 
	WHERE IDMascota=@IDMascota AND Completada=0
    
END
GO

CREATE PROCEDURE sp_GetAllPastPetsAppointments
	/*
	DESCRIPCI�N: 
	Extrae todas las citas anteriores de una mascota
	en espec�fico
	*/
	@IDMascota int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT IDCita
	, FechaCita
	, HoraCita
	, IDMascota
	, IDVeterinario
	, IDSucursal 
	FROM CITAS 
	WHERE IDMascota=@IDMascota AND Completada=1
    
END
GO
 

CREATE PROCEDURE sp_UpdateAppointment
	/*
	DESCRIPCI�N: 
	Cambia todos los datos de la cita excepto 
	el IDCita y el IDMascota
	Adem�s, ver sp_CompleteAppointment
	*/
	@IDCita int
	, @FechaCita date
	, @HoraCita time
	, @IDVeterinario int
	, @IDSucursal int 

AS
BEGIN
	
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE CITAS SET FechaCita=@FechaCita, HoraCita=@HoraCita
		, IDVeterinario=@IDVeterinario, IDSucursal=@IDSucursal
		WHERE IDCita=@IDCita

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN

	DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH
    
END
GO

CREATE PROCEDURE sp_CompleteAppointment
	/*
	DESCRIPCI�N: 
	Las citas realmente no se eliminan, pues son parte
	del historial, entonces nada m�s se marcan como completadas
	eso es lo que hace este SP
	Marca la cita como completada
	*/
	@IDCita int

AS
BEGIN
	
	SET NOCOUNT ON;

	BEGIN TRY 
	BEGIN TRAN

		UPDATE CITAS SET Completada=1
		WHERE IDCita=@IDCita

	COMMIT TRAN
	END TRY
	
	BEGIN CATCH
	ROLLBACK TRAN

	DECLARE @ErrorMessage NVARCHAR(4000);
        SELECT @ErrorMessage = ERROR_MESSAGE();
        THROW 50000, @ErrorMessage, 1;

	END CATCH
    
END
GO

-- =========================== HISTORIAL USUARIO ===============================
SELECT * FROM HistorialUsuario
SELECT * FROM CLICKS
SELECT * FROM TipoAccion

INSERT INTO TipoAccion VALUES ('Compras'),('Citas'),('Clicks')

GO 

CREATE PROCEDURE sp_CreateNewClientsHistoryEntry
	/*
	DESCRIPCI�N: 
	Inserta una nueva acci�n en el historial de usuario
	Tipo de acci�n
		1: Compras
		2: Citas
		3: Clicks
	*/
	@IDCliente int
	, @TipoAccion int
	, @Fecha datetime
	, @IDAccion int 
AS
BEGIN
	
	SET NOCOUNT ON;

	INSERT INTO HistorialUsuario(TipoAccion,FechaAccion,IDAccion,IDCliente) VALUES(@TipoAccion,@Fecha,@IDAccion,@IDCliente)
    
END
GO

CREATE PROCEDURE sp_GetUserHistory
	/*
	DESCRIPCI�N: 
	Extrae toda la informacion 
	Tipo de acci�n
		1: Compras
		2: Citas
		3: Clicks
	*/
	@IDCliente int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT NumHistorial
	, TipoAccion
	, FechaAccion
	, IDAccion --(Aqui se coloca el id dependiendo del tipo) 
	--  SI es una agendacion de cita, aqui ir�a el ID de cita
	--  SI es una compra, aqui ir�a el ID de compra
	--  SI es un click, aqui ir�a el IDClick 
	FROM HistorialUsuario 
	WHERE IDCliente=@IDCliente
    
END
GO

CREATE PROCEDURE sp_GetHistoryEntry
	/*
	DESCRIPCI�N: 
	Extrae la informaci�n de una entrada del historial espec�fico
	*/
	@NumHistorial int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT TipoAccion
	, FechaAccion
	, IDAccion --(Aqui se coloca el id dependiendo del tipo) 
	--  SI es una agendacion de cita, aqui ir�a el ID de cita
	--  SI es una compra, aqui ir�a el ID de compra
	--  SI es un click, aqui ir�a el IDClick 
	, IDCliente
	FROM HistorialUsuario 
	WHERE NumHistorial=@NumHistorial
    
END
GO

--Los historiales se hacen automatico, entonces no se puede hacerles update 
-- y como son un historial, tampoco se pueden eliminar :p

CREATE PROCEDURE sp_CreateNewClickHistoryEntry
	/*
	DESCRIPCI�N: 
	Inserta una nueva acci�n de tipo click en el historial de usuario
	es decir, cada vez que se ocupe registrar el click de alguna acci�n que hizo el 
	cliente se llama a este sp
	Tipo de acci�n
		3: Clicks
	*/
	@IDCliente int
	, @Fecha datetime
	, @Descripcion text
AS
BEGIN
	
	SET NOCOUNT ON;
	INSERT INTO CLICKS(Descripcion) VALUES (@Descripcion)

	DECLARE @ClickInstance int 
	SET @ClickInstance = SCOPE_IDENTITY();

	INSERT INTO HistorialUsuario(TipoAccion,FechaAccion,IDAccion,IDCliente) VALUES(3,@Fecha,@ClickInstance,@IDCliente)
    
END
GO

CREATE PROCEDURE sp_GetAllClientsClickHistory
	/*
	DESCRIPCI�N: 
	Obtiene el historial de clicks del Cliente
	Tipo de acci�n
		3: Clicks
	*/
	@IDCliente int
AS
BEGIN
	
	SELECT NumHistorial, FechaAccion, IDAccion 
	FROM HistorialUsuario 
	WHERE TipoAccion=3 AND IDCliente=@IDCliente
    
END
GO