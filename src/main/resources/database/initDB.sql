CREATE TABLE IF NOT EXISTS accounts
(
    id SERIAL PRIMARY KEY ,
    credit_card BIGINT NOT NULL ,
    payment_card BIGINT NOT NULL ,
    FOREIGN KEY (clientId) REFERENCES clients (id)


);

CREATE TABLE IF NOT EXISTS clients
(
    id SERIAL PRIMARY KEY ,
    first_name VARCHAR(50) NOT NULL ,
    last_name VARCHAR(50) NOT NULL ,
    age INT NOT NULL
);