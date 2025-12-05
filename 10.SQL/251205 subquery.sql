/*

	sub query : quey 안에 query

	select 	한개 row, 한개 column
	from 	다중 row, 다중 column
	where	다중 row, 다중 column


*/

-- select
select employee_id, (select first_name from employees where employee_id = 100)
from employees;

-- 다중 컬럼은 사용할 수 없다
select employees.employee_id, ( select first_name, last_name from employees)
from employees;

-- 다중 행을 사용할 수 없다.
select employees.employee_id, ( select first_name from employees where department_id = 20)
from employees;

-- 그룹함수랑 같이 사용할 수 없다
select employee_id, first_name, salary, round(avg(salary))
from employees;

-- 서브쿼리를 활용하여 사용 가능
select employee_id, first_name, salary, (select round(avg(salary)) from employees)
from employees;

select employee_id, first_name, salary, (select round(avg(salary)) from employees), (select count(salary) from employees)
from employees;


-- 100번 부서의 각 사원들과 100부서의 평균 급여가 같이 추력되도록 작성하라
select department_id, employee_id, first_name, salary,
		round((	select avg(salary)
			from employees
			GROUP by department_id
			HAVING department_id = 100
		)) as 급여평균
from employees
where department_id = 100;





-- from절
-- 50번 부서의 사원 중에서 $5000가 넘는 사원을 구하라
SELECT first_name
from employees
where department_id = 50 and salary > 5000;


select first_name
from(select *
	from employees
	where department_id = 50 and salary > 5000);

-- 컬럼의 명을 변경하면 컬럼 명도 변경해줘야한다
select firstname
from(select department_id, first_name as firstname
	from employees
	where department_id = 50 and salary > 5000);


-- 업무별로 급여의 합계, 인원수, 사원명, 월급
-- 그룹바이 사용시 first_name, salary는 사용불가
select job_id, sum(salary), count(employee_id), first_name, salary
from employees
GROUP by job_id;

select e.job_id, j.salarysum, j.cnt, e.first_name, e.salary
from employees e, (select job_id, sum(salary) as salarysum, count(*) as cnt
					from employees
					group by job_id ) j;




-- where 절
-- 평균 급여보다 많이 받는 사원
select first_name
from employees
where salary > (select avg(salary)
				from employees
				);

-- 부서가 90인 사원의 업무
select first_name
from employees
where job_id in (select job_id
				from employees
				where department_id = 90);

-- 부서별로 가장 급여를 적게 받는 사원의 급여와 같은 급여를 받는 사원
select department_id, first_name, salary
from employees
where salary in (select min(salary)
				from employees
				GROUP by department_id)
				


-- 부서별로 가장 급여를 많이 받는 사원

select *
from employees
where departmentid in 	(select department_id, max(salary)
						from employees
						where department_id is not null
						group by department_id)
order by department_id asc;


-- 특수 Query

select employee_id, first_name, phone_number, case substr(phone_number, 1, 3) 
												when '515' then '뉴욕' 
												when '590' then '워싱턴'
												when '650' then '보스턴'
												else '기타지역'
												end
from employees;


-- 그룹함수랑 같이 사용 가능
select department_id, first_name, count(*)over(), avg(salary)over()
from employees;


select department_id, first_name,
		count(*)over(PARTITION by department_id),
		avg(salary)over()
from employees;


/*

	순위함수
	rank() 			1 2 3 3 5 6
	dense_rank()	1 2 3 3 4 5
	row_number()	1 2 3 4 5 6
	rownum			1 2 3 4 5 6

	over( 순위 결정 코드 ) 와 같이 사용
	
*/

select employee_id, first_name, salary,
		rank()over( order by salary desc) as rank,
		dense_rank()over( order by salary desc) as dense,
		row_number()over( order by salary desc) as row
from employees;



-- 사원의 급여 랭킹 1~10위까지 구하라
-- select 보다 Where 가 먼저 실행 되기 때문에 에러표출
select row_number()over(order by salary desc ) as rnum, first_name, salary
from employees
where rnum >= 1 and rnum <= 10
order by salary desc;

-- 1. 번호할당
-- 2. 범위설정

select rnum, first_name, salary
from (select row_number()over(order by salary desc ) as rnum, first_name, salary
		from employees
		order by salary desc)
where rnum BETWEEN 11 and 20;


/*

	SQL 실제 실행 순서
	FROM : 각 테이블 확인
	ON : 조인 조건 확인
	JOIN : 테이블 조인 (병합)
	WHERE : 데이터 추출 조건 확인
	GROUP BY : 특정 칼럼으로 데이터 그룹화
	HAVING : 그룹화 이후 데이터 추출 조건 확인
	SELECT : 데이터 추출
	DISTINCT : 중복 제거
	ORDER BY : 데이터 정렬

	
*/






