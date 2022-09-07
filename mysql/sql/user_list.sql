DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  teacher VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO users (name, teacher) VALUES ("エナミコウジ", "Java・AWS");
INSERT INTO users (name, teacher) VALUES ("小山 由人", "Java");
INSERT INTO users (name, teacher) VALUES ("戸部拓人", "Java");
INSERT INTO users (name, teacher) VALUES ("ウシジマユウタ", "AWS");
INSERT INTO users (name, teacher) VALUES ("中西 悠人", "AWS");
