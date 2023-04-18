package binarytree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BSTTraversal {

 public static void main(String[] args) {

	 BSTTraversal myBST = new BSTTraversal();

     myBST.insert(47);
     myBST.insert(21);
     myBST.insert(76);
     myBST.insert(18);
     myBST.insert(27);
     myBST.insert(52);
     myBST.insert(82);

     System.out.println("\nDFS InOrder:");
     System.out.println( myBST.DFSInOrder() );

     /*
         EXPECTED OUTPUT:
         ----------------
         DFS InOrder:
         [18, 21, 27, 47, 52, 76, 82]

     */

 }

 public Node root;

 public static class Node {
     public int value;
     public Node left;
     public Node right;

     private Node(int value) {
         this.value = value;
     }
 }

 public boolean insert(int value) {
     Node newNode = new Node(value);
     if (root == null) {
         root = newNode;
         return true;
     }
     Node temp = root;
     while (true) {
         if (newNode.value == temp.value) return false;
         if (newNode.value < temp.value) {
             if (temp.left == null) {
                 temp.left = newNode;
                 return true;
             }
             temp = temp.left;
         } else {
             if (temp.right == null) {
                 temp.right = newNode;
                 return true;
             }
             temp = temp.right;
         }
     }
 }

 public boolean contains(int value) {
     if (root == null) return false;
     Node temp = root;
     while (temp != null) {
         if (value < temp.value) {
             temp = temp.left;
         } else if (value > temp.value) {
             temp = temp.right;
         } else {
             return true;
         }
     }
     return false;
 }

 public ArrayList<Integer> BFS() {
     Node currentNode = root;
     Queue<Node> queue = new LinkedList<>();
     ArrayList<Integer> results = new ArrayList<>();
     queue.add(currentNode);

     while (queue.size() > 0) {
         currentNode = queue.remove();
         results.add(currentNode.value);
         if (currentNode.left != null) {
             queue.add(currentNode.left);
         }
         if (currentNode.right != null) {
             queue.add(currentNode.right);
         }
     }
     return results;
 }

 public ArrayList<Integer> DFSPreOrder() {
     ArrayList<Integer> results = new ArrayList<>();

     class Traverse {
         Traverse(Node currentNode) {
             results.add(currentNode.value);
             if (currentNode.left != null) {
                 new Traverse(currentNode.left);
             }
             if (currentNode.right != null) {
                 new Traverse(currentNode.right);
             }
         }
     }

     new Traverse(root);
     return results;
 }

 public ArrayList<Integer> DFSPostOrder() {
     ArrayList<Integer> results = new ArrayList<>();

     class Traverse {
         Traverse(Node currentNode) {
             if (currentNode.left != null) {
                 new Traverse(currentNode.left);
             }
             if (currentNode.right != null) {
                 new Traverse(currentNode.right);
             }
             results.add(currentNode.value);
         }
     }

     new Traverse(root);
     return results;
 }

 public ArrayList<Integer> DFSInOrder() {
     ArrayList<Integer> results = new ArrayList<>();

     class Traverse {
         Traverse(Node currentNode) {
             if (currentNode.left != null) {
                 new Traverse(currentNode.left);
             }
             results.add(currentNode.value);
             if (currentNode.right != null) {
                 new Traverse(currentNode.right);
             }
         }
     }

     new Traverse(root);
     return results;
 }

}

