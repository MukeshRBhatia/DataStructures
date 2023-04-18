package stack_queue;

public class MyStack {
	
	int[] ar = null;
	int head;
	int capacity;
	
	public MyStack(int capacity) {
		this.capacity = capacity;
		ar = new int[capacity];
		head = -1;
	}
	
	public void push(int n) {
		if(capacity == head + 1) {
			//throw new Exception("error");
			System.out.println("cannot push! Stack full");
		}
		ar[++head] = n;
	}
	
	public void pop() {
		if(head == -1) {
			System.out.println("cannot pop! Stack empty");
		}
		head = head - 1;
	}
	
	public void printStack() {
		if(head == -1) System.out.println("no values");
		for(int i = 0; i <= head; i++) {
			System.out.print(ar[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		MyStack st = new MyStack(6);
		st.push(10);
		st.push(11);
		st.push(12);
		st.push(13);
		st.printStack();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.printStack();
	}
}