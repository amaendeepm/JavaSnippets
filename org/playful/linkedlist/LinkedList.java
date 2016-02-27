package org.playful.linkedlist;

public class LinkedList {

	private Node head;
	
	public LinkedList(){
		head = new Node(null);
	}
	
	public Node getHead() {
		return head;
	}
	
	public void printList() {
		if(head.getNext()==null)
			return;
		Node current = head.getNext();
		System.out.print("Head -> " + current.getValue() + " -> ");

		while(current.getNext()!= null){
			current = current.getNext();
			System.out.print(current.getValue() + " -> ");			
		}
		
		System.out.print("(null)");
	}
	
	public LinkedList add(Object o) {
		Node n = new Node(o);
		if(head.getNext()==null) { //first element case
			head.setNext(n);
		} else {			
			Node current = head.getNext();
			while(current.getNext()!=null) {
				current = current.getNext();
				if(current.getNext()==null) {
					current.setNext(n);
					break;
				}	
			}			
		}
		return this; // SMILE :-) https://en.wikipedia.org/wiki/Fluent_interface
	}
	
	public boolean insertAfter(Object what, Object obj) {
			Node current = head.getNext();
			while(current!=null) {
				if(current.getValue().equals(what)) {
					Node newNode = new Node(obj);
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					return true;
				}
				current = current.getNext();
			}
			return false;
	}

	public boolean remove(Object what) {
		Node prev = head;
		Node current = head.getNext();
		
		if(current==null)
			return false;
		while(current!=null) {
			if(current.getValue().equals(what)) {
				prev.setNext(current.getNext());
				return true;
			}
			prev = current;
			current= current.getNext();
		}
		return false;
	}
	
	public LinkedList reverse() {
		if(head.getNext()==null || head.getNext().getNext()==null)
			return this;
		
		Node prev = null;
		Node curr = head.getNext();
		Node next = head.getNext();
		int i=0;
		
		while(curr!=null){
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			//System.out.println("After while loop ...prev="+prev+" curr="+curr+" head"+head);			
		}
		head.setNext(prev);
		return this;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.printList(); System.out.println("\n");
		list.add("apple");
		list.insertAfter("apple", "raspberry");
		list.add("orange").add("pineapple");
		list.printList(); System.out.println("\n");
		list.insertAfter("orange", "banana");
		list.printList(); System.out.println("\n");
		list.insertAfter("apple", "lichi");
		list.printList(); System.out.println("\n");
		list.insertAfter("pineapple", "guava");
		list.printList(); System.out.println("\n");
		list.add("strawberry");
		list.printList(); System.out.println("\n");
		list.insertAfter("strawberry","rambutan");
		list.printList(); System.out.println("\n");
		list.remove("strawberry");
		list.printList(); System.out.println("\n");
		list.remove("rambutan");
		list.printList(); System.out.println("\n");		
		list.remove("apple");
		list.printList(); System.out.println("\n");	
		list.remove("orange");
		list.printList(); System.out.println("\n");	
		
		list.remove("raspberry"); list.remove("guava");
		list.printList(); System.out.println("\n");	
		
		list.reverse();
		list.printList(); System.out.println("\n");
		
		list.reverse().add("grapes").reverse();
		list.printList(); System.out.println("\n");	
	}
	
}


