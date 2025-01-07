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

CREATE TABLE posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

SELECT * FROM posts;


INSERT INTO posts (id, title, content, author) VALUES 
(null, "제목 1", "내용 1", "작성자 1"), 
(null, "제목 2", "내용 2", "작성자 2"), 
(null, "제목 3", "내용 3", "작성자 3"),
(null, "제목 4", "내용 4", "작성자 4"), 
(null, "제목 5", "내용 5", "작성자 5"), 
(null, "제목 6", "내용 6", "작성자 6"), 
(null, "제목 7", "내용 7", "작성자 7"), 
(null, "제목 8", "내용 8", "작성자 8"), 
(null, "제목 9", "내용 9", "작성자 9"), 
(null, "제목 10", "내용 10", "작성자 10");
