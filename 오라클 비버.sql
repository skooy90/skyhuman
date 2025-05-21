SELECT * FROM emp
ORDER BY sal DESC;

SELECT * FROM emp
ORDER BY deptno ASC, sal DESC;

-- deptno asc, sal desc; 이 상황에서 연봉이 같으면 사원 번호 내림차순 정렬

SELECT * FROM emp
ORDER BY DEPTNO ASC, sal DESC, EMPNO DESC;

-- 주석달기 

SELECT distinct deptno FROM emp;

SELECT * FROM emp 
WHERE deptno = 30 OR deptno = 20;

SELECT * FROM emp 
WHERE deptno = 30 and sal > 1000 ;

-- sal이 1600인 사람
SELECT * FROM emp
WHERE sal = 1600;

-- 초과
SELECT * FROM emp
WHERE sal > 1600;

-- 이상
SELECT * FROM emp
WHERE sal >= 1600;

-- 이하
SELECT * FROM emp
WHERE sal <= 1600;


-- 아니다(부정) 프래그램 언어
SELECT * FROM emp
WHERE deptno != 30;

-- 부정 sql 언어
SELECT * FROM emp
WHERE deptno <> 30;

-- and
SELECT * FROM emp
WHERE deptno = 30
AND job = 'SALESMAN';



-- OR
/*
 * emp테이블에서 모든행을 출력하는데 deptno가 30이거나 job이 CLERK인 애들만 출력해줘 
 */

SELECT * FROM emp
WHERE deptno = 30
OR job = 'CLERK';


/*
 * job이 CLERK이고 sal이 2000초과 이거나 deptno가 10인 사원 조회
 */

SELECT * FROM emp
WHERE job = 'CLERK' AND sal > 2000
OR deptno = 10;

-- job이 CLERK이거나 sal이 2000초과면서 deptno가 10인 사원 조회
SELECT * FROM emp
WHERE job = 'CLERK' OR sal > 2000
and deptno = 10;

-- job이 CLERK이거나 sal이 2000초과면서 deptno가 10인 사원 조회 아닌것만
SELECT * FROM emp
WHERE not (job = 'CLERK' OR sal > 2000
and deptno = 10);

/*
 * deptno != 30, deptno <> 30, deptno ^= 30, not deptno = 30
 */

-- 월급이 2000이상 4000미만인 사원을 출력 하시오
SELECT * FROM emp
WHERE sal >= 2000 AND sal <4000;

-- 부서번호 10 또는 20인 사원만 출력

SELECT * FROM emp
WHERE deptno = 10 OR deptno = 20;

SELECT * FROM emp
WHERE deptno IN (10,20);


SELECT * FROM emp
WHERE deptno not IN (10,20);

SELECT * FROM emp
WHERE deptno BETWEEN 10 AND 20;

-- 05.13일 수업마무리

SELECT * FROM emp
WHERE ename LIKE 'S%';

SELECT * FROM emp
WHERE ename LIKE '_L%';

SELECT * FROM emp
WHERE ename LIKE '%AM%';

SELECT * FROM emp
WHERE ename LIKE '%A%';

SELECT * FROM emp
WHERE ename not LIKE '%A%';

SELECT COMM FROM emp;

SELECT COMM FROM EMP 
WHERE comm > 400;

SELECT * FROM emp
WHERE comm IS NULL;

SELECT * FROM emp
WHERE comm IS not NULL;

SELECT * FROM emp
WHERE deptno = 10
union
SELECT * FROM emp
WHERE deptno = 20;


SELECT * FROM emp
WHERE deptno = 10
union
SELECT * FROM emp
WHERE deptno = 10;

SELECT * FROM emp
WHERE deptno = 10
UNION all
SELECT * FROM emp
WHERE deptno = 10;


SELECT empno FROM emp
UNION  ALL
SELECT sal FROM emp;


SELECT empno FROM emp
UNION  ALL
SELECT ename FROM emp;

