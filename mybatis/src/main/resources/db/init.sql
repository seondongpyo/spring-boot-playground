DROP TABLE IF EXISTS Member;
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Team;

CREATE TABLE Member
(
    member_id bigint primary key auto_increment,
    name      varchar(255),
    age       integer
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

INSERT INTO Post VALUES(1, 'kim', 'title1', 'content1');
INSERT INTO Post VALUES(2, 'park', 'title2', 'content2');

CREATE TABLE Team
(
    id   bigint primary key auto_increment,
    name varchar(255)
);

INSERT INTO Team VALUES(1, 'Tottenham Hotspur F.C.');

CREATE TABLE Player
(
    id       bigint primary key auto_increment,
    team_id  bigint,
    name     varchar(255),
    position varchar(255),
    FOREIGN KEY (team_id) REFERENCES Team(id) ON UPDATE CASCADE
);

INSERT INTO Player VALUES(1, 1, 'Son Heung-min', 'LW');
INSERT INTO Player VALUES(2, 1, 'Harry Kane', 'CF');

