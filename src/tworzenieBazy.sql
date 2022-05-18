CREATE DATABASE transactions DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

CREATE TABLE transactions.transaction (
                                          id INT NOT NULL AUTO_INCREMENT,
                                          type VARCHAR(20) NOT NULL,
                                          description VARCHAR(400) NOT NULL,
                                          amount DECIMAL(10, 2) NOT NULL,
                                          date DATE NOT NULL,
                                          PRIMARY KEY (id)
);

INSERT INTO
    transaction (type, description, amount, date)
VALUES
    ('wydatek','opłaty', 1500.00,'2020-05-05'), ('przychód', 'wypłata', 5500.00,'2021-05-10');