-- 부서 10번을 사원번호 내림차순(desc)으로 정렬하여 출력
SELECT * FROM emp 
WHERE deptno = 10
ORDER BY empno desc;
-- 부서 20번을 사원번호 오름차순(asc)으로 정렬하여 출력
SELECT * FROM emp 
WHERE deptno = 20
ORDER BY empno;

-- 아직 안배운 기술로 order by 적용 가능 
SELECT * FROM (
	SELECT * FROM emp 
	WHERE deptno = 10
	UNION all
	SELECT * FROM emp 
	WHERE deptno = 20
	)
ORDER BY empno;

SELECT ename,empno,sal,deptno FROM emp
WHERE ename LIKE '%E%' AND deptno=30 and sal NOT BETWEEN 1000 AND 2000 ;


-- 추가수당 null, 상급자(mgr) null, 직책 m,c 이름에 두번째 글씨가 l이 아닌!!
-- 손코딩으로 미리 작성하고 구문 작성
SELECT * FROM emp
WHERE (comm IS NULL 
AND mgr IS NOT null
AND JOB = 'MANAGER' OR JOB = 'CLERK')
AND ename NOT LIKE '_L%';


SELECT empno, ename, job, sal ,deptno FROM emp
WHERE deptno = 30 AND job = 'SALESMAN';



-- upper, lower
SELECT ename, upper(ename), lower(ename) FROM EMP; 

-- like 검색
SELECT ename FROM emp
WHERE lower(ename) LIKE lower('%aM%');

-- dual 더미 테이블로 출력만 하고 싶을떄

SELECT upper('aBc'), lower('aBc') FROM dual;

SELECT ename FROM emp;

SELECT length(ename) FROM emp;

SELECT ename FROM emp
WHERE LENGTH(ename) = 5;

SELECT LENGTHB('a') FROM dual;

SELECT lengthb('한') FROM dual;



SELECT  * FROM emp
WHERE NOT (sal >= 2000 AND sal <=3000);


SELECT * FROM emp
WHERE comm IS NULL
AND mgr IS NOT null
AND job IN ('MANAGER','CLERK')
AND ename NOT like('_L%');


SELECT job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 5)
FROM emp;

-- 사원이름(ename) 두번째 부터 3글자만 출력
SELECT ename ,substr(ename, 2,3)
FROM emp;


-- 음수 사용(글자의 끝부터 사용)
SELECT job, substr(job, -3, 2) FROM emp;


-- 이름의 뒤에서부터 3글자만 모두 출력하기
SELECT ename, substr(ename, -3) FROM emp;


SELECT '010-1234-5678' AS REPLACE_brfore,
	replace('010-1234-5678', '-', ' ') AS REP_1,
	replace('010-1234-5678', '-') AS REP_2
	FROM dual;

-- 사원이름에서 E를 -으로 모두 교체
SELECT ename,
	replace(ename, 'E', '-') AS rep
	FROM emp;

SELECT ename,
	replace(ename, 'TT', '-') AS rep
	FROM emp;



-- LPAD
SELECT LPAD(ename, 10, '#') FROM emp;
-- PRAD
SELECT RPAD(ename, 5, '@') FROM emp;

-- 모자르면 채우고
-- 넘어가면 자르고 


-- 난이도 쉬운거
-- nanme에 앞에 두글자만 출력
SELECT substr(ename,1,2) FROM emp;
-- 답
SELECT ename, substr(ename,1,2) FROM emp;
SELECT rpad(ename, 2) FROM emp;
-- 이름을 마스킹하는 버전 
-- 앞에 두글자만 원본을 출력하고 나머지는 4개의 *로 표시
SELECT Rpad(substr(ename,1,2), 6, '*') FROM emp;
-- 답
SELECT 
	rpad(
		substr(ename, 1,2),
		6,
		'*'
	)
	FROM emp;

-- 사원 이름 두글자만 보이고 나머지는 *로 단, 이름 갯수는 일치하게

