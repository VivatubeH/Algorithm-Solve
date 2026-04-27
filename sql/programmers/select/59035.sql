-- 문제: 역순 정렬하기
-- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59035
-- 핵심: 특정 컬럼만 조회하려면 원하는 순서대로 명시, 내림차순 정렬은 DESC를 사용한다.
-- 참고: ASC는 기본값이라 생략 가능하다.
SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;