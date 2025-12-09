-- sequence 
create SEQUENCE test_seq
increment by 1	-- 1씩증가
start with 1 	--  시작 숫자 지정
maxvalue 100;

-- 현재 sequence value
select currval('test_seq')

select nextval('test_seq')

alter sequence test_seq
increment by 3;

-- 삭제
drop sequence test_seq;


create table client(

	seq integer primary key,
	id varchar(30) not null,
	name varchar(30),
	age int
);

insert into client(seq, id, name, age)
values(nextval('test_seq'), 'abc', '홍길동', 24);


insert into client(seq, id, name, age)
values(nextval('test_seq'), 'abc', '성춘향', 34);


insert into client(seq, id, name, age)
values(nextval('test_seq'), 'abc', '일지매', 14);

select * from client;


create table client2(

	seq integer default nextval('test_seq') primary key,
	id varchar(30) not null,
	name varchar(30) not null,
	age int
	
);

insert into client2(id, name, age)
values('abc', '홍길동', 24);

insert into client2(id, name, age)
values('abc', '성춘향', 34);

insert into client2(id, name, age)
values('abc', '일지매', 14);

select * from client2 ;
