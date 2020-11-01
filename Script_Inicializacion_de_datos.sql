
/*DROPEAR TODO -> Elimina todas las tabls para comenzar a poblarlas nuevamente*/
/*DROP TABLE `tpdatabase`.`administrad_unidad`, `tpdatabase`.`administrado`, `tpdatabase`.`edificios`, `tpdatabase`.`espacios_comunes`, `tpdatabase`.`especialidades`, 
`tpdatabase`.`hibernate_sequence`, `tpdatabase`.`inspector_edificio`, `tpdatabase`.`inspector_especialidad`, `tpdatabase`.`inspectores`, `tpdatabase`.`reclamos`, 
`tpdatabase`.`unidades`, `tpdatabase`.`users`;*/
 
 /*INSERTAR USUARIOS*/
 INSERT INTO tpdatabase.users (`id`, `celular`, `email`, `first_name`, `first_time`, `last_name`, `numero_identificacion`, `password`, 
 `pregunta_seguridad`, `respuesta_seguridad`, `sexo`, `tipo_identificacion`, `tipo_user`, `username`,`recibir_notificaciones`,`datos_moviles`)
 VALUES (1, "celular1" , "mail1", "nombre1", "true", "apellido1", "identificacion1", "password1",
 "pregunta1", "respuesta1", "masculino", "DNI", "Administrado", "user1", true, false);
 INSERT INTO tpdatabase.users (`id`, `celular`, `email`, `first_name`, `first_time`, `last_name`, `numero_identificacion`, `password`, 
 `pregunta_seguridad`, `respuesta_seguridad`, `sexo`, `tipo_identificacion`, `tipo_user`, `username`,`recibir_notificaciones`,`datos_moviles`)
 VALUES (2, "celular2" , "mail2", "nombre2", "false", "apellido2", "identificacion2", "password2",
 "pregunta2", "respuesta2", "masculino", "DNI", "Administrado", "user2", true, false);
 INSERT INTO tpdatabase.users (`id`, `celular`, `email`, `first_name`, `first_time`, `last_name`, `numero_identificacion`, `password`, 
 `pregunta_seguridad`, `respuesta_seguridad`, `sexo`, `tipo_identificacion`, `tipo_user`, `username`,`recibir_notificaciones`,`datos_moviles`)
 VALUES (3, "celular3" , "mail3", "nombre3", "false", "apellido3", "identificacion3", "password3",
 "pregunta3", "respuesta3", "masculino", "DNI", "Administrado", "user3",  true, false); 
 INSERT INTO tpdatabase.users (`id`, `celular`, `email`, `first_name`, `first_time`, `last_name`, `numero_identificacion`, `password`, 
 `pregunta_seguridad`, `respuesta_seguridad`, `sexo`, `tipo_identificacion`, `tipo_user`, `username`,`recibir_notificaciones`,`datos_moviles`)
 VALUES (4, "celular4" , "mail4", "nombre4", "false", "apellido4", "identificacion4", "password4",
 "pregunta4", "respuesta4", "masculino", "DNI", "Inspector", "user4",  true, false);
  INSERT INTO tpdatabase.users (`id`, `celular`, `email`, `first_name`, `first_time`, `last_name`, `numero_identificacion`, `password`, 
 `pregunta_seguridad`, `respuesta_seguridad`, `sexo`, `tipo_identificacion`, `tipo_user`, `username`,`recibir_notificaciones`,`datos_moviles`)
 VALUES (5, "celular5" , "mail5", "nombre5", "false", "apellido5", "identificacion5", "password5",
 "pregunta5", "respuesta5", "masculino", "DNI", "Inspector", "user5",  true, false);
  INSERT INTO tpdatabase.users (`id`, `celular`, `email`, `first_name`, `first_time`, `last_name`, `numero_identificacion`, `password`, 
 `pregunta_seguridad`, `respuesta_seguridad`, `sexo`, `tipo_identificacion`, `tipo_user`, `username`,`recibir_notificaciones`,`datos_moviles`)
 VALUES (6, "celular6" , "mail6", "nombre6", "false", "apellido6", "identificacion6", "password6",
 "pregunta6", "respuesta6", "masculino", "DNI", "Inspector", "user6",  true, false);
 select id, username, password, tipo_user,pregunta_seguridad, respuesta_seguridad,first_name, last_name, email, celular 
 ,sexo,tipo_identificacion,numero_identificacion,first_time,datos_moviles, recibir_notificaciones from tpdatabase.users;
 


