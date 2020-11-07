--MENUTABLE 생성
INSERT INTO MENU VALUES('M01', '뼈해장국', 6000);
INSERT INTO MENU VALUES('M02', '갈비탕', 9000);
INSERT INTO MENU VALUES('M03', '육개장', 7000);
INSERT INTO MENU VALUES('M04', '제육덮밥', 6000);
INSERT INTO MENU VALUES('S01', '공깃밥', 6000);
INSERT INTO MENU VALUES('S02', '계란찜', 6000);
INSERT INTO MENU VALUES('S03', '꽁치구이', 6000);
INSERT INTO MENU VALUES('S04', '계란후라이', 6000);
INSERT INTO MENU VALUES('B01', '소주', 6000);
INSERT INTO MENU VALUES('B02', '맥주', 6000);
INSERT INTO MENU VALUES('B03', '콜라', 6000);
INSERT INTO MENU VALUES('B04', '사이다', 6000);


-- ORDERTABLE생성
INSERT INTO TABLEINFO VALUES(01,'1번테이블');
INSERT INTO TABLEINFO VALUES(02,'2번테이블');
INSERT INTO TABLEINFO VALUES(03,'3번테이블');
INSERT INTO TABLEINFO VALUES(04,'4번테이블');
INSERT INTO TABLEINFO VALUES(05,'5번테이블');
INSERT INTO TABLEINFO VALUES(06,'6번테이블');
INSERT INTO TABLEINFO VALUES(07,'7번테이블');
INSERT INTO TABLEINFO VALUES(08,'8번테이블');



INSERT INTO MENU_ORDER VALUES(01,'M01','2020-08-27', 4, 0);
INSERT INTO MENU_ORDER VALUES(02,'M02','2020-08-28', 2, 0);
INSERT INTO MENU_ORDER VALUES(03,'M03','2020-08-28', 3, 1);
INSERT INTO MENU_ORDER VALUES(04,'M04','2020-08-26', 1, 0);
INSERT INTO MENU_ORDER VALUES(05,'S01','2020-08-25', 2, 0);
INSERT INTO MENU_ORDER VALUES(06,'S01','2020-08-24', 3, 0);
INSERT INTO MENU_ORDER VALUES(07,'S01','2020-08-28', 5, 1);
INSERT INTO MENU_ORDER VALUES(08,'B01','2020-08-23', 2, 0);


INSERT INTO MENU_ORDER VALUES(1, ' ', SYSDATE, 0, 0);
INSERT INTO MENU_ORDER VALUES(2, ' ', SYSDATE, 0, 0);
INSERT INTO MENU_ORDER VALUES(3, ' ', SYSDATE, 0, 0);
INSERT INTO MENU_ORDER VALUES(4, ' ', SYSDATE, 0, 0);
INSERT INTO MENU_ORDER VALUES(5, ' ', SYSDATE, 0, 0);
INSERT INTO MENU_ORDER VALUES(6, ' ', SYSDATE, 0, 0);
INSERT INTO MENU_ORDER VALUES(7, ' ', SYSDATE, 0, 0);
INSERT INTO MENU_ORDER VALUES(8, ' ', SYSDATE, 0, 0);

DELETE FROM MENU_ORDER  ;
SELECT * FROM MENU_ORDER ;


SELECT * FROM MENU;
SELECT * FROM MENU_ORDER;
SELECT * FROM TABLEINFO;

SELECT NAME, CODE 
  FROM MENU
 WHERE NAME = CODE;
 
SELECT T.NO, M.NAME, M.PRICE * O.CNT AS PRICE, O.CNT, O.ISPAYMENT
  FROM MENU M, TABLEINFO T, MENU_ORDER O
 WHERE T.NO = O.NO AND ;

-- 테이블에 표시해야할 정보들 MENUORDERTABLE
SELECT T.NO, M.NAME, M.PRICE * O.CNT AS PRICE, O.CNT, O.ISPAYMENT FROM MENU M JOIN MENU_ORDER O ON (M.CODE = O.CODE) JOIN TABLEINFO T ON (T.NO = O.NO);


UPDATE MENU_ORDER 
	SET CODE= 'M03', ORDERDAY=SYSDATE, CNT=5, ISPAYMENT=1 WHERE NO =1;


