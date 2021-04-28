DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS students;

CREATE TABLE users (
	user_id VARCHAR(64) PRIMARY KEY NOT NULL,
	password VARCHAR(256) NOT NULL,
	role VARCHAR(64) NOT NULL
);

CREATE TABLE students (
    student_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(64) NOT NULL
);

INSERT INTO students (name) VALUES
('Fillip Molodtsov'),
('Andrei Rozhko'),
('Max Kolesnik');


COMMIT;