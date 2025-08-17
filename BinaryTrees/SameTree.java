package BinaryTrees;

class SameTree {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        if(p.val!=q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}