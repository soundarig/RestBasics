drop table  if exists  employee;

CREATE TABLE employee (                                 
           employeeNumber BIGINT,   
           name varchar(50) DEFAULT NULL,                    
           city varchar(50) DEFAULT NULL,                       
           country varchar(50) DEFAULT NULL,                   
           emailaddress varchar(50) DEFAULT NULL,               
           CONSTRAINT PK_employee PRIMARY KEY (employeeNumber)                         
         );


insert into employee(employeeNumber, name,city,country,emailaddress) values(112233, 'soundari','Bangalore','India','gnanasoundari.soundarajan@emc.com');

