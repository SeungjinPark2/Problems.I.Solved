package RegularExpressionMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean answer = true;
        int idxOfS = 0, idxOfP = 0;

        while (idxOfS < s.length() && idxOfP < p.length() && answer) {
            char pattern = p.charAt(idxOfP++);
            char target = s.charAt(idxOfS++);

            if (pattern == '.') {
                // do nothing
            } else if (pattern == '*') {
                char previous = p.charAt(idxOfS - 2); // * 패턴 앞에는 무조건 valid 한 char 가 온다고 문제에 명시되어 있음.

                //while (idxOfS < s.length()) {
                //    target = s.charAt(idxOfS);
                //    answer = target == pattern;
                //}
            } else { // 일반 알파벳인 경우
                answer = target == pattern;
            }
        }

        answer = answer && (idxOfS == s.length()); // 패턴 p 가 s 를 다 커버하지 못한 케이스

        return answer;
    }
}
