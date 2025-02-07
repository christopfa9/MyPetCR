



---------COMPRAS--------------------
---CREATE-----------------------------------------------------------------------------------------------------
 CREATE PROCEDURE sp_CreatePurchase
 	/*
	DESCRIPCIñN: 
	Crea un encabezado de factura con informacion general.
    Retorna el ID de la Factura que se crea para la posterior 
    agregacion de lineas.
	*/
    @Domicilio BIT,
    @Monto Numeric,
    @IDCliente INT,
    @FormaPago BIT
AS
BEGIN

    -- Insertar en EncabezadoFactura
    INSERT INTO EncabezadoFactura (Domicilio, Monto, IDCliente, CantidadProductos, FechaFactura, FormaPago)
    VALUES (@Domicilio, @Monto, @IDCliente, 0, GETDATE(), @FormaPago);

    -- Obtener el IDFactura reciñn insertado
    PRINT SCOPE_IDENTITY();

END;
GO

--insertar fila-----------------------------------------------------------------------------------------------------

go
CREATE PROCEDURE sp_CreatePurchaseLine
	/*
	DESCRIPCIñN: 
	agrega una una linea a una factura existente (encabezado) 
    con el producto, cantidad y precio TOTAL (coste * cantidad)

    suma la cantidad de producto a la cantidad total del
    encabezado
	*/
	@IDFactura INT,
	@IDProducto INT,
	@Cantidad INT,
	@PrecioTotal Numeric
AS
BEGIN

	BEGIN TRANSACTION;
		INSERT INTO DetalleFacturas( IDFactura, IDProducto, Cantidad, PrecioTotal)
		VALUES (@IDFactura, @IDProducto, @Cantidad, @PrecioTotal);
	
		UPDATE EncabezadoFactura
		SET CantidadProductos = CantidadProductos + @Cantidad
		WHERE IDFactura = @IDFactura;

	Commit transaction;
END;
GO



--GET Factura-----------------------------------------------------------------------------------------------------


CREATE PROCEDURE sp_GetPurchase
	/*
	DESCRIPCIñN: 
	Retorna todos los datos de la tabla del encabezado
    seleccionado por ID
	*/
    @IDFactura int
AS
BEGIN
	SELECT * 
	from EncabezadoFactura EF
	JOIN DetalleFacturas F on F.IDFactura = EF.IDFactura
	where @IDFactura = EF.IDFactura
END;
GO
--UPDATE Encabezado-----------------------------------------------------------------------------------------------------

CREATE PROCEDURE sp_UpdatePurchase
	/*
	DESCRIPCIñN: 
    Modifica los datos de la compra (EncabezadoFactura)
    Unica forma de personalizar la fecha, en caso de una 
    factura no actual.

	!!!Se ingresa unicamente el valor a modificar 
    con el formato: (@FechaFactura = 1)

    si un valor no se va a modificar no es necesario ingresarlo,
    se mantendrá igual que antes del update
	*/
    @IDFactura INT,
    @Domicilio BIT = NULL,
    @Monto numeric = NULL,
    @IDCliente INT = NULL,
    @FechaFactura DATE = NULL,
    @FormaPago BIT = NULL
AS
BEGIN

    UPDATE EncabezadoFactura
    SET Domicilio = COALESCE(@Domicilio, Domicilio),
        Monto = COALESCE(@Monto, Monto),
        IDCliente = COALESCE(@IDCliente, IDCliente),
        FechaFactura = COALESCE(@FechaFactura, FechaFactura),
        FormaPago = COALESCE(@FormaPago, FormaPago)
    WHERE IDFactura = @IDFactura;

END;
GO

--UPDATE Linea-----------------------------------------------------------------------------------------------------

CREATE PROCEDURE sp_UpdatePurchaseLine
	/*
	DESCRIPCIñN: 
    Modifica los datos especificos de la compra (Linea Factura)
    Al final suma los espacios calculados al encabezado de factura

	!!!Se ingresa unicamente el valor a modificar 
    con el formato: (@FechaFactura = 1)

    si un valor no se va a modificar no es necesario ingresarlo,
    se mantendrá igual que antes del update
	*/
    @IDNumeroLinea INT,
    @IDFactura int = NULL,
    @IDProcucto int = NULL,
    @Cantidad INT = NULL,
    @PrecioTotal numeric = NULL