SELECT Rpad(substr(ename,1,2), LENGTH(ename), '*') FROM emp;
-- 답
SELECT
	ename,
	rpad(
		substr(ename, 1,2),
		LENGTH(ename),
		'*'
	)
	FROM emp;

-- 심화???? 
-- job을 총 20자리 중 가운데 정렬 

SELECT Lpad(
rpad(job , (LENGTH(job)+20)/2, '*') ,20,'*') 
AS job_centered FROM emp;

SELECT 'ab' || 'cd' || 'fe' FROM dual;

SELECT empno || ' : ' || ename FROM emp;



SELECT '    ab c   ', trim('    ab c   ')FROM dual;


-- round
SELECT  
	round(14.46), -- 하나만 입력하면 소수점 첫자리 반올림	
	round(14.46, 1),-- 소수점 두번쨰 자리에서 반올림
	round(14.46, -1) -- 양의 자리 첫번째 자리에서 반올림
FROM dual;

SELECT 
	trunc(14.46),
	trunc(14.46, 1),
	trunc(14.46, -1),
	trunc(-14.46)
FROM dual;

SELECT 
	CEIL(3.14),
	floor(3.14),
	ceil(-3.14),
	floor(-3.14),
	trunc(-3.14)
	FROM dual;
	

SELECT 7 / 3 FROM dual;
SELECT 7 / 0 FROM dual;

SELECT mod(7, 3) FROM dual;
SELECT mod(9.3, 3.3) FROM dual;

SELECT sysdate FROM dual;


SELECT empno, empno + '1000' FROM emp;


SELECT empno, empno + 'abcd' FROM emp;


SELECT 'a'+'b' FROM dual;

SELECT 'a' || 'b' FROM dual;

SELECT 123 || 123 FROM dual;
SELECT 123 + 123 FROM dual;

SELECT TO_char(sysdate, 'yyyy-mm-dd hh-mi-ss') AS "현재 시간" FROM dual;


SELECT to_char(hiredate, 'yyyy"년"mm"월"dd"일"') FROM emp;

SELECT to_date('2025-05-15', 'yyyy-mm-dd') - to_date('1995-12-01', 'yyyy-mm-dd') FROM dual;


SELECT * FROM emp;

SELECT * FROM emp
WHERE hiredate > TO_date('1981-06-01', 'yyyy-mm-dd');

SELECT 
	nvl (comm, -1) ,
	sal * 12 + comm ,
	sal * 12 + nvl (comm, 0)
FROM emp;

-- 각사원 연봉 출력
-- 월급(sal) * 12 + comm 
-- 이름과(ename), total_pay 출력
 
SELECT 
	ename, 
	sal * 12 + nvl(comm, 0) 
		AS total_pay
FROM emp;

SELECT empno, ename, job, sal,
	decode(job,
		'MANGER', sal*1.1,
		'SALESMAN', sal*1.05,
		'ANALYST', sal,
		sal * 1.03) AS upsal
	FROM emp;



SELECT ename, job, sal,
	CASE job
		WHEN 'MANAGER' THEN sal*1.1
		WHEN 'SALESMAN' THEN sal*1.05
		WHEN 'ANALYST' THEN sal
		ELSE sal*1.03
	eND AS upsal
	FROM emp;

SELECT comm,
	decode(comm,
		NULL, -1,
		comm) AS decode
	FROM emp;

SELECT comm,
	CASE 
	WHEN comm IS null THEN '해당 없음'
	WHEN comm = 0 THEN '0원'
	WHEN comm > 0 THEN '수당 : ' || comm
	END  AS "case"
	FROM emp;


SELECT comm,
	CASE 
	WHEN comm IS not null 
		THEN '수당 : ' || comm
	ELSE '해당없음'
	END  AS "case"
	FROM emp;


