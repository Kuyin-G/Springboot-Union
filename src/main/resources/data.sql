# 表格并插入一定的数据
CREATE TABLE `tbl_user` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
      `userName` varchar(20) NOT NULL,
    `loginAccount` varchar(20) NOT NULL,
    `password` varchar(16) NOT NULL,
    `email` varchar(20) DEFAULT NULL,
     `createtime` date DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `loginAccount` (`loginAccount`)
 );