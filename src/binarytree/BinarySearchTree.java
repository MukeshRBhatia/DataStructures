package binarytree;

public class BinarySearchTree {
	private Node root;
	
	class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	// Worst case time complexity O(log n)
	// Adding an item to a Binary Search Tree is O(log n): 
	// Omega (best case) and Theta (average case) are both (log n). 
	// However, worst case is O(n) and Big O measures worst case.
	
	// create newNode
	// if root == null then root == newNode
	// temp = root
	// while 
	// 		if newNode == temp return false
	//      if < left else > right
	//      if null insert newNode else move to next
	public boolean insert(int nvalue) {
		Node n = new Node(nvalue);
		if(root == null) {
			this.root = n;
			return true;
		}
		Node temp = this.root;
		while(true) {
			if(temp.value == n.value)return false;
			if(n.value < temp.value) {
				if(temp.left == null) {
					temp.left = n;
					return true;
				}
				temp = temp.left;
			} else {
				if(temp.right == null) {
					temp.right = n;
					return true;
				}
				temp = temp.right;
			}
		}
	}
	
	public boolean contains(int value) {
		if (root == null) {
			return false;
		}
		Node temp = root;
		while (true) {
			if (temp.value == value)
				return true;
			if (value < temp.value) {
				if (temp.left == null) {
					return false;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					return false;
				}
				temp = temp.right;
			}
		}
	}
	
}