package BinaryTrees;

class DeleteNodeFromBST {
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
    public TreeNode manageNode(TreeNode node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val<key) root.right = deleteNode(root.right,key);
        else if(root.val>key) root.left = deleteNode(root.left,key);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode rootVal = manageNode(root.right);
            root.val = rootVal.val;
            root.right = deleteNode(root.right,rootVal.val);
        }
        return root;
    }
}
