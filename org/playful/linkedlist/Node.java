package org.playful.linkedlist;

public 	class Node {
	
	Node next;
	Object value;
	
	public Object getValue(){
		return value;
	}
	
	public void setValue(Object o) {
		value = o;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
	public Node getNext(){
		return next;
	}
	
	public Node(Object o) {
		value = o;
		next = null;
	}
	
	public String toString(){
		return "["+value+" next("+next+")]";
	}
	
}