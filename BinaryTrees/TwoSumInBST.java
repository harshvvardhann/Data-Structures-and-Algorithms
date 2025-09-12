package BinaryTrees;
import java.util.HashSet;
class TwoSumInBST {
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
    HashSet<Integer> seen = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root,k);
    }

    public boolean dfs(TreeNode root,int k){
        if(root == null) return false;

        if(seen.contains(k-root.val)) return true;

        seen.add(root.val);

        return dfs(root.left,k) || dfs(root.right,k);
    }
}