CREATE TABLE User (
  customer_id serial PRIMARY KEY,
  name VARCHAR(50),
  surname VARCHAR(50)
);

CREATE TABLE Transaction (
   transaction_id serial PRIMARY KEY,
   account_id INT NOT NULL,
   amount DOUBLE PRECISION,
   CONSTRAINT FK_AccountTransaction FOREIGN KEY (account_id)
       REFERENCES Account(account_id)
);

CREATE TABLE Account (
   account_id serial PRIMARY KEY,
   customer_id INT NOT NULL,
   balance DOUBLE PRECISION,
   CONSTRAINT FK_CustomerAccount FOREIGN KEY (customer_id)
       REFERENCES User(customer_id)
);

INSERT INTO User(name, surname) VALUES ('hilarion', 'kodia');
INSERT INTO User(name, surname) VALUES ('lewis', 'hamilton');
INSERT INTO User(name, surname) VALUES ('max', 'verstappen');
INSERT INTO User(name, surname) VALUES ('charles', 'leclerc');
