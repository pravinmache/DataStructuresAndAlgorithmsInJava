package ds;

/**
 * Circular Linked List representation in Java. 
 * @author Pravin Mache
 *
 * @param <T>
 */
public class CircularLinkedList<T> {
	
	private Node rear;
	
	private int length;
	
	private class Node{
		T data;
		Node next;
		
		Node(T data){
			this.data = data;
		}
	}

	public int length() {
		return length;
	}
	
	public boolean removeNodeAtPosition(int position) {
		if(rear == null || position > length - 1 || position <0) {
			return false;
		}
		else {
			Node current = rear.next;
			if(position == 0) {
				rear.next = current.next;
				length--;
			}
			else{
				int count = 0;
				while(count < position - 1) {
					current = current.next;
					count++;
				}
				if(position == length - 1) {
					current.next  = rear.next;
					rear = current;
				}
				else {
					current.next = current.next.next;
					
				}
				length--;
			}
			
		}
		
		return true;
	}
	
	public void addNodeAtTheBeginning(T data) {
		Node newNode = new Node(data);
		if(rear == null) {
			rear = newNode;
			rear.next = newNode;
			
		}
		else {
			newNode.next = rear.next;
			rear.next = newNode;
		}
		length++;
	}
	
	
	public void addNodeAtTheEnd(T data) {
		Node newNode = new Node(data);
		if(rear == null) {
			rear= newNode;
			rear.next = newNode;
			
		}
		else {
			newNode.next = rear.next;
			rear.next = newNode;
			rear = newNode;
			
		}
		length++;
		
	}
	
	public void print() {
		Node current = rear.next;
		if(current == null) {
			return;
		}
		while(current != rear) {
			System.out.print(current.data+"  ");
			current = current.next;	
		}
		System.out.print(current.data);
	
	}
	
	
	public static void main(String[] args) {
		CircularLinkedList<Integer> cll = new CircularLinkedList<>();
		cll.addNodeAtTheBeginning(43);
		cll.addNodeAtTheBeginning(123);
		cll.addNodeAtTheBeginning(12);
		cll.addNodeAtTheEnd(544);
		cll.addNodeAtTheEnd(654);
		cll.addNodeAtTheEnd(653);
		cll.print();
		System.out.println();
		cll.removeNodeAtPosition(5);
		cll.removeNodeAtPosition(0);
		cll.removeNodeAtPosition(3);
		cll.print();
	}
	
	
	
}
