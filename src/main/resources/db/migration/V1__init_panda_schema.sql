create schema if not exists panda;
SET search_path TO panda;

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS owners;
DROP TABLE IF EXISTS mails;
DROP TABLE IF EXISTS types;

CREATE TABLE IF NOT EXISTS mails
(
    id   SERIAL PRIMARY KEY,
    mail CHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS owners
(
    id         SERIAL PRIMARY KEY,
    owner_name CHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS types
(
    id         SERIAL PRIMARY KEY,
    type CHAR(200) NOT NULL
);


CREATE TABLE IF NOT EXISTS accounts
(
    id       SERIAL PRIMARY KEY,
    name     CHAR(90)  NOT NULL,
    account  CHAR(50),
    password CHAR(30)  NOT NULL,
    link     text,
    description text,
    mail     integer   NOT NULL,
    owner    integer   NOT NULL,
    type    integer NOT NULL,
    date     timestamp NOT NULL
);
