package leetcode.none.category.longestpalindromicsubstring;

public class TestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("babab"));
        System.out.println(s.longestPalindrome("zxbbqwerstsrewbzxc"));
        System.out.println(s.longestPalindrome("a"));
        System.out.println(s.longestPalindrome("aa"));
        System.out.println(s.longestPalindrome("abba"));
        System.out.println(s.longestPalindrome("aaaa"));
    }
}
