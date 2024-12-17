package leetcode.bfs.symmetrictree;

import leetcode.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode[] nodes = {
                root.left,
                root.right
        };

        do {
            TreeNode[] tempNodes;
            int nullCount = 0;

            for (int i = 0, j = nodes.length - 1; i < nodes.length / 2; i++, j--) {
                if ((nodes[i] == null) ^ (nodes[j] == null)) return false;
                if (nodes[i] == null) nullCount += 2;
                else {
                    if (nodes[i].val != nodes[j].val) return false;
                }
            }

            if (nodes.length == nullCount) break;
            tempNodes = new TreeNode[(nodes.length - nullCount) * 2];

            int idx = 0;
            for (TreeNode node : nodes) {
                if (node == null) continue;
                tempNodes[idx++] = node.left;
                tempNodes[idx++] = node.right;
            }

            nodes = tempNodes;
        } while (true);

        return true;
    }
}
