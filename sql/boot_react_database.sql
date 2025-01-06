CREATE DATABASE boot_react;

USE boot_react;

-- CREATE TABLE users (
-- 	user_name  VARCHAR(20) PRIMARY KEY NOT NULL,
--     user_password VARCHAR(50) NOT NULL
-- );

-- SELECT * FROM users;

-- INSERT INTO users VALUES ('ja2pyc', '1234'
-- );

DROP TABLE users;

SELECT * FROM users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO users (name, email) VALUES
('Alice', 'alice@example.com'),
('Bob', 'bob@example.com');
