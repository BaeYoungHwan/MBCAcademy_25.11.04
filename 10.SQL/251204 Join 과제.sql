-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
select e.first_name, e.department_id, d.department_name
from employees e inner join departments d on e.department_id = d.department_id;

-- 문제2) 30번 부서의 사원들의 이름, 직업, 부서명을 출력하라
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e inner join departments d on e.department_id = d.department_id
where e.department_id = 30;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호, 부서명을 출력하라
select e.employee_id, e.first_name, j.job_title,e.department_id, d.department_name
from employees e inner join departments d on e.department_id = d.department_id inner join jobs j on e.job_id = j.job_id
where e.commission_pct is not null;

-- 문제4) 지역번호 2500 에서 근무하는 사원의 이름, 직업, 부서번호, 부서명을 출력하라
select e.first_name, j.job_title, d.department_id, d.department_name
from employees e , departments d , jobs j
where e.department_id = d.department_id and e.job_id = j.job_id and d.location_id = 2500;

-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
select e.first_name,d.department_name
from employees e , departments d
where e.first_name like '%A%';

-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라
select e.first_name as 사원이름, mgr.first_name as 상사이름
from employees e , employees mgr 
where e.manager_id = mgr.employee_id;

-- 문제7) 사원이름과 부서명과 월급을 출력하는데 월급이 6000 이상인 사원을 출력하라
select e.first_name, d.department_name, e.salary
from employees e inner join departments d on e.department_id = d.department_id
where e.salary >= 6000
order by e.salary;

-- 문제8) first_name 이 TJ 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라
select m.first_name, m.hire_date
from employees e, employees m 
where e.first_name = 'TJ' and e.hire_date < m.hire_date;
     
 
-- 문제9) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
select  e.first_name, d.department_name
from employees e, departments d
where e.employee_id = d.department_id and e.salary BETWEEN 3000 and 5000;

-- 문제10) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력하라
select d.department_name, e.first_name, e.hire_date
from employees e, departments d
where e.department_id = d.department_id and d.department_name = 'Accounting';


-- 문제11) 급여가 3000이하인 사원의 이름과 급여, 근무지(city)를 출력하라
select  e.first_name, e.salary, l.city
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id and e.salary <= 3000;

-- 문제12) 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 
-- 함께 표시하고 레이블명을 각각 emp name, emp hired, mgr name, mgr hired 로 지정하라.
select e.first_name as "emp name", e.hire_date as "emp hired", m.first_name as "mgr name", m.hire_date as "mgr hired"
from employees e, employees m
where e.manager_id = m.employee_id and e.hire_date < m.hire_date

-- 문제13) 지역별로 근무하는 사원의 수가 5명 이하인 경우, 사원이 적은 도시순으로 정렬하고 city와 사원수를 출력하시오.
select l.location_id, l.city, count(e.employee_id)
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id
group by l.location_id
having count(l.location_id) <= 5 
order by count(e.employee_id);

-- 문제14) 지정한 부서번호, 사원이름 및 지정한 사원과 동일한 부서에서 근무하는 모든 사원을 표시하도록 하고 부서번호는 deptno, 사원이름은 사원, 동일한 부서에서 근무하는 사원은 동료로 표시하시오.
-- (부서번호, 사원이름, 동료 순으로 오름차순 정렬)
select e.department_id as deptno, e.first_name as "사원", m.first_name as "동료"
from employees e, employees m
where e.department_id = m.department_id and e.employee_id != m.employee_id
order by deptno, "사원", "동료" ;






