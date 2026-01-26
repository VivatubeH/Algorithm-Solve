# 📂 [Algo] 백준 10816 - 숫자 카드 2

> 날짜: 2026-01-26 | 난이도: Silver 4

### 1. 핵심 아이디어 💡
* **알고리즘**: 이분 탐색
* **핵심 발상**: 시간 복잡도를 어떻게 줄일지?
* - **선형 탐색** : O(N * M) - 시간 초과 
* - **이분 탐색** : O(N logN) + O(M * 2 *log N) - 정렬 + 이분탐색, 시간 내에 가능

### 2. 코드 리뷰 & 로직 ⭐
* **주의점**: N개의 수가 중복이 있을 수 있어서, **단순히 찾는 게 끝이 아닌 개수 찾기**
* - 이분 탐색으로 최대 1개의 데이터만 있도록 하기 위해 Map을 활용할 수 있다.

### 3. 트러블슈팅 & 배운 점 🚩
- map에 빈도를 저장해두고, 풀 수도 있지만 lowerBound, upperBound 활용도 가능.
- 이 코드에서는 lowerBound = 등장하는 첫 위치, uppprBound = 등장하는 마지막 위치로 했다.

#### **반 열린 구간** 
- lowerBound : 해당 수의 **이상인 수가 등장하는 첫 위치**
- upperBound : 해당 수를 **초과하는 수가 등장하는 첫 위치**
- `[Lower, Upper)` (Lower는 포함, Upper는 미포함) 사용
- `길이(개수) = Uppper - lower`이 된다.
- **값이 있을 때** : upperBound - lowerBound가 개수가 된다.
- **값이 없을 때** : upperBound == lowerBound가 되어서 0이 된다.

#### while (left < right), right = size 이해하기
- 숫자가 아닌, **숫자 사이의 칸막이를 찾는다**
- `[1, 2, 3, 4, 5]`를 `| 1 | 2 | 3 | 4 | 5 |`로 생각해본다.
- 배열의 끝은 **size-1**이지만, 칸막이는 **size**까지 존재한다.
- `left < right`는 **두 칸막이 사이에 숫자가 하나라도 있는지?** 체크
- 칸막이의 사이는 **숫자가 들어갈 수 있는 공간**으로 본다.

#### Lower Bound
```java
public static int lowerBound(List<Integer> list, int target) {
    int left = 0; // 가장 왼쪽 칸막이
    int right = list.size(); // 가장 오른쪽 칸막이

    while (left < right) { // 두 칸막이 사이에 숫자가 있다면 계속 반복
        int mid = (left + right) / 2;

        // 중앙 숫자가 target보다 크거나 같으면?
        // -> 적어도 mid번째 칸막이 혹은 그 왼쪽이 우리가 찾는 시작점이 된다.
        if (list.get(mid) >= target) { // mid번째 칸막이 뒤의 숫자가 target보다 크면
            right = mid; // 오른쪽 칸막이를 mid로 당긴다.
        } 
        // 중앙 숫자가 target보다 작다면?
        // -> mid번째 칸막이와 그 왼쪽은 절대 답이 될 수 없다.
        else {
            left = mid + 1; // 왼쪽 칸막이를 mid 다음으로 밀어낸다.
        }
    }
    // left와 right가 만나는 지점 = target 이상의 값이 시작되는 '최초의 칸막이'
    return left; 
}
```

#### Upper Bound
```java
public static int upperBound(List<Integer> list, int target) {
    int left = 0; // 가장 왼쪽 칸막이
    int right = list.size(); // 가장 오른쪽 칸막이

    while (left < right) { // 두 칸막이 사이에 숫자가 있는 동안 반복
        int mid = (left + right) / 2;

        // 중앙 숫자가 타겟보다 크면?
        // -> 적어도 mid번째 칸막이 혹은 그 이전이 초과 지점의 시작이다.
        if (list.get(mid) > target) {
            right = mid; // 오른쪽 칸막이를 mid로 당긴다.
        } 
        // 중앙 숫자가 타켓보다 작다면?
        // -> mid번째 칸막이와 그 왼쪽이 절대 답이 될 수 없다.
        else {
            left = mid + 1;
        }
    }
    // left와 right가 만나는 지점 = target 이상의 값이 시작되는 '최적의 칸막이'
    return left;
}
```