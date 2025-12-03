/*

	where : 조건절 == if

	비교연산자 : = > < >= <= != <>_같지않음
	NULL, IS NULL, IS NOT NULL
	( ), NOT, AND, OR
	

*/

-- 이름이 줄리아인 사람 찾기
select employee_id, first_name, last_name, email
from employees
where first_name = 'Julia';


select employee_id, first_name, last_name, email
from employees
where salary >= 9000;


select employee_id, first_name, last_name, email
from employees
where first_name >= 'shanta';

-- 원래 a는 ASCII코드가 뒤에 이기 때문에 안 나와야하지만 postgre에서는 모두 나온다
select employee_id, first_name, last_name, email
from employees
where first_name >= 'a';

-- is NULL
select employee_id, first_name, last_name, email
from employees
where manager_id is NULL;

-- is not NULL
select employee_id, first_name, last_name, email
from employees
where commission_pct is not NULL;

-- or
select employee_id, first_name, last_name, email
from employees
where first_name = 'Shanta' or first_name = 'John'

-- name : John and 연봉 5000 이상
select employee_id, first_name, last_name, email
from employees
where  first_name = 'John' and employees.salary > 5000;

-- 2017년 12월 31일 이후 입사한 사람 출력
select employee_id, first_name, last_name, email, hire_date
from employees
where  hire_date > '2017-12-31';


-- ALL(and), ANY(or) SubQuery를 사용해야지만 사용가능
select employee_id, first_name, last_name, email, salary
from employees
where salary = ALL(select salary from employees where first_name = 'Julia');

select employee_id, first_name, last_name, email, salary
from employees
where salary = ANY(select salary from employees where first_name = 'Julia');


-- in, not in
select employee_id, first_name, last_name, email
from employees
where salary in(8000, 3200, 6000);


select employee_id, first_name, last_name, email
from employees
where first_name not in('Julia', 'John');


-- between 범위 연산자

select employee_id, first_name, last_name, email, salary
from employees
where salary >= 6000 and salary <= 9000;

select employee_id, first_name, last_name, email, salary
from employees
where salary between 6000 and 9000 or salary between 3000 and 4000;


select employee_id, first_name, last_name, email, salary
from employees
where salary not between 6000 and 9000 ;


-- like 
select employee_id, first_name, last_name, email, salary
from employees
where first_name like 'G_ra_d'; -- _ = 한글자


select employee_id, first_name, last_name, email, salary
from employees
where first_name like 'B%y';


select employee_id, first_name, last_name, email, salary
from employees
where first_name like '%b%';


-- 2016년도에 입사한 사원들

select employee_id, first_name, last_name, email, hire_date
from employees
where to_char(hire_date, 'YYYY/MM/DD') like '2016%';































