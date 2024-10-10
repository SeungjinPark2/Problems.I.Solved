package MyAtoi;

public class Solution {
    public int myAtoi(String s) {
        // 1. 앞에 온 공백 제거
        // 2. + 또는 - 가 붙을 수 있음
        // 3. digit 이 아닌 문자를 받으면 종료
        // 4. leading 0 는 생략, 0을 받다 끝나면 0을 리턴
        // 5. int 를 벗어나는 값이면 int 의 최대, 최소 값으로 변경해서 리턴

        int answer = 0;
        String ss = s.trim();
        String digits = "0123456789";
        boolean isMinus = false;
        boolean digitStarted = false;

        for (int i = 0; i < ss.length(); i++) {
            char c = ss.charAt(i);

            if (digits.contains(String.valueOf(c))) {
                int digit = Integer.parseInt(String.valueOf(c));
                int MAX_DIGIT = isMinus ? Integer.MAX_VALUE % 10 + 1 : Integer.MAX_VALUE % 10;

                // rounding 처리. 1의 자리수를 제외한 자리를 비교한다. 그 후 1의 자리를 비교한다. 이 때 음수냐 아니냐에 따라 1 차이가 갈린다.
                if ((answer > Integer.MAX_VALUE / 10)
                        || (answer == Integer.MAX_VALUE / 10 && digit >= MAX_DIGIT)
                ) {
                    answer = isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    break;
                }
                answer = answer * 10 + digit;
                if (!digitStarted) digitStarted = true;
            } else if (c == '+' || c == '-') {
                if (digitStarted) {
                    break;
                }
                if (c == '-') isMinus = true;
                digitStarted = true;
            } else {
                break;
            }
        }

        return isMinus ? answer * -1 : answer;
    }
}
