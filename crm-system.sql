drop schema if exists crmsystemdb;
CREATE SCHEMA `crmsystemdb` DEFAULT CHARACTER SET utf8;

use crmsystemdb;

drop table if exists customer;
CREATE TABLE `customer` (
`id` int not null auto_increment,
`FirstName` varchar(100) NULL,
`LastName` varchar(100) NULL,
`NickName` varchar(100) NULL,
`Email` varchar(100) NULL,
`Phone` varchar(100) NULL,
`CVR` varchar(100) NULL,
`DateOfBirth` varchar(100) NULL,
`Adress1` varchar(100) NULL,
`Adress2` varchar(100) NULL,
`City` varchar(100) NULL,
`PostalCode` varchar(100) NULL,
`Country` varchar(100) NULL,
`Website` varchar(100) NULL,
`Facebook` varchar(100) NULL,
`Trello` varchar(100) NULL,
`GitHub` varchar(100) NULL,
`gmail` varchar(100) NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `crmsystemdb`.`customer` (`FirstName`, `LastName`, `Email`, `Phone`, `DateOfBirth`, `PostalCode`, `Country`, `Facebook`, `Trello`, `GitHub`) values ('Adil', 'Hussain', 'adhus91@gmail.com', '', '150891', '', 'Danmark', 'https://www.facebook.com/profile.php?id=100001484700711', '@adhus911', 'adil0049');
insert into `crmsystemdb`.`customer` (`FirstName`, `LastName`, `Email`, `Phone`, `DateOfBirth`, `PostalCode`, `Country`, `Facebook`, `Trello`, `GitHub`) values ('Jack', 'Zhong', 'bakagami007@gmail.com', '', '070397', '', 'Danmark', 'https://www.facebook.com/jack.zhong.758', '@chimichanga3', 'managerjack');
insert into `crmsystemdb`.`customer` (`FirstName`, `LastName`, `Email`, `Phone`, `DateOfBirth`, `PostalCode`, `Country`, `Facebook`, `Trello`, `GitHub`) values ('Jonas', 'Sørensen', 'adhus91@gmail.com', '', '070793', '3520', 'Danmark', 'https://www.facebook.com/jonas.aka.bjarne', '@j0nas7', 'J0nas7');
insert into `crmsystemdb`.`customer` (`FirstName`, `LastName`, `Email`, `Phone`, `DateOfBirth`, `PostalCode`, `Country`, `Facebook`, `Trello`, `GitHub`) values ('Morten', 'Therkildsen', 'morten@therkildsen.com', '28408191', '291074', '2880', 'Danmark', 'https://www.facebook.com/morten.therkildsen.7', '@mortentherkildsen', 'MortenGTherkildsen');



