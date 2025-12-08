/*
	무결성 : constraint
			column 에 지정하는 성질(값을 넣을 때 규칙)

	Primary Key(PK) : 기본키. null을 허용하지 않는다. 중복을 허용하지 않는다
					  ID, 주민등록번호 	
	Unique Key(UK) : 고유키. null을 허용한다. 중복을 허용하지 않는다
					  email
	Foreign Key(FK) : 외래키. null을 허용한다. 
					  join의 목적. 테이블을 연결하기 위한 성질
					  연결된 테이블에서 기본키(PK)나 고유키(UK)로 되어 있어야 한다
	Check : 지정된 값, 범위만을 사용할 수 있다. null을 허용한다
	not null : 빈칸을 허용하지 않는다
*/

drop table tb_test;

-- not null
create table tb_test(
	name varchar(30) not null,
	height numeric(5, 1)
);

insert into tb_test(name, height)
values('홍길동', 172.3);

insert into tb_test(name)
values('성춘향');

select * from tb_test;

insert into tb_test(name, height) 		-- 빈문자도 들어간다
values('', 167.2);

insert into tb_test(name, height)		-- error
values(null, 167.2);

insert into tb_test(height)				-- error
values(167.2);

-- Check
create table tb_check(
	name varchar(30),
	fruit varchar(30),
	numcnt int,
	constraint check1 check(fruit in('apple', 'pear', 'banana')),
	constraint check2 check(numcnt > 0 and numcnt <= 10)
);

insert into tb_check(name, fruit, numcnt)
values('홍길동', 'apple', 3);

insert into tb_check(name, fruit, numcnt)
values('성춘향', 'grape', 3);	-- 포도는 없음

insert into tb_check(name, fruit, numcnt)
values('성춘향', null, 3);

insert into tb_check(name, numcnt)
values('성춘향', 3);

insert into tb_check(name, fruit, numcnt)
values('성춘향', 'banana', 11);

select * from employees;

-- Primary Key = UK + NOT NULL
insert into employees(employee_id ,last_name, email, hire_date, job_id)
values(207, 'Kim', 'kim@naver.com', '2012-10-12', 'IT_PROG');

drop table tb_test;

create table tb_test(
	id varchar(30) primary key,
	name varchar(30),
	height numeric(3)
);

insert into tb_test(id, name, height)
values('abc', '홍길동', 172.3);

insert into tb_test(id, name, height)
values('', '홍길동', 172.3);

insert into tb_test(id, name, height)	-- 동일한 key의 값 error
values('abc', '성춘향', 135.3);

insert into tb_test(name, height)		-- null error
values('성춘향', 135.3);

drop table if exists tb_test;

create table tb_test(
	id varchar(30),
	name varchar(30)
);

-- PK를 추가
alter table tb_test
add
primary key(id);


-- unique : 고유키 null은 OK, 중복X
create table tb_test(
	email varchar(30) unique,
	name varchar(30)
);

insert into tb_test(email, name)
values('abc@naver.com', '홍길동');

insert into tb_test(name)
values('홍길동');

select * from tb_test;

-- 외래키
/*
	foreign key : join을 목적
				  외부테이블에서 반드시 기본키 또는 고유키여야만 한다

				  외부테이블에 있는 값이거나 null은 허용
*/
drop table emp;		-- employees
drop table dept;	-- departments

-- 부모테이블
create table dept(
	department_id int primary key,
	department_name varchar(30)
);

insert into dept(department_id, department_name)
values(10, '기획부');

insert into dept(department_id, department_name)
values(20, '영업부');

insert into dept(department_id, department_name)
values(30, '개발부');

select * from dept;

-- 자식테이블
create table emp(
	employee_id int primary key,
	first_name varchar(30),
	department_id int,
	foreign key(department_id) references dept(department_id)
);

insert into emp(employee_id, first_name, department_id)
values(100, '홍길동', 10);

insert into emp(employee_id, first_name, department_id)
values(101, '성춘향', 20);

insert into emp(employee_id, first_name)
values(102, '일지매');

select * from emp;

select e.employee_id, e.first_name,
	e.department_id, d.department_name
from emp e, dept d
where e.department_id = d.department_id;



