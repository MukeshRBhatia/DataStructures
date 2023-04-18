package linkedlist;

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

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
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
		if(length == 0) {
			System.out.println("The linkedlist is empty");
			return;
		}
		Node temp = this.head;
		while(temp != null) {
			System.out.print(temp.value +"->");
			temp = temp.next;
		}	
		System.out.println();
	}
	
	
	/* Last element cannot be remove directly as we do not know the tail after removing the last node.
	 * So we iterate from first and maintain last and the penultimate last node
	 * Complexity O(n)
	 * 
	 * */
	public Node removeLast() {
		if(length == 0) {
			System.out.println("The linkedlist is empty");
			return null;
		}
		Node temp = head;
		Node pretemp = head;
		
		while(temp.next != null) {
			pretemp = temp;
			temp = temp.next;
		}
		tail = pretemp;
		pretemp.next = null;
		length--;
		if(length == 0) {
			this.tail = null;
			this.head = null;
		}
		return temp;
	}
	
	/* Last element cannot be remove directly as we do not know the tail after removing the last node.
	 * So we iterate from first and maintain last and the penultimate last node
	 * Complexity O(n)
	 * 
	 * */
	public Node removeFirst() {
		if(length == 0) {
			System.out.println("The linkedlist is empty");
			return null;
		}
		if(length == 1) {
			tail = null;
			head = null;
		}
		Node first = head;
		head = head.next;
		first.next = null;
		length--;
		if(length == 0) {
			tail = null;
			head = null;
		}
		return first;
	}
	
	public void prepend(int value) {
		Node newNode = new Node(value);
		if(length == 0) {
			tail = newNode;
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public Node get(int index) {
		//Zero based indexing
		if(index < 0 || index >= length) {
			return null;
		}
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	//This method updates the value at a particular index
	public boolean set(int index, int value) {
		//Zero based indexing
		if(index < 0 || index >= length) {
			return false;
		}
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.value = value;
		return true;
	}
	
	//This method inserts a new node at a particular index
	public boolean insert(int index, int value) {
		//Zero based indexing
		if (index < 0 || index > length) return false;
		if (index == 0) {
			prepend(value);
			return true;
		}
		if (index == length) {
			append(value);
			return true;
		}
		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}
	
	//This method removes a node at a particular index
	public Node remove(int index) {
		//Zero based indexing
		if (index < 0 || index >= length) return null;
		if (index == 0) return removeFirst();
		if (index == length - 1) return removeLast();
		Node temp = get(index - 1);
		Node remove = temp.next;
		temp.next = remove.next;
		remove.next = null;
		length--;
		return remove;
	}
	
	public void reverse() {
		//first swap head and tail
		Node temp = head;
		head = tail;
		tail = temp;
		//now we need 3 pointers - before, temp, after
		Node after = temp.next;
		Node before = null;
		// before the iteration starts, before = null, temp = node1, after = node2  
		// So we reverse the next value in temp to before
		for (int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}
	/**
	 * public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;   
    }
	 * 
	 */
	
	// finds middle node without considering the length variable
	// makes 2 variables.
	// Approach is when the faster pointer reaches the end, the slower pointer is still at the middle
	public Node findMiddleNode(){
	    if(head == null) return null;
	    Node temp = head;
	    Node temp1 = head;
	    while(temp.next != null) {
	        temp1 = temp1.next;
	        temp = temp.next.next;
	    }
	    return temp1;
	}
	
	/*
	 * The method initializes two pointers, slow and fast, both pointing to the head of the LinkedList.
     * It then moves the fast pointer k steps ahead in the LinkedList. If fast becomes null at any point during this process, it means that k is out of bounds (greater than the length of the LinkedList), so the method returns null.
     * After moving the fast pointer k steps ahead, the method enters a while loop. This loop continues until the fast pointer reaches the end of the LinkedList (i.e., fast becomes null).
     * Inside the while loop, both the slow and fast pointers move one step at a time. Since the fast pointer is already k steps ahead of the slow pointer, when the fast pointer reaches the end of the LinkedList, the slow pointer will be at the kth node from the end.
     * Finally, the method returns the slow pointer, which now points to the kth node from the end of the LinkedList.
	 *  
	 *  */
	public Node findKthFromEnd(int k) {
        Node slow = this.head;
        Node fast = this.head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
	
	// Given a linked list A, swap every two adjacent nodes and return its head.
    // NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.
	public static Node swapPairs(SingleLinkedList A) {
        if(A.head.next == null) return A.head;
        
        Node head = A.head;
        Node t1 = A.head;
        Node t2 = A.head.next;
        head = head.next;
        
        //A>B>C>D>E
        while(t2 != null){
        	System.out.print(t1 + " " + t2);
            t2.next = t1;
            t1.next = t2.next;
            t1 = t1.next;
            t2 = t1.next;
        }
        return head;
    }
	
	public boolean hasLoop(){
	    Node fast = head;
	    Node slow = head;
	    while(fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if(slow == fast) {
	            return true;
	        }
	    }
	    return false;
	}
	
	// good to visualize
	public void removeDuplicates() {
        Node temp = head;
        while(temp.next != null) {
            Node temp1 = temp;
            while(temp1.next != null) {
                if(temp.value == temp1.next.value) {
                    temp1.next = temp1.next.next;
                } else { // chances that we miss the next value if the if condition is correct.
                temp1 = temp1.next;
            }
                }
            temp = temp.next;
        }
    } 
	
	// reverses the nodes of the list between indexes m and n (inclusive).
	
	
	//
}
