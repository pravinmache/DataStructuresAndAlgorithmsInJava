package ds;

/**
 * Stack data structure implementation in Java with Generic Type.
 * Stack is implemented using circular linked list. Reference to last node is stored in 'rear'.
 * @author Pravin Mache
 * @email pravinmache@gmail.com
 *
 * @param <T>
 */
public class StackWithLL<T> {

	private Node rear;
	private int size;
	class Node{
	
		T data;
		Node next;
		Node(T data){
			this.data = data;
		}
	}
	
	public boolean isEmpty() {
		return rear == null;
		
	}
	public void push(T data) {
		if(rear == null) {
			rear = new Node(data);
			rear.next = rear;
			size++;
		}
		else {
			Node newNode = new Node(data);
			newNode.next = rear.next;
			rear.next = newNode;
			size++;
		}
		
	}
	
	public Node pop() {
		Node top = null;
		if(rear.next != null) {
			top = rear.next;
			size--;
			if(top == rear) {
				rear = null;
			}
			else {
				rear.next = top.next;
			}
		}
		
		return top;
	}
	
	public int size() {
		return size;
	}
	public Node peek() {
		if(rear.next != null) {
			return rear.next;
		}
		else {
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		StackWithLL<Integer> stack = new StackWithLL<>();
		stack.push(12);
		stack.push(123);
		stack.push(54);
		stack.push(54);
		System.out.println(stack.peek().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println(stack.pop().data);
		System.out.println("Size:"+stack.size());
		System.out.println(stack.pop().data);
	}
}


