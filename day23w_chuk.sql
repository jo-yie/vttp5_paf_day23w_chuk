-- drop database if exists 
DROP DATABASE IF EXISTS day23w_chuk; 

-- create database 
CREATE DATABASE day23w_chuk; 

-- use database 
USE day23w_chuk; 

-- create table shopping_cart
CREATE TABLE shopping_cart (
    shopping_id int auto_increment, 
    name varchar(128) not null, 
    address varchar(128) not null, 
    delivery_date date not null, 
    CONSTRAINT pk_shopping_id PRIMARY KEY (shopping_id)
);

-- create table line_item
CREATE TABLE line_item (
    item_id int auto_increment, 
    name varchar(128) not null, 
    quantity int not null, 
    unit_price decimal(5,2) not null, 
    shopping_id int not null,
    CONSTRAINT pk_item_id PRIMARY KEY (item_id),
    CONSTRAINT fk_shopping_id FOREIGN KEY (shopping_id)
        REFERENCES shopping_cart(shopping_id)
);

-- drop user if exists
DROP USER IF EXISTS 'day23w_chuk'@'%';

-- create user 
CREATE USER 'day23w_chuk'@'%' IDENTIFIED BY 'password'; 
FLUSH PRIVILEGES; 

-- grant privileges 
GRANT ALL PRIVILEGES ON day23w_chuk.* TO 'day23w_chuk'@'%';
FLUSH PRIVILEGES; 