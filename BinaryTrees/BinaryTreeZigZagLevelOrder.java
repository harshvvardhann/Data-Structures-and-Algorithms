package BinaryTrees;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
class BinaryTreeZigZagLevelOrder {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int key) {
            val = key;
            left = null;
            right = null;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> ls = new LinkedList<>();

            for(int i=0;i<size;i++){
                TreeNode current = queue.poll();

                if(leftToRight) {
                    ls.addLast(current.val);
                }else{
                    ls.addFirst(current.val);
                }

                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
            list.add(ls);
            leftToRight = !leftToRight;
        }
        
        return list;
    }
}