CREATE DATABASE restapi;
USE restapi;

CREATE TABLE cards (
                       card_id VARCHAR(255) PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       amt DOUBLE NOT NULL
);

CREATE TABLE users(
                      username VARCHAR(255) PRIMARY KEY,
                      hashed_password VARCHAR(255) NOT NULL
);

CREATE TABLE maps(
                     store_address VARCHAR(255) PRIMARY KEY,
                     city VARCHAR(255) NOT NULL
);

CREATE TABLE sessions(
                    session_id INT(8) AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(255) NOT NULL
);