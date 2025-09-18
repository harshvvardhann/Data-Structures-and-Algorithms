package BinaryTrees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BTLevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int val = queue.size();

            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<val;i++){
                TreeNode node = queue.poll();
                ls.add(node.val);

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }

            list.add(ls);
        }

        return list;
    }
}