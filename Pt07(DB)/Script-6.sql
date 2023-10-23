desc totalstudent

insert into totalstudent 
values
('601', '손흥민', '토트넘', '컴퓨터과', null, null, null, null)

insert into totalstudent 
values
('701', '조규성', '토트넘2', '체육학과', null, null, null, null)

-- 삽입할 때 너무 많은 Null을 포함하고 있으면 스키마를 수정해 주어야 한다.(삽입이상)

select * from totalstudent

update totalstudent
set 주소 = '서울'
where 학생이름 = '박지성' and 강좌이름 = '자료구조'

-- 수정하고 나서 데이터에 이상한 현상(이상현상)

delete from totalstudent
where 학생이름 = '김연아' -- 데이터베이스 수강 취소

-- 지우려고 했던 데이터가 아닌 것까지 연쇄적으로 지워지면 이상현상(삭제이상)

CREATE TABLE 학생 (
	학생번호 varchar(100) NULL,
	학생이름 varchar(100) NULL,
	주소 varchar(100) NULL,
	학과 varchar(100) NULL
)

desc 학생

CREATE TABLE 강좌정보 (
	강좌이름 varchar(100) NULL,
	강의실 varchar(100) NULL
)

desc 강좌정보

CREATE TABLE 학과정보 (
	학과 varchar(100) NULL,
	학과사무실 varchar(100) NULL
)

desc 학과정보

CREATE TABLE 성적정보 (
	학생번호 varchar(100) NULL,
	강좌이름 varchar(100) null,
	성적 varchar(100) null
)

desc 성적정보

select * from 학생

-- 삽입 ==>null이 생기는 이상이 사라짐.

insert into 학생
values
('601', '손흥민', '토트넘', '체육학과')

-- 수정 ==> 정보의 불일치 이상이 사라짐.

update 학생
set 주소 = '서울'
where 학생이름 = '박지성'

select * from 학생

-- 삭제 ==> 연쇄삭제 이상현상이 사라짐.

delete from 성적정보
where 학생번호 = '401'

select * from 성적정보

-- ---------검색----------

show tables

select * from 학생

select * from 학과정보

select count(학과) as 전체학과개수 from 학과정보

-- 학생의 번호, 이름, 학과, 학과사무실(2개의 테이블을 합해야 한다.) - join

select s.학생번호, s.학생이름, d.학과, d.학과사무실  
from 학생 s, 학과정보 d
where s. 학과 = d.학과

select s.학생번호, s.학생이름, d.학과, d.학과사무실  
from 학생 s inner join 학과정보 d
on s. 학과 = d.학과

-- 학생의 학생번호, 학생이름, 강좌이름, 성적(학생 + 성적정보)

select s.학생번호, s.학생이름, c.강좌이름, c.성적
from 학생 s inner join 성적정보 c
on s.학생번호 = c.학생번호

-- 학생의 학생번호, 강좌이름, 강의실, 성적(성적정보 + 강좌정보)

select s.학생번호, c.강좌이름, c.강의실, s.성적
from 성적정보 s inner join 강좌정보 c
on s.강좌이름 = c.강좌이름 

-- 3개 조인할 때 사용법

select s.학생번호, j.강좌이름 , j.성적 , c.강의실
from 학생 s
inner join 성적정보 j on s.학생번호 = j.학생번호
inner join 강좌정보 c on j.강좌이름 = c.강좌이름 

select *
from 학생 s
left join 성적정보 j on s.학생번호 = j.학생번호 

select * from 성적정보

select * from 학생
where 학생번호 in(
select 학생번호 from 성적정보
where 학생번호 = '501')

-- 자료구조를 들은 학생들의 이름과 학과를 프린트 in (sql 문)
-- 성적정보 + 학생

select 학생이름, 학과
from 학생
where 학생번호 in (
select 학생번호
from 성적정보
where 강좌이름 = '자료구조'
)

-- 강의실이 공학관 110에서 수업을 듣는 학생의 학생번호와 성적 프린트
-- 강좌정보 + 성적정보

select 학생번호, 성적
from 성적정보
where 강좌이름 = (
select 강좌이름
from 강좌정보
where 강의실 = '공학관110'
)





