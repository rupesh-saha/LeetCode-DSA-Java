/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    public static boolean helper( TreeNode leftnode, TreeNode rightnode ){
        if (leftnode == null && rightnode == null) {
            return true;
        }

        if (leftnode == null || rightnode == null) {
            return false;
        }

        boolean isSym = false;

        return (leftnode.val == rightnode.val) && helper(leftnode.left, rightnode.right) && helper(leftnode.right, rightnode.left);

    }
}