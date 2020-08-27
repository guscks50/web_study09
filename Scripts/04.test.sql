SELECT name,userid,pwd,email,phone,admin,JOINDATE 
	FROM MEMBER;

SELECT name,userid,pwd,email,phone,admin,JOINDATE 
	FROM MEMBER
WHERE userid = 'parkgy';

INSERT INTO MEMBER(name,userid,pwd,email,phone,admin) values('박규영','parkgy','1234','pgy@gmail.com','010-1111-2222',0);

UPDATE MEMBER
	SET name='문채원',pwd='5678',email='mcw@gmail.com',phone='010-3333-5555',admin= 1 , JOINDATE ='2020-08-20'
WHERE userid='parkgy';

DELETE 
FROM  MEMBER
WHERE userid='parkgy';
