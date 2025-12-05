-- 문제1) EMPLOYEES 테이블에서 Kochhar(last_name)의 급여보다 많은 사원의 사원번호, 이름, 담당업무, 급여를 출력하라.
select employee_id, first_name, job_id, salary
from employees
where salary > (select salary
				from employees
				where last_name = 'Kochhar');


-- 문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 사원번호, 이름, 담당업무, 급여, 부서번호를 출력하여라.  
select	employee_id, first_name, job_id, salary, department_id
from employees
where salary < (select avg(salary) from employees);

-- 문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하라
select department_id, min(salary) , (select min(salary) from employees where department_id = 100)
from employees 
group by department_id
having min(salary) > (select min(salary) from employees where department_id = 100);

-- 문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호를 출력하여라. 

select e.job_id, employee_id, first_name, department_id
from employees e,(
				select min(salary) as salary , job_id
				from employees
				group by job_id
				) s
where e.salary = s.salary and e.job_id = s.job_id;



select job_id, employee_id, first_name, department_id
from employees
where (job_id, salary) in (select job_id, min(salary) 
							from employees
							group by job_id)

-- 단 업무별로 정렬하여라.

-- 문제5) EMPLOYEES 테이블에서 업무(JOB_ID)가 SA_MAN 사원들의 이름, 업무, 부서명, 근무지(city)를 출력하라.
select e.first_name, e.job_id, e.department_id, l.city
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id and e.job_id = 'SA_MAN';


-- 문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의 사원번호를 출력하라.

select manager_id, ctt
from (select manager_id, count(*) as ctt
		from employees
		group by manager_id)
where ctt in (select max(ct)
			from ((select manager_id, count(*) as ct
				from employees
				group by manager_id)));



select manager_id, count(manager_id)
from employees
group by manager_id
having count(manager_id) = (select max(ct)
							from ((select manager_id, count(*) as ct
							from employees
							group by manager_id)));




-- 문제7) EMPLOYEES 테이블에서 가장 많은 사원이 속해 있는 부서 번호와 사원수를  출력하라.

select department_id, ctt
from (select department_id, count(*) as ctt
		from employees
		group by department_id)
where ctt in (select max(ct)
			from (
					select department_id, count(*) as ct
					from employees
					group by department_id)
				);



select department_id, count(*) as ctt
from employees
group by department_id
having count(department_id) = (select max(ct)
								from (
									select department_id, count(*) as ct
									from employees
									group by department_id)
									);



-- 문제8) EMPLOYEES 테이블에서 
-- 사원번호가 123인 사원의 직업과 같고
-- 사원번호가 192인 사원의 급여(SAL)보다 많은
-- 사원의 사원번호,이름,직업,급여를 출력하라.
select employee_id, first_name, job_id, salary
from employees
where job_id = (select job_id
				from employees
				where employee_id = 123)
				and
	  salary > (select Salary
				from employees
				where employee_id = 192);

-- 문제9)직업(JOB)별로 최소급여를 받는 사원의 정보를 사원번호,이름,업무,부서명을 출력하라.
-- 직업별로 내림차순정렬

select employee_id, first_name, e.job_id, department_id, e.salary
from employees e left join (select job_id, min(salary) as minS
					from employees
					group by job_id) j
					on e.job_id = j.job_id
where salary = j.minS
order by job_id desc;
				

select employee_id, first_name, job_id, d.department_id, e.salary
from employees e, departments d
where (job_id, salary) in (select job_id, min(salary)
						from employees
						group by job_id)
	and e.department_id = d.department_id
order by job_id desc;


-- 문제10) EMPLOYEES 테이블에서 50번 부서의 최소 급여를 받는 사원
-- 보다 많은 급여를 받는 사원
-- 의 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 
-- 단 50번은 제외

select employees.employee_id, employees.first_name, job_id, hire_date, salary, department_id
from employees
where salary > (select min(salary) 
				from employees
				where department_id = 50)
			and
			department_id != 50;

-- 문제11) 부서별로 커미션이 없는 사원들
-- 중 월급이 가장 높은 사원의 이름, 급여를 출력하시오(부서순으로 정렬).

select e.department_id, first_name, e.salary
from employees e inner join (select department_id, max(salary) as maxS
						from employees
						where commission_pct is null
						group by department_id) d
						on e.department_id = d.department_id 
						and e.salary = d.maxS
order by department_id;


select department_id, first_name, salary, commission_pct
from employees
where (department_id, salary) in (select department_id, max(salary) as maxS
									from employees
									where commission_pct is null
									group by department_id)



-- 문제12) 각 부서별로 최근에 입사한 사원들의 부서번호, 사원번호, 이름, 입사일을 출력하시오(부서순으로 정렬).
select e.department_id, e.employee_id,first_name, e.hire_date
from employees e inner join (select department_id, max(hire_date) as maxH
						from employees
						group by department_id) d
						on e.department_id = d.department_id 
						and e.hire_date = d.maxH
order by department_id;



select	department_id, employee_id, first_name, hire_date
from	employees
where (department_id, hire_date) in (select department_id, max(hire_date) as maxH
									from employees
									group by department_id)
order by department_id;


-- 문제13) 업무가 FI_ACCOUNT 이면 월급을 10% 인상하고 ST_MAN 이면 20% 인상, IT_PROG 이면 30% 인상하고 그 외의 사원들은 10% 인상된 금액이 출력하시오. 
/*
select employee_id, first_name, e.job_id, 	case substr(j.job_title, 1, 6) 
											when 'ST_MAN%' then salary * 1.2
											when 'IT_PROG' then salary * 1.3
											else salary * 1.1
											end as "After salary",
											salary as "Before salary"
from employees e, jobs j
where e.job_id = j.job_id;
*/

select employee_id, first_name, job_id, 	case job_id
											when 'ST_MAN' then salary * 1.2
											when 'IT_PROG' then salary * 1.3
											else salary * 1.1
											end as "After salary",
											salary as "Before salary"
from employees e;


--	   문제14) 월급이 
--     15000 이상이면 A, 
--     14999 ~ 10000 B,
--     9999 ~ 7000 C,
--     6999 ~ 3000 D,
--     그 외는 F 가 출력되도록 하시오.

select employee_id, first_name, case  
								when  Salary >= 15000 then 'A'
								when  Salary BETWEEN 10000 and 14999 	then 'B'
								when  Salary BETWEEN 7000 	and 9999 	then 'C'
								when  Salary BETWEEN 3000 and 6999 	then 'D'
								else 'F'
								end
from employees 


-- 문제15) 각 매니저의 부하직원 수와 (매니저)사원명을 구하고 제일 많은 순서부터 5위까지 출력하라.
-- manager_id, first_name, 부하직원수
		 
-- 1.각 매니저의 아이디, 매니저별로 부하직원 수
-- 2.부하직원 수에 따른 Sorting으로 번호 할당
-- 3.범위를 설정

select m.manager_id, e.first_name, ct
from employees e, (select manager_id, count(*) as ct
					from employees
					group by manager_id) m
where e.employee_id = m.manager_id
order by ct desc
LIMIT 5;


select rnum, mid, ename, cnt
from (select row_number()over(order by cnt desc) as rnum,
	mgr.manager_id as mid, emp.first_name as ename, cnt
	from(select manager_id, count(*) as cnt
		from employees
		group by manager_id) mgr, employees emp

	where mgr.manager_id = emp.employee_id
	order by cnt desc)
where rnum between 1 and 5;


