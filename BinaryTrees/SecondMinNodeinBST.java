package BinaryTrees;

class SecondMinNodeinBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    long MAX = Long.MAX_VALUE;
    long SECOND_MAX = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        findSecminValue(root);
        return SECOND_MAX == Long.MAX_VALUE ? -1 : (int)SECOND_MAX; 
    }

    public void findSecminValue(TreeNode root){
        if(root == null) return;

        if(root.val<MAX) {
            SECOND_MAX = MAX;
            MAX = root.val;
        }else if(root.val>MAX && root.val<SECOND_MAX){
            SECOND_MAX = root.val;
        }

        findSecminValue(root.left);
        findSecminValue(root.right);
    }
}