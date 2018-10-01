package codestore.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
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

        breadthFirstSearch(n1);
    }

    private static void breadthFirstSearch(Node mNode) {
        if (mNode == null) return;
        Queue<Node> mQueue = new LinkedList<>();
        mQueue.add(mNode);
        while (!mQueue.isEmpty()) {
        	// Remove from queue and add the children back into queue.
            mNode = mQueue.remove();
            System.out.print(mNode.data);
            if (mNode.left != null) mQueue.add(mNode.left);
            if (mNode.right != null) mQueue.add(mNode.right);
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