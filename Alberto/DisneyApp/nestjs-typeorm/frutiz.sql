
CREATE TABLE task(
  id_task SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  completed BOOLEAN NOT NULL DEFAULT FALSE
);
INSERT INTO task (title, completed) VALUES ('Task 1', FALSE);
INSERT INTO task (title, completed) VALUES ('Task 2', FALSE);
INSERT INTO task (title, completed) VALUES ('Task 3', FALSE);
INSERT INTO task (title, completed) VALUES ('Task 4', FALSE);
INSERT INTO task (title, completed) VALUES ('Task 5', FALSE);
