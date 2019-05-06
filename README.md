# JEMS Starbucks
Emmeline Tsen
Sindhuja Ramini
Matt DiPietro
Jonathan Gee

# Steps
1. Import project on IntelliJ through the pom.xml file
2. On the terminal, run mysql: mysql -u root
3. Create database and tables:
CREATE DATABASE restapi;
USE restapi;

CREATE TABLE cards (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    card VARCHAR(500) NOT NULL,
    amt DOUBLE NOT NULL
);

4. Insert values into database from terminal on mysql:
INSERT into cards (id, card, amt) VALUES ('1', '123456789', 20.0)

5. Execute through MainApplicationClass
6. 
To see all cards: 
http://localhost:8080/cards