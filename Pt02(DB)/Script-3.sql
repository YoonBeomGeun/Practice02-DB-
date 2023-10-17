create database test;

use test;

-- test.dept definition

CREATE TABLE `dept` (
  `DEPTNO` int NOT NULL,
  `DNAME` varchar(100) DEFAULT NULL,
  `LOC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- test.emp definition

CREATE TABLE `emp` (
  `EMPNO` int NOT NULL,
  `ENAME` varchar(100) DEFAULT NULL,
  `JOB` varchar(100) DEFAULT NULL,
  `MGR` int DEFAULT NULL,
  `HIREDATE` datetime DEFAULT NULL,
  `SAL` int DEFAULT NULL,
  `COMM` int DEFAULT NULL,
  `DEPTNO` int DEFAULT NULL,
  PRIMARY KEY (`EMPNO`),
  KEY `emp_FK` (`DEPTNO`),
  CONSTRAINT `emp_FK` FOREIGN KEY (`DEPTNO`) REFERENCES `dept` (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- test.professor definition

CREATE TABLE `professor` (
  `ID` varchar(100) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `TEL` varchar(100) DEFAULT NULL,
  `DEPTID` int DEFAULT NULL,
  `ADDR` varchar(100) DEFAULT NULL,
  `ROOMNO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `professor_FK` (`DEPTID`),
  CONSTRAINT `professor_FK` FOREIGN KEY (`DEPTID`) REFERENCES `dept` (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- test.student definition

CREATE TABLE `student` (
  `ID` varchar(100) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `TEL` varchar(100) DEFAULT NULL,
  `DEPTID` int DEFAULT NULL,
  `PROFESSORID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `student_FK` (`DEPTID`),
  CONSTRAINT `student_FK` FOREIGN KEY (`DEPTID`) REFERENCES `dept` (`DEPTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- depart2 생성

create table depart2 (
	id varchar(100) primary key,
	name varchar(100),
	instructor varchar(100)
)

select * from depart2

desc depart2

create table student2 (
	id varchar(100),
	name varchar(100),
	tel varchar(100),
	dept_id varchar(100)
)

desc student2

alter table student2 add constraint student2_FK
foreign key (dept_id) references depart2(id)

drop table depart2

show tables












