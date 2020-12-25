create database if not exists family_db;
use family_db;

drop table if exists family_tree;
drop table if exists family_values;
drop table if exists family_life_partners;
drop table if exists member_has_value;
drop table if exists sex;

drop table if exists new_tree_1;
drop table if exists new_tree_2;

-- ------------------------------------------------- --
--                   FAMILY TREE                     --
-- ------------------------------------------------- --

create table family_tree (
    id int not null auto_increment PRIMARY KEY,
	surname varchar(45) not null,
    name varchar(45) not null,
	credit_card_number varchar(20) not null,
    birth_date date not null,
	birth_place varchar(45) not null,
    death_date date not null,
    death_place varchar(45) not null,
    
	sex_id int not null,
    family_life_partners_id int not null,
    ancector_id int default null
);

-- ------------------------------------------------- --
--               FAMILY LIFE PARTNERS                --
-- ------------------------------------------------- --

create table family_life_partners (
    id int not null auto_increment PRIMARY KEY,
    surname varchar(45) not null,
	name varchar(45) not null,
    birth_date date not null,
    birth_place varchar(45) not null,
    death_date date not null,
    death_place varchar(45) not null,
    marriage_date date not null,
    
    sex_id int not null
);

-- ------------------------------------------------- --
--                   FAMILY VALUES                   --
-- ------------------------------------------------- --

create table family_values (
    id int not null auto_increment PRIMARY KEY,
    name varchar(45) not null,
    estimated_price int not null,
    max_price int not null,
    min_price int not null,
    catalog_code int not null
);

-- ------------------------------------------------- --
--                  MEMBER HAS VALUE                 --
-- ------------------------------------------------- --

create table member_has_value (
	id int auto_increment PRIMARY KEY,
    family_tree_id  int not null,
    family_values_id int not null
);

-- ------------------------------------------------- --
--                       SEX                         --
-- ------------------------------------------------- --

create table sex (
    id int not null auto_increment PRIMARY KEY,
    name varchar(45) not null
);