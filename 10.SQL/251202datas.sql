-- 한줄 주석문

/*
범위 주석문
*/

/*
	SQL(Structured Query Language)
	     구조적인   질(문)의   언어

	이 조건으로 이러한 데이터들은? -> 
							   <- Database	
    Data 창고
	CRUD를 사용할 수 있다

	Data
	insert delete select update
	              90%
    Object(Table, View)
	create drop 

	employees	(회)사원테이블
	departments  부서테이블 
	jobs         업무테이블
	locations    ㅈㅣ역테이블 

	Table : rows(한개의 데이터), column(항목)
*/
select * from employees;
select * from departments;
select * from jobs;
select * from locations;

/*
	자료형
	java				SQL
	int					int, numeric, integer
	float, double		float, double, decimal(5, 1)
	String				varchar(30)
	Date				date, timestamp
*/

select * from "TestTable";

/*
	create table 테이블명(
		컬럼명1 자료형,
		컬럼명2 자료형
		      :
	);
*/

-- varchar == character varying == String
-- varchar(30) == character varying[30]

create table tb_varchar(
	col1 varchar(10),
	이름 varchar(20),
	주소 varchar
);

insert into tb_varchar(col1, 이름)
values('abc', '홍길동');

-- insert into tb_varchar(col1, 이름)
-- values('abc', "홍길동");  -- 이건 안됨

select * from tb_varchar;


-- int, numeric(자리수, 소수점자리수)
create table tb_numeric(
	col1 int,
	col2 integer,
	col3 numeric,
	col4 numeric(5),
	col5 numeric(5, 2)
);

insert into tb_numeric(col1, col2, col3, col4, col5)
values(123, 123.4, 123.45, 123.45, 123.4547);

insert into tb_numeric(col1, col2, col3, col4, col5)
values(123, 123.4, 123.45, 123.45, 125.6789); -- 수치 필드 오버플로우

select * from tb_numeric;

-- 날짜
create table tb_date(
	col1 date,
	col2 date
);

insert into tb_date(col1, col2)
values('2025-12-2', now());	 -- now() 함수 

select * from tb_date;

-- timestamp 날짜 + 시, 분, 초, 밀러세컨(60/1000)까지 나온다   
create table tb_timestamp(
	col1 timestamp,
	col2 timestamp default now()
);

insert into tb_timestamp(col1, col2)
values('2026-05-04 12:33:09', now());

insert into tb_timestamp(col1, col2)
values(now(), default);

insert into tb_timestamp(col1)
values(now());

select * from tb_timestamp;