AS
BEGIN
    BEGIN TRANSACTION;

    -- Actualiza EncabezadoFactura, mantiene los originales si se ingresan
    UPDATE DetalleFacturas
    SET IDFactura = COALESCE(@IDFactura, IDFactura),
        IDProducto= COALESCE(@IDProcucto, IDProducto),
        Cantidad = COALESCE(@Cantidad, Cantidad),
        PrecioTotal = COALESCE(@PrecioTotal, PrecioTotal),
		@IDFactura=IDFactura
    WHERE IDNumeroLinea = @IDNumeroLinea;

	UPDATE EncabezadoFactura
		SET CantidadProductos =(SELECT SUM(Cantidad) 
		FROM DetalleFacturas F
		WHERE IDFactura = @IDFactura)


    COMMIT TRANSACTION;
END;
GO


-----------Eliminar una compra-----------------------------------------------------------------------------------------------------

CREATE PROCEDURE sp_DeletePurchase
	/*
	DESCRIPCIñN: 
    Se elimina la compra seleccionada por medio de
    ID de la base de datos (borrado fisico)
	*/
    @IDFactura INT
AS
BEGIN

    BEGIN TRANSACTION;

    BEGIN TRY
        DELETE FROM DetalleFacturas
        WHERE IDFactura = @IDFactura;

        DELETE FROM EncabezadoFactura
        WHERE IDFactura = @IDFactura;

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

        -- Re-lanzar el error para ser manejado por el cñdigo que llama al procedimiento
        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO

-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------PRODUCT-----------------------------------------------------


----CREATE
 	/*
	DESCRIPCIñN: 
	Crea un nuevo producto en la tabla Productos
	*/
CREATE PROCEDURE sp_CreateProduct
    @Nombre Nvarchar(150),
    @Categoria INT,
    @CantidadTotal Numeric,
    @Precio INT
AS
BEGIN

    INSERT INTO PRODUCTOS(NOMBRE, CATEGORIA, CANTIDADTOTAL, PRECIO)
    VALUES (@Nombre, @Categoria, @CantidadTotal, @Precio);
END;
GO


---READ (informacion producto)
CREATE PROCEDURE sp_GetProduct
 	/*
	DESCRIPCIñN: 
	Rotorna todos los datos de un producto especifico
    seleccionado por ID.
	*/
    @IDProducto int
AS
BEGIN
    
    select * from PRODUCTOS 
	where IDProducto= @IDProducto and Categoria<>1
END;
GO


---UPDATE(actualizar datos)


CREATE PROCEDURE sp_UpdateProduct
 	/*
	DESCRIPCIñN: 
    Modifica los datos un producto

	!!!Se ingresa unicamente el valor a modificar 
    con el formato: (@FechaFactura = 1)

    si un valor no se va a modificar no es necesario ingresarlo,
    se mantendrá igual que antes del update
	*/
    @IDProducto INT,
    @Nombre Nvarchar(150) = NULL,
	@Categoria INT=NULL,
    @CantidadTotal INT=NULL,
    @Precio Numeric=NULL
AS
BEGIN

    UPDATE PRODUCTOS
    SET Nombre =COALESCE(@Nombre, Nombre),
        Categoria = COALESCE(@Categoria, Categoria),
        CantidadTotal = COALESCE(@CantidadTotal, CantidadTotal),
        Precio = COALESCE(@Precio, Precio )
    WHERE IDProducto = @IDProducto;
END;
GO


-- DELETE --


CREATE PROCEDURE sp_DeleteProduct
    @IDProducto INT
AS
BEGIN
    -- Iniciar transacciñn
    BEGIN TRANSACTION;

    BEGIN TRY
        -- Eliminar lñneas de factura de la tabla Facturas
        DELETE FROM PRODUCTOS
        WHERE IDProducto = @IDProducto;

        -- Confirmar transacciñn
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        -- Revertir transacciñn en caso de error
        ROLLBACK TRANSACTION;

        -- Manejo de errores
        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT 
            @ErrorMessage = ERROR_MESSAGE(),
            @ErrorSeverity = ERROR_SEVERITY(),
            @ErrorState = ERROR_STATE();

        -- Re-lanzar el error para ser manejado por el cñdigo que llama al procedimiento
        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO


-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------ALMACENamiento-----------------------------------------------------

