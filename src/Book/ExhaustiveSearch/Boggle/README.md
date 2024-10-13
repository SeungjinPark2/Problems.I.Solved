# Book.ExhaustiveSearch.Boggle game
## 도서 알고리즘 문제해결 전략 p.150
보글게임 문제 \
다음과 같이 5 x 5 배열이 주어졌을 때 상하좌우 / 대각선으로 인접한 칸들의 글자들을 이어서 단어를 찾아낸다.
각 글자들은 대각선으로도 이어질 수 있으며 한 글자가 두 번이상 사용될 수도 있다.

예)

```
u r l p m
x p r e t
g i a e t
x t n z y
x o q r s

문제의 배열이 위같이 주어졌을 때 prettym girl repeat 는 다음과 같이 존재한다.

* * * * *
* p r * t
* * * e t
* * * * y
* * * * *

* * l * *
* * r * *
g i * * *
* * * * *
* * * * *
```

## 문제 풀이 방법
재귀함수를 이용한 완전탐색을 통해 문제를 해결해 본다(이는 최선의 방법은 아니지만 해당 챕터가 다루는 내용이므로 따른다).

## 답안과 비교
내가 작성한 답안과 책의 답안을 비교했을 때 기능보다 가독성 측면에서 차이가 난다는 것을 확인할 수 있었다.
내가 잘 못했던 부분을 체크해 보았다.

1. 단축시킬 수 있던 반복문 - 답안의 direction 과 내가 만든 이중 반복문
2. 기저사례 명시
```java
// 나의 답안
public static void blahblah(...) {
    if (idx >= 0) {
        // 재귀함수의 메인 로직이 이곳에 들어있다.
        ...
    }
}

// 정답안
public static void blahblah(...) {
    if (기저사례1) return false;
    if (기저사례2) return false;
    // 재귀함수의 메인 로직
}
```
둘을 놓고 비교해 보면, 기저사례를 중심으로 쳐낼 case 를 쳐내고 로직을 적는것이 더 깔끔함을 볼 수 있다. 따라서 앞으로 재귀함수를 작성할 때 기저사례를 잘 가져가는 것이 좋겠다는 생각이 든다.

3. 본래의 word 를 수정하면서 나아가지 말고 복사본을 넘겨라.

내가 작성한 답을 보면 word 를 Stringbuilder 로 굳이 바꾸어서 이것의 수정이 불가피하게 이루어지면 되돌리는 수정작업도 들어간다. 문제마다 다를 수 있겠지만 이 문제에서는 substring 을 넘김으로써 간단하게 해결하고 있다.