-- 문제 1
-- 사원이름 5글자 이상 6글자 미만
-- MASKING_EMPNO 열에는 사원번호 2자리 외 별포로 표시
-- 마스킹 이네임은 사원의 첫글자만 표시나머지 별표
SELECT  
	empno,
	rpad(substr(empno, 1,2), 4, '*') AS MASKING_EMPNO,
	ename,
	rpad(substr(ename, 1,1),5, '*') AS MASKING_ENAME
FROM emp
WHERE LENGTH(ename) >= 5 and LENGTH(ename) < 6; 

-- 문제2
-- 월평균이 21.5일 일을 한다.
-- 하루는 8시간 일을 한다.
-- 일급으로 따지면 얼마인가? 소수점 3자리에서 버리고 DAY_PAY
-- 시급은 얼마인가? 소수점 2자리에서 반올림
SELECT 
	empno,ename,sal,
	trunc(sal / 21.5, 2) AS DAY_PAY,
	round((sal / 21.5)/8, 1) AS TIME_PAY
	FROM emp;
	
-- 문제3
-- 표처럼 나오게 해주세요
-- mgr 직속상관이 null일때는 0000이 나오게
-- mgr 앞자리 2개에 따라 뒤에는 표처럼 나오게
-- mgr 그외에는 그대로 나오게 표시

-- V1
SELECT empno, ename, mgr,
	 CASE
	 	WHEN mgr IS NULL THEN '0000' 
	 	WHEN mgr LIKE '75__' THEN '5555'
	 	WHEN mgr LIKE '76__' THEN '6666'
	 	WHEN mgr LIKE '77__' THEN '7777'
	 	WHEN mgr LIKE '78__' THEN '8888'
	 	ELSE to_char(mgr)
	 END AS CHG_MGR
FROM emp;

-- V2
SELECT empno, ename, mgr,
	 CASE
	 	WHEN mgr IS NULL THEN '0000'
	 	WHEN substr(mgr ,1,2) = '75'  THEN '5555'
	 	WHEN substr(mgr ,1,2) = '76' THEN '6666'
	 	WHEN substr(mgr ,1,2) = '77' THEN '7777'
	 	WHEN substr(mgr ,1,2) = '78' THEN '8888'
	 	ELSE to_char(mgr) -- '' || mgr
	 END AS CHG_MGR
FROM emp;

-- V3
SELECT empno, ename, mgr,
	CASE 
		WHEN mgr IS NULL THEN '0000'
		WHEN mgr IS NOT NULL 
		THEN 
	 		CASE substr(mgr ,1,2)
	 			WHEN '75' THEN '5555'
	 			WHEN '76' THEN '6666'
			ELSE to_char(MGR)
	 		END
	END AS CHG_MGR
FROM emp;

-- V4

SELECT empno, ename, mgr,
	 CASE
	 	WHEN substr(mgr ,1,2) = '75'  THEN '5555'
	 	WHEN substr(mgr ,1,2) = '76' THEN '6666'
	 	WHEN substr(mgr ,1,2) = '77' THEN '7777'
	 	WHEN substr(mgr ,1,2) = '78' THEN '8888'
	 	ELSE to_char( nvl(mgr, '0000')) -- '' || mgr
	 END AS CHG_MGR
FROM emp;


 -- V5
SELECT 
	CASE 
		WHEN mgr IS NULL THEN '0000'
		WHEN substr(mgr, 2,1) IN ( '5','6','7','8' )
		THEN lpad( substr(mgr,2,1), 4,substr(mgr,2,1))
		ELSE ' ' || mgr
	END 
	FROM emp;


SELECT sum(sal) FROM emp;

SELECT sum(comm) FROM EMP;
SELECT count(comm) FROM emp;
SELECT count(sal) FROM emp;

SELECT count(*), sum(SAL) FROM emp;

SELECT count(sal), count(comm) FROM emp;

SELECT max(sal), min(sal), sum(sal), avg(sal) FROM emp;
SELECT min(hiredate), min(comm) FROM emp;

SELECT count(ename) FROM emp
WHERE ename LIKE '%A%';

SELECT ename FROM emp
WHERE ename LIKE '%L%';

