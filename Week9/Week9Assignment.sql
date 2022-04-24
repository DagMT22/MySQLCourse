create database if not exists week9;

use week9;

drop table if exists comments;
drop table if exists posts;
drop table if exists users;

CREATE TABLE users (
    username VARCHAR(64) NOT NULL,
    email VARCHAR(64) NOT NULL,
    password_hash VARCHAR(128) NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    birth_date DATE NOT NULL,
    content TEXT,
    PRIMARY KEY (username)
);

CREATE TABLE posts (
    post_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    post_time TIMESTAMP,
    content TEXT,
    PRIMARY KEY (post_id),
    FOREIGN KEY (username)
        REFERENCES users (username)
);

CREATE TABLE comments (
    comment_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    post_id INT NOT NULL,
    comment_time TIMESTAMP,
    content TEXT,
    PRIMARY KEY (comment_id),
    FOREIGN KEY (username)
        REFERENCES users (username),
    FOREIGN KEY (post_id)
        REFERENCES posts (post_id)
);