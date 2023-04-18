package linkedlist;

import linkedlist.SingleLinkedList.Node;

public class SinglyLinkedListUtility {
	
	public static void main(String[] args) {
		SingleLinkedList ll = new SingleLinkedList(10);
		ll.append(23);
		ll.append(88);
		ll.append(230);
		ll.append(808);
		ll.append(231);
		ll.append(8448);
		ll.printLinkedList();
		System.out.println("removed last - " + ll.removeLast());
		System.out.println("removed last - " + ll.removeLast());
		System.out.println("removed last - " + ll.removeLast());
		System.out.println("removed last - " + ll.removeLast());
		System.out.println("removed last - " + ll.removeLast());
		System.out.println("removed last - " + ll.removeLast());
		ll.printLinkedList();
		ll.append(8448);
		ll.printLinkedList();
		ll.removeFirst();
		ll.printLinkedList();
		ll.prepend(222);
		ll.prepend(111);
		ll.printLinkedList();
		System.out.println(ll.get(0));
		System.out.println(ll.get(1));
		System.out.println(ll.get(2));
		System.out.println(ll.get(3));
		System.out.println(ll.get(4));
		ll.set(1, 101010);
		ll.printLinkedList();
		ll.insert(1, 555);
		ll.insert(1, 5055);
		ll.insert(1, 50055);
		ll.insert(1, 500055);
		ll.printLinkedList();
		ll.remove(1);
		ll.remove(1);
		ll.printLinkedList();
		ll.reverse();
		ll.printLinkedList();
		
		System.out.print("###swap pairs");
		SingleLinkedList ll2 = new SingleLinkedList(10);
		ll2.append(23);
		ll2.append(88);
		ll2.append(230);
		ll2.append(230);
		ll2.append(808);
		ll2.append(231);
		ll2.append(8448);
		ll2.append(231);
		ll2.append(231);
		ll2.append(231);
		///Node newList = SingleLinkedList.swapPairs(ll2);
		//Node temp = newList;
		//while(temp != null) {
		//	System.out.print(temp.value +"->");
		//	temp = temp.next;
		//}	
		ll2.printLinkedList();
		System.out.println();
		ll2.removeDuplicates();
		ll2.printLinkedList();
	}

}