SELECT count(ename) FROM emp
WHERE ename LIKE '%L%';

SELECT trunc(avg(sal),2) FROM emp;

-- 다중행 함수, (집계 함수)
-- where에서 사용 할 수 없다. 


SELECT avg(sal), deptno
FROM emp
GROUP BY deptno;



SELECT deptno, sum(sal), count(*), max(sal), min(sal)
FROM emp
GROUP BY deptno;

SELECT job FROM emp
GROUP BY job;


SELECT deptno, job, count(*), 
FROM EMP
GROUP BY deptno, job;

SELECT deptno, job, count(*), ename
FROM EMP
GROUP BY deptno, job, ename;


SELECT job 
FROM EMP
WHERE deptno = 10
GROUP BY job
ORDER BY JOB desc;


SELECT job, deptno
FROM emp
GROUP BY deptno, JOB 
	HAVING deptno = 10;


SELECT job, deptno, avg(sal)
FROM emp
GROUP BY deptno, JOB 
	HAVING deptno = 10;

SELECT job, deptno, avg(sal)
FROM emp
GROUP BY deptno, JOB 
	HAVING avg(sal) > 2000;

SELECT job, count(*) as cnt
FROM emp
WHERE sal >= 1000
GROUP BY JOB 
HAVING count(*) >= 3 
ORDER BY cnt DESC;



SELECT * FROM dept;

SELECT * FROM EMP, DEPT
ORDER BY empno;


SELECT * FROM EMP e , DEPT d
WHERE e.deptno = d.deptno
ORDER BY empno;

--SELECT  deptno가 어떤 테이블인지 헷갈려 에러발생  -> deptno, ename
--FROM EMP e , DEPT d
--WHERE e.deptno = d.deptno;

SELECT e.deptno, ename
FROM EMP e , DEPT d
WHERE e.deptno = d.deptno;

SELECT * 
	FROM  emp
	WHERE ename = 'SMITH';



SELECT s.grade , e.ename , e.sal
	FROM salgrade s , EMP e 
	WHERE e.sal BETWEEN s.losal AND s.HISAL 
	AND e.ename = 'SMITH';

SELECT * FROM salgrade;

SELECT * FROM emp;


SELECT e1.empno,e1.ename,e1.mgr,
	e.empno AS MGR_empno, e.ename AS MGR_ENAME
 FROM emp e1, emp e
 WHERE e1.mgr = e.empno;
-- 총 13개 나옴 king이 mgr이 null이라서


SELECT count(*)
 FROM emp e1, emp e
 WHERE e1.mgr = e.empno;

-- 오라클 전용 널값 나오게 하는 버젼

SELECT e1.empno,e1.ename,e1.mgr,
	e.empno AS MGR_empno, e.ename AS MGR_ENAME
 FROM emp e1, emp e
 WHERE e1.mgr = e.empno(+);

-- (+) 기준의 반대편 left,right 조인이 된다.

SELECT e1.empno,e1.ename,e1.mgr,
	e.empno AS MGR_empno, e.ename AS MGR_ENAME
 FROM emp e1, emp e
 WHERE e1.mgr(+) = e.empno;

-- => 좌우로 움직이는 거보다는  한쪽으로 정의해서 보기 좋은쪽으로 정리한다.

SELECT e.ename,d.loc, deptno
FROM emp e join DEPT d using(deptno)
WHERE sal >=3000;


SELECT e.ename,d.loc, d.deptno
FROM emp e join DEPT d on(e.deptno = d.deptno)
WHERE sal <=3000;


SELECT *
FROM emp e1 JOIN emp e2 on(e1.mgr = e2.empno);

SELECT *
FROM emp e1 LEFT OUTER JOIN emp e2 ON (e1.mgr = e2.empno);

SELECT *
FROM emp e1 RIGHT OUTER JOIN emp e2 ON (e1.mgr = e2.empno);

SELECT *
FROM emp e1 FULL OUTER JOIN emp e2 ON (e1.mgr = e2.empno )
Order BY e1.ename;

