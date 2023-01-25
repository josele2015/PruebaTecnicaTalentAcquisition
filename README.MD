# V 1.0.0 Prueba técnica talent adquisition

## Descripción 

Creación de un Back End CRUD con comunicación Rest utilizando lo que contiene las entidades: Entidades, Personas, Clientes, Cuentas y Movimientos. El objetivo demostrar conocimientos básico en creación de bases de datos, validaciones en backend.

## comandos docker 

* Digitar. "docker pull mysql".
* Digitar. "docker compose up".
* Digitar. "docker network connect network_talent_acquisition mysql_container".(Ejecuta docker-compose)
* Digitar. "mvn clean install". Verificar que este compilado con el JDK 1.8 o compilarlo con Maven 3.8.6. "mvn spring-boot:run".
* Digitar. "docker build -t back_mysql_rest_talent_acquisition:V1"(Ejecuta el archivo dockerfile)
* Digitar. "docker run --network network_talent_acquisition -d -p 18082:8082 --name springboot back_mysql_rest_talent_acquisition:V1"
* Esperar al menos 2 minutos antes de digitar. docker exec -it mysql_container mysql -uroot -p.
* Ejecutar las lineas sql talentAcquisition.sql que esta en este proyecto con un sofware como workbench
* create user 'PruebaTalentAcquisition' identified by 'DockerSecret'.
* grant all privileges on *.* to 'PruebasDocker'@'%';
* grant all privileges on *.* TO 'mysql_container'@'localhost';

## modificación en producción
* spring.datasource.url = jdbc:mysql://localhost:13306/PruebaTalentAcquisition

## Tecnologias
- MYSQL 8.0.
- Gestor de dependencia Maven 3.8.6.
- JDK 1.8
- Spring boot 2.7.7.
- docker 4.15.0.
- wsdl 2 .