package leetcode.none.category.addtwonumbers;

import java.math.BigInteger;
import java.util.ArrayList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 함수1: 리스트 -> 숫자
        // 함수2: 숫자 -> 리스트
        // l1 l2 를 파싱하여 숫자를 얻고 이를 더한 값을 리스트로 변경해주어야 한다.

        BigInteger num1 = parseList(l1);
        BigInteger num2 = parseList(l2);

        BigInteger sum = num1.add(num2);

        return convertIntToList(sum);
    }

    public static BigInteger parseList(ListNode ln) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode ptr = ln;
        while (ptr != null) {
            arr.add(ptr.val);
            ptr = ptr.next;
        }
        BigInteger number = BigInteger.ZERO;
        BigInteger ten = BigInteger.TEN;
        for (int i = arr.size() - 1; i >= 0; i--) {
            number = number.multiply(ten).add(BigInteger.valueOf(arr.get(i)));
        }
        return number;
    }

    public static ListNode convertIntToList(BigInteger n) {
        // 숫자에서 1의 자릿수부터 n 자릿수를 얻는 방법.
        // 1의 자리 숫자 - n % 10, 그 다음 숫자 (n / 10) % 10
        // n / 10 > 0 인 조건에서만 진행한다.
        // 리스트의 마지막 요소는 next 를 초기화 하지 않는 요소가 되어야 한다.
        BigInteger ten = new BigInteger("10");

        // Initialize the head of the list
        ListNode head = new ListNode();
        ListNode ptr = head;

        // Processing each digit
        do {
            int digit = n.mod(ten).intValue();
            n = n.divide(ten);
            ptr.val = digit;
            if (n.compareTo(BigInteger.ZERO) > 0) {
                ptr.next = new ListNode();
                ptr = ptr.next;
            }
        } while (n.compareTo(BigInteger.ZERO) > 0);

        return head;
    }
}
