public class E68_PrintOutBinaryTreePreOrderInOrderPostOrder {
    public static String preOrder(Node node) {
        return node != null ? node + preOrder(node.left) + preOrder(node.right) : "";
    }

    public static String inOrder(Node node) {
        return node != null ? inOrder(node.left) + node + inOrder(node.right) : "";
    }

    public static String postOrder(Node node) {
        return node != null ? postOrder(node.left) + postOrder(node.right) + node : "";
    }

    public static void main(String[] args) {
        Node node = createTree();
        System.out.println("preOrder = " + preOrder(node));
        System.out.println("inOrder = " + inOrder(node));
        System.out.println("postOrder = " + postOrder(node));
    }

    public static Node createTree() {
        Node headNode = new Node("f");
        headNode.left = new Node("b");
        headNode.left.left = new Node("a");
        headNode.left.right = new Node("d");
        headNode.left.right.left = new Node("c");
        headNode.left.right.right = new Node("e");
        headNode.right = new Node("g");
        headNode.right.right = new Node("i");
        headNode.right.right.left = new Node("h");
        return headNode;
    }

    public static class Node {
        String content;
        Node left;
        Node right;

        public Node(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
