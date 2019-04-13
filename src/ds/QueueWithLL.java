package ds;

/**
 * Queue data structure implementation in Java with generic type.
 * 
 * @author Pravin Mache
 * @email pravinmache@gmail.com
 *
 * @param <T>
 */
public class QueueWithLL<T> {
	
	private Node front, rear;
	private int length;
	
	class Node{
		T data;
		Node next;
		Node(T data){
			this.data = data;
		}
	}
	
	public void enqueue(T data) {
		
		if(front == null) {
			front  = new Node(data);
			rear = front;
			
		}
		else {
			Node newNode = new Node(data);
			rear.next = newNode;
			rear = newNode;
			
		}
		length++;
	}
	
	public Node dequeue() {
		if(front == null) {
			return null;
		}
		else if(front == rear) {
			Node removedNode = front;
			front = null;
			rear = null;
			length--;
			return removedNode; 
		}
		else {
			Node removedNode = front;
			front = front.next;
			length--;
			return removedNode;
		}
	}
	
	public int length() {
		return length;
	}
	
	public static void main(String[] args) {
		QueueWithLL<Integer> queue = new QueueWithLL<>();
		queue.enqueue(34);
		queue.enqueue(54);
		queue.enqueue(74);
		queue.enqueue(87);
		queue.enqueue(2);

		System.out.println(queue.dequeue().data);
		System.out.println(queue.dequeue().data);
		System.out.println(queue.dequeue().data);
		System.out.println(queue.dequeue().data);
		System.out.println("Length : "+queue.length());
		System.out.println(queue.dequeue().data);
		System.out.println(queue.dequeue().data);
		
	}
	
}
