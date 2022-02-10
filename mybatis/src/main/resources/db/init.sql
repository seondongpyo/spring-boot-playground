DROP TABLE IF EXISTS Member;
DROP TABLE IF EXISTS Post;

CREATE TABLE Member
(
    id   bigint primary key auto_increment,
    name varchar(255),
    age  integer
);

INSERT INTO Member VALUES(1, '홍길동', 20);
INSERT INTO Member VALUES(2, '김길동', 30);

CREATE TABLE Post
(
    id      bigint primary key auto_increment,
    writer  varchar(255),
    title   varchar(255),
    content clob
);

