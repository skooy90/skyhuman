SELECT	* FROM emp
ORDER BY sal DESC;

SELECT * FROM emp
ORDER BY deptno ASC, sal DESC;

-- deptno asc, sal desc; 이 상황에서 연봉이 같으면 사우ㅝㄴ 번호 내림차순 정렬

SELECT * FROM emp
ORDER BY DEPTNO ASC, sal DESC, EMPNO DESC;

-- 주석달기 

