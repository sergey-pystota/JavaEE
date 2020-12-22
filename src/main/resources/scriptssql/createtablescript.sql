CREATE TABLE books
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(200) not null ,
    author      VARCHAR(200) not null ,
    description VARCHAR(500) not null ,
    year        INT not null ,
    price       DOUBLE not null
);