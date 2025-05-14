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
