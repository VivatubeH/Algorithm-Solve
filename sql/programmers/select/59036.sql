-- 문제: 아픈 동물 찾기
-- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59036
-- 핵심: 조건 검색은 WHERE, ORDER BY로 아이디 순 조회
-- 참고: 문자열 비교는 보통 = 과 작음따옴표('')를 사용한다.
-- 참고: MySQL에서는 식별자(테이블명, 컬럼명)를 필요할 때 백틱(``)으로 감싼다. (오라클은 ""를 쓰는 경우가 많다.)
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID;