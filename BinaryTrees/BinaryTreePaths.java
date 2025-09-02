package BinaryTrees;
import java.util.List;
import java.util.ArrayList;
class BinaryTreePaths {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root,list,"");
        return list;
    }

    public void dfs(TreeNode root,List<String> list,String path){
        if(root == null) return;

        if(path.isEmpty()){
            path = "" + root.val;
        }else{
            path += "->" + root.val;
        }

        //leaf node
        if(root.left == null && root.right == null){
            list.add(path);
            return;
        }

        dfs(root.left,list,path);
        dfs(root.right,list,path);
    }
}