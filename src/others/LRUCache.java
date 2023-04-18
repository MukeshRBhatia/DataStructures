package others;
	/* 
	* Implement an LRU Cache
	*
	* Class. have a data structure.
	*
	* constructor - data structure of fixed capacity
	* get(key) - return value for the key.  if no value is found, throw an exception
	* put(key, value) - add key and value to the data structure.  if cache is full, evict the least recently used.
	*
	* oldest entry in the cache that hasn't been accessed (created, retreived)
	*
	*/
	/*
	 * public class LRUC { private Integer capacity;
	 * 
	 * LinkedList1 map = new LH(capapcity);
	 * 
	 * 
	 * public LRUC(int capacity) { this.capacity = capacity; }
	 * 
	 * public Integer get(Integer key) { map.get(key) // iterate from head to tail
	 * and find the key and then the value O(n) // throw Exception("") // remove
	 * this node and append the tail and rerefer the tail }
	 * 
	 * public Node<k,V> put(key, value) { // if(check capacity == capallow) // temp
	 * = head // go to head, repoint the head to node.next O(1) // append the new
	 * key, value //else // append the new key value
	 * 
	 * }
	 * 
	 * public static void main(String[] args) { LRUC cache = new LRUC(8);
	 * cache.put(1001, "ABAB");
	 * 
	 * Node{ key value hashcode } }
	 * 
	 * 
	 * }
	 */

