CREATE DATABASE blog_db;

USE blog_db;

CREATE TABLE `user` (
                        `user_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `email` VARCHAR(255) NOT NULL,
                        `password` VARCHAR(255) NOT NULL
);

CREATE TABLE `posts` (
                         `post_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `user_id` INT NOT NULL,
                         `title` VARCHAR(255) NOT NULL,
                         `content` VARCHAR(255) NOT NULL,
                         `author` VARCHAR(255) NOT NULL
);

CREATE TABLE `roles` (
                         `role_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `name` VARCHAR(255) NOT NULL
);

INSERT INTO roles (role_id, name)
VALUES (1, "ROLE_USER"), (2, "ROLE_ADMIN");

CREATE TABLE `user_roles` (
                              `user_role_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              `user_id` INT NOT NULL,
                              `role_id` INT NOT NULL
);

CREATE TABLE `likes` (
                         `like_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `user_id` INT NOT NULL,
                         `post_id` INT NOT NULL,
                         `liked` BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE `commtents` (
                             `comment_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             `post_id` INT NOT NULL,
                             `content` VARCHAR(255) NOT NULL,
                             `author`  VARCHAR(255) NOT NULL
);



