CREATE DATABASE  IF NOT EXISTS `plantCom`;
USE `plantCom`;

--質問内容を格納
DROP TABLE IF EXISTS `questions`;
CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    user_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id)
);


DROP TABLE IF EXISTS `users`;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_name VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- answersテーブル
DROP TABLE IF EXISTS `answers`;
CREATE TABLE answers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT NOT NULL,
    user_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);