----------ALMACEN
Drop table Almacen;
CREATE TABLE Almacen (
    IDAlmacen INT IDENTITY(1,1) PRIMARY KEY,
    Ubicacion NVARCHAR(1500) NOT NULL
);

go
---Create
CREATE PROCEDURE sp_CreateAlmacen
    @Ubicacion NVARCHAR(1500)
AS
BEGIN
    INSERT INTO Almacen (Ubicacion)
    VALUES (@Ubicacion);
END;
GO
---Read
CREATE PROCEDURE sp_GetAlmacen
    @IDAlmacen INT
AS
BEGIN
    SELECT IDAlmacen, Ubicacion
    FROM Almacen
    WHERE IDAlmacen = @IDAlmacen;
END;
GO

CREATE PROCEDURE sp_GetAllAlmacenes
AS
BEGIN
    SELECT IDAlmacen, Ubicacion
    FROM Almacen;
END;
GO

---Update
CREATE PROCEDURE sp_UpdateAlmacen
 	/*
	DESCRIPCIñN: 
    Modifica la ubicacion de un almacen
	*/
    @IDAlmacen INT,
    @Ubicacion NVARCHAR(1500)
AS
BEGIN
    UPDATE Almacen
    SET Ubicacion = @Ubicacion
    WHERE IDAlmacen = @IDAlmacen;
END;
GO
---delete

CREATE PROCEDURE sp_DeleteAlmacen
    @IDAlmacen INT
AS
BEGIN
    DELETE FROM Almacen
    WHERE IDAlmacen = @IDAlmacen;
END;
GO



---EXISTENCIAS

---Create
CREATE PROCEDURE sp_CreateStorage
    @IDAlmacen int,
	@IDProductos int,
	@Cantidad int
AS
BEGIN
    INSERT INTO EXISTENCIAS(IDAlmacen, IDProductos, Cantidad)
    VALUES (@IDAlmacen, @IDProductos, @Cantidad);
END;
GO

---read
CREATE PROCEDURE sp_GetStorage 
	@ID int
AS
BEGIN
	SELECT * FROM EXISTENCIAS
	WHERE ID= @ID;
END;

GO

--update

CREATE PROCEDURE sp_UpdateStorage 
 	/*
	DESCRIPCIñN: 
    Modifica los datos una existencia

	!!!Se ingresa unicamente el valor a modificar 
    con el formato: (@FechaFactura = 1)

    si un valor no se va a modificar no es necesario ingresarlo,
    se mantendrá igual que antes del update
	*/
    @IDExistencias INT = NULL,
	@IDAlmacen INT=NULL,
    @IDPRODUCTO INT=NULL,
	@CANTIDAD INT=NULL
AS
BEGIN
    UPDATE EXISTENCIAS
    SET IDAlmacen = COALESCE(@IDAlmacen, IDAlmacen),
	IDProductos = COALESCE(@IDPRODUCTO, IDProductos),
	Cantidad = COALESCE(@CANTIDAD, Cantidad)
    WHERE ID = @IDEXISTENCIAS;
END;
GO

---delete

CREATE PROCEDURE sp_DeleteStorage 
    @ID INT
AS
BEGIN
    DELETE FROM EXISTENCIAS
    WHERE ID = @ID;
END;
GO


-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------RESEñA-----------------------------------------------------


---Create
CREATE PROCEDURE sp_CreateReseña
    @IDProducto INT,
    @Descripcion TEXT,
    @Calificacion INT
AS
BEGIN
    INSERT INTO Reseñas (IDProducto, Descripcion, Calificacion)
    VALUES (@IDProducto, @Descripcion, @Calificacion);
END;
GO



---Read

CREATE PROCEDURE sp_GetReseña
    @IDReseña INT
AS
BEGIN
    SELECT IDReseña, IDProducto, Descripcion, Calificacion
    FROM RESEñAS
    WHERE IDReseña = @IDReseña;
END;
GO


CREATE PROCEDURE sp_GetAllReseñas
AS
BEGIN
    SELECT IDReseña, IDProducto, Descripcion, Calificacion
    FROM RESEñAS;
END;
GO

---UPDATE
CREATE PROCEDURE sp_UpdateReseña

    @IDReseña INT=NULL,
    @IDProducto INT=NULL,
    @Descripcion TEXT=NULL,
    @Calificacion INT=NULL
