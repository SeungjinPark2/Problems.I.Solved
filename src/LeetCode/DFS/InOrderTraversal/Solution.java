package LeetCode.DFS.InOrderTraversal;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        // 트리의 끝에 도달했을 때
        if (root == null) return ret;

        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));

        return ret;
    }
}
