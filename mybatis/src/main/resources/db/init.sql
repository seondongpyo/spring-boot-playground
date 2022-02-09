DROP TABLE IF EXISTS Member;

CREATE TABLE Member
(
    id   bigint primary key,
    name varchar(255),
    age  integer
);

INSERT INTO Member VALUES(1, '홍길동', 20);
INSERT INTO Member VALUES(2, '김길동', 30);
