-- 문제1) EMPLOYEES 테이블에서 20번 부서의 모든 컬럼을 포함하는 EMP_20 VIEW를 생성 하라

create view EMP_20
as
select *
from employees
where department_id = 20;

select * from EMP_20 order by department_id;

-- 문제2) EMPLOYEES 테이블에서 30번 부서만 EMPLOYEE_ID 를 emp_no 로 LAST_NAME을 name으로 SALARY를 sal로 바꾸어 EMP_30 VIEW를 생성하라.
create view EMP_30(

	"emp_no",
	"name",
	"sal"

)
as
select employee_id, last_name, salary
from employees
where department_id = 30;

select * from EMP_30;

-- 문제3) 부서별로 부서명, 최소 급여, 최대 급여, 부서의 평균 급여를 포함하는 
-- DEPT_SUM VIEW을 생성하여라.
create view DEPT_SUM
as
select department_id, min(salary), max(salary), avg(salary)
from employees e
group by department_id;

select * from dept_sum;

-- 문제4) 앞에서 생성한 EMP_20,EMP_30 VIEW을 삭제하여라.

drop view EMP_20, EMP_30


