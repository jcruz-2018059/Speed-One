Drop database if exists DBSpeedOne;
Create database DBSpeedOne;

Use DBSpeedOne;

Create table Empleado(
	codigoEmpleado int not null auto_increment,
    DPIEmpleado varchar(15) not null,
    nombreEmpleado varchar(200) not null,
    apellidoEmpleado varchar(200) not null,
    telefonoEmpleado varchar(8) not null,
    correoEmpleado varchar(50) not null,
    estado varchar(1) not null,
    usuario varchar(15) not null,
    foto varchar(100) not null,
    primary key PK_codigoEmpleado (codigoEmpleado)
);

Create table Categoria(
	codigoCategoria int not null auto_increment,
	nombreCategoria varchar(50) not null,
	descripcionCategoria varchar(100) not null,
	primary key PK_codigoCategoria (codigoCategoria)
);

Create table Cliente(
	codigoCliente int not null auto_increment,
    nombresCliente varchar(50) not null,
    apellidosCliente varchar(50) not null,
    direccionCliente varchar(100) not null,
    telefonoPersonal varchar(8) not null,
    emailCliente varchar(100) not null,
    primary key PK_codigoCliente (codigoCliente)
);

Create table Garantia(
	codigoGarantia int not null auto_increment,
	tiempoGarantia varchar(50) not null,
	primary key PK_codigoGarantia (codigoGarantia)
);

Create table TelefonoProveedor(
	codigoTelefonoProveedor int not null auto_increment,
	telefonoProveedor varchar(50) not null,
	telefonoPersonal varchar(100) not null,
	primary key PK_codigoTelefonoProveedor (codigoTelefonoProveedor)
);

Create table EstadoProducto(
	codigoEstadoProducto int not null auto_increment,
    estadoProducto varchar(50) not null,
    Primary key PK_codigoEstadoProducto (codigoEstadoProducto)
);

Create table FormaDePago(
	codigoFormaPago int not null auto_increment,
	formaPago varchar(50) not null,
    Primary key PK_codigoFormaPago (codigoFormaPago)
);

Create table Proveedor(
	codigoProveedor int not null auto_increment,
	nombreProveedor varchar(50) not null,
	direccionProveedor varchar(100) not null,
	codigotelefonoProveedor int not null,
	primary key PK_codigoProveedor (codigoProveedor),
	Constraint FK_Proveedor_TelefonoProveedor foreign key (codigotelefonoProveedor)
		references TelefonoProveedor (codigotelefonoProveedor)
);

Create table Pedidos(
	numeroDePedido int not null,
    fechaDePedido date not null,
    totalDelPedido Double not null,
    fechaDeEnvio date not null,
    codigoFormaPago int not null,
    codigoCliente int not null,
    codigoEmpleado int not null,
    Primary key PK_numeroDePedido (numeroDePedido),
    Constraint FK_Pedidos_FormaDePago foreign key (codigoFormaPago)
		references formaDePago (codigoFormaPago),
    Constraint FK_Pedidos_Cliente foreign key (codigoCliente)
		references Cliente (codigoCliente),
	Constraint FK_Pedidos_Empleado foreign key (codigoEmpleado)
		references Empleado (codigoEmpleado)
);

Create table Producto(
	codigoProducto int not null auto_increment,
    nombreProducto varchar(100) not null,
    stockProducto int not null,
    precioProducto Double not null,
    codigoCategoria int not null,
    codigoProveedor int not null,
    codigoGarantia int not null,
    codigoEstadoProducto int not null,
	Primary key PK_codigoProducto (codigoProducto),
    Constraint FK_Producto_Categoria foreign key (codigoCategoria)
		references Categoria (codigoCategoria),
	Constraint FK_Producto_Proveedor foreign key (codigoProveedor)
		references Proveedor (codigoProveedor),
    Constraint FK_Producto_EstadoProducto foreign key (codigoEstadoProducto)
		references estadoProducto (codigoEstadoProducto),
	Constraint FK_Producto_Garantia foreign key (codigoGarantia)
		references Garantia (codigoGarantia)
);

