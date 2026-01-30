# 📂 [Algo] 백준 15831 - 준표의 조약돌

## 다시 풀만한 문제 

> 날짜: 2026-01-30 | 난이도: Gold 4

### 시간 복잡도
- O(2N) = O(N) : 문자열 길이만큼 투 포인터를 움직이면서 체크한다.

### 알고리즘
- 투 포인터 

### 핵심 발상
- **right는 계속 전진해야한다** ( 가능한 구간을 늘린다. )
- **조건 위배 시 left를 전진시킨다.** ( left는 조건에 의해 구간을 줄인다. )
- **조건 만족 시 최댓값을 갱신한다.**

### 핵심 조건
- **필수 조건** : `흰색 >= W` AND `검은색 <= B`
- **목표** : 위 조건을 만족하는 **가장 긴 구간 찾기**
- **구간의 길이** : `닫힌 구간 [a, b]의 길이 = b - a + 1`

### 코드 로직
1. right를 계속 증가시키면서 구간을 확장한다.
2. 검은색이 B개를 초과하면 left를 이동시키면서 검은색을 제거한다.
3. 흰색 >= W이고 검은색 <= B일 때 길이를 갱신한다.

### 개선 1: for문 사용
```java
// 기존 (잘못된 구조)
while (left <= right && right < N) {
    while (...) { right++; }
    while (...) { left++; }
}

// 개선 (명확한 구조)
for (int right = 0; right < N; right++) {
    // right는 무조건 전진
    while (...) { left++; }  // 필요할 때만 left 이동
}
```

**이유:**
- right는 **반드시 N-1까지 도달**해야 함 → for문이 적합
- left는 **조건에 따라 선택적으로 이동** → while문이 적합

### 개선 2: 길이 계산 수정
```java
// 기존
right - left  // ❌ 잘못됨 (right가 이미 증가한 상태)

// 개선
right - left + 1  // ✅ 올바름 (인덱스 기반 길이 계산)
```

**예시:**
```
인덱스: 0 1 2 3 4
left = 1, right = 3
실제 구간: [1, 2, 3] → 길이 3
계산: 3 - 1 + 1 = 3 ✅
```

### 트러블슈팅 & 배운점
1. 최초에 이중 while문을 사용하려고 했다.
```java
while (left <= right && right < N) {
    while (currentWhite < minWhite && right < N) {
        // right 증가
    }
    while (currentBlack > maxBlack && left <= right) {
        // left 증가
    }
}
```

**문제점**
- 외부 while문이 무한루프에 빠졌다. 
- 내부 while문 2개가 모두 조건을 만족하지 않을 때, left, right의 변경이 없었다.

2. 최댓값 갱신 시, white, black을 매번 체크했다. ( 비효율 )
```java
if (currentBlack <= maxBlack && currentWhite >= minWhite) {
    length = Math.max(length, right - left);
}
```

**문제점**
- 조건을 만족시마다 체크하는 건 맞지만, while 내에서 중복 체크가 발생했다.

#### 최종 코드 구조
```
for (right 증가) {
    while (조건 위배) {
        left 증가
    }
    if (조건 만족) {
        답 갱신
    }
}
```