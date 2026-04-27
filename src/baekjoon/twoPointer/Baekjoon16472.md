# BOJ_16472_고냥이

**알고리즘:** 투 포인터  
**시간 복잡도:** O(L)  
**난이도:** Gold 4

## 핵심
- 알파벳 종류를 `int[] alphaCount`로 관리
- 추가 시 `count[c]++ == 0`이면 종류 증가
- 제거 시 `count[c]-- == 1`이면 종류 감소
- 길이 = `right - left + 1`

## 주의
- 인덱스 변환: `c - 'a'`
- 길이 계산에 `+1` 필수
- `currentCount`는 알파벳 "종류"
- `right - left`만 쓰면 길이가 반영 x, `right - left + 1`이 길이
- while 후 `if (currentCount <= maxCount)` 추가는 불필요

## 피드백
- 변수명 `maxCount` → `maxTypes`로 변경하는 것이 좋음.

## 투 포인터에서 left > right 불가능한 이유

## 간단 설명

**Q: left가 right를 넘어갈 수 있나?**

**A: 불가능. 3단계 논리:**

1. `left`는 while 안에서만 증가
2. `left = right`일 때 문자 1개
3. while 탈출이 보장됨 → `right++`로 다시 벌어짐

## 예시
```
right=5, left=5 (같아짐)
→ while 안 돌아감
→ right++ (6이 됨)
→ 다시 벌어짐
```

**결론: left는 right를 절대 추월 못함**