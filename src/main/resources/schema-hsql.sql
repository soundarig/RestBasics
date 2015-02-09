drop table  if exists  employee;

CREATE TABLE employee (                                 
           employeenumber BIGINT,   
           name varchar(50) DEFAULT NULL,                    
           city varchar(50) DEFAULT NULL,                       
           country varchar(50) DEFAULT NULL,                   
           emailaddress varchar(50) DEFAULT NULL,               
           CONSTRAINT PK_employee PRIMARY KEY (employeenumber)                         
         );


insert into employee(employeenumber, name,city,country,emailaddress) values(112233, 'soundari','Bangalore','India','gnanasoundari.soundarajan@emc.com');

