package codestore.binarysearchtree;

import codestore.Node;

public class LowestCommonAncestor_Optimized {
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
        // The idea is to start traversing the tree starting from node
        // - If both nodes are lesser than root, then LCA is present in left sub tree
        // - If both nodes are greater than root, then LCA is present in right sub tree
        // - If any node is equal to root node or if root node lies between both nodes, then current root node is the LCA
        if (mRoot == null) return -1;
        while (mRoot != null) {
            if (mRoot.data > mNodeOne.data && mRoot.data > mNodeTwo.data)
                mRoot = mRoot.left;
            else if (mRoot.data < mNodeOne.data && mRoot.data < mNodeTwo.data)
                mRoot = mRoot.right;
            else break;
        }
        return mRoot != null ? mRoot.data : -1;
    }
}

/*class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/