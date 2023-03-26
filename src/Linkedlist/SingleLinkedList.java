package Linkedlist;

public class SingleLinkedList {
	Node tail;
	Node head;
	int length;

	public SingleLinkedList(int value) {
		Node node = new Node(value);
		this.tail = node;
		this.head = node;
		this.length = 1;
	}

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if(length == 0) { 
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
		length++;
	}

	public void printLinkedList() {
		Node temp = this.head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}	
	}
	
	public void removeLast() {
		
	}
	
	public void removeFirst() {
		
	}

	public static void main(String[] args) {
		SingleLinkedList ll = new SingleLinkedList(10);
		ll.append(23);
		ll.append(88);
		ll.append(230);
		ll.append(808);
		ll.append(231);
		ll.append(8448);
		ll.printLinkedList();
	}

}
