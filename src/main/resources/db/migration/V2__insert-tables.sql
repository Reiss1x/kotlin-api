INSERT INTO category (name) VALUES ('Category A');
INSERT INTO category (name) VALUES ('Category B');
INSERT INTO category (name) VALUES ('Category C');

INSERT INTO product (name, prices) VALUES ('Banana', 2.99);
INSERT INTO product (name, prices) VALUES ('Maçã', 1.49);
INSERT INTO product (name, prices) VALUES ('Abacaxi', 5.99);

INSERT INTO product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO product_category (product_id, category_id) VALUES (3, 3);