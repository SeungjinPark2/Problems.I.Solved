package LeetCode.NonCategory.AddTwoNumbers;

import java.math.BigInteger;

public class TestAddTwoNumbers {
    public static void main(String[] args) {

        BigInteger num1 = new BigInteger("9");
        BigInteger num2 = new BigInteger("9999999991");

        ListNode l1 = AddTwoNumbers.convertIntToList(num1);
        ListNode l2 = AddTwoNumbers.convertIntToList(num2);

        // test convert, parse
        System.out.println(AddTwoNumbers.parseList(l1));
        System.out.println(AddTwoNumbers.parseList(l2));

        // test LeetCode.NonCategory.AddTwoNumbers
        ListNode answer = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(AddTwoNumbers.parseList(answer));
    }
}
