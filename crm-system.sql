drop schema if exists crmsystemdb;
CREATE SCHEMA `crmsystemdb` DEFAULT CHARACTER SET utf8;

use crmsystemdb;

drop table if exists CRM_Customer;
CREATE TABLE `CRM_Customer` (
`CRM_Customer_Id` int not null auto_increment,
`CRM_Customer_FirstName` varchar(100) NULL,
`CRM_Customer_LastName` varchar(100) NULL,
`CRM_Customer_NickName` varchar(100) NULL,
`CRM_Customer_Email` varchar(100) NULL,
`CRM_Customer_Phone` varchar(100) NULL,
`CRM_Customer_CVR` varchar(100) NULL,
`CRM_Customer_DOB` varchar(100) NULL,
`CRM_Customer_Adress1` varchar(100) NULL,
`CRM_Customer_Adress2` varchar(100) NULL,
`CRM_Customer_City` varchar(100) NULL,
`CRM_Customer_PostalCode` varchar(100) NULL,
`CRM_Customer_Country` varchar(100) NULL,
`CRM_Customer_Website` varchar(100) NULL,
`CRM_Customer_Facebook` varchar(100) NULL,
`CRM_Customer_Trello` varchar(100) NULL,
`CRM_Customer_GitHub` varchar(100) NULL,
`CRM_Customer_Gmail` varchar(100) NULL,
PRIMARY KEY (`CRM_Customer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`, `CRM_Customer_Email`, `CRM_Customer_Phone`, `CRM_Customer_DOB`, `CRM_Customer_PostalCode`, `CRM_Customer_Country`, `CRM_Customer_Facebook`, `CRM_Customer_Trello`, `CRM_Customer_GitHub`) values ('Adil', 'Hussain', 'adhus91@gmail.com', '', '150891', '', 'Danmark', 'https://www.facebook.com/profile.php?id=100001484700711', '@adhus911', 'adil0049');
insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`, `CRM_Customer_Email`, `CRM_Customer_Phone`, `CRM_Customer_DOB`, `CRM_Customer_PostalCode`, `CRM_Customer_Country`, `CRM_Customer_Facebook`, `CRM_Customer_Trello`, `CRM_Customer_GitHub`) values ('Jack', 'Zhong', 'bakagami007@gmail.com', '', '070397', '', 'Danmark', 'https://www.facebook.com/jack.zhong.758', '@chimichanga3', 'managerjack');
insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`, `CRM_Customer_Email`, `CRM_Customer_Phone`, `CRM_Customer_DOB`, `CRM_Customer_PostalCode`, `CRM_Customer_Country`, `CRM_Customer_Facebook`, `CRM_Customer_Trello`, `CRM_Customer_GitHub`) values ('Jonas', 'Sørensen', 'adhus91@gmail.com', '', '070793', '3520', 'Danmark', 'https://www.facebook.com/jonas.aka.bjarne', '@j0nas7', 'J0nas7');
insert into `crmsystemdb`.`CRM_Customer` (`CRM_Customer_FirstName`, `CRM_Customer_LastName`, `CRM_Customer_Email`, `CRM_Customer_Phone`, `CRM_Customer_DOB`, `CRM_Customer_PostalCode`, `CRM_Customer_Country`, `CRM_Customer_Facebook`, `CRM_Customer_Trello`, `CRM_Customer_GitHub`) values ('Morten', 'Therkildsen', 'morten@therkildsen.com', '28408191', '291074', '2880', 'Danmark', 'https://www.facebook.com/morten.therkildsen.7', '@mortentherkildsen', 'MortenGTherkildsen');



