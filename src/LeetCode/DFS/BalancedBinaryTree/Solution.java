package LeetCode.DFS.BalancedBinaryTree;

import LeetCode.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftSide = isBalanced(root.left, 1);
        int rightSide = isBalanced(root.right, 1);

        if (leftSide < 0 || rightSide < 0) return false;
        else {
            return Math.abs(leftSide - rightSide) < 2;
        }
    }

    public int isBalanced(TreeNode root, int depth) {
        if (root == null) return depth - 1;

        int leftMaxDepth = isBalanced(root.left, depth + 1);
        int rightMaxDepth = isBalanced(root.right, depth + 1);

        if (leftMaxDepth < 0 || rightMaxDepth < 0) return -1;
        if (Math.abs(leftMaxDepth - rightMaxDepth) > 1) {
            return -1;
        } else {
            return Math.max(leftMaxDepth, rightMaxDepth);
        }
    }
}
