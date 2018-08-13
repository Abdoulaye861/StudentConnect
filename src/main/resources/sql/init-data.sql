CREATE DATABASE Implementation_student-connect_db ;
USE Implementation_student-connect_db ;


CREATE TABLE Student(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
FirstName CHAR(20) NOT NULL,
LastName  CHAR(20) NOT NULL,

)ENGINE = InnoDB CHARACTER SET latin1 COLLATE latin1_bin;