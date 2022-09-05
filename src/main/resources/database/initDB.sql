CREATE TABLE IF NOT EXISTS accounts
(
    id    SERIAL PRIMARY KEY ,
    name  CHAR(90) NOT NULL ,
    owner CHAR(50) NOT NULL ,
    link  text ,
    mail  CHAR(200) ,
    account CHAR(50) ,
    password CHAR(30)  NOT NULL
);
-- DROP TABLE IF EXISTS accounts