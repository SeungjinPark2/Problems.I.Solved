package book.none.category.rotatearray;

import java.util.Arrays;

public class Solution {
    public static void solution(int[][] arr, int n) {
        assert arr.length <= 10;
        assert arr.length == arr[0].length;
        assert n > 0 && n < 5;

        int [][] result = new int[arr.length][arr[0].length];

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    result[i][j] = arr[arr[i].length - 1 - j][i];
                }
            }
        }

        System.out.println(Arrays.deepToString(result));
    }
}
