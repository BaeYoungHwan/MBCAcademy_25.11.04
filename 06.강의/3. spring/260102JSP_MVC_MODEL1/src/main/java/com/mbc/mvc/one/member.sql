select * from employees;      -- Alt + C

drop table member;

create table member(
   id varchar(50) primary key,
   pw varchar(50) not null,
   name varchar(50) not null,
   email varchar(50) unique,
   auth int      -- 사용자:3 관리자:1
);