/*

	view : 가상 테이블
	실제 테이블이 아니다 -> int arr[] = array;
	한개의 view로 여러개의 테이블의 데이터를 검색하는것이 가능하다

	장점 
	속도가 빠르다
	제한 설정이 가능하다 -> read only(insert, delete, update)
	
*/

create view ub_test(

	job_id,
	job_title,
	max_salary

)
as
select job_id, job_title, max_salary
from jobs;


select * from ub_test;

insert into ub_test
values('sales', '영업부', 20000);


-commit 과 rollback
commit ;	-- 적용
	
rollback;	-- 되돌림


-- 두개의 테이블을 접근하도록 구현
create or replace view deft_emp_view
as
select e.employee_id, e.first_name, e.department_id, d.department_name, d.location_id
from employees e, departments d
where e.department_id = d.department_id


select * from deft_emp_view;


-- employees 
create or replace view empview (

		"사원번호",
		"성",
		"이메일",
		"입사일",
		"업무명"

)
as
select employee_id, last_name, email, hire_date, job_id
from employees;



select *
from empview;