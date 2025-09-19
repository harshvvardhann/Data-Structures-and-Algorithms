package BinaryTrees;
class KthSmallestElementInBST {
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
    int count = 0;
    int value = -1;
    public int kthSmallest(TreeNode root, int k) {
        getInorderTree(root,k);
        return value;
    }

    public void getInorderTree(TreeNode root,int k){
        if(root == null) return;

        getInorderTree(root.left,k);
        count ++;
        if(count == k){
            value = root.val;
            return;
        }
        getInorderTree(root.right,k);
    }
}