CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    prices DOUBLE PRECISION,
    description TEXT
);