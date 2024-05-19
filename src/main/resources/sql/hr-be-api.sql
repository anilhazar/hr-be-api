CREATE DATABASE hr_be_api;

USE hr_be_api;

CREATE TABLE employee
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name VARCHAR(24)                       NOT NULL,
    last_name  VARCHAR(24)                       NOT NULL,
    gender     VARCHAR(24)                       NOT NULL,
    birthday   DATE                              NOT NULL,
    age        INT                               NOT NULL,
    email      VARCHAR(48)                       NOT NULL,
    username   VARCHAR(24)  NOT NULL,
    password   VARCHAR(240) NOT NULL
);

CREATE TABLE leave_request
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY               NOT NULL,
    employee_id  BIGINT                                          NOT NULL,
    request_type ENUM ('BIRTH', 'ANNUAL', 'PATERNITY', 'EXCUSE') NOT NULL,
    status ENUM ('APPROVED', 'REJECTED', 'PENDING')              NOT NULL,
    create_date  DATE                                            NOT NULL,
    start_date   DATE                                            NOT NULL,
    end_date     DATE                                            NOT NULL,
    CONSTRAINT fk__employee_id__leave_request FOREIGN KEY (employee_id) REFERENCES employee (id)
);

INSERT INTO employee (first_name, last_name, gender, birthday, age, email)
VALUES ('John', 'Doe', 'Male', 30, '1996-08-17', 'johndoe@example.com');

INSERT INTO leave_request (employee_id, request_type, status, start_date, end_date)
VALUES (1, 'ANNUAL', 'PENDING', '2024-06-01', '2024-06-10');


