
CREATE TABLE PERMISOS (
	Consecutivo int IDENTITY(1,1) PRIMARY KEY
	, IDPermiso int
	, IDAdmin int 
	, Habilitado bit -- 1: Si tiene permiso, 0: no tiene permiso
)

CREATE TABLE TIPOPERMISO (
	IDPermiso int IDENTITY(1,1) PRIMARY KEY
	, NombrePermiso nvarchar(250)
)


CREATE TABLE ADMINISTRADORES (
	IDAdmin int IDENTITY(1,1) PRIMARY KEY
	, Nombre nvarchar(50)
	, Apellidos nvarchar(150)
	, Cedula int unique not null
	, ContraseñaActual nvarchar(40)
	, ContraseñaAnterior nvarchar(40)
	, Correo nvarchar(200)
	, Direccion text
	, Telefono int
	, Gerente bit 
	, NumSucursal int
	, Activo bit default 1

)

INSERT INTO ADMINISTRADORES VALUES ('Hermeregildo','Martinez','sadasdasda','hermeMartin15@gmail.com',1)

CREATE TABLE CLIENTES (
	IDClientes int IDENTITY(1,1) PRIMARY KEY
	, Nombre nvarchar(50)
	, Apellidos nvarchar(150)
	, Cedula int unique not null
	, ContraseñaActual nvarchar(40)
	, ContraseñaAnterior nvarchar(40)
	, Correo nvarchar(200)
	, Direccion nvarchar(1500)
	, Telefono int
	, Activo bit default 1
)

CREATE TABLE VETERINARIOS (
	IDVet int IDENTITY(1,1) PRIMARY KEY
	, Nombre nvarchar(50)
	, Apellidos nvarchar(150)
	, Cedula int unique not null
	, ContraseñaActual nvarchar(40)
	, ContraseñaAnterior nvarchar(40)
	, Correo nvarchar(200)
	, Direccion text
	, Telefono int
	, Activo bit default 1
)

CREATE TABLE SUCURSALES (
	IDSucursal int IDENTITY(1,1) PRIMARY KEY
	, Nombre nvarchar(150)
	, Ubicacion nvarchar(1500)
)

CREATE TABLE MASCOTAS (
	IDMascota int IDENTITY(1,1) PRIMARY KEY
	, IDCliente int
	, Nombre nvarchar(150)
	, Edad int
	, Sexo bit

)

CREATE TABLE CATEGORIASP (
	IDCategoria int IDENTITY(1,1) PRIMARY KEY 
	, NombreCategoria nvarchar(150)
)


CREATE TABLE PRODUCTOS (
	IDProducto int IDENTITY(1,1) PRIMARY KEY 
	, Nombre nvarchar(150)
	, Categoria int
	, CantidadTotal int
	, Precio numeric(18,0) 
)

CREATE TABLE ALMACEN (
	IDAlmacen int PRIMARY KEY
	, Ubicacion nvarchar(1500)
)

CREATE TABLE EXISTENCIAS (
	ID int IDENTITY(1,1) PRIMARY KEY
	, IDAlmacen int 
	, IDProductos int 
	, Cantidad int
)

CREATE TABLE RESEÑAS (
	IDReseña int IDENTITY(1,1) PRIMARY KEY 
	, IDProducto int 
	, Descripcion text
	, Calificacion int 
)

CREATE TABLE TIPOSNOTIFICACIONES (
	IDTipo int PRIMARY KEY 
	, Nombre nvarchar(150)
)

CREATE TABLE NOTIFICACIONES (
	IDNotificacion int IDENTITY(1,1) PRIMARY KEY
	, IDTipo int 
	, Descripcion text
	, Leido bit
	, IDUsuario int
	, IDCliente int-- A quien le llega 
	, IDVeterinario int
)



CREATE TABLE CITAS (
	IDCita int IDENTITY(1,1) PRIMARY KEY
	, FechaCita date
	, HoraCita nvarchar(6) not null
	CHECK (HoraCita IN ('8:00', '9:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00'))
	, IDMascota int 
	, IDVeterinario int
	, IDSucursal int
	, Completada bit

)

CREATE TABLE EncabezadoFactura (
	IDFactura int IDENTITY(1,1) PRIMARY KEY 
	, Domicilio bit --0 Presencial, 1 A domicilio
	, Monto numeric(18,0)
	, IDCliente int 
	, CantidadProductos int 
	, FechaFactura date
	, FormaPago bit --0 Tarjetas, 1 Sinpe
)

CREATE TABLE DetalleFacturas (
	IDNumeroLinea int 
	, IDFactura int 
	, IDProducto int 
	, Cantidad int
	, PrecioTotal numeric(18,0) 
)

CREATE TABLE VACUNAS (
	IDVacunas int IDENTITY(1,1) PRIMARY KEY
	, Nombre nvarchar(150)
)

CREATE TABLE RegistroVacunas(
	IDRegistro int IDENTITY(1,1) PRIMARY KEY 
	, IDMascota int 
	, IDVacuna int
	, FechaVacuna date 
)

CREATE TABLE EncabezadoReceta (
	IDReceta int IDENTITY(1,1) PRIMARY KEY
	, IDMascota int
	, FechaReceta date
	, IDVet int
)

CREATE TABLE LineasReceta (
	NumLinea int
	, IDReceta int 
	, IDMedicamento int 
)

--
CREATE TABLE ENFERMEDADES (
	IDEnfermedad int IDENTITY(1,1) PRIMARY KEY 
	, NombreEnfermedad nvarchar(150)
)

CREATE TABLE EncabezadoDiagnosticos (
	IDDiagnostico int IDENTITY(1,1) PRIMARY KEY
	, IDMascota int
	, Descripcion text
	, FechaDiagnostico date
)


