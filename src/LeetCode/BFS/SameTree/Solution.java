package LeetCode.BFS.SameTree;

import LeetCode.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null) ^ (q == null)) return false;
        if (p == null) return true; // 위에서 p q 는 다른 진리값을 같은 경우를 배제했으므로 p == null 이라면 자동적으로 q == null

        boolean leftSubtree = isSameTree(p.left, q.left);
        boolean rightSubtree = isSameTree(p.right, q.right);
        boolean isValueSame = p.val == q.val;

        return leftSubtree && rightSubtree && isValueSame;
    }
}
