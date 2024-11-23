package book.dynamic.programming.floyd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void testFloyd() {
        int n = 5;
        int INF = Integer.MAX_VALUE / 2;
        int[][] graph = new int[][] {
                {0, 1, INF, 1, 5},
                {9, 0, 3, 2, INF},
                {INF, INF, 0, 4, INF},
                {INF, INF, 2, 0, 3},
                {3, INF, INF, INF, 0}
        };

        Solution s = new Solution();
        int[][] answer = s.floyd(n, graph);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }

        int[][] expected = new int[][]{
                {0, 1, 3, 1, 4},
                {8, 0, 3, 2, 5},
                {10, 11, 0, 4, 7},
                {6, 7, 2, 0, 3},
                {3, 4, 6, 4, 0 }
        };

        for (int i = 0; i < n; i++) {
            assertArrayEquals(expected[i], answer[i]);
        }
    }
}