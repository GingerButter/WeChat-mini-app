


use mydb;

CREATE TABLE `mydb`.`member`(  
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(30),
  `name` VARCHAR(100),
  `credits` DOUBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `IDX_PHONE` (`phone`)
) ENGINE=INNODB CHARSET=utf8mb4;


INSERT INTO member(phone,`name`,credits) 
  VALUES('18911230117','佟强',500),('18812345678','Tony',2800);
  
  CREATE TABLE `mydb`.`detail`(  
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '交易记录ID',
  `memberId` BIGINT NOT NULL COMMENT '会员ID',
  `amount` DOUBLE NOT NULL COMMENT '充值为正，消费为负',
  `comment` VARCHAR(500) COMMENT '交易备注',
  `finishTime` DATETIME COMMENT '交易完成时间',
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_MID` FOREIGN KEY (`memberId`) REFERENCES `mydb`.`member`(`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
) ENGINE=INNODB CHARSET=utf8mb4;

CREATE TABLE `mydb`.`myuser`(  
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200),
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4;

INSERT INTO myuser(`name`) VALUES('张三'),('李四');

CREATE TABLE `mydb`.`userinfo`(  
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200),
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8mb4;

INSERT INTO userinfo(`name`) VALUES('张三'),('李四');

