drop table bbs;

drop sequence seq_bbs;

create sequence seq_bbs
increment by 1
start with 1;

create table bbs(
	seq integer default nextval('seq_bbs') primary key,
	id varchar(50) not null,
	
	ref integer not null,	
	step integer not null,
	depth integer not null,
	
	title varchar(200) not null,
	content varchar(4000) not null,
	wdate timestamp,
	parent integer not null,	
	
	del integer not null,		
	readcount numeric(8) not null 
);

alter table bbs
add constraint fk_bbs_id foreign key(id)
references member(id);

insert into bbs(id, ref, step, depth, title, content, wdate, parent, del, readcount)
values('abc', (select coalesce(max(ref), 0) + 1 from bbs), 0, 0, '제목', '내용', now(), 0, 0, 0);

select id, ref, step, depth, title, content, wdate, parent, del, readcount
from bbs
where seq=1

select * from bbs;


				
				