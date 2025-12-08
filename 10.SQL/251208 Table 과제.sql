-- 문제1) EMPLOYEES 테이블에서 부서별로 인원수,평균 급여,급여의 합,최소 급여,최대 급여를 포함하는 
-- EMP_DEPTNO 테이블을 생성하라.
create table EMP_DEPTNO
as
select department_id, count(*) as dcount,
		avg(salary) as avgS, sum(salary) as sumS, min(salary) as minS, max(salary) as maxS
from employees
group by department_id;


select *
from EMP_DEPTNO;

-- 문제2) EMP_DEPTNO 테이블에 ETC COLUMN을 추가하라. 
-- 단 자료형은 VARCHAR(50) 사용하라.
alter table EMP_DEPTNO
add ETC VARCHAR(50);

-- 문제3) EMP_DEPTNO 테이블에 ETC COLUMN을 수정하라. 
-- 자료 형은 VARCHAR(15)로 하라.
alter table EMP_DEPTNO
alter column ETC
type VARCHAR(15);


-- 문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라.
alter table EMP_DEPTNO
drop column ETC;

-- 문제5) 위에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT로 변경하라.
alter table EMP_DEPTNO
rename to EMP_DEPT;


-- 문제6) EMP_DEPT 테이블을 삭제하라.
drop table EMP_DEPT;

-- 문제7) EMPLOYEES 테이블을 EMP 테이블을 생성하고 복제하도록 하라.
-- (데이터 포함)
-- "사원번호", "이름", "월급", "부서번호", "부서명", "부서월급순위"  부서안의 사원별 월급순위 
create table EMP_Table
as
select e.employee_id, e.first_name, e.salary, d.department_id, d.department_name, row_number()over(partition by e.department_id order by salary desc)
from employees e, departments d
where e.department_id = d.department_id

drop table EMP_Table; 

select *
from EMP_Table;

-- 문제8) EMP 테이블에 row를 추가해 봅니다.
-- 다만, 반드시 데이터를 기입을 안해도 되면, NULL로 설정하도록 한다.

insert into EMP_Table(employee_id, first_name, salary, department_id, rank)
values(1004, 'ADD', 3000, 130, 1);


-- 문제9) EMPLOYEES 테이블에서 EMPNO, ENAME, SAL, HIREDATE, DEPARTMENT_ID의 COLUMN만 선택하여 
-- EMP_10 테이블을 생성(데이터 미포함)합시다.
create table EMP_10
as
select employee_id as EMPNO, first_name as ENAME, Salary as SAL, hire_date as HIREDATE, department_id
from EMPLOYEES
where 1=2;


select *
from EMP_10;

-- 문제10) 50번 부서만 선택하여 이에 대응하는 값을 EMP_10 테이블에 추가하라.

drop table EMP_10;

insert into emp_10
select employee_id as EMPNO, first_name as ENAME, Salary as SAL, hire_date as HIREATE, department_id
from EMPLOYEES e
where e.department_id = 50;