--q1, 급여가 2000를 초과한 사원의 부서 정보(dept) 사원 정보(emp)를 출력
SELECT d.deptno, d.dname, e.empno, e.ename, e.sal 
FROM dept d JOIN emp e ON (e.deptno = d.deptno )
WHERE e.sal > 2000
ORDER BY d.DEPTNO  , dname  ;

SELECT * FROM dept;
SELECT * FROM emp;

--q2, 부서별 평균굽여ㅡ 최대 급여 , 최소 급여 , 사원 수를 출력
SELECT d.deptno,d.dname, 
floor(avg(e.sal)) as AVG_sal, max(e.sal) as MAX_SAL, 
min(e.sal) as MIN_sal, count(*)
FROM dept d JOIN emp e ON(e.deptno = d.deptno )
GROUP BY d.deptno,d.dname
ORDER BY d.deptno;

--q3, 부서에서 모든 부서정보와 사원 정보를 다음과 같이 출력 
-- 부서 번호 -> 사원 이름수느 40부서도 포함.
SELECT d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
FROM dept d LEFT OUTER JOIN emp e on (e.deptno = d.deptno)
ORDER BY d.deptno, e.ename;


-- q4, 40부서를 살리고 직송 상관 정보까지 나오게 해서 출력 salgrade
-- v1
SELECT d.deptno,d.dname, 
e.empno,e.ENAME ,e.mgr,e.sal,e.deptno, 
s.losal,s.hisal,s.grade,
e2.empno AS MGR_empno,
e2.ename AS MGR_ename  
FROM emp e left OUTER JOIN emp e2 ON (e.mgr = e2.empno )
LEFT OUTER JOIN SALGRADE s ON (e.sal BETWEEN losal AND hisal)
right OUTER JOIN dept d on (e.deptno = d.deptno)
ORDER BY d.deptno, e.empno;
-- v2
SELECT d.deptno,d.dname, 
e.empno,e.ENAME ,e.mgr,e.sal,e.deptno, 
s.losal,s.hisal,s.grade,
e2.empno AS MGR_empno,
e2.ename AS MGR_ename
FROM dept  d
	LEFT OUTER JOIN emp e ON (d.deptno = e.deptno)
	left OUTER JOIN salgrade s ON (e.sal >= s.losal 
						AND e.sal <= s.hisal)
	LEFT OUTER JOIN emp e2 ON (e.mgr = e2.empno)
ORDER BY d.deptno, e.empno;
SELECT * FROM SALGRADE;

 
-- q
-- 각 부서별로 급여가 
-- 가장 높은 사원 , 가장 낮은 사원의 급여 차이 부서번호를 가지오니라
SELECT  deptno, max(sal),min(sal), max(sal) - min(sal) AS salcap
FROM emp
GROUP BY deptno;

SELECT *
FROM emp
WHERE sal > (SELECT SAL 
			FROM EMP
			WHERE ename = 'JONES');

SELECT *
FROM emp
WHERE hiredate < (SELECT hiredate
			FROM emp
			WHERE ename = 'SCOTT');



-- emp 평균 월급보다 이상받는 사람 출력

SELECT *
FROM emp
WHERE sal > (SELECT avg(sal)
			FROM emp); 

SELECT deptno,ename, sal
FROM emp
WHERE sal in (SELECT max(sal)
	FROM emp
	GROUP BY deptno);


SELECT * 
FROM  (SELECT * FROM emp WHERE deptno = 10) e10,
	dept d
WHERE e10.deptno = d.deptno;;

-- 직책별 3명이상인 것만 부하시오

SELECT job, count(*) CNT
FROM EMP
GROUP BY job HAVING count(job) >= 3;

SELECT *
from(
	SELECT job, count(*) cnt
	FROM EMP
	GROUP BY job
)
WHERE cnt >= 3;



-- 
SELECT *
from(
SELECT rownum rn, emp.*
FROM emp
)
WHERE rn > 3 AND rn < 6;

