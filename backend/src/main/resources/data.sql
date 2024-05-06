-- 더미 사용자 데이터
INSERT INTO users (name, email, password, authority, deleted_yn, register_date, last_consultation_date)
VALUES ('홍길동', 'hong@example.com', '패스워드123', 'ROLE_USER', FALSE, CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       ('김영희', 'kim@example.com', '안전한비밀번호', 'ROLE_ADMIN', FALSE, CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP),
       ('이철수', 'lee@example.com', '비밀번호@1', 'ROLE_USER', FALSE, CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP);

-- 더미 고객 데이터
INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth,
                      register_date, last_consultation_date)
VALUES ('김동지', 'VIP', '01012345678', '서울시 강남구 역삼동', 1, '정기 고객',
        '남성', '1990-05-15', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('김동자', '일반', '01098765432', '서울시 서초구 반포동', 2, '우럭 고객',
        '여성', '1985-08-20', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('김동재', '일반', '01055556666', '경기도 수원시 영통구 매탄동', 3,
        '신규 고객', '남성', '1995-12-10', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