/*INSERTAR EDIFICIOS*/
INSERT INTO tpdatabase.edificios (id_edificio, cant_unidades, direccion, nombre, telefono) VALUES (1,40,"savedra 10","savedra 10", "2131342");
INSERT INTO tpdatabase.edificios (id_edificio, cant_unidades, direccion, nombre, telefono) VALUES (2,30,"catate 29","catate building", "23215412");
INSERT INTO tpdatabase.edificios (id_edificio, cant_unidades, direccion, nombre, telefono) VALUES (3,24,"suipaya 2332","sapayis", "7764565465");
select * from tpdatabase.edificios;
/*INSERTAR ESPECIALIDADES*/
INSERT INTO tpdatabase.especialidades (id_especialidad, descripcion, nombre) VALUES (1,"TRabajos de electricidad general","Electricidad");
INSERT INTO tpdatabase.especialidades (id_especialidad, descripcion, nombre) VALUES (2,"TRabajos de Albañileria","Albañileria");
INSERT INTO tpdatabase.especialidades (id_especialidad, descripcion, nombre) VALUES (3,"Trabajos de Pintura","Pintura");
INSERT INTO tpdatabase.especialidades (id_especialidad, descripcion, nombre) VALUES (4,"trabajos de Plomeria","Plomeria");
select * from tpdatabase.especialidades;
/*INSERTAR INSPECTORES*/
INSERT INTO tpdatabase.inspectores(id_inspector,id_user)VALUES(1,4);
INSERT INTO tpdatabase.inspectores(id_inspector,id_user)VALUES(2,5);
INSERT INTO tpdatabase.inspectores(id_inspector,id_user)VALUES(3,6);
select * from tpdatabase.inspectores;

/*INSERTAR INSPECTOR-ESPECIALIDAD*/
INSERT INTO tpdatabase.inspector_especialidad(id_inspectorespecialidad,id_especialidad,id_inspector) values(1,1,1);
INSERT INTO tpdatabase.inspector_especialidad(id_inspectorespecialidad,id_especialidad,id_inspector) values(2,2,1);
INSERT INTO tpdatabase.inspector_especialidad(id_inspectorespecialidad,id_especialidad,id_inspector) values(3,3,1);
INSERT INTO tpdatabase.inspector_especialidad(id_inspectorespecialidad,id_especialidad,id_inspector) values(4,4,1);
INSERT INTO tpdatabase.inspector_especialidad(id_inspectorespecialidad,id_especialidad,id_inspector) values(5,1,2);
INSERT INTO tpdatabase.inspector_especialidad(id_inspectorespecialidad,id_especialidad,id_inspector) values(6,1,3);
select * from tpdatabase.inspector_especialidad;
/*INSERTAR RELACION EDIFICIOS-INSPECTORES*/
INSERT INTO tpdatabase.inspector_edificio(id_inspectoredificio,id_edificio,id_inspector) values(1,1,1);
INSERT INTO tpdatabase.inspector_edificio(id_inspectoredificio,id_edificio,id_inspector) values(2,1,2);
INSERT INTO tpdatabase.inspector_edificio(id_inspectoredificio,id_edificio,id_inspector) values(3,1,3);
INSERT INTO tpdatabase.inspector_edificio(id_inspectoredificio,id_edificio,id_inspector) values(4,2,1);
INSERT INTO tpdatabase.inspector_edificio(id_inspectoredificio,id_edificio,id_inspector) values(5,2,2);
select * from tpdatabase.inspector_edificio;
/*INSERTAR UNIDADES*/
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (1,5,"B",1);
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (2,1,"C",2);
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (3,3,"A",3);
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (4,5,"Piso",1);
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (5,7,"D",2);
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (6,10,"F",3);
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (7,9,"A",1);
INSERT INTO tpdatabase.unidades (id_unidad, piso, unidad, id_edificio) VALUES (8,2,"B",2);
select * from tpdatabase.unidades order by id_edificio;
 
 /*INSERTAR ESPACIOS COMUNES*/
