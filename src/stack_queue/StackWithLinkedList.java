package stack_queue;

public class StackWithLinkedList {
	
	Node head;
	Node tail;
	
	public StackWithLinkedList() {
		head = null;
		tail = null;
	}
	
	class Node {
		
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public void push(int value) {
		Node n = new Node(value);
		if(this.head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}
	
	public void pop() {
		if(this.head == null) {
			System.out.println("no values to pop");
		} else {
			Node temp = head;
			while(temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
			tail = temp;
		}
	}
	
	public void printstack() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		StackWithLinkedList st = new StackWithLinkedList();
		st.push(10);
		st.push(11);
		st.push(12);
		st.push(13);
		st.printstack();
		st.pop();
		//st.pop();
		//st.pop();
		//st.pop();
		st.printstack();
	}
}