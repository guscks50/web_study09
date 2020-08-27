--계정 추가 및 권한 부여

--접속자 확인
DROP  USER JSP_STUDY CASCADE;
SELECT USER FROM dual;

--계정 생성
CREATE USER JSP_STUDY IDENTIFIED BY rootroot;

--권한 추가
GRANT CONNECT,resource,CREATE synonym, CREATE VIEW
	TO JSP_STUDY;
	
--계정 확인
SELECT *
FROM DBA_USERS
WHERE username = 'JSP_STUDY';