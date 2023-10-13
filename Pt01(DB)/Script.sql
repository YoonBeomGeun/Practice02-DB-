-- 주석
-- 1. DB 생성: ctrl + enter

create database shop2

use shop2 -- shop2 db 선택

-- 2. Table 생성: 항목명 결정

create table member (
	id varchar(100),
	pw varchar(100),
	name varchar(100),
	tel varchar(100)
)

-- 여기까지 어떤 데이터를 저장할지 정의하는 문법
-- DDL(Data Definition Language)

-- 이 아래부터는 데이터를 어떻게 할지 조작하는 문법 
-- DML(Data Manipulation Language)

-- 3. Data 넣어보고, 수정/검색/삭제
-- varchar == String

insert into member values ('100', '100', 'yoon', '010')

insert into member values ('200', '200', 'yoon', '010')

insert into member values ('300', '300', 'yoon', '010')

select * from member

update member set tel = '000'

update member set tel = '999' where id = '100'

-- id가 200인 사람의 이름을 'park'으로 수정

update member set name = 'park' where id = '200'

delete from member where id = '100'

delete from member where id = '200' and tel = '000'

select id, name, tel from member


-- product 3 테이블 작성

create table product3 (
	id varchar(100),
	name varchar(100),
	content varchar(100),
	price int,
	company varchar(100),
	img varchar(100)
)

insert into product3 values
('100', 'shoes1', 'fun shoes1', 1000, 'c100', '1.png')

insert into product3 values
('200', 'shoes2', 'fun shoes2', 2000, 'c200', '2.png')

insert into product3 values
('300', 'shoes3', 'fun shoes3', 3000, 'c300', '3.png')

insert into product3 values
('400', 'shoes4', 'fun shoes4', 4000, 'c400', '4.png')

update product3 set id = '102' where id = '200'

update product3 set id = '103' where id = '300'

update product3 set id = '104' where id = '400'

select * from product3

select name, content from product3 where id = '100'

select price from product3 where id = '102'

update product3 set price = 5000 where name = 'shoes1'

update product3 set company = 'c555' where name = 'shoes2'

update product3 set name = 'fun', price = 9999 where id = '103'

delete from product3 where id = '100'

delete from product3 where price = 3000 or img = '4.png'

truncate product3


create database bookstore

create table member (
	id varchar(100),
	pw varchar(100),
	name varchar(100)
)

create table book (
	title varchar(100),
	author varchar(100),
	inventory int(100),
	price int(100)
)

insert into member values('qwer', '1234', 'yoon')

insert into member values('qwer', '1234', 'lee')

insert into member values('qwer', '1234', 'kang')


insert into book values('세계 요리가 집밥으로 빛나는 순간', '윤지영', 50, 23400)

insert into book values('한번쯤 자전거 여행', '송미령', 70, 15000)

insert into book values('이건 책', '윤', 100, 10000)

select * from member

select * from book

select pw from member where id = 'qwer'

update member set id = 'qwer2' where name = 'lee'

update member set id = 'qwer3' where name = 'kang'

delete from member where id = 'qwer'

select title, author from book where inventory = 70