AS
BEGIN
    UPDATE RESEñAS
    SET IDProducto = COALESCE(@IDProducto,IDProducto),
        Descripcion = COALESCE(@Descripcion,Descripcion),
        Calificacion = COALESCE(@Calificacion,Calificacion)
    WHERE IDReseña =@IDReseña;
END;
GO

---DELETE
CREATE PROCEDURE sp_DeleteReseña
    @IDReseña INT
AS
BEGIN
    DELETE FROM RESEñAS
    WHERE IDReseña = @IDReseña;
END;
GO


-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------Diagnosticos-----------------------------------------------------



CREATE PROCEDURE sp_CreateDiagnostico
    @Descripcion text,
	@IDMascota INT
AS
BEGIN

    -- Insertar en EncabezadoDiagnostico
    INSERT INTO EncabezadoDiagnosticos(Descripcion,FechaDiagnostico,IDMascota)
    VALUES (@Descripcion, GETDATE(),@IDMascota);

    -- Obtener el diagnostico reciñn insertado
    PRINT SCOPE_IDENTITY();

END;
GO

--insertar fila

go
CREATE PROCEDURE sp_CreateLineasDiagnostico
	@IDDiagnostico INT,
	@IDEnfermedad INT
AS
BEGIN

	INSERT INTO LineasDiagnostico (IDDiagnostico, IDEnfermedad)
	VALUES (@IDDiagnostico, @IDEnfermedad);

END;
GO


EXEC sp_CreateDiagnostico '',1;
EXEC sp_CreateLineasDiagnostico 1, 1;

go


--detalles Diagnostico-----------------------------------------------------------------------------------------------------


CREATE PROCEDURE sp_GetDiagnostico
    @IDDiagnostico int
AS
BEGIN
	SELECT * 
	from EncabezadoDiagnosticos ED
	JOIN LineasDiagnostico LD on LD.IDDiagnostico= ED.IDDiagnostico
	where @IDDiagnostico = ED.IDDiagnostico
END;
GO
--UPDATE-----------------------------------------------------------------------------------------------------

CREATE PROCEDURE sp_UpdateDiagnostico
    @IDDiagnostico INT,
	@IDMascota INT = NULL,
    @Descripcion TEXT = NULL,
    @FechaDiagnostico Date = NULL
AS
BEGIN
    -- Iniciar transacciñn
    BEGIN TRANSACTION;

    -- Actualizar EncabezadoFactura con valores proporcionados, mantener los originales si no se proporcionan
    UPDATE EncabezadoDiagnosticos
    SET Descripcion = COALESCE(@Descripcion, Descripcion),
        FechaDiagnostico = COALESCE(@FechaDiagnostico, FechaDiagnostico ),
		IDMascota = COALESCE(@IDMascota,IDMascota)
    WHERE IDDiagnostico = @IDDiagnostico;

    -- Confirmar transacciñn
    COMMIT TRANSACTION;
END;
GO


---------------------updateLinea

CREATE PROCEDURE sp_UpdateDetalleDiagnostico
    @NumLinea INT,
    @IDDiagnostico int = NULL,
    @IDEnfermedad int = NULL
AS
BEGIN
    -- Iniciar transacciñn
    BEGIN TRANSACTION;

    -- Actualizar EncabezadoFactura con valores proporcionados, mantener los originales si no se proporcionan
    UPDATE LineasDiagnostico
    SET IDDiagnostico = COALESCE(@IDDiagnostico, IDDiagnostico),
		IDEnfermedad = COALESCE(@IDEnfermedad, IDEnfermedad)
    WHERE NumLinea = @NumLinea;

    -- Confirmar transacciñn
    COMMIT TRANSACTION;
END;
GO
------------------------------

---------------------------

-----------Eliminar una Diagnostico-----------------------------------------------------------------------------------------------------


CREATE PROCEDURE sp_DeleteDiagnostico
    @IDDiagnostico INT
