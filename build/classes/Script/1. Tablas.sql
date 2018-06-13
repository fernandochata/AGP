--	BORRAR TABLAS	--

DROP TABLE Detalles_Permiso;
DROP TABLE Permisos;
DROP TABLE Usuarios;
DROP TABLE Usuario_Cargos;
DROP TABLE Usuario_Perfiles;
DROP TABLE Permiso_Estados;
DROP TABLE Permiso_Motivos;
DROP TABLE Permiso_Tipos;
DROP TABLE Usuario_Departamentos;



--	CREAR TABLAS	--

CREATE TABLE PERMISO_TIPOS (
    id_tipo NUMBER (38,0),
    tipo VARCHAR2(100),
    dias NUMBER (38,0),
    descripcion VARCHAR2(100),
    estado_tipo NUMBER (38,0),
    CONSTRAINT PERMISO_TIPO_PK PRIMARY KEY (id_tipo)
);

CREATE TABLE PERMISO_MOTIVOS (
  id_motivo NUMBER (38,0),
  motivo VARCHAR2(100),
  CONSTRAINT PERMISO_MOTIVO_PK PRIMARY KEY (id_motivo)
);

CREATE TABLE PERMISO_ESTADOS (
    id_estado NUMBER (38,0),
    estado VARCHAR2(100),
    descripcion VARCHAR2(100),
    CONSTRAINT PERMISO_ESTADO_PK PRIMARY KEY (id_estado)
);

CREATE TABLE USUARIO_PERFILES (
    id_perfil NUMBER (38,0),
    perfil VARCHAR2(100),
    descripcion VARCHAR2(100),
    CONSTRAINT USUARIO_PERFIL_PK PRIMARY KEY (id_perfil)
);

CREATE TABLE USUARIO_CARGOS (
    id_cargo NUMBER (38,0),
    cargo VARCHAR2(100),
    descripcion VARCHAR2(100),
    CONSTRAINT CARGO_PK PRIMARY KEY (id_cargo)
);

CREATE TABLE USUARIO_DEPARTAMENTOS ( 
    id_departamento NUMBER (38,0), 
    departamento VARCHAR2(100),
    descripcion VARCHAR2(300),
    CONSTRAINT DEPARTAMENTO_PK PRIMARY KEY (id_departamento)
);


CREATE TABLE USUARIOS (
  rut NUMBER (38,0),
  digito_verificador VARCHAR2(1),
  clave VARCHAR2(100),
  nombres VARCHAR2(100),
  apellido_paterno VARCHAR2(100),
  apellido_materno VARCHAR2(100),
  direccion VARCHAR2(100),
  comuna VARCHAR2(100),
  telefono NUMBER (38,0),
  email VARCHAR2(100),
  dd_legales NUMBER(10),
  dd_administrativos NUMBER (10,0),
  fecha_contrato TIMESTAMP,
  id_perfil NUMBER (38,0),
  id_cargo NUMBER (38,0),
  id_departamento NUMBER (38,0),
  CONSTRAINT USUARIO_PK PRIMARY KEY (rut),
  CONSTRAINT USUARIO_FK_PERFIL FOREIGN KEY (id_perfil) REFERENCES USUARIO_PERFILES (id_perfil),
  CONSTRAINT USUARIO_FK_CARGO FOREIGN KEY (id_cargo) REFERENCES USUARIO_CARGOS (id_cargo),
  CONSTRAINT USUARIO_FK_DEPARTAMENTO FOREIGN KEY (id_departamento) REFERENCES USUARIO_DEPARTAMENTOS (id_departamento)
);

CREATE TABLE PERMISOS (
  id_permiso NUMBER (38,0),
  fecha_creacion TIMESTAMP,
  rut NUMBER (38,0),
  CONSTRAINT PERMISO_PK PRIMARY KEY (id_permiso),
  CONSTRAINT PERMISO_FK_USUARIO FOREIGN KEY (rut) REFERENCES USUARIOS (rut)
);

CREATE TABLE DETALLES_PERMISO (
  id_detalle NUMBER (38,0),
  fecha_resolucion TIMESTAMP,
  fecha_desde TIMESTAMP,
  fecha_hasta TIMESTAMP,
  nombre_archivo VARCHAR2(255),
  dias NUMBER (38,0),
  id_permiso NUMBER (38,0),
  id_motivo NUMBER (38,0),
  id_tipo NUMBER (38,0),
  id_estado NUMBER (38,0),
  CONSTRAINT DETALLE_PERMISO_PK PRIMARY KEY (id_detalle),
  CONSTRAINT DETALLE_PERMISO_FK_PERMISO FOREIGN KEY (id_permiso) REFERENCES PERMISOS (id_permiso),
  CONSTRAINT DETALLE_PERMISO_FK_MOTIVO FOREIGN KEY (id_motivo) REFERENCES PERMISO_MOTIVOS (id_motivo),
  CONSTRAINT DETALLE_PERMISO_FK_TIPO FOREIGN KEY (id_tipo) REFERENCES PERMISO_TIPOS (id_tipo),
  CONSTRAINT DETALLE_PERMISO_FK_ESTADO FOREIGN KEY (id_estado) REFERENCES PERMISO_ESTADOS (id_estado)
);