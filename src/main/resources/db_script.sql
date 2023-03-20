CREATE TABLE IF NOT EXISTS `Customer` (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    surname VARCHAR(50)
);

CREATE TABLE `Account` (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    balance DOUBLE PRECISION,
    CONSTRAINT FK_CustomerAccount FOREIGN KEY (customer_id)
     REFERENCES `Customer`(customer_id)
);

CREATE TABLE `Transaction` (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    amount DOUBLE PRECISION,
    CONSTRAINT FK_AccountTransaction FOREIGN KEY (account_id)
       REFERENCES `Account`(account_id)
);


INSERT INTO `Customer`(customer_id, name, surname) VALUES (1, 'hilarion', 'kodia');
INSERT INTO `Customer`(customer_id, name, surname) VALUES (2, 'lewis', 'hamilton');
INSERT INTO `Customer`(customer_id, name, surname) VALUES (3, 'max', 'verstappen');
INSERT INTO `Customer`(customer_id, name, surname) VALUES (4, 'charles', 'leclerc');
