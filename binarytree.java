import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    // Method to count non-leaf nodes using level order traversal
    public int countNonLeafNodes(Node root) {
        if (root == null) return 0;

        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Check if the current node is a non-leaf node
            if (current.left != null || current.right != null) {
                count++;
            }

            // Add child nodes to the queue for further processing
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return count;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Non-leaf node count: " + tree.countNonLeafNodes(root));
    }
}
