CREATE DATABASE transactions DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

CREATE TABLE transactions.transaction (
                                          id INT NOT NULL AUTO_INCREMENT,
                                          type VARCHAR(20) NOT NULL,
                                          description VARCHAR(400) NOT NULL,
                                          amount DECIMAL(10, 2) NOT NULL,
                                          date INT NOT NULL,
                                          PRIMARY KEY (id)
);

INSERT INTO
    transaction (type, description, amount, date)
VALUES
    ('wydatek','opłaty', 1500.00,'1'), ('przychód', 'wypłata', 5500.00,'10');