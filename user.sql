CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `roles` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