CREATE TABLE LineasDiagnostico (
	NumLinea int 
	, IDDiagnostico int
	, IDEnfermedad int 

	PRIMARY KEY(NumLinea, IDDiagnostico)
)

CREATE TABLE TipoAccion (
	IDTipo int IDENTITY(1,1) PRIMARY KEY
	, NombreTipo nvarchar(200)
)

CREATE TABLE CLICKS (
	IDClick int IDENTITY(1,1) PRIMARY KEY
	, Descripcion text
)

CREATE TABLE HistorialUsuario (
	NumHistorial int IDENTITY(1,1) PRIMARY KEY
	, TipoAccion int 
	, FechaAccion datetime
	, IDAccion int --(Aqui se coloca el id dependiendo del tipo) 
	--  SI es una agendacion de cita, aqui iría el ID de cita
	--  SI es una compra, aqui iría el ID de compra
	--  SI es un click, aqui iría el IDClick 
)

CREATE TABLE SUCURSALES (
    IDSucursal int IDENTITY(1,1) PRIMARY KEY,
    Nombre nvarchar(150),
    Ubicacion nvarchar(1500),
    Activo bit DEFAULT 1
);

-- FKeys

ALTER TABLE PERMISOS
ADD CONSTRAINT FK_PERMISOS_IDPermiso FOREIGN KEY (IDPermiso) REFERENCES TIPOPERMISO(IDPermiso),
    CONSTRAINT FK_PERMISOS_IDAdmin FOREIGN KEY (IDAdmin) REFERENCES ADMINISTRADORES(IDAdmin);

ALTER TABLE MASCOTAS
ADD CONSTRAINT FK_MASCOTAS_IDCliente FOREIGN KEY (IDCliente) REFERENCES CLIENTES(IDClientes);

ALTER TABLE PRODUCTOS
ADD CONSTRAINT FK_PRODUCTOS_Categoria FOREIGN KEY (Categoria) REFERENCES CATEGORIASP(IDCategoria);

ALTER TABLE EXISTENCIAS
ADD CONSTRAINT FK_EXISTENCIAS_IDAlmacen FOREIGN KEY (IDAlmacen) REFERENCES ALMACEN(IDAlmacen),
    CONSTRAINT FK_EXISTENCIAS_IDProductos FOREIGN KEY (IDProductos) REFERENCES PRODUCTOS(IDProducto);

ALTER TABLE RESEÑAS
ADD CONSTRAINT FK_RESEÑAS_IDProducto FOREIGN KEY (IDProducto) REFERENCES PRODUCTOS(IDProducto);

ALTER TABLE NOTIFICACIONES
ADD CONSTRAINT FK_NOTIFICACIONES_IDTipo FOREIGN KEY (IDTipo) REFERENCES TIPOSNOTIFICACIONES(IDTipo)

ALTER TABLE CITAS
ADD CONSTRAINT FK_CITAS_IDMascota FOREIGN KEY (IDMascota) REFERENCES MASCOTAS(IDMascota),
    CONSTRAINT FK_CITAS_IDVeterinario FOREIGN KEY (IDVeterinario) REFERENCES VETERINARIOS(IDVet),
    CONSTRAINT FK_CITAS_IDSucursal FOREIGN KEY (IDSucursal) REFERENCES SUCURSALES(IDSucursal);

ALTER TABLE EncabezadoFactura
ADD CONSTRAINT FK_EncabezadoFactura_IDCliente FOREIGN KEY (IDCliente) REFERENCES CLIENTES(IDClientes);

ALTER TABLE DetalleFacturas
ADD CONSTRAINT FK_DetalleFacturas_IDFactura FOREIGN KEY (IDFactura) REFERENCES EncabezadoFactura(IDFactura),
    CONSTRAINT FK_DetalleFacturas_IDProducto FOREIGN KEY (IDProducto) REFERENCES PRODUCTOS(IDProducto);

ALTER TABLE RegistroVacunas
ADD CONSTRAINT FK_RegistroVacunas_IDMascota FOREIGN KEY (IDMascota) REFERENCES MASCOTAS(IDMascota),
    CONSTRAINT FK_RegistroVacunas_IDVacuna FOREIGN KEY (IDVacuna) REFERENCES VACUNAS(IDVacunas);

ALTER TABLE EncabezadoReceta
ADD CONSTRAINT FK_EncabezadoReceta_IDMascota FOREIGN KEY (IDMascota) REFERENCES MASCOTAS(IDMascota),
    CONSTRAINT FK_EncabezadoReceta_IDVet FOREIGN KEY (IDVet) REFERENCES VETERINARIOS(IDVet);

ALTER TABLE LineasReceta
ADD CONSTRAINT FK_LineasReceta_IDReceta FOREIGN KEY (IDReceta) REFERENCES EncabezadoReceta(IDReceta);

ALTER TABLE EncabezadoDiagnosticos
ADD CONSTRAINT FK_EncabezadoDiagnosticos_IDMascota FOREIGN KEY (IDMascota) REFERENCES MASCOTAS(IDMascota);

ALTER TABLE LineasDiagnostico
ADD CONSTRAINT FK_LineasDiagnostico_IDDiagnostico FOREIGN KEY (IDDiagnostico) REFERENCES EncabezadoDiagnosticos(IDDiagnostico),
    CONSTRAINT FK_LineasDiagnostico_IDEnfermedad FOREIGN KEY (IDEnfermedad) REFERENCES ENFERMEDADES(IDEnfermedad);

ALTER TABLE HistorialUsuario
ADD CONSTRAINT FK_HistorialUsuario_TipoAccion FOREIGN KEY (TipoAccion) REFERENCES TipoAccion(IDTipo);