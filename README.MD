# V 0.0.3 Prueba técnica talent adquisition

## Descripción 

Creación de un Back End CRUD con comunicación Rest utilizando lo que contiene las entidades: Entidades, Personas, Clientes, Cuentas y Movimientos. El objetivo demostrar conocimientos básico en creación de bases de datos, validaciones en backend.

## comandos docker 

* docker pull mysql
* docker volume create MysqlTalentAcquisition.
* docker volume ls.
* docker run -d -p 13306:3306 --name mysql_container -e MYSQL_ROOT_PASSWORD=JOSELE2015 --mount src=MysqlTalentAcquisition,dst=/var/lib/mysql mysql
* esperar al menos 2 minutos antes de digitar docker exec -it mysql_container mysql -uroot -p.
* create user 'PruebaTalentAcquisition' identified by 'DockerSecret'.
* grant all privileges on *.* to 'PruebasDocker'@'%';
* grant all privileges on *.* TO 'mysql_container'@'localhost';

## modificación en producción
* spring.datasource.url = jdbc:mysql://localhost:13306/PruebaTalentAcquisition

## Tecnologias
- MYSQL 8.0.
- Gestor de dependencia Maven 3.8.6.
- Spring boot 2.7.7.
- docker 4.15.0.
- wsdl 2 .