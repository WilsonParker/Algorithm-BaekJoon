네 개의 소수
---

date : 2022-03-30   
url : https://www.acmicpc.net/problem/1153   
difficulty : Gold 4   
status : success

문제
---

임의의 자연수가 주어지면, 이를 네 개의 소수의 합으로 분해하는 프로그램을 작성하시오. 예를 들어 38 = 5 + 7 + 13 + 13이 된다.

입력
---
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
---
첫째 줄에 네 개의 소수를 빈 칸을 사이에 두고 순서대로 출력한다. 불가능한 경우는 -1을 출력한다.

예제
--

### 1)
- input
```
38
```

- output
```
5 7 13 13
```

풀이
---

```
N 까지의 자연수 중 소수를 구하고 (에라토스테네스의 체)
골드바흐의 추측을 사용하여 4개의 소수의 합이 N 인 경우를 출력
```