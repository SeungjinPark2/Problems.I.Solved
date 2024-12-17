package book.dynamic.programming.floyd;

public class Solution {
    public int[][] floyd(int n, int [][] wGraph) {
        int [][] dGraph = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(wGraph[i], 0, dGraph[i], 0, n);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dGraph[i][j] = Math.min(dGraph[i][j], dGraph[i][k] + dGraph[k][j]);
                }
            }
        }

        return dGraph;
    }
}
