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
