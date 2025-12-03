Select * from employees; --모든 테이블 표출

-- 원하는 컬럼명만 표출
Select *
from employees;

-- 컬럼의 별명 (alias) 대소문자 및 생략가능 (붙이는걸 권장)
select employee_id AS "사원번호", first_name as "이름", salary 월급
from employees;

--
select employee_id AS "사원 번호", first_name as 이름, salary 월급
from employees;


-- 연산도 가능
select employee_id+50000 AS "사원 번호", first_name as 이름, salary+300 월급
from employees;

-- 문자열(컬럼 + 컬럼) 합해서 출력
select concat(last_name, first_name)
from employees;

select concat('성 : ' , last_name, '	이름 : ',first_name) as fullname
from employees;

select last_name || ' ' || first_name as fullname
from employees;



