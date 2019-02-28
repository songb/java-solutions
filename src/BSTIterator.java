import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack= new Stack<>();

    public BSTIterator(TreeNode root) {
        if(root!=null) {
            stack.push(root);
            addLeft(root);
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        TreeNode r = current.right;
        if(r!=null){
            stack.push(r);
            addLeft(r);
        }
        return current.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    private void addLeft(TreeNode n){
        while(n.left!=null){
            n=n.left;
            stack.push(n);
        }
    }
}
