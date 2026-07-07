import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorder {

    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right)
            return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = build(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = build(preorder, inorderMap.get(rootValue) + 1, right);

        return root;
    }
}