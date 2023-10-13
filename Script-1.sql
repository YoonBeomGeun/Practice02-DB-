use shop

-- hobby table 작석

insert into hobby values
(100, 'run', 'seoul'),
(200, 'book', 'busan')

select * from hobby

select content from hobby

select location, content from hobby

-- movie table 작성

create table movie (
	id varchar(100),
	title varchar(100),
	content varchar(100),
	actor varchar(100)
)

insert into movie values
('m1', '블랙아담', '액션', '드웨인 존슨'),
('m2', '리멤버', '드라마', '남주혁'),
('m3', '자백', '스릴러', '소지섭')

select * from movie

select * from movie where id='m1'

update movie set content='스릴러' where id='m1'

delete from movie where id='m1'

-- place table 작성

create table place (
	id varchar(100),
	name varchar(100),
	addr varchar(100),
	tel varchar(100)
)

insert into place values
('p1', 'cgv', '강남구 삼성동', '02-555'),
('p2', 'megabox', '강남구 역삼동', '02-666'),
('p3', 'lotte', '강남구 대치동', '02-777')

select * from place

select * from place where name='cgv'

update place set tel='02-888' where name='lotte'

delete from place where id='p3'

delete from movie

delete from place

drop table movie

drop table place