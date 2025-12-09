/*
1. 운동부 TABLE을 작성하라.
TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지
PLAYER : 선수번호, 선수 명, 등록일, 포지션, 키, 팀 아이디
TEAM을 두 개만 등록합니다.

두 개의 TEAM에 선수를 각각 3명씩 등록(추가)합니다.

같은 팀 선수들만을 출력해 보도록 합니다

선수를 입력하면 그 선수의 팀 명과 전화번호, 홈페이지가 출력되도록
JOIN 해 보도록 합니다.
*/

create table team(

	id 				int 		primary key,
	location 		varchar(30),
	name 			varchar(30)	not null,
	create_date 	timestamptz,
	telephon 		varchar(30),
	homepage 		varchar(30)

);


create table player(

	playerNo 		int 		primary key,
	playerName 		varchar(30),
	regDate			timestamptz,
	playerPosition	varchar(30),
	playerheight	numeric,
	id				int,
	foreign key(id) references team(id)
	
);

select * from team;
select * from player;


drop table team, player;


-- TEAM을 두 개만 등록합니다.
insert into team
values(1000, '익산', '청룡익산', '1996-02-01', '010-4188-1773', 'www.uee835.com');

insert into team
values(1001, '광주', '주작광주', '1999-05-26', '010-4926-1773', 'www.guswl.com');

-- 두 개의 TEAM에 선수를 각각 3명씩 등록(추가)합니다.

insert into player
values(62, '병건', '1965-05-08', 'GK', 175.8, 1000);

insert into player
values(59, '현숙', '1968-11-24', 'FW', 159.8, 1000);

insert into player
values(30, '영환', '1996-02-01', 'MF', 177.7, 1000);

insert into player
values(26, '현지', '1999-05-26', 'GK', 161.2, 1001);

insert into player
values(25, '현우', '2000-11-24', 'FW', 179.8, 1001);

insert into player
values(00, '윤슬', '2025-08-01', 'MF', 75.8, 1001);


-- 같은 팀 선수들만을 출력해 보도록 합니다
select *
from player
where id = 1000;

select *
from player
where id = 1001;

-- 선수를 입력하면 그 선수의 팀 명과 전화번호, 홈페이지가 출력되도록 JOIN 해 보도록 합니다.
select p.playername, t."name", t.telephon, t.homepage
from player p, team t
where p.id = t.id and p.playername = '영환';


/*
2. 온라인 마켓 TABLE을 작성하라.
PRODUCT(상품) : 상품번호, 상품명, 상품가격, 상품설명
CONSUMER(소비자) : 소비자 ID, 이름, 나이
CART(장바구니) : 장바구니 번호, 소비자 ID, 상품번호, 수량

상품 테이블에 상품을 등록합니다(개수는 원하는 데로).

소비자를 등록합니다.

소비자가 쇼핑한 상품을 추가합니다.

쇼핑한 상품을 출력합니다.
*/
create SEQUENCE proudct_seq
increment by 1	-- 1씩증가
start with 1000 	--  시작 숫자 지정
maxvalue 100000;

create SEQUENCE consumer_seq
increment by 1	-- 1씩증가
start with 3000 	--  시작 숫자 지정
maxvalue 100000;


create SEQUENCE cart_seq
increment by 1	-- 1씩증가
start with 5000 	--  시작 숫자 지정
maxvalue 100000;



create table PRODUCT(
-- 상품번호, 상품명, 상품가격, 상품설명
	product_no		int				default nextval('proudct_seq')		primary key,
	product_name 	varchar(30),
	product_price	numeric,
	product_memo	varchar(30)
	
);


create table CONSUMER(
-- 소비자 ID, 이름, 나이
	consumer_id			int			default nextval('consumer_seq')		primary key,			
	consumer_name		varchar(30),
	consumer_age		int

);


create table CART(
-- 장바구니 번호, 소비자 ID, 상품번호, 수량
	cart_no			int			default nextval('cart_seq')		primary key,
	consumer_id		int,				
	foreign key(consumer_id) references CONSUMER(consumer_id),
	product_no		int,
	foreign key(product_no) references PRODUCT(product_no),
	cart_qty		int

);

select * from product;
select * from CONSUMER;
select * from CART;


--상품 테이블에 상품을 등록합니다(개수는 원하는 데로).
-- 상품번호, 상품명, 상품가격, 상품설명
insert into product(product_name, product_price, product_memo)
values('신선한 우유', 2500, '신선한 우유 2L가 2500원인 가성비 음료');
insert into product(product_name, product_price, product_memo)
values('초코맛 우유', 3500, '진한 초코맛 우유');
insert into product(product_name, product_price, product_memo)
values('변신로봇 캡', 9900, '애니메이션 캡의 형상을 띈 변신로봇');
insert into product(product_name, product_price, product_memo)
values('맛있는 라면', 4500, '맛있는 라면 6봉지 묶음세트');
insert into product(product_name, product_price, product_memo)
values('장미 방향제', 8500, '장미향이 나는 방향제');

--소비자를 등록합니다.
-- 소비자 ID, 이름, 나이
insert into CONSUMER(consumer_name, consumer_age)
values('영환', 30);
insert into CONSUMER(consumer_name, consumer_age)
values('병건', 60);
insert into CONSUMER(consumer_name, consumer_age)
values('현숙', 57);
insert into CONSUMER(consumer_name, consumer_age)
values('현지', 26);

--소비자가 쇼핑한 상품을 추가합니다.
-- 장바구니 번호, 소비자 ID, 상품번호, 수량
insert into CART(consumer_id, product_no, cart_qty)
values(3000, 1002, 3);
insert into CART(consumer_id, product_no, cart_qty)
values(3002, 1004, 5);
insert into CART(consumer_id, product_no, cart_qty)
values(3003, 1000, 1);

--쇼핑한 상품을 출력합니다.
select co.consumer_name as 고객이름, p.product_name as 상품명, p.product_price as 단가, c.cart_qty as 수량, (c.cart_qty * p.product_price) as 총가격
from cart c, product p, consumer co
where c.product_no = p.product_no and c.consumer_id = co.consumer_id;



