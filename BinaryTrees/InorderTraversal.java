package BinaryTrees;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
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
    // using recursion
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

    //using iteration(stack)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode current = root;
        while(current!=null || !st.isEmpty()){
            while(current!=null){
                st.push(current);
                current = current.left;
            }

            current = st.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}