select * from user_tables;

--주석
--ctrl+/ 주석토글링
--create 명령어 - DDL 데이터 정의어
create user c##scott identified by tiger;
drop user c##scott;
alter session set "_ORACLE_SCRIPT"=true;
create user kh identified by kh;
create user scott identified by tiger;

--DCL
--create session, create table 처럼 각각 권한명을 모두 나열하여 적기 어려움..
--권한들을 묶어서 만들어둔 롤role 을 사용하여 권한을 부여함.
--connect - 접속관련 권한들이 있는 role
--resource - 자원관련(table, view 등 객체 )관련 권한들이 있는 role
grant connect, resource to c##scott;

grant connect, resource to kh;
revoke connect, resource from kh;
grant connect, resource to scott,kh;
--21g xe 버젼 , dba 추가
grant connect, resource, dba to scott,kh;


--select * from kh.dept;
--안됨create public synonym dept_public for KH.DEPT;
--create public synonym DEPT2_public for KH.DEPT;
--select * from emp;
--select * from DEPT2_PUBLIC;
--<계정삭제>
--alter session set "_ORACLE_SCRIPT"= true;
--drop user kh cascade;

--서버잠겼을때
--alter user kh account unlock;