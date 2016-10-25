package easy_BinaryTreeDepth;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        } else if (root.left == null) {
            return maxDepth(root.right);
        } else if (root.right == null) {
            return maxDepth(root.left);
        } else {
            return maxDepth(root.left) > maxDepth(root.right) ? maxDepth(root.left) + 1 : maxDepth(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(4);
        TreeNode node10 = new TreeNode(4);
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(4);
        TreeNode node13 = new TreeNode(4);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(4);
        TreeNode node16 = new TreeNode(4);
        TreeNode node17 = new TreeNode(4);
        TreeNode node18 = new TreeNode(4);
        TreeNode node19 = new TreeNode(4);
        TreeNode node20 = new TreeNode(4);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(4);
        TreeNode node23 = new TreeNode(4);
        TreeNode node24 = new TreeNode(4);
        TreeNode node25 = new TreeNode(4);
        TreeNode node26 = new TreeNode(4);
        TreeNode node27 = new TreeNode(4);
        TreeNode node28 = new TreeNode(4);
        TreeNode node29 = new TreeNode(4);
        TreeNode node30 = new TreeNode(4);
        TreeNode node31 = new TreeNode(4);
        TreeNode node32 = new TreeNode(4);
        TreeNode node33 = new TreeNode(4);
        TreeNode node34 = new TreeNode(4);
        TreeNode node35 = new TreeNode(4);
        TreeNode node36 = new TreeNode(4);
        TreeNode node37 = new TreeNode(4);
        TreeNode node38 = new TreeNode(4);
        TreeNode node39 = new TreeNode(4);
        TreeNode node40 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node3.right = node8;
        node4.left = node9;
        node4.right = node10;
        node5.left = node11;
        node5.right = node12;
        node6.left = node13;
        node6.right = node14;
        node7.left = node15;
        node7.right = node16;
        node8.left = node17;
        node8.right = node18;
        node9.left = node19;
        node9.right = node20;
        node10.left = node21;
        node10.right = node22;
        node11.left = node23;
        node11.right = node24;
        node12.left = node25;
        node12.right = node26;
        node13.left = node27;
        node13.right = node28;
        node14.left = node29;
        node14.right = node30;
        node15.left = node31;
        node15.right = node32;
        node16.left = node33;
        node16.right = node34;
        node17.left = node35;
        node17.right = node36;
        node18.left = node37;
        node18.right = node38;
        node19.left = node39;
        node19.right = node40;
//		for(int i =21 ; i<40;i++){
//			System.out.println("TreeNode node"+i+"=new TreeNode(4);");
//		}
        for (int i = 2; i < 20; i++) {
            System.out.println("node" + i + ".left=node" + (i * 2 + 1) + "; node" + i + ".right=node" + (i * 2 + 2) + ";");
        }
        System.out.println(s.maxDepth(root));
    }
}
