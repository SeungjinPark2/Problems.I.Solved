package LeetCode.ZigzagConversion;

public class TestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("helloworld", 1));
        System.out.println(s.convert("helloworld", 2));
        System.out.println(s.convert("PAYPALISHIRING", 3));
        System.out.println(s.convert("PAYPALISHIRING", 4));
        /*
        * h   o   l
        * e l w r d
        * l   o   t
        *
        * */
    }
}