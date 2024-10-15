package Book.Optimization.ClockSync;

public class Solution {
    public static int[][] switches = {
            { 0,1,2 },
            { 3,7,9,11 },
            { 4,10,14,15 },
            { 0,4,5,6,7 },
            { 6,7,8,10,12 },
            { 0,2,14,15 },
            { 3,14,15 },
            { 4,5,7,14,15 },
            { 1,2,3,4,5 },
            { 3,4,5,9,13 },
    };
    static int total = Integer.MAX_VALUE;

    public boolean count(int[] clocks, int num, int numSwitchPushedFromPrevSteps) {
        if (num == switches.length) {
            if (checkAnswer(clocks)) {
                total = Math.min(total, numSwitchPushedFromPrevSteps);
                return true;
            } else {
                return false;
            }
        }

        int numSwitchPushed = 0;

        for (int i = 0; i < 4; i++) {
            // 하위 경우 탐색
            if(count(clocks, num + 1, numSwitchPushedFromPrevSteps + numSwitchPushed)) {
                return true;
            }
            tick(clocks, num);
            numSwitchPushed++;
        }

        return false;
    }
    
    public void tick(int[] clocks, int num) {
        for (int i = 0; i < switches[num].length; i++) {
            int currentTick = clocks[switches[num][i]];
            clocks[switches[num][i]] = (currentTick + 1) % 4;
        }
    }
    
    public boolean checkAnswer(int[] clocks) {
        boolean ans = true;
        for (int clock : clocks) {
            if (clock != 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] clocks1 = {
                0,0,0,3,
                3,3,0,0,
                0,3,0,0,
                0,3,0,0
        };
        int[] clocks2 = {
                0,2,2,2,
                2,2,0,0,
                0,0,0,0,
                0,0,0,0
        };
        int[] clocks3 = {
                0,3,1,0,
                2,2,3,1,
                0,3,0,3,
                0,0,2,2
        };
        new Solution().count(clocks1, 0, 0);
        System.out.println(Solution.total);
        Solution.total = Integer.MAX_VALUE;

        new Solution().count(clocks2, 0, 0);
        System.out.println(Solution.total);
        Solution.total = Integer.MAX_VALUE;

        new Solution().count(clocks3, 0, 0);
        System.out.println(Solution.total);
    }
}
