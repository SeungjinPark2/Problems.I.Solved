package leetcode.dynamic.programming.regularexpressionmatching;

public class TestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();

        //System.out.println(s.isMatch("aa", "a") + " should be false");
        //System.out.println(s.isMatch("aa", "aa") + " should be true");
        //System.out.println(s.isMatch("aa", ".a") + " should be true");
        //System.out.println(s.isMatch("aa", ".b") + " should be false");
        System.out.println(s.isMatch("aaa", "a*a") + " should be true");
        System.out.println(s.isMatch("aaa", ".*") + " should be true");
        System.out.println(s.isMatch("aaz", ".*") + " should be true");
        System.out.println(s.isMatch("aaab", ".*.") + " should be true");
        System.out.println(s.isMatch("aabc", "a*b.") + " should be true");
        System.out.println(s.isMatch("aab", "c*a*b") + " should be true");
        System.out.println(s.isMatch("aab", ".*c") + " should be true");
    }
}
