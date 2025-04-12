CREATE DATABASE  IF NOT EXISTS `plantCom`;
USE `plantCom`;

--質問内容を格納
--先にテーブルがあれば削除する
DROP TABLE IF EXISTS `questions`;
--questionsテーブルを作成
CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- 質問ID (自動採番)
    title VARCHAR(255) NOT NULL,        -- 質問のタイトル (255文字以内、必須)
    content TEXT NOT NULL,              -- 質問の本文 (長いテキスト、必須)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 質問の作成日時 (デフォルトで現在のタイムスタンプ)
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 質問の更新日時 (変更時に自動更新)
);

DROP TABLE IF EXISTS `users`;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_name VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);