use `ems`;

INSERT INTO `tbl_department` (`departmentId`, `departmentName`) VALUES ('S', 'SOFTWARE');

INSERT INTO `tbl_department` (`departmentId`, `departmentName`) VALUES ('A', 'ACCOUNTS');

INSERT INTO `tbl_department` (`departmentId`, `departmentName`) VALUES ('P', 'PURCHASE');

INSERT INTO `tbl_department` (`departmentId`, `departmentName`) VALUES ('M', 'MARKETING');

INSERT INTO `tbl_department` (`departmentId`, `departmentName`) VALUES ('D', 'ADMIN');


INSERT INTO `tbl_role` (`roleId`, `roleName`) VALUES ('A', 'ADMIN');
INSERT INTO `tbl_role` (`roleId`, `roleName`) VALUES ('E', 'EMPLOYEE');
INSERT INTO `tbl_role` (`roleId`, `roleName`) VALUES ('M', 'ACCOUNT_MANAGER');

INSERT INTO `tbl_status` (`status`, `statusName`) VALUES ('C', 'CREATED');
INSERT INTO `tbl_status` (`status`, `statusName`) VALUES ('A', 'APPROVED');
INSERT INTO `tbl_status` (`status`, `statusName`) VALUES ('R', 'REJECTED');
INSERT INTO `tbl_status` (`status`, `statusName`) VALUES ('X', 'CANCELLED');
INSERT INTO `tbl_status` (`status`, `statusName`) VALUES ('P', 'RECEIVED');
INSERT INTO `tbl_status` (`status`, `statusName`) VALUES ('D', 'DEDUCTED');


INSERT INTO `tbl_employee_details` ( `name`, `departmentId`, `gender`, `dateOfBirth`, `mobileNumber`, `emailId`, `address`, `roleId`, `status`, `createdBy`, `createdDate`, `modifiedBy`, `modifiedDate`) VALUES ( 'admin', 'A', 'M', '1996-06-06','9876543210', 'admin@medplus.com', 'Hyderabad', 'A', 'D',0, '2019-07-15 09:22:00',0, '0000-00-00 00:00:00');


INSERT INTO `tbl_login_details`(`employeeCode`,`password`) VALUES (1,"admin");
