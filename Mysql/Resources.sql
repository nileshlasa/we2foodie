SELECT * FROM we2foodiesdb.resources;
insert into we2foodiesdb.resources (name,path) values ('MAIN_iMAGE','images/hero-bg.jpg');

update we2foodiesdb.resources set name='main_image';


commit;CREATE TABLE `resources` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `path` varchar(100) NOT NULL,
  `type` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resourcescol_UNIQUE` (`path`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
