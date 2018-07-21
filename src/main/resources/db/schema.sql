CREATE TABLE product (
  id INT(6) AUTO_INCREMENT,
  code VARCHAR(10) NOT NULL,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(255) NOT NULL,
  base_product VARCHAR(1),
  date_from DATE,
  date_to DATE,
  PRIMARY KEY(id),
);

CREATE TABLE product_associate (
  main_product_id INT(6),
  associate_product_id INT(6),
  PRIMARY KEY(main_product_id, associate_product_id)
)

CREATE TABLE product_parameter (
  id INT(6) AUTO_INCREMENT,
  code VARCHAR(10) NOT NULL,
  value VARCHAR(255),
  date_from DATE,
  date_to DATE,
  product_id INT(6),
  PRIMARY KEY(id),
  FOREIGN KEY (product_id) references product(id)
)