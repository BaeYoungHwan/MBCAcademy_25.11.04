drop sequence seq_comment;

create sequence seq_comment
increment by 1
start with 1;

drop table bbscomment;

create table bbscomment(
	seq integer default nextval('seq_comment') primary key,			-- 기본 글의 seq
	bbsseq int not null,		-- 게시판 글의 번호
	id varchar(50) not null,	-- login한 유저의 아이디
	content varchar(1000) not null,
	wdate timestamp not null
);

alter table bbscomment
add foreign key(id) references member(id);

