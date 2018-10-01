package codestore.binarytree;

import java.util.Stack;

public class DepthFirstSearch {
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

        depthFirstSearch(n1);
    }

    private static void depthFirstSearch(Node mNode){
        if (mNode == null) return;
        // Print the node and push its child to the stack
        Stack<Node> mStack = new Stack<>();
        mStack.push(mNode);
        while(!mStack.isEmpty()){
            Node mTemp = mStack.pop();
            System.out.print(mTemp.data);
            if (mTemp.right!=null) mStack.push(mTemp.right);
            if (mTemp.left!=null) mStack.push(mTemp.left);
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