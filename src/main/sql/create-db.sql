SET NAMES utf8;

DROP DATABASE IF EXISTS departmentsdb;
CREATE DATABASE departmentsdb CHARACTER SET utf8 COLLATE utf8_bin;

USE departmentsdb;


CREATE TABLE departments(
	id BIGINT NOT NULL auto_increment PRIMARY KEY,
	name VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE employees(
	id BIGINT NOT NULL auto_increment PRIMARY KEY,
	email VARCHAR(255) NOT NULL UNIQUE,
	recruitment_date DATE NOT NULL,
	name VARCHAR(255) NOT NULL,
	salary DOUBLE NOT NULL,
	department_id BIGINT NOT NULL,
	FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE
);

INSERT INTO departments VALUES(DEFAULT, 'department');
INSERT INTO employees VALUES(DEFAULT, 'das@gmail', '01.01.2000', 'sanya', '3000', 1);


SELECT * FROM departments;
SELECT * FROM employees;