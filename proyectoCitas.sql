  CREATE DATABASE bdsistemacitas;  
  
  use bdsistemacitas;
  
  CREATE TABLE PACIENTES (
  pacIdentificacion INT PRIMARY KEY  AUTO_INCREMENT,
  pacNombres VARCHAR(45) NOT NULL,
  pacApellidos VARCHAR(45) NOT NULL,
  pacFechaNacimiento DATE NOT NULL,
  pacTelefono VARCHAR(15) NOT NULL,
  pacDireccion VARCHAR(45) NOT NULL
);

CREATE TABLE MEDICOS (
  medIdentificacion INT PRIMARY KEY AUTO_INCREMENT,
  medNombres VARCHAR(45) NOT NULL,
  medApellidos VARCHAR(45) NOT NULL,
  medEspecialidad VARCHAR(45) NOT NULL,
  medTelefono VARCHAR(15) NOT NULL,
  medEmail VARCHAR(45) NOT NULL
);

CREATE TABLE CONSULTORIOS (
  conNumero INT PRIMARY KEY AUTO_INCREMENT,
  conNombre VARCHAR(45) NOT NULL,
  conUbicacion VARCHAR(45) NOT NULL
);
  CREATE TABLE TRATAMIENTOS (
  TraNumero INT PRIMARY KEY AUTO_INCREMENT,
  TraFechaAsignado DATE NOT NULL,
  TraDescripcion VARCHAR(45) NOT NULL,
  TraFechaInicio DATE NOT NULL,
  TraFechaFin DATE NOT NULL,
  TraObservaciones VARCHAR(45) NOT NULL,
  PACIENTES_pacIdentificacion INT,
  FOREIGN KEY (PACIENTES_pacIdentificacion) REFERENCES PACIENTES(pacIdentificacion)
  );
  
  CREATE TABLE CITAS (
  citNumero INT PRIMARY KEY AUTO_INCREMENT,
  citFecha DATE NOT NULL,
  citHora TIME NOT NULL,
  pacIdentificacion INT NOT NULL,
  medIdentificacion INT NOT NULL,
  conNumero INT NOT NULL,
  FOREIGN KEY (pacIdentificacion) REFERENCES PACIENTES(pacIdentificacion),
  FOREIGN KEY (medIdentificacion) REFERENCES MEDICOS(medIdentificacion),
  FOREIGN KEY (conNumero) REFERENCES CONSULTORIOS(conNumero)
);
