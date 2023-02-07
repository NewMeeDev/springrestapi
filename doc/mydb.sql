----------------------------------------------------------
-- springrestapi - Vorgehensweise via Springboot Hibernate
----------------------------------------------------------

use mydb;

-- einen Admin-User anlegen
create user 'neumee'@'%' identified by 'H@16bed7'; -- Creates the user

-- dem Admin-User alle Rechte auf die gerade angelegte DB geben
grant all on mydb.* to 'neumee'@'%';


-- einen User für Springboot anlegen
create user 'springuser'@'%' identified by '#EBIT2022'; -- Creates the user

-- dem Springboot User alle Rechte auf die gerade angelegte DB geben
grant all on mydb.* to 'springuser'@'%';

create table tbl_employee 
( 
id int not null auto_increment primary key,
name varchar(255) not null,
age int not null,
location varchar(255) not null,
email varchar(255) not null,
department varchar(255) not null
)

insert into tbl_employee (name, age, location, email, department) 
values ('Maxi Lange', 28, 'Germany', 'leckme@web.de', 'HR');

insert into tbl_employee (name, age, location, email, department) 
values ('Frieda Friedrich', 68, 'Hungary', 'lefried@web.de', 'Service');

insert into tbl_employee (name, age, location, email, department) 
values ('Marc Neumann', 45, 'Germany', 'neumee@web.de', 'IT');


-- wenn die Anwendung läuft, sollte man dem Springboot User alle Rechte
revoke all on mydb.* from 'springuser'@'%';

-- und dann nur die wirklich benötigten CRUD-Rechte zuweisen, sodass keine Änderungen an der Struktur der DB mehr möglich sind
grant select, insert, delete, update on mydb.* to 'springuser'@'%';

-- jetzt kann die Springboot Applikation via Hibernate die DB mit den Entities aus dem Programm füllen

select * from tbl_employee;

-- drop table tbl_employee 