SELECT rownum rn, emp.*
FROM emp
order BY sal DESC;

SELECT rownum,e1.*
from(
SELECT *
FROM emp
order BY sal DESC
) e1;

SELECT rn,ename
from(
	SELECT rownum rn,e1.*
	from(
		SELECT *
		FROM emp
		order BY sal DESC
		) e1
	)
WHERE rn IN (2,3);

WITH  e10 AS (
	SELECT * FROM emp WHERE deptno = 10
)
SELECT ename FROM e10;

SELECT empno, ename, job, sal,
	(SELECT grade
	FROM SALGRADE
	WHERE e.sal BETWEEN losal AND hisal) AS salgrade,
	deptno,
	(SELECT dname
	FROM dept
	WHERE e.deptno = dept.deptno) AS dname	
FROM emp e;


-- q1
-- 전체 사원중 ALLEN과 같은 직종의 사람들을 출력
-- 사원 정보와 부서 정보


SELECT e.job, e.empno, e.ename,e.SAL, d.deptno, d.dname 
FROM emp e , dept d
WHERE job = (SELECT job 
		FROM emp
		WHERE ename = 'ALLEN') AND e.deptno = d.deptno
ORDER BY ename ;


-- q2
-- 전체 사원중 평균보다 더 많이 받는 사람들을 출력
SELECT e.empno, e.ename,d.deptno, e.hiredate, d.loc ,e.sal ,
	(SELECT grade
	FROM SALGRADE
	WHERE e.sal BETWEEN losal AND hisal) AS grade
FROM
	(SELECT *
	FROM emp
	WHERE sal > (SELECT avg(sal)
			FROM emp)) e
	,dept d
WHERE e.deptno = d.deptno
ORDER BY sal DESC, empno;

--q3
-- 10번 부서에 근무하는 사원중 30번 부서에 없는 직책을 가진 사람을 출력
-- 

SELECT *
FROM (SELECT *
	FROM emp
	WHERE deptno in (10,30)) 
WHERE job NOT IN (SELECT job FROM emp WHERE deptno = 30 GROUP BY JOB );
 -- AND (SELECT job FROM emp WHERE deptno = 30);



	
	
-- q4
-- 직책이 세일즈맨의 최고 급여보다 많이 받는 사원의 사원 정보 출력
SELECT empno,ename,sal,
	(SELECT grade
	FROM SALGRADE
	WHERE e.sal BETWEEN losal AND hisal) AS grade
FROM emp e
WHERE 
 e.sal > (SELECT max(sal) FROM emp WHERE job = 'SALESMAN') ;


/*
문제
1. 커미션이 null인 사원을 급여 오름차순으로 정렬,

2. 급여 등급 별 사원 수를 등급 오름차순으로 정렬,
단, 모든 등급을 표시한다
salgrade
3. 이름, 급여, 급여 등급, 부서이름 조회,
단, 급여 등급 3 이상만 조회. 급여 등급 내림차순, 급여 등급이 같은 경우 급여 내림 차순

4. 부서명이 SALES인 사원 중 급여 등급이 2 또는 3인 사원을 급여 내림차순으로 정렬
*/
-- q1
SELECT * FROM emp 
WHERE comm IS NULL
ORDER BY sal ;

-- q2
SELECT s.grade, count(*)  FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
GROUP BY GRADE rade
ORDER BY grade;

-- q3 
SELECT s.ename, s.sal, s.grade, d.dname 
FROM 
(SELECT *  FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal) s,
dept d
WHERE d.deptno = s.deptno and
	s.grade >=3
ORDER BY s.grade DESC, s.sal desc;  

-- q4

SELECT s.* FROM 
(SELECT *  FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal) s,
(SELECT * FROM emp e, dept d WHERE e.deptno = d.deptno and d.dname = 'SALES') d
WHERE 
s.grade in(2,3) AND s.empno = d.empno
ORDER BY s.sal desc;
SELECT * FROM dept; 


