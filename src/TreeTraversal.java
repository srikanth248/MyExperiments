public class TreeTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }

    private static class BinaryTree {

        private Node root;

        public BinaryTree() {
            root = null;
        }

        public void printPreorder() {
            printPreorder(root);
        }

        private void printPreorder(Node node) {
            if(node == null) {
                return;
            }
            System.out.println(node.value);
            printPreorder(node.left);
            printPreorder(node.right);
        }

        public void printInorder() {
            printInorder(root);
        }

        private void printInorder(Node node) {
            if(node == null) {
                return;
            }
            printInorder(node.left);
            System.out.println(node.value);
            printInorder(node.right);
        }

        public void printPostorder() {
            printPostorder(root);
        }

        private void printPostorder(Node node) {
            if(node == null) {
                return;
            }
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.println(node.value);
        }
    }

    private static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }
}
