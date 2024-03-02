INSERT INTO students (first_name, last_name, date_of_birth, email)
VALUES ('John', 'Smith', '1995-10-02', 'john.smith@gmail.com'),
       ('John', 'Doe', '1994-06-11', 'john.doe@gmail.com');

INSERT INTO courses (name)
VALUES ('Web Application Scripting'),
       ('Database Management');

INSERT INTO results (student_id, course_id, score)
VALUES (1, 1, 'A'),
       (1, 2, 'B'),
       (2, 1, 'D'),
       (2, 2, 'C');
