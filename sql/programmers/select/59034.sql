-- 문제: 모든 레코드 조회하기
-- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59034
-- 핵심: 테이블의 모든 컬럼을 출력해야 하므로 *을 쓰고, ANIMAL_ID 기준 정렬을 위해 ORDER BY를 쓴다.
SELECT *
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
