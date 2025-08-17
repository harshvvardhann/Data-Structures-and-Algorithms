package BinaryTrees;

class PathSum {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int key){
            val = key;
            left = null;
            right = null;
        }
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return targetSum == root.val;

        boolean leftPathSum = hasPathSum(root.left,targetSum - root.val);
        boolean rightPathSum = hasPathSum(root.right,targetSum - root.val);

        return leftPathSum | rightPathSum;
    }
}