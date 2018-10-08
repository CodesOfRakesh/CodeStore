package codestore.binarytree;

public class LowestCommonAncestor {
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

        Node mResult = lowestCommonAncestor(n1, n5, n2);
        if (mResult == null) System.out.println("Invalid input");
        else System.out.println("Ancestor is : " + mResult.data);
    }

    private static Node lowestCommonAncestor(Node mRoot, Node mNodeOne, Node mNodeTwo) {
        // From a bottom-up manner, each node returns null if lca nodes are not found
        // If we find any node, we return that node's value until we reach a point where we have both lca nodes value
        // this node is our lca
        if (mRoot == null) return null;
        if (mRoot == mNodeOne || mRoot == mNodeTwo) return mRoot;
        return returnWhat(mRoot, lowestCommonAncestor(mRoot.left, mNodeOne, mNodeTwo), lowestCommonAncestor(mRoot.right, mNodeOne, mNodeTwo), mNodeOne, mNodeTwo);
    }

    private static Node returnWhat(Node mRoot, Node mRetOne, Node mRetTwo, Node mNodeOne, Node mNodeTwo) {
        if (mRetOne != null && mRetTwo == null) return mRetOne;
        if (mRetTwo != null && mRetOne == null) return mRetTwo;
        if ((mRetOne == mNodeOne && mRetTwo == mNodeTwo) || (mRetOne == mNodeTwo && mRetTwo == mNodeOne))
            return mRoot;
        return null;
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