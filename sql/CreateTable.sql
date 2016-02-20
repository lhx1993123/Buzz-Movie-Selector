/*Create Table Statements*/

CREATE TABLE IF NOT EXISTS User (
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    firstname VARCHAR(30),
    lastname VARCHAR(30),
    interest VARCHAR(30),
    major VARCHAR(30),
    sex INT,
    status VARCHAR(30),
    role INT,
    PRIMARY KEY (username)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS Rating (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    movieID VARCHAR(30) NOT NULL,
    scores INT NOT NULL,
    comments LONGTEXT,
    username VARCHAR(30),
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES User(username)
    )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
