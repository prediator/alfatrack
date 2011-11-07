import static java.lang.Math.max;

public class E51_DepthOfBinaryTree {
    public static int calcTreeDepth(Node node) {
        return node == null || (node.left == null && node.right == null)
                ? 0 
                : 1 + max(calcTreeDepth(node.left), calcTreeDepth(node.right));
    }
    
    public static void main(String[] args) {
        Node headNode = createTree();
        System.out.println("depth = " + calcTreeDepth(new Node()));
        System.out.println("depth = " + calcTreeDepth(headNode));
    }
    
    public static Node createTree() {
        Node headNode = new Node();
        headNode.left = new Node();
        headNode.left.left = new Node();
        headNode.left.right = new Node();
        headNode.left.right.left = new Node();
        headNode.left.right.left.left = new Node();
        headNode.left.right.left.right = new Node();
        headNode.left.right.left.left.right = new Node();
        headNode.left.right.left.left.right.right = new Node();
        headNode.right = new Node();
        headNode.right.left = new Node();
        headNode.right.left.left = new Node();
        headNode.right.left.right = new Node();
        headNode.right.left.left.left = new Node();
        headNode.right.left.left.left.left = new Node();
        headNode.right.left.left.left.right = new Node();
        return headNode;
    }
    
    public static class Node {
        Node left;
        Node right;
    }
}
