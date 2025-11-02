package singlylinkedlist;

public class CreationOfSinglyLinkedList {

	public static void main(String[] args) {
		
		
	}
	
}


//Lets create SinglyLinkedList
//General approach before creating any Object 
//What will be data member?
//And what will be method to operate on data member?
//Data member -> 1. ek node -> which contains two things. -> a. data  b. link or reference to next node
//node jo ki khud ek object hai and node can only exist when LinkedList exist or engine can only exist when car exist
//so composite relationship between LinkedList and Node or Has - A - Relationship
//LinkedList has A Node
		

class SinglyLinkedList{
	
	
//	LinkedList must contain node -> composite relation
//	node contains two field.  ------>  1. data   2. reference to next node 
	
	private ListNode head;
	
	
	
	
	
	private static class ListNode{
		
//		Data inside node
		private int data;
		
//		reference or link to next node
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	
	public static void main(String[] args) {
		
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
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
		

		

//		node means ek dabba or box -> which contain two things -> 1. data  2. link to next node or reference to next node
		
//		Suppose we have not initialized current node then it is a local variable. And if you try to access it then compilation error.
		ListNode currentNodeWithoutReferringAnyNode;
		
//		The local variable currentNodeWithoutReferringAnyNode may not have been initialized
//		System.out.println(currentNodeWithoutReferringAnyNode);
		
//		creating a node say current and current is referring to head		
		ListNode current = singlyLinkedList.head;
		
//		Lets print current node
		System.out.println("Reference of current node: " + current);  // singlylinkedlist.SinglyLinkedList$ListNode@49097b5d
		
//		Lets check what is inside this current node -> i mean data and reference to next node
//		data inside current node
		System.out.println("Data inside current node: " + current.data);
		
//		reference to next node
		System.out.println("Reference or Link to next node:" + current.next);
		
//		Lets compare link given by current node to the reference of next node -> It must be equal.
		System.out.println("comparing reference given by current node and reference of next node: " + (current.next == second));
		
		
//		printing data of all the node or simply say printing elements of SinglyLinkedList
		System.out.println("printing elements of SinglyLinkedList: ");
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
		
//		finding length of the LinkedList
		int count =0;
//		assigning current node to head and increment count one by one till null
		current = singlyLinkedList.head;
		while(current != null) {
			count++;
			current = current.next;
		}
		System.out.println("printing count of SinglyLinkedList: " + count);
		
		
		
		
//		inserting node at the beginning of SinglyLinkedList
		
		
		
		
		
		
		
		
		
	}
	
	
	
}