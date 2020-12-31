create table addresses
(
    id        bigint auto_increment
        primary key,
    city      varchar(128) not null,
    street    varchar(128) not null,
    building  int          not null,
    apartment int          not null
);
create table books
(
    id          bigint auto_increment
        primary key,
    title       varchar(200) not null,
    author      varchar(200) not null,
    description varchar(500) not null,
    year        int          not null,
    price       double       not null
);
create table clients
(
    id            bigint auto_increment
        primary key,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    address_id_fk bigint       not null,
    constraint address_id_fk
        foreign key (address_id_fk) references addresses (id)
);
create table orders
(
    id           bigint auto_increment
        primary key,
    total_price  double not null,
    client_id_fk bigint not null,
    constraint client_id_fk
        foreign key (client_id_fk) references clients (id)
);
create table orders_books
(
    id           bigint auto_increment
        primary key,
    orders_id_fk bigint not null,
    books_id_fk  bigint not null,
    constraint books_id_fk
        foreign key (books_id_fk) references books (id),
    constraint orders_id_fk
        foreign key (orders_id_fk) references orders (id)
);

