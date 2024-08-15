-- Insertar datos de prueba en la tabla cor_user
INSERT INTO practica.cor_user
(id, email, lastname, "name", "password", phone)
VALUES
    (nextval('user_seq'), 'john.doe@example.com', 'Doe', 'John', 'password123', '123-456-7890'),
    (nextval('user_seq'), 'jane.smith@example.com', 'Smith', 'Jane', 'password456', '098-765-4321');