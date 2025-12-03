-- 문제1) EMPLOYEES Table의 모든 자료를 출력하여라.

select *
from employees;

-- 문제2) EMPLOYEES Table의 컬럼들만 모두 출력하라.

SELECT * FROM employees LIMIT 0;

select column_name, data_type
from information_schema."columns"
where table_name = 'employees';

-- 문제3) EMPLOYEES Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.

select employee_id, last_name || first_name, salary, job_id
from employees;


-- 문제4) 모든 종업원의 급여를 $300증가 시키기 위해서 덧셈 연산자를 사용하고 결과에 SALARY+300을 디스플레이 합니다.

select employee_id, last_name || first_name, salary+300, job_id
from employees;


-- 문제5) EMPLOYEES 테이블에서 사원번호, 이름, 급여, 보너스, 보너스 금액을 출력하여라. 
-- (참고로 보너스는 월급 + (월급*커미션))

select employee_id, last_name || first_name, salary+300, coalesce(commission_pct, 0) as 보너스, coalesce((commission_pct * salary) + salary, 0) as "보너스 금액"
from employees;


-- 문제6) EMPLOYEES 테이블에서 LAST_NAME을 이름으로 SALARY을 급여로 출력하여라.

select employee_id as 사번, first_name as 이름, salary as 급여
from employees;


-- 문제7) EMPLOYEES 테이블에서 LAST_NAME을 Name으로 SALARY * 12 를 Annual Salary(연봉)로 출력하여라

select employee_id as 사번, last_name  as Name, salary*12 as 연봉
from employees;


-- 문제8) EMPLOYEES 테이블에서 이름과 업무를 연결하여 출력하여라.

select employee_id as 사번, last_name || job_id as "이름 및 업무" 
from employees;


-- 문제9) EMPLOYEES 테이블에서 이름과 업무를 "KING is a PRESIDENT" 형식으로 출력하여라. 


select employee_id as 사번, last_name || ' is a ' || job_id as "이름 및 업무" 
from employees;


-- 문제10) EMPLOYEES 테이블에서 이름과 연봉을 "KING: 1 Year salary = 60000" 형식으로 출력하여라.

select employee_id as 사번, last_name || ' : Year salary = ' || round(salary*12) as "이름 및 연봉" 
from employees;




