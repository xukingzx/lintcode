package lintcode.binarytree;

/**
 * Created by ouakira on 2017/6/1.
 */
public class Main {
    public static void main(String[] args) {

    }

    public static TreeNode cloneTree(TreeNode root) {
        // Write your code here
        if (root != null) {
            TreeNode tree = new TreeNode(root.val);
            if (root.left != null) {
                tree.left = cloneTree(root.left);
            }
            if (root.right != null) {
                tree.right = cloneTree(root.right);
            }
            return tree;
        }
        return null;
    }
}
