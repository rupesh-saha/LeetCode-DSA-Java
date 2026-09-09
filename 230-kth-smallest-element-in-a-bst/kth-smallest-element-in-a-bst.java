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
    int[] result;
    int idx = 0;

    public int kthSmallest(TreeNode root, int k) {
        int size = getSize(root);
        result = new int[size];

        inOrder(root);

        return result[k-1];
    }

    public void inOrder(TreeNode root){
        if (root == null) return;

        inOrder(root.left);

        result[idx] = root.val;
        idx++;

        inOrder(root.right);
    }

    public int getSize(TreeNode root){
        if (root == null) return 0;

        return 1 + getSize(root.left) + getSize(root.right);
    }
}