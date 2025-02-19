
public class LList_mutable<T> { 

	class Node<T> {
		T value;
		Node<T> next;
		Node(T value, Node<T> next) { this.value = value; this.next = next; }
		T getValue() {	return value;	}
		void setValue(T value) {	this.value = value;	}
		Node<T> getNext() {	return this.next;	}
		void setNext(Node<T> next) {	this.next = next;	}
		public String toString() { return value.toString(); }
	}

   	private Node<T> head;
	public LList_mutable(){
		head = null; 		
	}


	public void insertFirst(T value) {	
		head = new Node<T>(value, head);
	}

	public void insertAfter(Node<T> prevNode, T value) {
		if (prevNode == null)
           		throw new IllegalArgumentException("prevNode is null");	

		prevNode.next = new Node<T>(value, prevNode.next);
	}
	
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
		
				
		LList<SomeType> list = new LList<SomeType>();
		list.insertFirst(item1);
		list.insertFirst(item2);
		list.insertFirst(item3);
		list.insertFirst(item4);
		
				


		System.out.println("full list: " + list.listToString());				

		System.out.println("length: " + list.listLength());
				
		System.out.println("head of list: " + list.listPosition(1));

		System.out.println("second element : " + list.listPosition(2));
		
		
		System.out.println("search for 100: " + list.findNode(item1));
		System.out.println("search for 200: " + list.findNode(item2));
		System.out.println("search for 300: " + list.findNode(item3));
		System.out.println("search for 400: " + list.findNode(item4));
		list.printForward();
		System.out.println();

		list.insertAfter(list.findNode(item3), new SomeType(3000));
		list.printForward();
		System.out.println();

		list.insertAfter(list.findNode(item4), new SomeType(4000));
		list.printForward();
		System.out.println();

		list.insertAfter(list.findNode(item1), new SomeType(1000));
		list.printForward();
		System.out.println();

		list.removeAfter(list.findNode(item1));
		list.removeAfter(list.findNode(item3));
		list.removeAfter(list.findNode(item4));
		list.printForward();
		System.out.println();

	}
}