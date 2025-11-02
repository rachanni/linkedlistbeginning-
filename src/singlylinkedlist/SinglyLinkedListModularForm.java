package singlylinkedlist;



public class SinglyLinkedListModularForm {

//	LinkedList must contain node -> composite relation
//	node contains two field.  ------>  1. data   2. reference to next node 

	private ListNode head;

	private static class ListNode {

//		Data inside node
		private int data;

//		reference or link to next node
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	public static void main(String[] args) {
		
		SinglyLinkedListModularForm singlyLinkedList = new SinglyLinkedListModularForm();
		singlyLinkedList.head= new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		
//		Till now we have created four node having name 1. head  2. second  3. third  4. fourth
//		But we have not established link between these nodes 
//		They are like different boxes lying inside heap memeory.
		
//		established link between head and second node
		singlyLinkedList.head.next=second;
//		established link between second and third node 
		second.next=third;
//		established link between third and fourth node
		third.next=fourth;
		
		
//		printing elements of LinkedList
		singlyLinkedList.display();
		
//		finding count of LinkedList
		System.out.println("printing count of SinglyLinkedList: " + singlyLinkedList.findingCount());
		
//		inserting node at the beginning
		singlyLinkedList.insertNodeAtBeginning(15);
		singlyLinkedList.insertNodeAtBeginning(8);
		singlyLinkedList.insertNodeAtBeginning(1);
		System.out.println("inserting node at the beginning: " );
		singlyLinkedList.display();
//		inserting node at the end
		System.out.println("inserting node at the end");
		singlyLinkedList.insertNodeAtEnd(45);
		singlyLinkedList.insertNodeAtEnd(55);
		singlyLinkedList.display();
//		inserting node at any given position
		System.out.println("inserting node at any given position: ");
		singlyLinkedList.insertAtGivenPosition(5, 51);
		singlyLinkedList.display();
		singlyLinkedList.insertAtGivenPosition(3, 31);
		singlyLinkedList.display();
//		deleting first node
		System.out.println("deleting first node: " + singlyLinkedList.deleteFirst().data);
		singlyLinkedList.display();
		System.out.println("deleting first node: " + singlyLinkedList.deleteFirst().data);
		singlyLinkedList.display();
//		deleting last node
		System.out.println("deleting last node: " + singlyLinkedList.deleteLast().data);
		singlyLinkedList.display();
		System.out.println("deleting last node: " + singlyLinkedList.deleteLast().data);
		singlyLinkedList.display();
	}
//	printing elements of LinkedList
	public void display() {
		 ListNode current = head;
		while(current != null) {
			System.out.print(current.data + "------->");
			
//			The moment current.next executed -> current jo ki ek dabba hai or simply ek node hai -> will start pointing to
//			new node -> which new node?
//			wo node jiska reference or link current node mein ye line current = current.next;
//			execute hone se pahle tha
			
//			Aise hi ye daba jump karte karte last node par pahuchega
//			Jisme data to hoga
//			But reference to next node or link to next node nahi hoga
//			Iska matlab link to next node null hoga
//			Aur ye null is daba ko null assign kar dega 
//			and finally is dabba ke andar na data hoga aur na hi koi link hoga
			current = current.next;
		}
		
//		java.lang.NullPointerException: Cannot read field "data" because "current" is null
//		System.out.println(current.data);
		
//		java.lang.NullPointerException: Cannot read field "next" because "current" is null
//		System.out.println(current.next);
		
		
		System.out.println("null");
		
	}
	
	
	public int findingCount() {
		
		 if (head == null) {
	         return 0;
	      }
		int count =0;
	     
//		assigning current node to head and increment count one by one till null
		 ListNode current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
		
	}
	
	
	
	
	public void insertNodeAtBeginning(int value) {
		
//		new node is created -> independent box in the heap memory -> having data but not link to other node
		ListNode newNode= new ListNode(value);
		
//		make this dabba pointing to head 
		newNode.next=head;
		
//		make head referring to new node
		head = newNode;
	}
	
	
	
	public void insertNodeAtEnd(int value) {
		
		ListNode newNode = new ListNode(value);
//		check if head is null -> if null that means LinkedList is empty
//		so simply assign new node to head and return
		if(head == null) {
			head = newNode;
			return;
		}
		
//		create temporary node current 
		ListNode current = head;
		
//		now jump one by one till end of LinkedList
//		start jumping from head
//		condition for last node -> current.next == null => true 
		while(current.next != null) {
			
//			real jumping is doing here from one node to another node
			current = current.next;
		}
		
//		now current node is referring to new node
		current.next= newNode;
	}
	
	public void insertAtGivenPosition(int position, int value) {
		
//		Assuming position is starting from 1 and given position is valid position
//		1  ----> 4 -----> 5
//		1 at position 1
//		4 at position 2
//		5 at position 3
		
//		Obviously it will have data but it is referring to null
//		independent box in the heap memory
		ListNode newNode = new ListNode(value);
		
		
		if(position == 1) {
//			that means we are inserting node at the beginning
			
//			make newNode referring to head 
			newNode.next = head;
//			now head is referring to newNode
			head = newNode;
			
		}else {
//			previous is pointing to head
			ListNode previous = head;
//			we need to reach position - 1
			int count = 1;
			
//			jump node to node till reach required position
			while(count < position - 1) {
				
//				start jumping
				previous = previous.next;
				count++;
			}
			
//			1 -> 4 -> 5
//			insert 6 at position 2
//			1 -> 6 -> 4 -> 5
//			create temporary node
//			before breaking the link between 1 and 4 , we need to store the link. 
			ListNode current = previous.next;
//			now previous is pointing to newNode
			previous.next = newNode;
//			newNode is pointing to current
			newNode.next = current;
		}
	}
	
	
//	delete first node
//	what should be return type of method which is deleting node?
//	Return type -> node or ListNode
//	1------->8------->31------->15-
	public ListNode deleteFirst() {
		
//		true -> no node to delete
		if(head == null) {
			return null;
		}
		
//		create temp node -> make temp referring to head
		ListNode current = head;
//		jump head to next node before deleting
		head = head.next;
//		breaking the link of current node and make it pointing to null
		current.next = null;
		return current;
		
	}
	
	
	
//	delete last node 
//	1------->8------->31------->15
//	we need one reference to second last node before breaking the link between last node and second last node
//	make second last node referring to null
//	checking two condition -> 1. no node i.e. empty LinkedList  2. only one node
	public ListNode deleteLast() {
		
		if(head == null || head.next == null) {
			return head;
		}
		
//		we need to jump from head node to last node one by one
		ListNode current = head;
//		Before breaking link b/w last node and second last node, we need to point second last node referring to null.
		ListNode previous = null;
		while(current.next != null) {
//			before jumping current node, we are assigning current to previous
			previous = current;
//			jumping current node one by one
			current = current.next;
		}
		
//		making second last node pointing to null
		previous.next = null;
//		now last node is free to return
		return current;
	}
	
	
	
	
	
	
	
}