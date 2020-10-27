CREATE DATABASE IF NOT EXISTS MovieFlix;

USE MovieFlix;

CREATE TABLE IF NOT EXISTS MovieFlix.genero (
  idGenero INT NOT NULL AUTO_INCREMENT,
  tipoGenero VARCHAR(20) NOT NULL,
  PRIMARY KEY (idGenero)
  );
  
  CREATE TABLE IF NOT EXISTS MovieFlix.cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  fechaRegistro DATE NOT NULL,
  PRIMARY KEY (idCliente)
  );
  
  
CREATE TABLE IF NOT EXISTS MovieFlix.peliculas (
  idPelicula INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(120) NOT NULL,
  anyoEstreno INT NULL,
  idGenero INT NOT NULL,
PRIMARY KEY (idPelicula),
FOREIGN KEY (idGenero) REFERENCES Genero (idGenero)
);


CREATE TABLE IF NOT EXISTS MovieFlix.suscripcion (
  idSuscripcion INT NOT NULL AUTO_INCREMENT,
  idCliente INT NOT NULL,
  idGenero INT NOT NULL,
  PRIMARY KEY (idSuscripcion),
  FOREIGN KEY (idGenero) REFERENCES Genero (idGenero),
  FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
  );
  
INSERT INTO genero (idgenero, tipoGenero)
VALUES (0, "Policiaca");INSERT INTO genero (idgenero, tipoGenero)
VALUES (0, "Romantica");INSERT INTO genero (idgenero, tipoGenero)
VALUES (0, "Aventuras");INSERT INTO genero (idgenero, tipoGenero)
VALUES (0, "Comedia");INSERT INTO genero (idgenero, tipoGenero)
VALUES (0, "Animacion");INSERT INTO genero (idgenero, tipoGenero)
VALUES (0, "Thriller");