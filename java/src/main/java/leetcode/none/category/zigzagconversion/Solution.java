package leetcode.none.category.zigzagconversion;

public class Solution {
    public String convert(String s, int numRows) {
        /*
        a b c d e f g 를 받아 zigzag pattern 으로 표현
        rows = 1 이라면 인풋과 동일
        rows = 2 라면 a c e g 이므로 a c e g b d f 를 반환함
                     b d f
                  0 1 2 3 4 5 6
        rows = 3, a   e   i               이며 답은 a e b d f c g
                  b d f h j
                  c   g   k

                  0 1 2 3 4 5 6 7 8 9 10 ...
               4, a     g     "
                  b   f h   " "
                  c e   i k   "
                  d     j     "

                  0 1 2 3 4 5 6 7 8 9 10 11
               5, a       i       "
                  b     h j     " "
                  c   g   k   "   "
                  d f     l "     "
                  e       m       "

            순차적으로 Column 을 채워나감.
            분기점 = 0 + middle + 1.
            분기점이 아닌 column 은 middle 번째 요소만 값을 넣고 나머지는 빈 문자로 할당.
            이 때 middle 값은 1 씩 감소.
        */
        StringBuilder[] strings = new StringBuilder[numRows];
        StringBuilder answer = new StringBuilder();
        int pos = 0; // s 의 n 번째 요소를 얻기 위한 변수.

        // init matrix
        for (int i = 0; i < numRows; i++) {
            strings[i] = new StringBuilder();
        }

        for (int i = 0; pos < s.length(); i++) {
            for (int j = 0; j < numRows; j++) {
                if (numRows == 1 || i % (numRows - 1) == 0) {
                    // column 채우기
                    strings[j].append(s.charAt(pos++));
                } else {
                    // column 채우기
                    if (numRows - (i % (numRows - 1) + 1) == j) {
                        strings[j].append(s.charAt(pos++));
                    }
                }
                if (pos >= s.length()) break;
            }
        }

        for (StringBuilder sb : strings) {
            answer.append(sb);
        }

        return answer.toString();
    }
}
