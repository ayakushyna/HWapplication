/*
DROP TABLE tasks;
DROP SEQUENCE tasks_seq;
*/

CREATE TABLE tasks (
    task_id     NUMBER PRIMARY KEY,
    title       VARCHAR(70) NOT NULL,
    description VARCHAR(280),
    done        NUMBER(1) DEFAULT 0 NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE SEQUENCE tasks_seq START WITH 1;

CREATE OR REPLACE TRIGGER tasks_insert_id
BEFORE INSERT ON tasks
FOR EACH ROW

BEGIN
  SELECT tasks_seq.NEXTVAL
  INTO   :new.task_id
  FROM   dual;
END;