Create table DetallePedidos(
	codigoDetallePedidos int not null auto_increment,
    cantidad int not null,
    precio Double not null,
    numeroDePedido int not null,
    codigoProducto int not null,
    Primary key PK_codigoDetallePedidos (codigoDetallePedidos),
    Constraint FK_DetallePedido_Pedido foreign key (numeroDePedido)
		references Pedidos (numeroDePedido),
	Constraint FK_DetallePedido_Producto foreign key (codigoProducto)
		references Producto (codigoProducto)
);


insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('123', 'Fernando', 'Alegria', '54879632','falegria@kinal.gt' ,'1', 'falegria', "fernandoalegria.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('2313545645778', 'Selvin', 'Chuquiej', '43210509','schuquiej@kinal.gt' ,'1', 'schuquiej', "selvinchuquiej.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('1244257668800', 'Alejandro', 'Ceballos', '24587963', 'jceballos@kinal.gt','1', 'jceballos',"alejandroceballos.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('3451356877977', 'Cesar', 'de León', '32157235', 'cdeleon@kinal.gt', '1', 'cdeleon', "cesardeleon.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('9776452356775', 'Julio', 'Farnés', '76123421', 'jfarnes@kinal.gt','1', 'jfarnes',"juliofarnes.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('1234426664233', 'Eduardo ','Cruz', '89235431', 'ecruz@kinal.gt','1', 'ecruz', "eduardocruz.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('5756734668769', 'Pablo', ' Garcia', '54278100', 'pgarcia@kinal.gt','1', 'pgarcia',"pablogarcia.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('5442656863222', 'Edgar', ' Batzin', '98236129', 'ebatzin@kinal.gt','1', 'ebatzin', "edgarbatzin.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('8754635243555', 'José', ' Chiquin', '22315627', 'jchiquin@kinal.gt','1', 'jchiquin',"danielchiquin.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('0878452354666', 'Luis', ' Andrade', '93263510', 'landrade@kinal.gt','1', 'landrade', "luisandrade.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('1089566345465', 'Javier', ' Cruz', '15278934', 'jcruz@kinal.gt','1', 'jcruz', "javiercruz.png");
insert into Empleado (DPIEmpleado, nombreEmpleado, apellidoEmpleado, telefonoEmpleado, correoEmpleado, estado, usuario, foto) values ('1332542333335', 'Henry', ' Espinoza', '122344', 'hespinoza@kinal.gt','1', 'jhespinoza', "henryespinoza.png");

insert into Categoria (nombreCategoria, descripcionCategoria) values('Reparables','Son reparables');
insert into Categoria (nombreCategoria, descripcionCategoria) values('Consumibles','No son reparables');

insert into Cliente (nombresCliente, apellidosCliente, direccionCliente, telefonoPersonal, emailCliente) values ('Erick','Castillo','Guatemala','43216733','erickcastillo@gmail.com');
insert into Cliente (nombresCliente, apellidosCliente, direccionCliente, telefonoPersonal, emailCliente) values ('Pablo','Fernandez','Mixco','21334126','pablofernandez@gmail.com');
insert into Cliente (nombresCliente, apellidosCliente, direccionCliente, telefonoPersonal, emailCliente) values ('Roberto','Garcia','Guatemala','51414893','robertogarcia@gmail.com');
insert into Cliente (nombresCliente, apellidosCliente, direccionCliente, telefonoPersonal, emailCliente) values ('Mateo','Cruz','Guatemala','58298803','mateocruz@gmail.com');
insert into Cliente (nombresCliente, apellidosCliente, direccionCliente, telefonoPersonal, emailCliente) values ('Diego','Flores','Guatemala','67423388','diegoflores@gmail.com');

insert into Garantia (tiempoGarantia) values ('3 Meses');
insert into Garantia (tiempoGarantia) values ('6 Meses');
insert into Garantia (tiempoGarantia) values ('9 Meses');
insert into Garantia (tiempoGarantia) values ('12 Meses');
insert into Garantia (tiempoGarantia) values ('Sin Garantia');

insert into TelefonoProveedor (telefonoProveedor, telefonoPersonal) values ('23002300','32178492');
insert into TelefonoProveedor (telefonoProveedor, telefonoPersonal) values ('24241200','29253718');
insert into TelefonoProveedor (telefonoProveedor, telefonoPersonal) values ('22012200','21392715');
insert into TelefonoProveedor (telefonoProveedor, telefonoPersonal) values ('14440000','44361792');
insert into TelefonoProveedor (telefonoProveedor, telefonoPersonal) values ('24808080','42718399');

insert into EstadoProducto (estadoProducto) values ('Nuevo');
insert into EstadoProducto (estadoProducto) values ('Usado');

insert into FormaDePago (formaPago) values ('Tarjeta');
insert into FormaDePago (formaPago) values ('Contra Entrega');
insert into FormaDePago (formaPago) values ('Transferencia');
insert into FormaDePago (formaPago) values ('PayPal');

insert into Proveedor (nombreProveedor, direccionProveedor, codigotelefonoProveedor) values ('Honda','30 Av, 23 - 12 Calle Montufar',5);
insert into Proveedor (nombreProveedor, direccionProveedor, codigotelefonoProveedor) values ('Toyota','7 Av, 21 - 34 Zona 1',4);
insert into Proveedor (nombreProveedor, direccionProveedor, codigotelefonoProveedor) values ('Hyundai','5 Av, 45 - 12 Zona 14',3);
insert into Proveedor (nombreProveedor, direccionProveedor, codigotelefonoProveedor) values ('Ford','Avenida las Americas, 21 - 12 Zona 10',2);
insert into Proveedor (nombreProveedor, direccionProveedor, codigotelefonoProveedor) values ('Chevrolet','29 Av, 67 - 12 Zona 10',1);

insert into Pedidos (numeroDePedido, fechaDePedido, totalDelPedido, fechaDeEnvio, codigoFormaPago, codigoCliente, codigoEmpleado) values (001,'2022-08-23',350.00,'2022-08-29', 1, 1, 5);
insert into Pedidos (numeroDePedido, fechaDePedido, totalDelPedido, fechaDeEnvio, codigoFormaPago, codigoCliente, codigoEmpleado) values (002,'2022-08-12',490.00,'2022-08-20', 2, 3, 1);
insert into Pedidos (numeroDePedido, fechaDePedido, totalDelPedido, fechaDeEnvio, codigoFormaPago, codigoCliente, codigoEmpleado) values (003,'2022-08-20',213.00,'2022-08-24', 4, 2, 11);
insert into Pedidos (numeroDePedido, fechaDePedido, totalDelPedido, fechaDeEnvio, codigoFormaPago, codigoCliente, codigoEmpleado) values (004,'2022-08-02',1456.00,'2022-08-06', 1, 5, 8);
insert into Pedidos (numeroDePedido, fechaDePedido, totalDelPedido, fechaDeEnvio, codigoFormaPago, codigoCliente, codigoEmpleado) values (005,'2022-08-24',800.00,'2022-08-28', 3, 4, 9);

insert into Producto (nombreProducto, stockProducto, precioProducto, codigoCategoria, codigoProveedor, codigoGarantia, codigoEstadoProducto) values ('Radiador',12, 300.00, 2, 1, 1, 1);
insert into Producto (nombreProducto, stockProducto, precioProducto, codigoCategoria, codigoProveedor, codigoGarantia, codigoEstadoProducto) values ('Espejos',20, 250.00, 1, 3, 2, 1);
insert into Producto (nombreProducto, stockProducto, precioProducto, codigoCategoria, codigoProveedor, codigoGarantia, codigoEstadoProducto) values ('Farolas',8, 280.00, 1, 2, 4, 1);
insert into Producto (nombreProducto, stockProducto, precioProducto, codigoCategoria, codigoProveedor, codigoGarantia, codigoEstadoProducto) values ('Filtro de Aire',18, 300.00, 2, 2, 1, 1);
insert into Producto (nombreProducto, stockProducto, precioProducto, codigoCategoria, codigoProveedor, codigoGarantia, codigoEstadoProducto) values ('Frenos',30, 450.00, 2, 5, 4, 1);

insert into DetallePedidos (cantidad, precio, numeroDePedido, codigoProducto) values (1, 300.00, 2, 1);
insert into DetallePedidos (cantidad, precio, numeroDePedido, codigoProducto) values (3, 250.00, 1, 2);
insert into DetallePedidos (cantidad, precio, numeroDePedido, codigoProducto) values (2, 280.00, 3, 3);
insert into DetallePedidos (cantidad, precio, numeroDePedido, codigoProducto) values (1, 300.00, 5, 4);
insert into DetallePedidos (cantidad, precio, numeroDePedido, codigoProducto) values (1, 300.00, 4, 1);

Select * from Empleados;