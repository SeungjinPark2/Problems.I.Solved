package leetcode.none.category.myatoi;

public class TestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("123"));
        System.out.println(s.myAtoi("0-1"));
        System.out.println(s.myAtoi("+-1"));
        System.out.println(s.myAtoi("1a23"));
        System.out.println(s.myAtoi("-0013"));
        System.out.println(s.myAtoi("2147483647"));
        System.out.println(s.myAtoi("2147483657"));
        System.out.println(s.myAtoi("2147483648"));
        System.out.println(s.myAtoi("-21474836482"));
        System.out.println(s.myAtoi("   0 -0000214748a3648"));
        System.out.println(s.myAtoi("-2147483660"));
    }
}