AS
BEGIN
    -- Iniciar transacciñn
    BEGIN TRANSACTION;

    BEGIN TRY
        -- Eliminar lñneas de factura de la tabla Facturas
		DELETE FROM LineasDiagnostico
		WHERE IDDiagnostico = @IDDiagnostico;

        -- Eliminar el encabezado de la factura de la tabla EncabezadoFactura
        DELETE FROM EncabezadoDiagnosticos
        WHERE IDDiagnostico = @IDDiagnostico;

        -- Confirmar transacciñn
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        -- Revertir transacciñn en caso de error
        ROLLBACK TRANSACTION;

        -- Manejo de errores
        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT 
            @ErrorMessage = ERROR_MESSAGE(),
            @ErrorSeverity = ERROR_SEVERITY(),
            @ErrorState = ERROR_STATE();

        -- Re-lanzar el error para ser manejado por el cñdigo que llama al procedimiento
        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO 




-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------Efermedades-------------------------------------------------


---Create
CREATE PROCEDURE sp_CreateEnfermedad
    @NombreEnfermedad nvarchar(150)
AS
BEGIN
    INSERT INTO ENFERMEDADES(NombreEnfermedad)
    VALUES (@NombreEnfermedad);
END;
GO



---Read

CREATE PROCEDURE sp_GetEnfermedad
    @IDEnfermedad INT
AS
BEGIN
    SELECT *
    FROM ENFERMEDADES
    WHERE IDEnfermedad = @IDEnfermedad;
END;
GO


CREATE PROCEDURE sp_GetAllEnfermedades
AS
BEGIN
    SELECT *
    FROM ENFERMEDADES;
END;
GO

---UPDATE
CREATE PROCEDURE sp_UpdateEnfermedad
    @IDEnfermedad INT=NULL,
    @NombreEnfermedad Nvarchar(150)=NULL
AS
BEGIN
    UPDATE ENFERMEDADES
    SET NombreEnfermedad = COALESCE(@NombreEnfermedad,NombreEnfermedad)
    WHERE IDEnfermedad =@IDEnfermedad;
END;
GO

---DELETE
CREATE PROCEDURE sp_DeleteEnfermedad
    @IDEnfermedad INT
AS
BEGIN
    DELETE FROM ENFERMEDADES
    WHERE IDEnfermedad = @IDEnfermedad;
END;
GO



-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------Recetas-----------------------------------------------------




CREATE PROCEDURE sp_CreateReceta
    @IDMascota INt,
	@IDVet INT
AS
BEGIN

    -- Insertar en EncabezadoDiagnostico
    INSERT INTO EncabezadoReceta(IDVet,FechaReceta,IDMascota)
    VALUES (@IDVet, GETDATE(),@IDMascota);

    -- Obtener el diagnostico reciñn insertado
    PRINT SCOPE_IDENTITY();

END;
GO

--insertar fila

go
CREATE PROCEDURE sp_CreateLineasReceta
	@IDReceta INT,
	@IDMedicamento INT
AS
BEGIN

	INSERT INTO LineasReceta (IDReceta, IDMedicamento)
	VALUES (@IDReceta, @IDMedicamento);

END;
GO

--detalles Diagnostico-----------------------------------------------------------------------------------------------------


CREATE PROCEDURE sp_GetReceta
    @IDReceta int
AS
BEGIN
	SELECT * 
	from EncabezadoReceta ER
	JOIN LineasReceta LR on LR.IDReceta= ER.IDReceta
	where @IDReceta = ER.IDReceta
END;
GO
--UPDATE-----------------------------------------------------------------------------------------------------

CREATE PROCEDURE sp_UpdateReceta
    @IDReceta INT,
	@IDMascota INT = NULL,
    @IDVet TEXT = NULL,
    @FechaReceta Date = NULL
AS
BEGIN
    -- Iniciar transacciñn
    BEGIN TRANSACTION;

    -- Actualizar EncabezadoFactura con valores proporcionados, mantener los originales si no se proporcionan
    UPDATE EncabezadoReceta
    SET IDMascota = COALESCE(@IDMascota, IDMascota),
        FechaReceta = COALESCE(@FechaReceta, FechaReceta ),
		IDVet = COALESCE(@IDVet,IDVet)
    WHERE IDReceta = @IDReceta;

    -- Confirmar transacciñn
    COMMIT TRANSACTION;
END;
GO


---------------------updateLinea

CREATE PROCEDURE sp_UpdateDetalleReceta
    @NumLinea INT,
    @IDReceta int = NULL,
    @IDMedicamento int = NULL
