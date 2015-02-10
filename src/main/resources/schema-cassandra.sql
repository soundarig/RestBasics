--CREATE KEYSPACE vsfnkeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };
 
 
drop table if exists employee;

CREATE TABLE employee(employeeNumber bigint, name text, city text, country text, emailaddress text, primary key((employeeNumber)));

insert into employee(employeenumber, name,city,country,emailaddress) values(112233, 'soundari','Bangalore','India','gnanasoundari.soundarajan@emc.com');

