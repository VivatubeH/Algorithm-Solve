-- 문제: 어린 동물 찾기
-- 링크: https://school.programmers.co.kr/learn/courses/30/lessons/59037
-- 핵심: SQL에서 같다는 =로 쓰고, 다르다는 !=나 <>로 표현한다.
-- 참고: 표준 SQL에서는 <>를 사용하므로, 호환성을 생각하면 <>를 쓰는 편이 더 안전하다.
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID;