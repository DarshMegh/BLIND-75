import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {

        String value = queue.poll();

        if (value.equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }
}