package book.optimization.clock.sync;

public class BestPractice {
    int INF = Integer.MAX_VALUE - 1000, SWITCHES = 10, CLOCKS = 16;
    char[][] linked = {
            // x 와 . 으로 연결성을 표현함.
    };

    boolean areAligned (int[] clocks) {
        for (int i = 0; i < CLOCKS; i++)
            if (clocks[i] != 0) return false;
        return true;
    }

    void push(int[] clocks, int swtch) {
        for (int i = 0; i < CLOCKS; i++) {
            if (linked[swtch][i] == 'x') {
                clocks[i] += 3;
                if (clocks[i] == 15) clocks[i] = 3;
            }
        }
    }

    int solve(int[] clocks, int swtch) {
        if (swtch == SWITCHES) return areAligned(clocks) ? 0 : INF;
        int ret = INF;

        for (int cnt = 0; cnt < 4; ++cnt) {
            ret = Math.min(ret, cnt + solve(clocks, swtch + 1));
            push(clocks, swtch);
        }

        return ret;
    }
}
