package book.exhaustive.search.boardcover;

// 책의 해설지
public class BestPractice {
    // 타일을 덮을 수 있는 방법을 상대좌표로 4가지 표현을 했음.. 천재인가
    final int[][][] coverType = {
            {{0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}}
    };

    // 타일을 덮거나 제거하는 함수
    public boolean set(int [][] board, int y, int x, int type, int delta) {
        boolean ok = true;

        for (int i = 0; i < 3; i++) {
            int ny = y + coverType[type][i][1];
            int nx = x + coverType[type][i][0];
            if (ny < 0 || ny > board.length || nx < 0 || nx > board[0].length) {
                ok = false;
            } else if ((board[ny][nx] += delta) > 1) {
                ok = false;
            }
        }

        return ok;
    }

    public int cover(int[][] board) {
        int y = -1, x = -1;
        // 처음으로 유효한 좌상단 타일을 찾는다.
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 0) {
                    y = i;
                    x = j;
                    break;
                }
            }
            if (y != -1) break;
        }

        // 기저사례: 모든 칸이 다 덮였다면 끝난 것이다.
        if (y == -1) return 1;
        int ret = 0;
        for (int type = 0; type < 4; ++type) {
            if (set(board, y, x, type, 1))
                ret += cover(board);
            set(board, y, x, type, -1);
        }

        return ret;
    }
}

