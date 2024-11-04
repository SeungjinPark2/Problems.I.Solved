package LeetCode.NonCategory.LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 문자열의 처음부터 끝까지 읽어가면서 문자가 반복되지 않는 최소 문자열의 길이를 찾는다.
        // ex1) "abcabc" 답은 "abc"
        // ex2) "bbbbbb" 답은 "b"
        StringBuilder window = new StringBuilder();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int idx = window.indexOf(Character.toString(key));

            if (idx != -1) {
                answer = Math.max(answer, window.length());
                window.delete(0, idx + 1);
            }

            window.append(key);
        }

        return Math.max(answer, window.length());
    }
}
