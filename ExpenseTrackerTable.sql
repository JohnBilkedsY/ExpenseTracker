CREATE DATABASE expense_tracker;

USE expense_tracker;

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    description VARCHAR(255),
    date DATE NOT NULL
);
