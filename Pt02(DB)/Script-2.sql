-- 주석

-- shop, shop2, sys

-- db > table > 항목(field, item, property)

-- shop을 선택 후, SQL 버튼을 클릭한 경우, shop이 선택된 것

-- create table a ==> shop db에 만들어짐.

-- shop db 선택 후, 다른 db를 사용하고 싶은 경우

-- use shop2 입력

create user 'summer3'@'localhost' identified by '1111'

grant all privileges
on *.*
to 'summer3'@'localhost'


-- apple / 1234 생성 후, 디비버에서 연결

create user 'apple'@'localhost' identified by '1234'

grant all privileges
on *.*
to 'apple'@'localhost'

create user 'apple22'@'localhost' identified by '1234'

grant all privileges
on *.*
to 'apple22'@'localhost'


use shop3

show tables


use test


use shop

show tables

desc member

insert into member values ('melon', '1234', 'melon', '010')

select * from member

select tel, id from member

insert into member values ('computer', '1234', 'com', null)

select * from member

insert into member(id, pw, name) values ('ss', '1234', 'ss')


insert into member
values('ice2', '1234', 'ice2', '010', now())

delete from bbs

select * from bbs

insert into bbs values(null, 'db', 'fun db', 'apple')

insert into productorder
values(null, 'apple', 27000, now(), 'seoul')

insert into productorder
values('2', 'apple2', 28000, now(), 'incheon')

select * from productorder

insert into productorder(id, title, price, buydate)
values(null, 'apple3', 28000, now())

delete from productorder


-- productorder2

create table productorder2 (
	id varchar(100) primary key,
	title varchar(100) unique,
	price int,
	buydate date,
	addr varchar(100) default 'home' not null
)

select * from productorder2


