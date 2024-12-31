CREATE TABLE IF NOT EXISTS Lesson (
   id INT NOT NULL,
   title varchar(250) NOT NULL,
   subject varchar(250) NOT NULL,
   started_on timestamp NOT NULL,
   minutes_duration INT NOT NULL,
   version INT,
   PRIMARY KEY (id)
);