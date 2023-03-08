INSERT INTO clients(first_name, last_name, age)
VALUES ('Maksim', 'Medvedchuk', 33),
       ('Igor', 'Frank', 32);

INSERT INTO accounts(payment_card, money_amount, client)
VALUES ('147852369123', 1000, 1),
       ('147852369874', 2000, 1),
       ('258963147456', 3000, 2),
       ('123654789258', 4000, 2);

INSERT INTO payments( payment, order_amount, account)
VALUES ('communal services', 300, 1),
       ('internet', 25, 1),
       ('mobile connection', 15, 2),
       ('services of a lawyer', 100, 2),
       ('room rental', 60, 3),
       ('hotel reservation', 250, 3),
       ('donat for the army', 15, 4),
       ('a train ticket', 100, 4);