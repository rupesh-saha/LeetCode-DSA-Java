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

    public int kthSmallest(TreeNode root, int k) {
        int size = getSize(root);
        int[] result = new int[size];
        int[] idx = new int[]{0};

        inOrder(root,result,idx);

        return result[k-1];
    }

    public void inOrder(TreeNode root,int[] result,int[] idx){
        if (root == null) return;

        inOrder(root.left,result,idx);

        result[idx[0]] = root.val;
        idx[0]++;

        inOrder(root.right,result,idx);
    }

    public int getSize(TreeNode root){
        if (root == null) return 0;

        return 1 + getSize(root.left) + getSize(root.right);
    }
}