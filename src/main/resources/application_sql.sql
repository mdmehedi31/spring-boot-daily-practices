CREATE TABLE `employees` (
                             `id` int NOT NULL,
                             `first_name` varchar(255) DEFAULT NULL,
                             `last_name` varchar(255) DEFAULT NULL,
                             `email` varchar(255) DEFAULT NULL,
                             `department` varchar(255) DEFAULT NULL,
                             `salary` double DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- For create index of specific column
create index idx_email on employees(email);

-- For check which column has index
show index from employees;

-- For drop/remove the index from the column
DROP INDEX idx_email ON employees;