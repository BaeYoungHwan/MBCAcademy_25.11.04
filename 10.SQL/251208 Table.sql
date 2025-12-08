/* 	
	Table : column(항목, 열), row(행)로 이루어져 있다.
			데이터를 담을 수 있는 틀

	data 자료형
	String 			: varchar(byte), character varing
	int				: int, integer, numeric(정수)
	double, float	: numeric
	date 			: date, timestamp


	object(table, view) : create, drop, alter(수정)
	data : insert, delete, select, update
*/



drop table "tb_test";


create table tb_test(

	num integer,
	name varchar(30),
	address varchar(56),
	birth timestamp

)

insert into tb_test(num, name, address, birth)
values(1, '홍길동', '서울시', '2025-12-08');

insert into tb_test(num, name, address, birth)
values(2, '성춘향', '남원시', 'now()');

insert into tb_test(num, name, birth)
values(3, '일지매', current_date);

insert into tb_test(num, name, address, birth)
values(4, '임꺽정', '', current_timestamp);

insert into tb_test
values(5, '배영환', '익산시', '1996-02-01 05:28:35')

insert into tb_test(num, address, birth, name)
values(2, '남원시', 'now()', '이몽룡');

select *
from tb_test
order by num;


-- delete
delete from tb_test
where num = 4;

delete from tb_test
where address = '남원시';


-- update
update tb_test
set num = 0					-- 변경 할 값
where name = '배영환';		-- 변경 할 기준

update tb_test
set address = '곡성시시', birth = '1996-02-01'	-- 변경 할 값
where num = 0;					-- 변경 할 기준


-- table copy : 데이터 포함
create table tb_jobs
as
select *
from jobs;

select *
from tb_jobs;


insert into tb_jobs(job_id, job_title, min_salary, max_salary)
values('ADD', 'Address_AC', 3000, 13000);


drop table tb_jobs;


create table tb_jobs
as
select job_id as "id", job_title as "업무명",
		min_salary as min, max_salary as "max"
from jobs;

-- 필요한 칼럼만 복사 가능
create table tb_jobs
as
select job_id as "id", job_title as "업무명",
		max_salary as "max"
from jobs;



create table emp_dept
as
select employee_id as empno, first_name as name,
		salary as sal, e.department_id as deptno,
		department_name as deptname, location_id as loc
from employees e, departments d
where e.department_id = d.department_id

drop table emp_dept;

select *
from emp_dept;


-- group by를 한 후에 통계와 함께 사원정보를 검색하고 싶을 경우
create table gruop_dept
as
select department_id, count(*) as dcount,
		sum(salary) as dsum, avg(salary) as davg
from employees
group by department_id;


select *
from gruop_dept;



create table tb_jobs
as
select job_id as "id", job_title as "업무명",
		max_salary as "max"
from jobs;


-- 테이블 수정
-- 테이블명 수정
alter table tb_jobs
rename to new_jobs;


select *
from new_jobs;

-- 테이블에 컬럼추가
-- 컬럼 1개 추가
alter table new_jobs
add min_salary integer;


-- 2개 추가
alter table new_jobs
add job_col1 numeric(3, 1),
add job_col2 timestamp;


-- Table의 columns data 변환
alter table new_jobs
alter column job_col2
type varchar(30);


-- 컬럼 삭제
alter table new_jobs
drop column job_col1;


-- table copy : 데이터 미포함
create table tb_jobs
as
select *
from jobs
where 1=2;

select *
from tb_jobs;









