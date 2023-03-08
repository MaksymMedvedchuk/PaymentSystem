INSERT INTO clients(first_name, last_name, age)
VALUES ('Maksim', 'Medvedchuk', 33),
       ('Igor', 'Frank', 32);

INSERT INTO accounts(payment_card, client)
VALUES (147852369123, 1),
       (147852369874, 1),
       (258963147456, 2),
       (123654789258, 2);

INSERT INTO payments(payment, account)
VALUES ('communal services', 1),
       ('internet', 1),
       ('mobile connection', 2),
       ('services of a lawyer', 2),
       ('room rental', 3),
       ('hotel reservation', 3),
       ('donat for the army', 4),
       ('a train ticket', 4);