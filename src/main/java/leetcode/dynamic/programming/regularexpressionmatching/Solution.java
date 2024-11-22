package leetcode.dynamic.programming.regularexpressionmatching;

public class Solution {
    static char lastUsed;
    // 문제를 조각내서 해결한다.
    // 조각: 아직 검사되지 않은 문자를 검사한다.
    public boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' || p.charAt(i) == '.') continue;
                else return false;
            }
            return true;
        }

        if (p.isEmpty()) return false;

        char token = s.charAt(0), pattern = p.charAt(0);
        int deltaS = 1, deltaP = 1;

        if (token == pattern || pattern == '.') {
            lastUsed = pattern;
        } else if (pattern == '*') {
            if (p.length() > 1 && p.charAt(1) == token) deltaP++;
            else deltaP--;
            if (lastUsed == '.' || lastUsed == token) deltaS--;
        } else {
            // 패턴이 일치하지 않은 경우에도 뒤에 한칸까지 확인하고 넘김.
            if (p.length() > 1 && p.charAt(1) == '*') {
                deltaS--;
                deltaP++;
            } else return false;
        }

        return isMatch(
                s.substring(deltaS),
                p.substring(deltaP)
        );
    }
}
