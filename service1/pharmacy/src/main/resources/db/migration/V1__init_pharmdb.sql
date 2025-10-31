-- CATEGORY TABLE
create table if not exists category
(
    id integer generated always as identity primary key,
    name varchar(255),
    description varchar(255)
);

-- MEDICINE TABLE
create table if not exists medicine
(
     id integer generated always as identity primary key,
     name varchar(255) not null,
     description varchar(255),
     brand varchar(255),
     dosage varchar(255), -- e.g., "500mg", "10ml"
     available_quantity double precision not null,
     price numeric(38, 2) not null,
     expiry_date date not null,
     category_id integer
         constraint fk_medicine_category references category
);

-- SEQUENCES
drop sequence if exists category_seq;
create sequence category_seq start 1 increment 1;

drop sequence if exists medicine_seq;
create sequence medicine_seq start 1 increment 1;
