
/*INSERTAR EDIFICIOS*/
INSERT INTO tpdatabase.edificios (id_edificio, cant_unidades, direccion, nombre, telefono) VALUES (1,40,"savedra 10","savedra 10", "2131342");
INSERT INTO tpdatabase.edificios (id_edificio, cant_unidades, direccion, nombre, telefono) VALUES (2,30,"catate 29","catate building", "23215412");
INSERT INTO tpdatabase.edificios (id_edificio, cant_unidades, direccion, nombre, telefono) VALUES (3,24,"suipaya 2332","sapayis", "7764565465");
select * from tpdatabase.edificios;
/*INSERTAR INSPECTORES*/
INSERT INTO tpdatabase.inspectores(id_inspector,apellido,nombre)VALUES(1,"Tissera","Rodrigo");
INSERT INTO tpdatabase.inspectores(id_inspector,apellido,nombre)VALUES(2,"Gadda","Rodrigo");
INSERT INTO tpdatabase.inspectores(id_inspector,apellido,nombre)VALUES(3,"Gonzalez","Alejandro");
select * from tpdatabase.inspectores;
/*INSERTAR RELACION EDIFICIOS-INSPECTORES*/
INSERT INTO tpdatabase.inspectores_edificios(inspector_id_inspector,edificios_id_edificio) values(1,1);
INSERT INTO tpdatabase.inspectores_edificios(inspector_id_inspector,edificios_id_edificio) values(2,1);
INSERT INTO tpdatabase.inspectores_edificios(inspector_id_inspector,edificios_id_edificio) values(3,1);
INSERT INTO tpdatabase.inspectores_edificios(inspector_id_inspector,edificios_id_edificio) values(1,2);
INSERT INTO tpdatabase.inspectores_edificios(inspector_id_inspector,edificios_id_edificio) values(2,2);
select * from tpdatabase.inspectores_edificios;
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
 

