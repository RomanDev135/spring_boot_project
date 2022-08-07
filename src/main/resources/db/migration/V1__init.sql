drop table if exists products;
create table products
(
    id          serial primary key,
    title       varchar(255) UNIQUE NOT NULL,
    description TEXT,
    price       BIGINT

);



insert into products(title, description, price)
values ('MacBook', 'Ultra low and Great Power', 3000),
       ('iPhone', 'The most expensive phone by credit', 1000),
       ('iPad', 'More size - more cost', 1500),
       ('iMac', 'More size - more cost', 4000);

-- тестовая таблица

drop table if exists items;
create table items
(
    id    serial,
    title varchar(40)

);
insert into items (title)
values ('stone'),
       ('knife'),
       ('spoon');