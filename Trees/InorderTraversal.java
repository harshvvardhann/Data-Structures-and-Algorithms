package Trees;
import java.util.List;
import java.util.ArrayList;
class InorderTraversal {
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
    public List<Integer> getInorderTraversal(TreeNode root,List<Integer> list) {
        if(root == null) return list;
        getInorderTraversal(root.left,list);
        list.add(root.val);
        getInorderTraversal(root.right,list);

        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = getInorderTraversal(root,list);
        return list;
    }
}