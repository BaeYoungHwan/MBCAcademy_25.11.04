/*

	order by == sorting(정렬), 오름, 내림

*/

select first_name, salary
from employees
order by salary asc;


select employee_id, first_name, salary
from employees
order by employee_id ; -- 기본값 오름


select employee_id, first_name, hire_date , salary
from employees
order by hire_date ;


select employee_id, first_name, salary
from employees
order by salary desc;


select employee_id, first_name, salary, hire_date
from employees
where job_id = 'IT_PROG'
order by salary desc;


select employee_id, first_name, salary
from employees
order by salary desc;


select employee_id, first_name, salary, hire_date
from employees
order by salary desc, hire_date asc;


select employee_id, manager_id, first_name, salary, hire_date
from employees
order by manager_id nulls last;


select employee_id, first_name, salary as 월급, hire_date
from employees
order by 월급 desc nulls first;


/*

	group by : 그룹으로 묶는 기능
	ㅇ 그룹(통계)함수 : count, sum, avg, max, min, ... 표준편차
	
	Having : groupby로 묶은 후 조건절
	
	distinct : select 절에서만 사용가능

*/
-- 중복행을 제거
select DISTINCT department_id,
from employees
order by department_id;


select department_id
from employees
group by department_id
order by department_id;

--그룹함수
select count(employee_id), sum(salary), round(avg(salary),3), max(salary), min(salary)
from employees
where job_id = 'IT_PROG';


select job_id, count(employee_id), sum(salary), round(avg(salary),3), max(salary), min(salary)
from employees
group by job_id;


select department_id, count(employee_id), sum(salary), round(avg(salary),3), max(salary), min(salary)
from employees
group by department_id;


-- 업무별로 급여의 합계가 150000 이상인 업무만 표출

select department_id, count(employee_id), sum(salary), round(avg(salary),3), max(salary), min(salary)
from employees
group by department_id
HAVING sum(salary) >= 150000
order by sum (salary);































