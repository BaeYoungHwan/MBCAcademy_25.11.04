create sequence id_seq start with 1000 increment by 1;

Create table AddressBook (

	ID		int 	default		nextval('id_seq')	primary key,
	name	varchar(30),
	age		int,
	phone	varchar(30),
	address	varchar(30),
	memo	varchar(30)

)

drop table AddressBook


select id, name, age, address, memo from AddressBook 
select id, name, age, address, memo from AddressBook where age = 22;