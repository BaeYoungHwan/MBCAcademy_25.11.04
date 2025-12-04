/*

	Join : 두개이상의 테이블 연결(Join)해서 데이터를 취득하는 방법
			현재 테이블에서 취득할 수 없는 컬럼의 데이터를 상대 테이블에서 취득하기 위한 처리

			기본키(Primary Key) : 중복을 허용하지 않음. 빈칸도 허용하지 않음

			외래키(foregin Key) : 조인을 하기 위한 칼럼


	ERD(Entity Relationship Diagram)
	
	Join의 종류

		inner join			
		full outer join
		left outer join
		right outer join
		cross join
		self join
*/

-- inner join
-- ansi SQL
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e inner join departments d on e.department_id = d.department_id;

-- postgreSQL
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;



-- cross join
-- ansi SQL
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e cross join departments d;

-- postgreSQL
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e, departments d;



-- outer join
--left
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e left outer join departments d on  e.department_id = d.department_id;

--right
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e right outer join departments d on  e.department_id = d.department_id;

-- full outer join
select e.employee_id, e.first_name, e.department_id, d.department_id, d.department_name
from employees e full outer join departments d on  e.department_id = d.department_id;



-- self join 같은 테이블을 조인
-- ansi SQL
select e.employee_id as 사원번호, e.first_name as 사원이름, e.manager_id as "상사의 사원번호", mgr.employee_id as "상사의 사원번호", mgr.first_name as 상사이름
from employees e join employees mgr on e.manager_id = mgr.employee_id;

-- postgreSQL
select e.employee_id as 사원번호, e.first_name as 사원이름, e.manager_id as "상사의 사원번호", mgr.employee_id as "상사의 사원번호", mgr.first_name as 상사이름
from employees e , employees mgr 
where e.manager_id = mgr.employee_id;













