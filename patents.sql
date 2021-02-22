CREATE TABLE `patents` (
  `application_sn` varchar(25) NOT NULL,
  `status` text,
  `patent_expiration_date` text,
  `center` text,
  `title` text,
  `patent_number` varchar(25) NOT NULL,
  `case_number` varchar(40) NOT NULL,
  PRIMARY KEY (`application_sn`,`patent_number`,`case_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
