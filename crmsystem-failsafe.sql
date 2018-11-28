drop schema if exists crmsystemdb;
CREATE SCHEMA `crmsystemdb` DEFAULT CHARACTER SET utf8;

use crmsystemdb;

drop table if exists CRM_Customer;
CREATE TABLE `CRM_Customer` (
`CRM_Customer_Id` int not null auto_increment,
`CRM_Customer_FirstName` varchar(100) NULL,
`CRM_Customer_LastName` varchar(100) NULL,
PRIMARY KEY (`CRM_Customer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`) values ('Adil', 'Hussain');
insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`) values ('Jack', 'Zhong');
insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`) values ('Jonas', 'Sørensen');
insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`) values ('Morten', 'Therkildsen');



