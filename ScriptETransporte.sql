CREATE DATABASE ETransporte;

USE ETransporte;

CREATE TABLE Boleto (
    idBoleto int  NOT NULL,
    RaSoEmpresa int  NOT NULL,
    RucEmpresa int  NOT NULL,
    Pasajero_IdPasajero int  NOT NULL,
    Viaje_IdViaje int  NOT NULL,
    CONSTRAINT Boleto_pk PRIMARY KEY (idBoleto)
);


CREATE TABLE Bus (
    IdBus int  NOT NULL,
    PlacaBus int  NOT NULL,
    Personal_DniPersonal varchar(10)  NOT NULL,
    CONSTRAINT Bus_pk PRIMARY KEY (IdBus)
);


CREATE TABLE Manifiesto (
    idManifiesto int  NOT NULL,
    DescManifiesto int  NOT NULL,
    Bus_IdBus int  NOT NULL,
    Personal_DniPersonal varchar(10)  NOT NULL,
    CONSTRAINT Manifiesto_pk PRIMARY KEY (idManifiesto)
);


CREATE TABLE Pasajero (
    IdPasajero int  NOT NULL,
    NomPasajero varchar(40)  NOT NULL,
    ApePasajero varchar(40)  NOT NULL,
    SexoPasajero varchar(20)  NOT NULL,
    DniPasajero varchar(40)  NOT NULL,
    CantPasajero varchar(40)  NOT NULL,
    Manifiesto_idManifiesto int  NOT NULL,
    CONSTRAINT Pasajero_pk PRIMARY KEY (IdPasajero)
);


CREATE TABLE Personal (
    DniPersonal varchar(10)  NOT NULL,
    NomPersonal varchar(40)  NOT NULL,
    ApePersonal varchar(40)  NOT NULL,
    ProcedPersonal varchar(40)  NOT NULL,
    SexoPersonal varchar(20)  NOT NULL,
    Sucursales_IdSucursales int  NOT NULL,
    CONSTRAINT Personal_pk PRIMARY KEY (DniPersonal)
);


CREATE TABLE Sucursales (
    IdSucursales int  NOT NULL,
    DescSucursales varchar(40)  NOT NULL,
    Viaje_IdViaje int  NOT NULL,
    CONSTRAINT Sucursales_pk PRIMARY KEY (IdSucursales)
);


CREATE TABLE Viaje (
    IdViaje int  NOT NULL,
    OriViaje varchar(40)  NOT NULL,
    DestViaje varchar(40)  NOT NULL,
    FecViaje date  NOT NULL,
    HoraPartviaje time  NOT NULL,
    Costoviaje varchar(40)  NOT NULL,
    Pasajero_IdPasajero int  NOT NULL,
    CONSTRAINT Viaje_pk PRIMARY KEY (IdViaje)
);


ALTER TABLE Boleto ADD CONSTRAINT Boleto_Pasajero
    FOREIGN KEY (Pasajero_IdPasajero)
    REFERENCES Pasajero (IdPasajero);


ALTER TABLE Boleto ADD CONSTRAINT Boleto_Viaje
    FOREIGN KEY (Viaje_IdViaje)
    REFERENCES Viaje (IdViaje);


ALTER TABLE Bus ADD CONSTRAINT Bus_Personal
    FOREIGN KEY (Personal_DniPersonal)
    REFERENCES Personal (DniPersonal);


ALTER TABLE Manifiesto ADD CONSTRAINT Manifiesto_Bus
    FOREIGN KEY (Bus_IdBus)
    REFERENCES Bus (IdBus);


ALTER TABLE Manifiesto ADD CONSTRAINT Manifiesto_Personal
    FOREIGN KEY (Personal_DniPersonal)
    REFERENCES Personal (DniPersonal);


ALTER TABLE Pasajero ADD CONSTRAINT Pasajero_Manifiesto
    FOREIGN KEY (Manifiesto_idManifiesto)
    REFERENCES Manifiesto (idManifiesto);


ALTER TABLE Personal ADD CONSTRAINT Personal_Sucursales
    FOREIGN KEY (Sucursales_IdSucursales)
    REFERENCES Sucursales (IdSucursales);


ALTER TABLE Sucursales ADD CONSTRAINT Sucursales_Viaje
    FOREIGN KEY (Viaje_IdViaje)
    REFERENCES Viaje (IdViaje);


ALTER TABLE Viaje ADD CONSTRAINT Viaje_Pasajero
    FOREIGN KEY (Pasajero_IdPasajero)
    REFERENCES Pasajero (IdPasajero);