AS
BEGIN
    -- Iniciar transacciñn
    BEGIN TRANSACTION;

    -- Actualizar EncabezadoFactura con valores proporcionados, mantener los originales si no se proporcionan
    UPDATE LineasReceta
    SET IDReceta = COALESCE(@IDReceta, IDReceta),
		IDMedicamento= COALESCE(@IDMedicamento, IDMedicamento)
    WHERE NumLinea = @NumLinea;

    -- Confirmar transacciñn
    COMMIT TRANSACTION;
END;
GO


-----------Eliminar una Diagnostico-----------------------------------------------------------------------------------------------------

CREATE PROCEDURE sp_DeleteDiagnostico
    @IDDiagnostico INT
AS
BEGIN
    -- Iniciar transacciñn
    BEGIN TRANSACTION;

    BEGIN TRY
        -- Eliminar lñneas de factura de la tabla Facturas
		DELETE FROM LineasDiagnostico
		WHERE IDDiagnostico = @IDDiagnostico;

        -- Eliminar el encabezado de la factura de la tabla EncabezadoFactura
        DELETE FROM EncabezadoDiagnosticos
        WHERE IDDiagnostico = @IDDiagnostico;

        -- Confirmar transacciñn
        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        -- Revertir transacciñn en caso de error
        ROLLBACK TRANSACTION;

        -- Manejo de errores
        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT 
            @ErrorMessage = ERROR_MESSAGE(),
            @ErrorSeverity = ERROR_SEVERITY(),
            @ErrorState = ERROR_STATE();

        -- Re-lanzar el error para ser manejado por el cñdigo que llama al procedimiento
        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH;
END;
GO 





-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------Vacunas-----------------------------------------------------


---Create
CREATE PROCEDURE sp_CreateVacuna
    @NombreVacuna nvarchar(150)
AS
BEGIN
    INSERT INTO VACUNAS(Nombre)
    VALUES (@NombreVacuna);
END;
GO



---Read

CREATE PROCEDURE sp_GetVacuna
    @IDVacuna INT
AS
BEGIN
    SELECT *
    FROM VacunaS
    WHERE IDVacuna = @IDVacuna;
END;
GO


CREATE PROCEDURE sp_GetAllVacunas
AS
BEGIN
    SELECT *
    FROM VACUNAS;
END;
GO

---UPDATE
CREATE PROCEDURE sp_UpdateVacuna
    @IDVacuna INT=NULL,
    @NombreVacuna Nvarchar(150)=NULL
AS
BEGIN
    UPDATE VACUNAS
    SET Nombre = COALESCE(@NombreVacuna,Nombre)
    WHERE IDVacuna =@IDVacuna;
END;
GO

---DELETE
CREATE PROCEDURE sp_DeleteVacuna
    @IDVacuna INT
AS
BEGIN
    DELETE FROM VACUNAS
    WHERE IDVacuna = @IDVacuna ;
END;
GO



-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
-----------------------------------------Registro V-----------------------------------------------------


---Create
CREATE PROCEDURE sp_CreateRegistroVacuna
    @IDMascota int,
	@IDVacuna int
	
AS
BEGIN
    INSERT INTO RegistroVacunas(IDMascota,IDVacuna)
    VALUES (@IDMascota,@IDVacuna, GETDATE());
END;
GO



---Read

CREATE PROCEDURE sp_GetRegistroVacuna
    @IDRegistro INT
AS
BEGIN
    SELECT *
    FROM RegistroVacunas
    WHERE IDRegistro = @IDRegistro;
END;
GO


CREATE PROCEDURE sp_GetAllRegistrosVacuna
AS
BEGIN
    SELECT *
    FROM VACUNAS;
END;
GO

---UPDATE
CREATE PROCEDURE sp_UpdateRegistroVacuna
    @IDRegistro INT = NULL,
    @IDMascota INT = NULL,
	@IDVacuna INT = NULL,
	@FechaVacuna Date=NULL
AS
BEGIN
    UPDATE RegistroVacunas
    SET @IDMascota = COALESCE(@IDMascota ,IDMascota),
	@IDVacuna = COALESCE(@IDVacuna,IDVacuna),
	@FechaVacuna = COALESCE(@FechaVacuna,FechaVacuna)

    WHERE @IDRegistro =IDRegistro;
END;
GO

---DELETE
CREATE PROCEDURE sp_DeleteRegistroVacuna
    @IDRegistro INT
AS
BEGIN
    DELETE FROM RegistroVacunas
    WHERE IDRegistro = @IDRegistro ;
END;
GO


