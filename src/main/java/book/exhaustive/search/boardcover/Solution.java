package book.exhaustive.search.boardcover;

// 결국 제대로 구현하지 못했음
public class Solution {
    // 시계 방향
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    public boolean[][] covered;
    public int w, h;

    public int canCover(int remainedTiles, int x, int y) {
        // 놓을 수 있는 타일 수가 3의 배수가 아닐때
        if (remainedTiles % 3 != 0 || h == 1 || w == 1) return 0;
        // 타일을 전부 놓았을 때
        if (remainedTiles == 0) return 1;
        // 남은 타일이 있는데 끝에 도달했을 때
        if (x == w - 1 && y == h - 1) return 0;

        int ret = 0;
        int nextX = x == w - 1 ? 0 : x + 1;
        int nextY = x == w - 1 ? y + 1 : 0;

        // 해당 좌표에 타일을 놓을 수 있을 때 돌려가며 시도한다.
        if (!covered[y][x]) {
            for (int i = 0; i < 4; i++) {
                int k = (i + 1) % 4;
                // rotate 해 가며 타일을 놓을 수 있는지 검사
                if (x + dx[i] >= 0 && x + dx[i] < w && y + dy[i] >= 0 && y + dy[i] < h
                    && x + dx[k] >= 0 && x + dx[k] < w && y + dy[k] >= 0 && y + dy[k] < h
                    && !covered[y + dy[i]][x + dx[i]] && !covered[y + dy[k]][x + dx[k]])
                {
                    covered[y + dy[i]][x + dx[i]] = covered[y + dy[k]][x + dx[k]] = true;
                    remainedTiles -= 3;
                    ret += canCover(remainedTiles, nextX, nextY);
                    covered[y + dy[i]][x + dx[i]] = covered[y + dy[k]][x + dx[k]] = false;
                    remainedTiles += 3;
                }
            }
        } else {
            // 해당 좌표에 놓을 수 없어도 연이어서 시도한다.
            ret += canCover(remainedTiles, nextX, nextY);
        }


        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.covered = new boolean[][] {
                new boolean[]{false, false, false},
                new boolean[]{false, false, false}
        };
        s.h = s.covered.length;
        s.w = s.covered[0].length;

        int answer = s.canCover(6, 0, 0);
        System.out.println(answer);
    }
}
