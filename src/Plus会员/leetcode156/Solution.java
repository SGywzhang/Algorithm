package Plus会员.leetcode156;

import commonClass.TreeNode;

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode newNode = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newNode;
    }

    public static void main(String[] args) {
        // 构造原始树
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3)
        );

        Solution sol = new Solution();
        TreeNode newRoot = sol.upsideDownBinaryTree(root);
        // 打印新树结构（前序遍历）
        printTree(newRoot);
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
