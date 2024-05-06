CREATE TABLE users
(
    id                     BIGINT AUTO_INCREMENT PRIMARY KEY,
    name                   VARCHAR(255),
    email                  VARCHAR(255),
    password               VARCHAR(255),
    authority              VARCHAR(255),
    deleted_yn             BOOLEAN,
    register_date          TIMESTAMP,
    last_consultation_date TIMESTAMP
);

CREATE TABLE customer
(
    id                     BIGINT AUTO_INCREMENT PRIMARY KEY,
    name                   VARCHAR(255),
    customer_group         VARCHAR(255),
    phone                  VARCHAR(20),
    address                VARCHAR(255),
    user_id                BIGINT,
    memo                   VARCHAR(255),
    gender                 VARCHAR(10),
    birth                  DATE,
    register_date          TIMESTAMP,
    last_consultation_date TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
