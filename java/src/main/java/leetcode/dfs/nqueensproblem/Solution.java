package leetcode.dfs.nqueensproblem;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> board = new ArrayList<>();
    int size;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        solveNQueensRecursively(new int[n], 0);
        return board;
    }

    void solveNQueensRecursively(int[] c, int index) {
        if (index == size) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    if (j == c[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                answer.add(sb.toString());
            }

            board.add(answer);
            return;
        }

        for (int i = 0; i < size; i++) {
            // board 에 queen 을 놓는게 적절하다면
            c[index] = i;

            if (check(c, index + 1)) {
                solveNQueensRecursively(c, index + 1);
            }
        }
    }

    boolean check(int[] c, int index) {
        boolean flag = true;

        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                // 같은 줄 또는 대각선인 경우
                if (c[j] == c[i] || Math.abs(c[j] - c[i]) == j - i) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solveNQueens(1));
    }
}
