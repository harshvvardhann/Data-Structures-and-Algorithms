package BinaryTrees;

class InsertIntoBST {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertNode(root,val);
    }

    public TreeNode insertNode(TreeNode root,int val){
        if(root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        else if(root.val<val){
            root.right = insertNode(root.right,val);
        }else if(root.val>val){
            root.left = insertNode(root.left,val);
        }

        return root;
    }
}