CREATE TABLE IF NOT EXISTS clients
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    age        INT         NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts
(
    id           SERIAL PRIMARY KEY,
    payment_card VARCHAR(30) NOT NULL,
    money_amount INT         NOT NULL,
    client       INT REFERENCES clients (id)
);

CREATE TABLE IF NOT EXISTS payments
(
    id           SERIAL PRIMARY KEY,
    payment      VARCHAR(1000) NOT NULL,
    order_amount INT           NOT NULL,
    account      INT REFERENCES accounts (id)
);











