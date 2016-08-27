-- create database test_db;

-- create schema test_schema;

drop table if exists test_schema.user;

create table test_schema.user (
  id BIGSERIAL primary key,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  age NUMERIC,
  phone_number VARCHAR(20)
);

insert into test_schema.user (first_name, last_name, age, phone_number)
  values ('john', 'doe', 1, '111-111-111');