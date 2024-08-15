CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE cor_user
(
    id       INTEGER      NOT NULL,
    email    VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT cor_user_pkey PRIMARY KEY (id)
);