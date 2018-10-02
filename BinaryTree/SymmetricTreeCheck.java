package codestore.binarytree;

public class SymmetricTreeCheck {
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
        //    /   \     \
        //  (4)   (5)   (6)

        Node m1 = new Node(1);
        Node m2 = new Node(2);
        Node m3 = new Node(3);
        Node m4 = new Node(4);
        Node m5 = new Node(5);
        Node m6 = new Node(6);
        m1.left = m3;
        m1.right = m2;
        m3.left = m6;
        m2.left = m5;
        m2.right = m4;

        //        (1)
        //       /   \
        //     (3)   (2)
        //    /     /   \
        //  (6)   (5)   (4)

        boolean mResult = isSymmetricTree(n1, m1);
        System.out.println(mResult);
    }

    private static boolean isSymmetricTree(Node nRoot, Node mRoot) {
        if (nRoot == null && mRoot == null) return true;
        return nRoot != null
                && mRoot != null
                && nRoot.data == mRoot.data
                && isSymmetricTree(nRoot.left, mRoot.right)
                && isSymmetricTree(nRoot.right, mRoot.left);
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