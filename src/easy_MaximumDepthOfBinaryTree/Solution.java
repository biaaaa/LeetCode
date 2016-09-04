package easy_MaximumDepthOfBinaryTree;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node 
 * down to the farthest leaf node.
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
    	if (root==null){
    	    return 0;
    	}
        return depth(root);
    }
    
    public int depth(TreeNode node){
    	int leftD = node.left == null? 0 : depth(node.left);
    	int rightD = node.right == null? 0 : depth(node.right);
    	int d = leftD>rightD? leftD : rightD;
        return d+1;
    }
}