CREATE TABLE employee
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name VARCHAR(24)                       NOT NULL,
    last_name  VARCHAR(24)                       NOT NULL,
    gender     VARCHAR(24)                       NOT NULL,
    age        INT                               NOT NULL,
    email      VARCHAR(48)                       NOT NULL,
    username   VARCHAR(24),
    password   VARCHAR(240)
);

CREATE TABLE leave_request
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY               NOT NULL,
    employee_id  BIGINT                                          NOT NULL,
    request_type ENUM ('BIRTH', 'ANNUAL', 'PATERNITY', 'EXCUSE') NOT NULL,
    status       ENUM ('APPROVED', 'REJECTED', 'PENDING')        NOT NULL,
    create_date  DATE                                            NOT NULL,
    start_date   DATE                                            NOT NULL,
    end_date     DATE                                            NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);