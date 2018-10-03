package codestore.binarysearchtree;

public class LowestCommonAncestor_WithArray {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        n5.right = n6;

        //        (4)
        //       /   \
        //     (2)   (5)
        //    /   \    \
        //  (1)   (3)  (6)

        int mResult = lowestCommonAncestor(n4, n1, n3);
        if (mResult == -1) System.out.println("Invalid input");
        else System.out.println("Ancestor is : " + mResult);
    }

    private static int lowestCommonAncestor(Node mRoot, Node mNodeOne, Node mNodeTwo) {
        if (mRoot == null || mNodeOne == null || mNodeTwo == null) return -1;
        // Size can be n in case of skewed tree, we are taking 10 for our example.
        int[] mArrayOne = new int[10];
        int[] mArrayTwo = new int[10];

        // Find the path to the nodes
        findPath(mRoot, mNodeOne, mArrayOne);
        findPath(mRoot, mNodeTwo, mArrayTwo);

        // Return the last common element, it is our lowest common ancestor
        for (int i = 0; i < mArrayOne.length; i++) {
            if (mArrayOne[i] != mArrayTwo[i]) return mArrayOne[i - 1];
        }
        return -1;
    }

    private static void findPath(Node mRoot, Node mNode, int[] mArray) {
        int mCount = 0;
        while (mRoot != null) {
            mArray[mCount++] = mRoot.data;
            if (mRoot == mNode) return;
            if (mRoot.data < mNode.data)
                mRoot = mRoot.right;
            else
                mRoot = mRoot.left;
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