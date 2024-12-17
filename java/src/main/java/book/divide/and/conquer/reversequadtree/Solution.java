package book.divide.and.conquer.reversequadtree;

public class Solution {
    int MAX_TOKENS = 4;

    String reverse(String tree) {
        //4분면을 어떻게 나누지?
        if (tree.length() == 1) return tree;

        String[] tokens = decompress(tree); // ["b", "b", "w", "w"]

        return "x" + reverse(tokens[2]) + reverse(tokens[3]) + reverse(tokens[0]) + reverse(tokens[1]);
    }

    // 4개로 반환
    // "xbwxwbbwb"
    String[] decompress(String tree) {
        String[] ret = new String[MAX_TOKENS];
        int cnt = 0;

        // 넘겨받은 tree 가 x 로 시작하는 것은 관심 없으므로 i = 1 부터 시작한다.
        for (int i = 1; i <= MAX_TOKENS; i++) {
            if (tree.charAt(i) == 'b' || tree.charAt(i) == 'w') {
                ret[cnt++] = String.valueOf(tree.charAt(i));
            } else { // x
                String[] acc = decompress(tree.substring(i));
                ret[cnt] = "x" + String.join("", acc);
                cnt += acc.length;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse("xbwwb"));
        System.out.println(s.reverse("xbwxwbbwb"));
    }
}
