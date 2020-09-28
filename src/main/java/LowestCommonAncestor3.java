
   class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
           this.left = this.right = null;
     }
  }
class ReturnType{
    public boolean a_exsit, b_exist;
    public TreeNode node;

    ReturnType(TreeNode node, boolean a, boolean b){
        a_exsit = a;
        b_exist = b;
        this.node = node;
    }
}

public class LowestCommonAncestor3 {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ReturnType res = helper(root, A, B);
        if(res.a_exsit && res.b_exist)
            return res.node;
        else
            return null;
    }

    private ReturnType helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null){
            return new ReturnType(null, false, false);
        }

        ReturnType left = helper(root.left, A, B);
        ReturnType right = helper(root.right, A, B);

        boolean a_exsit = left.a_exsit || right.a_exsit || root == A;
        boolean b_exist = left.b_exist || right.b_exist || root == B;

        if(root == A || root == B)
            return new ReturnType(root, a_exsit, b_exist);
        if(left.node != null && right.node != null){
            return new ReturnType(root, a_exsit, b_exist);
        }
        if(left.node != null){
            return new ReturnType(left.node, a_exsit, b_exist);
        }
        if(right.node != null){
            return new ReturnType(right.node, a_exsit, b_exist);
        }

        return new ReturnType(null, a_exsit, b_exist);
    }


}