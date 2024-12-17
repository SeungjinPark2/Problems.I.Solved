# 알고리즘 문제 풀이 모음 & 정리

## 개요

코딩문제 풀이 코드를 1회용으로 버리기에는 아깝다는 생각이 들었다. \
어쨌거나 내 손으로 세상에 나온 코드이므로.. 깃허브에 저장하는 편이 좋겠다는 생각이 들어서 만든 프로젝트이다.

- 사용된 언어: `JAVA`, `GO`
- 사용된 IDE: `Intellij`
- 문제 출처
  - [leetcode](https://leetcode.com/problemset/)
  - 도서 "프로그래밍 대회에서 배우는 알고리즘 문제해결 전략"
  - 광운대학교의 자랑이신 김용혁 교수님의 강의자료

## 형식

프로젝트 구조

```
.
├── java/
│   ├── book/
│   │   ├── divide.and.conquer/
│   │   │   └── mergesort/
│   │   │       ├── Solution.java
│   │   │       ├── README.md
│   │   │       └── BestPractice.java
│   │   ├── none.category/
│   │   │   └── ...
│   │   └── ...
│   └── leetcode/
│       ├── dfs/
│       │   └── balancedbinarytree/
│       │       └── ...
│       ├── bfs/
│       │   └── ...
│       └── none.category/
└── go/

```

1. depth1: 사용하는 언어별로 구분했다. 여러 언어를 연습하기에 좋은 프로젝트여서 다양하게 시도한다.
2. depth2: 문제의 출처 별로 구분했다. 즉 책이나 강의자료 또는 leetcode 에 따라 구분.
3. depth3: 문제의 부류에 따라 구분했다. dfs, bfs 등 최대한 분류해보고 잘 모르겠는 부류는 none.category 에 분류한다.
4. depth4: 문제에 대한 설명 `README.md`, 스스로 작성한 답안 `Solution.java`, 문제의 답안 `BestPractice.java`
   - `Solution.java` 를 고치지 않는 이유는 스스로 작성한 답안과 실제 답안을 효율적으로 구분하기 위함.
   - `README.md` 나 `BestPractice.java` 파일은 optional 하다.
