
public class LList_immutable<T> { 

	class Node<T> {
		T value;
		Node<T> next;

		Node(T value, Node<T> next) {
			this.value = value; this.next = next;
		}

		T getValue() {
			return value;	
		}

		void setValue(T value) {
			this.value = value;
		}

		Node<T> getNext() {
			return this.next;
		}

		void setNext(Node<T> next) {
			this.next = next;
		}

		public String toString() {
			return value.toString();
		}
	}

   	private Node<T> head;

	public LList_immutable(){
		head = null; 		
	}

	public LList_immutable(Node<T> node){
		head = node; 		
	}

	// add code here that makes insertFirst() immutable 
	// completed by Oscar but need to check if it is correct approach
	public LList_immutable<T> insertFirst(T value) {
		LList_immutable<T> newList = new LList_immutable<>(); // create new list
		newList.head = new Node<T>(value, this.head); // add value first and old head after
	
		return newList;
	}
	

	public LList_immutable<T> insertAfter(Node<T> prevNode, T value) {
		if (prevNode == null) {
           		throw new IllegalArgumentException("prevNode is null");
		}

		prevNode.next = new Node<T>(value, prevNode.next);
		return null;
	}
	/*
	 * added by Smita
	 * Created a new constructor for LList_immutable class and helper method called copyList
	 */

	private Node<T> copyList(Node<T> current, Node<T> prevNode, Node<T> newNode) {
		if (current == null) {
			return null;
		}
		if (current == prevNode) {
			return new Node<>(current.value, newNode);
		}
		return new Node<>(current.value, copyList(current.next, prevNode, newNode));
	}
	
	//Add code here that make insertAfter() immutable
	
	
	
	
	
	
	public Node<T> findNode(T value) {
		Node<T> node = head;
		while (node != null) {
			if (node.value.equals(value)) {
				return node;
			}
			node = node.next;
		}		
		return null;	
	}   

	public void printForward()
	{
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}		
	}
	
	public String listToString() {  
		StringBuilder ret = new StringBuilder();
		Node current = head;
		while(current != null) {
			ret.append(current.value);         
			ret.append(" ");
			current = current.getNext();
		}
		return ret.toString().trim();
	}

	public int listLength()  
   	{
    		Node cursor;
	    	int answer = 0;
      
      		for (cursor = head; cursor != null; cursor = cursor.next) {
				answer++;
	    	}
        
      		return answer;
   	}

	public Node listPosition(int position) 
	{
      		if (position <= 0)
           		throw new IllegalArgumentException("position is not positive");
      
      		Node cursor = head;
      		for (int i = 1; (i < position) && (cursor != null); i++) {
				cursor = cursor.next;
			}

      		return cursor;
	}


	public static void main(String[] args) {
	
		class SomeType {
			private int value;

			public SomeType(int value) { this.value = value; }
			public String toString() { return "" + value; }
			public boolean equals(Object o) {
				if (!(o instanceof SomeType)) return false;
				return ((SomeType)o).value == value;
			}	
		}
		
		SomeType item1 = new SomeType(100);
		SomeType item2 = new SomeType(200);
		SomeType item3 = new SomeType(300);
		SomeType item4 = new SomeType(400);
		SomeType item5 = new SomeType(500);
		
		///////////////////////////////////////////////////////////////////
		// inserFirst()
		LList_immutable<SomeType> list0, list1, list2, list3, list4, list5;
		
		System.out.println("\n ////////////// insertFirst()");
		
		list0 = new LList_immutable<SomeType>();
		System.out.println("list0 must print nothing: " + list0.listToString());
		System.out.println();
		
		list1 = list0.insertFirst(item1);
		System.out.println("list0 must print nothing: " + list0.listToString());
		System.out.println("list1 must print 100: " + list1.listToString());
		System.out.println();
		
		list2 = list1.insertFirst(item2);
		System.out.println("list0 must print nothing: " + list0.listToString());
		System.out.println("list1 must print 100: " + list1.listToString());
		System.out.println("list2 must print 200 100: " + list2.listToString());
		System.out.println();
		
		list3 = list2.insertFirst(item3);
		System.out.println("list0 must print nothing: " + list0.listToString());
		System.out.println("list1 must print 100: " + list1.listToString());
		System.out.println("list2 must print 200 100: " + list2.listToString());
		System.out.println("list3 must print 300 200 100: " + list3.listToString());
		System.out.println();
		
		list4 = list3.insertFirst(item4);
		System.out.println("list0 must print nothing: " + list0.listToString());
		System.out.println("list1 must print 100: " + list1.listToString());
		System.out.println("list2 must print 200 100: " + list2.listToString());
		System.out.println("list3 must print 300 200 100: " + list3.listToString());
		System.out.println("list4 must print 400 300 200 100: " + list4.listToString());
		System.out.println();
		
		list5 = list4.insertFirst(item5);
		System.out.println("list0 must print nothing: " + list0.listToString());
		System.out.println("list1 must print 100: " + list1.listToString());
		System.out.println("list2 must print 200 100: " + list2.listToString());
		System.out.println("list3 must print 300 200 100: " + list3.listToString());
		System.out.println("list4 must print 400 300 200 100: " + list4.listToString());
		System.out.println("list5 must print 500 400 300 200 100: " + list5.listToString());
		System.out.println();	
		
		
		///////////////////////////////////////////////
		/////////// insertAfter()
		System.out.println("\n ////////////// insertAfter()");
		
		LList_immutable<SomeType> list;
		
		list = list1.insertAfter(list1.findNode(item1), new SomeType(101));
		System.out.println("must print 100 101: " + list.listToString());
		
		list = list2.insertAfter(list2.findNode(item2), new SomeType(201));
		System.out.println("must print 200 201 100: " + list.listToString());
		System.out.println("must print 200 100: " + list2.listToString());
		
		list = list5.insertAfter(list5.findNode(item1), new SomeType(101));
		System.out.println("must print 500 400 300 200 100 101: " + list.listToString());
		System.out.println("must print 500 400 300 200 100: " + list5.listToString());
		
	}
	
}