INSERT INTO tpdatabase.espacios_comunes (id_espaciocomun, descripcion, nombre, id_edificio) VALUES (1,"pileta","pileta",1);
INSERT INTO tpdatabase.espacios_comunes (id_espaciocomun, descripcion, nombre, id_edificio) VALUES (2,"ascensor","ascensor",1);
INSERT INTO tpdatabase.espacios_comunes (id_espaciocomun, descripcion, nombre, id_edificio) VALUES (3,"ascensor","ascensor",2);
INSERT INTO tpdatabase.espacios_comunes (id_espaciocomun, descripcion, nombre, id_edificio) VALUES (4,"pileta","pileta",1);
INSERT INTO tpdatabase.espacios_comunes (id_espaciocomun, descripcion, nombre, id_edificio) VALUES (5,"pileta","pileta",2);
INSERT INTO tpdatabase.espacios_comunes (id_espaciocomun, descripcion, nombre, id_edificio) VALUES (6,"ascensor","ascensor",3);
select * from tpdatabase.espacios_comunes;
 
/*INSERTAR ADMINISTRADO*/
INSERT INTO tpdatabase.administrado (`id_administrado`, `id_user`) VALUES (1, 1);
INSERT INTO tpdatabase.administrado (`id_administrado`, `id_user`) VALUES (2, 2);
INSERT INTO tpdatabase.administrado (`id_administrado`, `id_user`) VALUES (3, 3);
select * from tpdatabase.administrado;

/*INSERTAR ADMINISTRADO UNIDAD*/
INSERT INTO tpdatabase.administrad_unidad (`id_administradounidad`,`relacion`,`id_administrado`,`id_unidad`)VALUES(1,"Vividor",1,1);
INSERT INTO tpdatabase.administrad_unidad (`id_administradounidad`,`relacion`,`id_administrado`,`id_unidad`)VALUES(2,"Inquilino",2,5);
INSERT INTO tpdatabase.administrad_unidad (`id_administradounidad`,`relacion`,`id_administrado`,`id_unidad`)VALUES(3,"Dueño/Vividor",3,8);
select * from tpdatabase.administrad_unidad;

/*INSERTAR ESTADO*/
/*Abierto: Reclamo recien abierto sin tratar
Cerrado: Reclamo cerrado con solucion encontrada - Problema arreglado
Inspeccionando: en Bandeja del inspector X esperando por inspeccion
En Reparacion: reclamo en proceso de reparacion
Cancelado: Reclamo suspendido - Pedido Cancelado */
INSERT INTO tpdatabase.estados(`id_estado`,`descripcion`)VALUES(1,"Abierto");
INSERT INTO tpdatabase.estados(`id_estado`,`descripcion`)VALUES(2,"Cerrado");
INSERT INTO tpdatabase.estados(`id_estado`,`descripcion`)VALUES(3,"Inspeccionando");
INSERT INTO tpdatabase.estados(`id_estado`,`descripcion`)VALUES(4,"En Reparacion");
INSERT INTO tpdatabase.estados(`id_estado`,`descripcion`)VALUES(5,"Cancelado");
select * from tpdatabase.estados;

/*INSERTAR RECLAMOS*/
INSERT INTO tpdatabase.reclamos(`id_reclamo`,`nombre`,`descripcion`,`fecha`,`id_agrupador`,`id_edificio`,`id_especialidad`,`id_estado`,`username`)
VALUES(1,"Problema en Escalera","en la escalera se encientra la baranda suelta",20201101,null,1,2,1,
"user1");
INSERT INTO tpdatabase.reclamos(`id_reclamo`,`nombre`,`descripcion`,`fecha`,`id_agrupador`,`id_edificio`,`id_especialidad`,`id_estado`,`username`)
VALUES(2,"Problema Energia","Problemas de corte de luz en depto",20201102,null,2,1,2,
"user2");

INSERT INTO tpdatabase.reclamos(`id_reclamo`,`nombre`,`descripcion`,`fecha`,`id_agrupador`,`id_edificio`,`id_especialidad`,`id_estado`,`username`)
VALUES(3,"Problema de Pintura","se despinto la pared interna de depto",20201103,null,3,3,4,
"user4");
select * from tpdatabase.reclamos;