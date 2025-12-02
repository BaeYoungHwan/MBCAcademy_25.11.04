--가상테이블

select 1;
select 1+3;
SELECT 'Abc'; --dual
select 4/2; --2 

--(표준)함수
--기준 함수

-- 문자 함수
-- chr (n) : 숫자를 (n)넣으면 문자로 표현

select chr(65); -- 출력값 A
select chr(48); -- 출력값 0

select ASCII('A');	-- chr 함수의 반대로 나옴 ASCII값 표출

-- LPAD, RPAD : 칸수를 설정하고 특정문자로 채운다
select lpad('hello' , 10); -- 출력값 "     hello"
select lpad('hello' , 10, '2'); -- 출력값 "22222hello"

select rpad('hello' , 10, '2'); -- 출력값 "hello22222"

-- Position
select POSITION('e' In 'hello'); -- 결과값 2 // 타언어랑 다르게 DB는 1부터 시작
select POSITION('a' In 'hello'); -- 결과값 0

-- replace 문자열 변경
select replace('AAAAASDD', 'A', 'a'); -- "aaaaaSDD"
select replace('AAAAASDD', 'AA', 's'); -- "ssASDD"

-- tanslate 문자변경
select translate('AAAAASDD', 'A', 's'); -- "sssssSDD"
select translate('AAAAASDD', 'AA', 's'); -- "sssssSDD"

-- 문자열 합치기 "abcdef"
select ('abc' || 'def'); 

-- 길이 계산  3
select length('abc');

-- 소문자로 변경 "abc"
select lower('ABC');

-- 대문자로 변경 "ABC"
Select upper('abc');

-- substring('적용할 문자열', 시작위치, 글자수 ) == SUBSTR
select SUBSTRING('hello World', 7, 3); -- "Wor"
select SUBSTR('hello World', 7, 3); -- "Wor"

-- 산술 함수
select abs(-123); -- 123 절댓값
select mod(5,3); -- 2 나누기
select round(123.353); --123 자리수에 대한 반올림
select round(123.353, 1); -- 123.4
select round(123.353, -1); -- 120

select ceil(123.4); -- 124 올림
select floor(123.4); -- 123 올림

select sign(12.4); -- 1  
select sign(0); -- 0 양수면 1 음수면 -1
select sign(-12.4); -- -1

select trunc(12.3456); -- 12 소수점 버림
select trunc(12.3456,3); -- 12.345 자리수표시
select trunc(12.3456,-1); -- 10 소수점 기준으로 -1

-- 날짜 함수
select now(); -- 현재 날짜 및 시간 "2025-12-02 16:22:50.089855+09"
select current_date; -- 현재 날짜 "2025-12-02"
select current_time; -- 현재 시간"16:23:20.896821+09:00"
select current_timestamp; -- 현재 날짜 및 시간 "2025-12-02 16:24:02.049782+09"

-- 날짜 및 시간요소 자르기
select current_timestamp, extract(year from current_timestamp); -- "2025-12-02 16:26:11.927364+09"	2025
select current_timestamp, extract(month from current_timestamp); -- "2025-12-02 16:27:48.742722+09"	12
select current_timestamp, extract(day from current_timestamp); -- "2025-12-02 16:27:55.155263+09"	2
select current_timestamp, extract(hour from current_timestamp); -- "2025-12-02 16:27:59.827715+09"	16
select current_timestamp, extract(minute from current_timestamp); -- "2025-12-02 16:28:07.874271+09"	28
select current_timestamp, extract(second from current_timestamp); -- "2025-12-02 16:28:14.564091+09"	14.564091


-- 변환함수
select cast(001 as text); -- "1"
select cast('001' as integer); -- 1
select cast('001.234' as numeric); -- 1.234
select cast('00341.234' as decimal(10,3)); -- 341.234
select cast('2026-05-25' as date); -- "2026-05-25"
select cast('2026-05-25 12:34:56' as date); -- "2026-05-25"
select cast('2026-05-25 12:34:56' as timestamp); -- "2026-05-25 12:34:56"
select cast('2026-05-25 12:34:56' as timestamp);

-- coalesce (col,1) col의 값이 null경우 1로 표출
select coalesce(null, 1); -- 1 

-- to_char 문자열방식으로 변경
select to_char(CURRENT_DATE, 'MM-DD-YYYY'); --"12-02-2025"
select to_char(CURRENT_DATE, 'DD/MM/YYYY'); --"02/12/2025"
select to_char(CURRENT_TIMESTAMP, 'DD/MM/YYYY HH:MI:SS'); --"02/12/2025 04:39:28"

-- 금액 단위 변환
select to_char(1000000, '$999,999,999'); -- "$   1,000,000"

-- 문자열을 날짜 형식으로 변환
select to_date('2025-10-12', 'YYYY/MM/SS'); -- "2025-10-01"

-- 문자열 숫자로 변환
select to_number('12,353.55', '999,999.9'); -- 12353.5


select TIMESTAMPZ