-------------------------------------------------

CREATE TABLE EMP_DDL(
	empno number(4),
	ename varchar2(2),
	job varchar2(10),
	mgr number(4),
	hiredate DATE,
	sal NUMBER(7,2),
	comm NUMBER(7,2),
	deptno number(2)
);


SELECT * from EMP_DDL;

CREATE TABLE DEPT_DDL
	AS SELECT * FROM dept;

SELECT * FROM dept_ddl;

CREATE TABLE EMP_DDL_30
	AS SELECT * FROM emp
	WHERE deptno = 30;

SELECT * FROM emp_ddl_30;



CREATE TABLE empdept_ddl
	AS SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate,
	e.sal, e.comm, d.deptno, d.dname, d.loc	
	FROM emp e, dept d
	WHERE 1<>1;

SELECT * FROM empdept_ddl;

--------------------------------------



CREATE TABLE emp_alter
AS SELECT * FROM emp;

SELECT * FROM emp_alter;

ALTER TABLE emp_alter
	ADD hp varchar2(20);

SELECT * FROM emp_alter;

ALTER TABLE emp_alter
	add age2 NUMBER (3) DEFAULT 1;

ALTER TABLE emp_alter
	RENAME COLUMN hp TO tel;

ALTER TABLE emp_alter
	RENAME COLUMN age2 TO age;


SELECT * FROM emp_alter;

ALTER TABLE emp_alter
	DROP COLUMN age;

ALTER TABLE emp_alter
	MODIFY empno number(5);
-- 수정할 때 는 타입의 크기가 커지는거는 가능, 하지만
-- 줄어드는건 불가능 하다.
ALTER TABLE emp_alter
	MODIFY empno number(4);


SELECT * FROM emp_alter;

ALTER TABLE EMP_ALTER 
	DROP COLUMN hiredate;



RENAME emp_alter TO emp_rename;

SELECT * FROM emp_rename;

TRUNCATE table emp_rename;


DROP TABLE emp_rename;


CREATE TABLE dept_temp
	AS SELECT * FROM dept;


INSERT INTO dept_temp (deptno, dname,loc)
	VALUES (50, 'DATABASE', 'SEOUL');


INSERT INTO dept_temp
	VALUES (60, 'NETWORK', 'BUSAN');
	

INSERT INTO dept_temp
VALUES (80, 'MOBILE' , '');

INSERT INTO dept_temp (deptno, loc)
VALUES (90, 'INCHEON');

SELECT * FROM dept_temp;


CREATE TABLE emp_temp
	AS SELECT *
		FROM emp
		WHERE 1<>1;


INSERT INTO emp_temp (empno, ename, hiredate)
VALUES (2111, '이순신', to_date('2025-05-21', 'yyyy-mm-dd') );


INSERT INTO emp_temp (empno, ename, hiredate)
VALUES (2222, '심청이', sysdate);

SELECT * FROM emp_temp;

INSERT INTO emp_temp
SELECT * FROM emp WHERE deptno = 10;

CREATE TABLE dept_temp2
AS SELECT * FROM dept;

SELECT * FROM dept_temp2;


UPDATE dept_temp2
SET loc = 'SEOUL';

UPDATE dept_temp2
SET dname = 'DATEBASES'
	,loc = 'SEOUL2'
WHERE deptno = 40;

CREATE TABLE emp_tmp
AS SELECT * FROM emp;


-- 연봉이 천미만만 조회 
SELECT sal, sal * 1.03 FROM emp_tmp
WHERE sal <1000;

UPDATE emp_tmp
SET sal = sal * 1.03
WHERE sal < 1000;

SELECT * FROM  emp_tmp;

CREATE TABLE emp_temp2
AS SELECT * FROM emp;

COMMIT; 
SELECT * FROM emp_temp2;
DROP TABLE emp_temp2;

DELETE emp_temp2;

ROLLBACK;


DELETE emp_temp2
WHERE deptno = 10;


