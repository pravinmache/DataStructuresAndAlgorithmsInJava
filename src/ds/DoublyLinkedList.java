package ds;

/**
 * Doubly Linked List implementation in Java with Generic type
 * @author Pravin Mache
 *
 * @param <T>
 */
public class DoublyLinkedList<T> {
	Node first;
	Node last;
	private int length;
	
	private class Node{
		T data;
		Node prev;
		Node next;
		
		Node(T data){
			this.data = data;
		}
	}
	
	
	public void reverse() {
		if(length == 0 || length == 1) {
			return;
		}
		else {
			
			Node temp = null;
			Node current = first;
			while(current != null) {
				temp = current.prev;
				current.prev = current.next;
				current.next = temp;
				current = current.prev;
			}
			temp = last;
			last = first;
			first= temp;
			
		}
		
	}
	
	public int length() {
		return length;
	}
	
	public void insertNodeAtTheBeginning(T data) {
		Node node = new Node(data);
		if(first == null && last == null) {
			first = node;
			last = node;
		}
		else {
			node.next = first;
			first.prev=node;
			first = node;
			
		}
		length++;
		
	}
	
	public void insertNodeAtTheEnd(T data) {
		Node node = new Node(data);
		if(first == null && last == null) {
			first = node;
			last = node;
		}
		else {
			node.prev = last;
			last.next = node;
			last = node;
		}
		length++;
		
	}
	
	
	public T get(int position) {
		if(position < 0) {
			throw new IndexOutOfBoundsException("Index cannot be negative.");
		}
		else if(position > length - 1 ) {
			throw new IndexOutOfBoundsException(String.valueOf(position));
		}
		else {
			Node temp = first;
			int count = 0;
			while(count < position) {
				temp = temp.next;
				count++;
			}
			return temp.data;
		}
		
	}
	
	public boolean contains(T data) {
		if(length == 0) {
			return false;
		}
		else {
			Node temp = first;
			while(temp != null) {
				if(temp.data == data) {
					return true;
				}
				temp = temp.next;
				
			}
			return false;
		}
			
	}
	
	
	public void deleteFirstNode() {
		Node temp = first.next;
		temp.prev = null;
		first = temp;
		length--;
		
	}
	
	public void deleteLastNode() {
		Node temp = last.prev;
		temp.next = null;
		last = temp;
		length--;
		
	}
	
	public void deleteNodeAtPosition(int position) {
		if(position < 0) {
			throw new IndexOutOfBoundsException("Index cannot be negative.");
		}
		else if(position > length - 1 ) {
			throw new IndexOutOfBoundsException(String.valueOf(position));
		}
		else if(position == 0) {
			deleteFirstNode();
		}
		else if(position == length -  1) {
			deleteLastNode();
		}
		else {
			int count = 0;
			Node temp = first;
			while(count < position - 1) {
				temp = temp.next;
				count++;
			}
			temp.next.next.prev = temp;
			temp.next = temp.next.next;
			length--;
			
		}
		
	}
	
	public void print() {
		Node temp  = first;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}	
		System.out.println();
	}
	
	public void printReverse() {
		Node temp = last;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
		System.out.println();
		
	}
	
	
	public void insertNodeAtPosition(int position, T data) {
		if(position > length) {
			throw new IndexOutOfBoundsException("Position "+position+" is greater than length " +length+ "of list.");
		}
		else if(position < 0) {
			throw new IndexOutOfBoundsException("Index cannot be negative.");
		}
		else if(position == 0) {
			insertNodeAtTheBeginning(data);
		}
		else if(position == length) {
			insertNodeAtTheEnd(data);
		}
		else {
			Node node = new Node(data);
			Node temp = first;
			int count = 0;
			while(count  < position -1 ) {
				temp = temp.next;
				count++;
			}
			node.next = temp.next;
			node.next.prev = node;
			node.prev = temp;
			temp.next = node;
			length++;
			
		}
		
		
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.insertNodeAtTheBeginning(34);
		dll.insertNodeAtTheBeginning(6534);
		dll.insertNodeAtTheBeginning(233);
		dll.insertNodeAtTheEnd(655);
		dll.insertNodeAtTheEnd(512);
		//dll.insertNodeAtPosition(3, 45);
		//dll.insertNodeAtPosition(0, 1234);
		//dll.insertNodeAtPosition(1, 765);
		//System.out.println(dll.first.next.prev);
		dll.insertNodeAtPosition(0, 1);
		dll.insertNodeAtPosition(6, 7);
		//dll.print();
		dll.insertNodeAtPosition(2, 2);
		dll.insertNodeAtPosition(4, 4);
		dll.print();
		dll.printReverse();
		System.out.println("Reversing list...");
		dll.reverse();
		dll.print();
		dll.printReverse();
		
		System.out.println(dll.get(0));
		System.out.println(dll.get(2));
		System.out.println(dll.get(8));
		System.out.println("Length is : "+dll.length());
		System.out.println(dll.contains(233));
		System.out.println(dll.contains(656));
		System.out.println("Deleting first node..");
		dll.deleteFirstNode();
		dll.print();
		dll.printReverse();
		System.out.println("Deleting last node..");
		dll.deleteLastNode();
		dll.print();
		dll.printReverse();
		System.out.println("Length is : "+dll.length());
		System.out.println("Deleting node at position 1..");
		dll.deleteNodeAtPosition(1);
		dll.print();
		dll.printReverse();
		System.out.println("Deleting node at position 4..");
		dll.deleteNodeAtPosition(4);
		dll.print();
		dll.printReverse();
		dll.deleteNodeAtPosition(4);
		dll.print();
		dll.printReverse();
	}
	
}
