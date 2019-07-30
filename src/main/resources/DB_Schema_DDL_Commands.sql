CREATE SCHEMA `ems`;

CREATE TABLE `tbl_department` (
    `departmentId` CHAR(1) NOT NULL,
    `departmentName` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`departmentId`)
);




CREATE TABLE `tbl_role` (
    `roleId` CHAR(1) NOT NULL,
    `roleName` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`roleId`)
);



CREATE TABLE `tbl_status` (
    `status` CHAR(1) NOT NULL,
    `statusName` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`status`)
);



CREATE TABLE `tbl_employee_details` (
    `employeeCode` INT(10) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    `departmentId` CHAR(1) NOT NULL,
    `gender` CHAR(1) NOT NULL,
    `dateOfBirth` DATE NOT NULL,
    `mobileNumber` CHAR(10) NOT NULL,
    `emailId` VARCHAR(45) NOT NULL,
    `address` VARCHAR(250) NOT NULL,
    `roleId` CHAR(1) NOT NULL,
    `status` CHAR(1) NOT NULL,
    `createdBy` INT(10) NOT NULL,
    `createdDate` DATETIME NOT NULL,
    `modifiedBy` INT(10) NULL,
    `modifiedDate` DATETIME NULL,
    PRIMARY KEY (`employeeCode`),
    UNIQUE KEY (`mobileNumber`,`emailId`),
    CONSTRAINT `FR_employee_details_departmentId` FOREIGN KEY (`departmentId`)
        REFERENCES `tbl_department` (`departmentId`),
    CONSTRAINT `FR_employee_details_roleId` FOREIGN KEY (`roleId`)
        REFERENCES `tbl_role` (`roleId`)
);

CREATE TABLE `tbl_employee_details_log` (
    `employeeCode` INT(10) NOT NULL,
    `name` VARCHAR(30) NOT NULL,
    `departmentId` CHAR(1) NOT NULL,
    `gender` CHAR(1) NOT NULL,
    `dateOfBirth` DATE NOT NULL,
    `mobileNumber` CHAR(10) NOT NULL,
    `emailId` VARCHAR(45) NOT NULL,
    `address` VARCHAR(250) NOT NULL,
    `roleId` CHAR(1) NOT NULL,
    `status` CHAR(1) NOT NULL,
    `createdBy` INT(10) NOT NULL,
    `createdDate` DATETIME NOT NULL,
    `modifiedBy` INT(10) NULL,
    `modifiedDate` DATETIME NULL
);

CREATE TABLE `tbl_login_details` (
    `employeeCode` INT(10) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`employeeCode`),
    CONSTRAINT `FR_login_details_employeeCode` FOREIGN KEY (`employeeCode`)
        REFERENCES `tbl_employee_details` (`employeeCode`)
);





CREATE TABLE `tbl_balance` (
    `employeeCode` INT(10) NOT NULL,
    `balance` DECIMAL(10 , 2 ) NOT NULL,
    `createdBy` INT(10) NOT NULL,
    `createdDate` DATETIME NOT NULL,
    `modifiedBy` INT(10) NULL,
    `modifiedDate` DATETIME NULL,
    PRIMARY KEY (`employeeCode`),
    CONSTRAINT `FR_balance_employeeCode` FOREIGN KEY (`employeeCode`)
        REFERENCES `tbl_employee_details` (`employeeCode`)
);





CREATE TABLE `tbl_transaction` (
    `transactionId` INT(10) NOT NULL AUTO_INCREMENT,
    `employeeCode` INT(10) NOT NULL,
    `transactionType` CHAR(1) NOT NULL,
    `reason` VARCHAR(255) NOT NULL,
    `status` CHAR(1) NOT NULL,
    `comments` VARCHAR(255) NULL,
    `amount` DECIMAL(8 , 2 ) NOT NULL,
    `createdBy` INT(10) NOT NULL,
    `createdDate` DATETIME NOT NULL,
    `modifiedBy` INT(10) NULL,
    `modifiedDate` DATETIME NULL,
    PRIMARY KEY (`transactionId`),
    CONSTRAINT `FR_transaction_employeeCode` FOREIGN KEY (`employeeCode`)
        REFERENCES `tbl_employee_details` (`employeeCode`),
    CONSTRAINT `FR_transaction_status` FOREIGN KEY (`status`)
        REFERENCES `tbl_status` (`status`)
);


CREATE TABLE `tbl_transaction_log` (
    `transactionId` INT(10) NOT NULL,
    `employeeCode` INT(10) NOT NULL,
    `transactionType` CHAR(1) NOT NULL,
    `reason` VARCHAR(255) NOT NULL,
    `status` CHAR(1) NOT NULL,
    `comments` VARCHAR(255) NOT NULL,
    `amount` DECIMAL(8 , 2 ) NOT NULL,
    `createdBy` INT(10) NOT NULL,
    `createdDate` DATETIME NOT NULL,
    `modifiedBy` INT(10) NULL,
    `modifiedDate` DATETIME NULL
);













