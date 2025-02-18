CREATE DATABASE IF NOT EXISTS bibliothequeJava;
USE bibliothequeJava;
CREATE TABLE Livre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(50) UNIQUE NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    date_publication VARCHAR(50) NOT NULL
);