package LeetCode.NonCategory.ReverseInteger;

public class Solution {
    public int reverse(int x) {
        int answer = 0;
        int _x = x;
        int MAXIMUM = x > 0 ? Integer.MAX_VALUE : Math.abs(Integer.MIN_VALUE + 1);
        while (_x != 0) {
            int __x = _x / 10;
            int digit = _x - __x * 10;

            if (Math.abs(answer) > MAXIMUM / 10) {
                return 0;
            } else if (Math.abs(answer) == MAXIMUM / 10) {
                if (digit > MAXIMUM % 10) return 0;
            }

            answer = answer * 10 + digit;
            _x = __x;
        }

        return answer;
    }

}
