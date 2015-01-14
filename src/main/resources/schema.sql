drop table  if exists  employee;

CREATE TABLE employee (                                 
           employeeNumber serial,   
           name varchar(50) DEFAULT NULL,                    
           city varchar(50) DEFAULT NULL,                       
           country varchar(50) DEFAULT NULL,                   
           emailaddress varchar(50) DEFAULT NULL,               
           CONSTRAINT PK_employee PRIMARY KEY (employeeNumber)                         
         );


	insert into employee(name,city,country,emailaddress) values('soundari','Bangalore','India','gnanasoundari.soundarajan@emc.com');
	insert into employee(name,city,country,emailaddress) values('test','TamilNadu','India','test@gmail.com');
