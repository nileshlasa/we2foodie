CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `name` varchar(35) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `address` varchar(70) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




