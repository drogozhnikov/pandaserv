create schema if not exists panda;

DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS owners;
DROP TABLE IF EXISTS mails;

SET search_path TO panda;

CREATE TABLE IF NOT EXISTS mails
(
    id   SERIAL PRIMARY KEY,
    mail VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS owners
(
    id         SERIAL PRIMARY KEY,
    owner_name VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(90) NOT NULL,
    account     VARCHAR(50),
    password    VARCHAR(30) NOT NULL,
    link        text,
    description text,
    mail        integer     NOT NULL,
    owner       integer     NOT NULL,
    type        VARCHAR(10) NOT NULL DEFAULT 'TEMP'
);

ALTER TABLE accounts
    ADD FOREIGN KEY (mail) REFERENCES mails (id);
ALTER TABLE accounts
    ADD FOREIGN KEY (owner) REFERENCES owners (id);
