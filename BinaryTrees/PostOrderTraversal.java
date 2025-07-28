package BinaryTrees;
import java.util.List;
import java.util.ArrayList;
class PostOrderTraversal {
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
    public List<Integer> getPostOrderTraversal(TreeNode root,List<Integer> list){
        if(root == null) return list;
        getPostOrderTraversal(root.left,list);
        getPostOrderTraversal(root.right,list);
        list.add(root.val);
        return list;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = getPostOrderTraversal(root,list);
        return list;
    }
}