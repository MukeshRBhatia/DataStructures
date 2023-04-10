package binarytree;

public class BSTClient {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(100);
		bst.insert(18);
		bst.insert(19);
		bst.insert(102);
		System.out.println(bst.contains(100));
	}

}
