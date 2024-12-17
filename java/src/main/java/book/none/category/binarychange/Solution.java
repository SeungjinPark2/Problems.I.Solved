package book.none.category.binarychange;

import java.util.Arrays;

public class Solution {
    public int[] solution(String s) {
        // 이진 변환 횟수와 제거된 0 개수 출력
        int changeCount = 0;
        int zeroCount = 0;

        while (s.length() != 1) {
            changeCount++;
            int zeros = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeros++;
                }
            }
            s = Integer.toBinaryString(s.length() - zeros);
            zeroCount += zeros;
        }

        return new int[]{zeroCount, changeCount};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution("110010101001")));
        System.out.println(Arrays.toString(s.solution("01110")));
        System.out.println(Arrays.toString(s.solution("1111111")));
    }
}
