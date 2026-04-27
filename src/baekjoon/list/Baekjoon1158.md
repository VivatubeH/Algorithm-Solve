# BOJ_1158_요세푸스문제

**알고리즘:** LinkedList (원형 처리)  
**시간 복잡도:** O(N*K)  
**난이도:** Silver 4

## 핵심
- 원형 배열 구현: K-1명을 뒤로 옮기고 K번째 제거
- LinkedList 사용: `removeFirst()`, `addLast()` O(1)
- 인덱스 계산 없이 물리적 이동으로 해결

## 주의
- 출력 형식: `<1, 2, 3>` (마지막 쉼표 없음)
- BufferedWriter 사용 (N=5000일 때 시간초과 방지)
- `list.isEmpty()` 체크 필수

## 코드

## 실수
- 처음엔 `list.remove(K-1)`로 인덱스 삭제 시도 → 복잡
- 출력 시 마지막 쉼표 처리 `if (i == N - 1) continue;`

## 피드백
- LinkedList 물리적 이동 방식이 인덱스 계산보다 직관적
- 하지만 인덱스 방식으로도 가능.

## 인덱스 방식 풀이

### 핵심 아이디어
```
원형 배열에서 인덱스 계산:
idx = (idx + K - 1) % list.size()
```

### 코드
```java
LinkedList<Integer> list = new LinkedList<>();
List<Integer> yosepus = new ArrayList<>();

for (int i = 1; i <= N; i++) list.add(i);

int idx = 0;
while (!list.isEmpty()) {
    idx = (idx + K - 1) % list.size();
    yosepus.add(list.remove(idx));
    // idx는 유지 (remove 후 자동으로 다음 위치)
}
```

## 인덱스 계산 원리

### (idx + K - 1) % size 이해
```
현재 idx=2, K=3, size=5

1. idx + K = 2 + 3 = 5 (3번 이동)
2. -1 = 5 - 1 = 4 (현재 위치 제외)
3. % size = 4 % 5 = 4 (원형 처리)

[0, 1, 2, 3, 4]
     ^     ^
   현재  3번째
```

### 왜 -1을 하나?
```
idx=0, K=1일 때
- idx + K = 0 + 1 = 1 (잘못: 다음 사람)
- idx + K - 1 = 0 (올바름: 현재 사람)
```

### remove 후 idx 유지 이유
```
[1, 2, 3, 4, 5]에서 idx=2 (숫자 3) 제거
→ [1, 2, 4, 5]
→ idx=2는 이제 숫자 4를 가리킴
→ 자동으로 다음 위치가 됨
```
