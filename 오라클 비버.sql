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

SELECT Lpad(rpad(job , LENGTH(job)+5, '*') ,LENGTH(job)+10,'*') FROM emp;

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













