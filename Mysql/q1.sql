use we2foodiesdb;
create table login
(
email varchar(30) primary key,
password varchar(15),
role char(1)
);

drop table login;

drop table user;

create table user
(
id int auto_increment primary key,
email varchar(30) ,
name varchar(35),
mobile varchar(10),
address varchar(70),
password varchar(16),
role char(1)
);


alter table user
modify column password varchar(80);
update user set password='$2a$10$5rkj3KGKcWWUHF1pvDtV/.0B1JtLpzz5j9rp4NKH4CwauXOtkoYHu';
commit;

delete from user;
select * from user;
commit;

CREATE TABLE `we2foodiesdb`.`resources` (
  `id` INT auto_increment,
  `name` VARCHAR(45) NOT NULL,
  `path` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `resourcescol_UNIQUE` (`path` ASC) VISIBLE);


