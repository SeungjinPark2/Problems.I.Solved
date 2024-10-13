package Book.ExhaustiveSearch.Picnic;

public class BestPractice {
    public int n;
    public boolean[][] areFriends = new boolean[10][10];

    public int countParings(boolean[] taken) {
        int firstFree = -1;
        for (int i = 0; i < n; ++i) {
            if(!taken[i]) {
                firstFree = i;
                break;
            }
        }

        if (firstFree == -1) return 1;
        int ret = 0;
        for (int pairWith = firstFree + 1; pairWith < n; ++pairWith) {
            if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
                taken[firstFree] = taken[pairWith] = true;
                ret += countParings(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        BestPractice b = new BestPractice();
        b.n = 4;
        b.areFriends[0][1] = true;
        b.areFriends[0][2] = true;
        b.areFriends[0][3] = true;
        b.areFriends[1][2] = true;
        b.areFriends[1][3] = true;
        b.areFriends[2][3] = true;

        System.out.println(b.countParings(new boolean[]{false, false, false, false}));
    }
}
