-- 	INGRESO DE DATOS DE LA TABLA PERMISO_TIPO	--

INSERT INTO PERMISO_TIPOS (ID_TIPO, TIPO, DIAS, DESCRIPCION, ESTADO_TIPO) VALUES (1, 'Administrativo', 0, 'Permiso Administrativo', 1);
INSERT INTO PERMISO_TIPOS (ID_TIPO, TIPO, DIAS, DESCRIPCION, ESTADO_TIPO) VALUES (2, 'Fallecimiento', 7, 'Permiso por Fallecimiento de Familiar Directo', 1) ;
INSERT INTO PERMISO_TIPOS (ID_TIPO, TIPO, DIAS, DESCRIPCION, ESTADO_TIPO) VALUES (3, 'Legal', 0, 'Permiso Legal Anual', 1) ;
INSERT INTO PERMISO_TIPOS (ID_TIPO, TIPO, DIAS, DESCRIPCION, ESTADO_TIPO) VALUES (4, 'Parental', 7, 'Permiso Parental', 1) ;


-- 	INGRESO DE DATOS DE LA TABLA USUARIO_PERFIL	--

INSERT INTO USUARIO_PERFILES (id_perfil, perfil, descripcion) VALUES (1, 'Administrador', 'Persona que utiliza los mantenedores') ;
INSERT INTO USUARIO_PERFILES (id_perfil, perfil, descripcion) VALUES (2, 'Funcionario', 'Persona que genera los permisos') ;
INSERT INTO USUARIO_PERFILES (id_perfil, perfil, descripcion) VALUES (3, 'Jefe Interno', 'Persona que resuelve los permisos') ;
INSERT INTO USUARIO_PERFILES (id_perfil, perfil, descripcion) VALUES (4, 'Jefe Superior', 'Persona que genera resoluciones') ;
INSERT INTO USUARIO_PERFILES (id_perfil, perfil, descripcion) VALUES (5, 'Alcalde', 'Persona que puede visualizar toda la información') ;

-- 	INGRESO DE DATOS DE LA TABLA USUARIO	--

INSERT INTO USUARIOS (rut, digito_verificador, clave, nombres, apellido_paterno, apellido_materno, id_perfil) VALUES (11111111,'1', 'admin','Administrador', 'Paterno', 'Materno', 1);


