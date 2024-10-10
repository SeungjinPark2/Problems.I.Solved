package Boggle;

// 책의 답안을 정리
public class BestPractice {
    private static final int[] dx = new int[]{-1, -1, -1,  1, 1, 1,  0, 0};
    private static final int[] dy = new int[]{-1,  0,  1, -1, 0, 1, -1, 1};
    public char[][] board;

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public boolean hasWord(int y, int x, String word) {
        // 기저 사례1: 시작 위치가 범위 밖이면 무조건 실패
        if(!inRange(y, x)) return false;
        // 기저 사례2: 첫 글자가 일치하지 않으면 실패
        if(board[y][x] != word.charAt(0)) return false;
        // 기저 사례3: 단어 길이가 1이면 성공
        if(word.length() == 1) return true;

        for (int direction = 0; direction < 8; ++direction) {
            int nextY = y + dy[direction], nextX = x + dx[direction];
            if(hasWord(nextY, nextX, word.substring(1))) {
                return true;
            }
        }

        return false;
    }

    private boolean inRange(int y, int x) {
        return y < board.length && x < board[y].length;
    }

    public static void main(String[] args) {
        BestPractice solution = new BestPractice();

        char[][] board = new char[][]{
                new char[]{'u', 'r', 'l', 'p', 'm'},
                new char[]{'x', 'p', 'r', 'e', 't'},
                new char[]{'g', 'i', 'a', 'e', 't'},
                new char[]{'x', 't', 'n', 'z', 'y'},
                new char[]{'x', 'o', 'q', 'r', 's'}
        };

        solution.setBoard(board);
        //solution.hasWord(0, 0, "pretty");
        //solution.hasWord(0, 0, "pretty");
    }
}
