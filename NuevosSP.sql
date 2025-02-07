---------------------------------
---------------------------------
---------------------------------

select * from categoriasp
Insert into CATEGORIASP(NombreCategoria)
values ('Servicio')


----
----
----

go

CREATE PROCEDURE sp_GetProductsPorCategoria
 	/*
	DESCRIPCIñN: 
	Rotorna todos los datos de todos los productos
	que pertenezcan a una categoria especifica
	*/
	@Categoria int
AS
BEGIN
    
    select * from PRODUCTOS 
	where Categoria=@Categoria
END;
GO


CREATE PROCEDURE sp_GetProductsExcepto
 	/*
	DESCRIPCIñN: 
	Rotorna todos los datos de todos los productos
	que no pertenezcan a una categoria especifica
	*/
	@Categoria int
AS
BEGIN
    
    select * from PRODUCTOS 
	where Categoria<>@Categoria
END;
GO



-------------------
-------------------
-------------------

CREATE PROCEDURE sp_GetCategorias
 	/*
	DESCRIPCIñN: 
	Rotorna todas las categorias.
	*/
AS
BEGIN
    
    select * from CATEGORIASP 
END;
GO

-----------------
-----------------
----Expediente--

CREATE PROCEDURE sp_GetDiagnosticosPorMascota
 	/*
	DESCRIPCIñN: 
	Retorna todos los diagnosticos de una mascota seleccionada 
	por ID 
	*/
	@IDMascota int
AS
BEGIN
    
    select * from EncabezadoDiagnosticos
	where @IDMascota = IDMascota
END;
GO

CREATE PROCEDURE sp_GetRecetasPorMascota
 	/*
	DESCRIPCIñN: 
	Retorna todos las recetas de una mascota seleccionada 
	por ID 
	*/
	@IDMascota int
AS
BEGIN
    
    select * from EncabezadoReceta
	where @IDMascota = IDMascota
END;
GO


CREATE PROCEDURE sp_GetRecetasPorMascota
 	/*
	DESCRIPCIñN: 
	Retorna todos las recetas de una mascota seleccionada 
	por ID 
	*/
	@IDMascota int
AS
BEGIN
    
    select * from EncabezadoReceta
	where @IDMascota = IDMascota
END;
GO


--------------------
--------------------
-----Facturas------
CREATE PROCEDURE sp_GetFacturasPorCliente
 	/*
	DESCRIPCIñN: 
	Retorna todos las recetas de una mascota seleccionada 
	por ID 
	*/
	@IDCliente int
AS
BEGIN
    
    select * from EncabezadoFactura
	where @IDCliente = IDCliente
END;
GO

-----------
-----------
--Busuedas esquizofrenicas---
CREATE PROCEDURE sp_GetClientPorNombre
/*
DESCRIPCIÓN: 
Retorna todos los datos de los clientes cuyo nombre
contiene la cadena especificada.
*/ 
    @NombreCliente nvarchar(50)
AS
BEGIN
    SET NOCOUNT ON;

    SELECT * 
    FROM CLIENTES 
    WHERE Nombre LIKE '%' + @NombreCliente + '%';
END;
GO

CREATE PROCEDURE sp_GetMascotaPorNombre
/*
DESCRIPCIÓN: 
Retorna todos los datos de las mascotas cuyo nombre
contiene la cadena especificada.
*/ 
    @NombreMascota nvarchar(150)
AS
BEGIN
    SET NOCOUNT ON;

    SELECT * 
    FROM MASCOTAS 
    WHERE Nombre LIKE '%' + @NombreMascota + '%';
END;
GO


CREATE PROCEDURE sp_GetMascotaPorNombreDuennoYNombreMascota
/*
DESCRIPCIÓN: 
Retorna todos los datos de las mascotas cuyo nombre
de cliente y nombre de mascota contienen la cadena especificada
*/ 
    @NombreCliente nvarchar(50),
	@NombreMascota nvarchar(150)
AS
BEGIN
    SET NOCOUNT ON;

    SELECT IDMascota, M.Nombre as 'Nombre Mascota', C.Nombre as 'Nombre Cliente',C.Apellidos as 'Apellidos del cliente', Edad, Sexo
    FROM CLIENTES C
	JOIN MASCOTAS M on M.IDCliente =C.IDClientes
    WHERE C.Nombre LIKE '%' + @NombreCliente + '%' 
	AND M.Nombre LIKE '%' + @NombreMascota + '%'
	AND M.Activo=1;
END;
GO


---------------
-------------
--------Ventas






CREATE PROCEDURE sp_DescontarStock
/*
DESCRIPCIÓN: 
Elimina del stock los productos vendidos
en su respectiva sucursal y del total
*/ 
    @IDProducto INT,
	@IDSucursal INT,
	@Cantidad	INT

AS
BEGIN


    BEGIN TRY
		BEGIN TRANSACTION;
			UPDATE PRODUCTOS
			SET CantidadTotal = CantidadTotal - @Cantidad
			WHERE IDProducto = @IDProducto;

			UPDATE EXISTENCIAS
			SET Cantidad = Cantidad - @Cantidad
			WHERE IDProductos = @IDProducto AND IDAlmacen = @IDSucursal;

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

        -- Re-lanzar el error para ser manejado por el c�digo que llama al procedimiento
        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO




CREATE PROCEDURE sp_GetCategorias
/*
DESCRIPCIÓN: 
saca la tabla de categorias
*/ 
AS
BEGIN

	Select NombreCategoria from CATEGORIASP
    
END;
GO




/** Object:  StoredProcedure [dbo].[sp_GetAllNotifications]    Script Date: 19/6/2024 00:47:17 **/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[sp_GetAllNotificationsCliente]
	/*
	DESCRIPCIÓN: 
	Devuelve todas las notificaciones esten relacionadas a un cliente
	*/
	@idUsuario int
AS
BEGIN
	
	SET NOCOUNT ON;

	SELECT N.IDNotificacion
	, T.Nombre Tipo
	, N.Descripcion
	, N.Leido
	FROM NOTIFICACIONES N
	INNER JOIN TIPOSNOTIFICACIONES T ON T.IDTipo=N.IDTipo
	WHERE n.IDCliente = @idUsuario
END
GO