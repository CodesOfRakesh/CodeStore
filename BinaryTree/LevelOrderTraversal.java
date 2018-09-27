package codestore.binarytree;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        //        (1)
        //       /   \
        //     (2)   (3)
        //    /   \    \
        //  (4)   (5)  (6)

        levelOrderTraversal(n1);
    }

    private static void levelOrderTraversal(Node node) {
        int h = getHeight(node);
        for (int i = 1; i <= h; i++) {
            printLevel(node, i);
            System.out.println("");
        }
    }

    private static int getHeight(Node node) {
        if (node == null) return 0;
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        if (l > r) return l + 1;
        else return r + 1;
    }

    private static void printLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1)
            System.out.print(node.data + " ");
        else if (level > 1) {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}