package Boggle;

import java.util.ArrayList;

public class Solution {
    public static class Position {
        int y;
        int x;

        public Position(int y, int x) {
           this.x = x;
           this.y = y;
        }
    }

    public static void findWord(char[][] matrix, String word) {
        StringBuilder remainedWords = new StringBuilder(word);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println();
                System.out.println("trial " + (matrix.length * i + j));
                System.out.println();
                boolean found = findWordRecursively(matrix, remainedWords, new Position(i, j));
                if (found) {
                    System.out.println("found answer!");
                    return;
                } else {
                    System.out.println("not found answer, move to next trial...");
                }
            }
        }
    }

    public static boolean findWordRecursively(char[][] matrix, StringBuilder remainedWords, Position pos) {
        char target = matrix[pos.y][pos.x];
        int idx = remainedWords.indexOf(String.valueOf(target));

        if (remainedWords.isEmpty()) {
            return true;
        }

        if (idx >= 0) {
            remainedWords.deleteCharAt(idx);
            System.out.println("(" + pos.x + "," + pos.y + ") " + target);
            for (int y = Math.max(pos.y - 1, 0); y <= Math.min(pos.y + 1, matrix.length - 1); y++) {
               for (int x = Math.max(pos.x - 1, 0); x <= Math.min(pos.x + 1, matrix.length - 1); x++) {
                   if (x == pos.x && y == pos.y) {
                       continue;
                   }
                   if (findWordRecursively(matrix, remainedWords, new Position(y, x))) {
                       return true;
                   }
               }
            }

            remainedWords.append(target);
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                new char[]{'u', 'r', 'l', 'p', 'm'},
                new char[]{'x', 'p', 'r', 'e', 't'},
                new char[]{'g', 'i', 'a', 'e', 't'},
                new char[]{'x', 't', 'n', 'z', 'y'},
                new char[]{'x', 'o', 'q', 'r', 's'},
        };

        findWord(matrix, "pretty");
        findWord(matrix, "girl");
        findWord(matrix, "repeat");
    }
}
