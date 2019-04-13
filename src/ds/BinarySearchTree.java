package ds;

public class BinarySearchTree {

	private Node root;
	private int size;
	
	private class Node{
		
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
		}
	}
	
	public Node getRoot() {
		return root;
	}
	public int size() {
		return size;
	}
	
	public void insertNode(int data) throws DuplicateElementException {
		if(root == null) {
			root = new Node(data);
			size++;
			
		}
		else {
			Node temp = root;
			while(true) {
				
				if(data < temp.data && temp.left != null) {
					if(temp.data == data) {
						throw new DuplicateElementException("Element is already present in tree : "+data);
					}
					temp = temp.left;
				}
				else if(data >= temp.data && temp.right != null) {
					if(temp.data == data) {
						throw new DuplicateElementException("Element is already present in tree : "+ data);
					}
					temp = temp.right;
				}
				else if(data < temp.data && temp.left == null) {
					temp.left = new Node(data);
					size++;
					break;
				}
				else {
					temp.right = new Node(data);
					size++;
					break;
				}
				
			}
			
		}
		
	}
	
	
	public boolean deleteNode(int data, Node root) throws NoSuchElementException, EmptyTreeException {
		boolean isDeleted = false;
		Node temp = root;
		while(true) {
			if(temp.data == data) {
				
				break;
			}
			else if(data < temp.data && temp.left != null) {
				temp = temp.left;
			}
			else if(data < temp.data && temp.left == null){
				throw new NoSuchElementException(" : "+data);
				
			}
			else if(data >= temp.data && temp.right != null) {
				temp = temp.right;
			}
			else if(data >= temp.data && temp.right == null){
				throw new NoSuchElementException(""+data);
				
			}
		
		}
		
		if(temp.left == null && temp.right == null) {
			temp =null;
			isDeleted = true;
			size--;
		}
		else if(temp.right == null && temp.left!= null) {
			temp = temp.left;
			isDeleted = true;
			size--;
		}
		else if(temp.left == null && temp.right != null) {
			temp = temp.right;
			isDeleted =true;
			size--;
		}
		else {
			System.out.println(temp.data);
			int max= findMax(temp.left);
			
			System.out.println(max);
			
			
		}
		
		
		return isDeleted;
		
		
	}
	
	
	public int findMax(Node node) throws EmptyTreeException {
		Node temp = node;
		if(temp == null) {
			throw new EmptyTreeException("Tree is empty.");
		}
		while(temp.right != null) {
			temp = temp.right;
		}
		
		return temp.data;
		
	}
	
	public void printPreorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data+"  ");
		printPreorder(node.left);
		printPreorder(node.right);
		
	}
	
	public void printInorder(Node node) {
		if(node == null )
			return;
		printInorder(node.left);
		System.out.print(node.data+"  ");
		printInorder(node.right);
	}
	
	public void printPostorder(Node node) {
		if(node == null) {
			return;
		}
		
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data+"  ");
		
	}
	
	
	public static void main(String[] args) throws DuplicateElementException, NoSuchElementException, EmptyTreeException {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insertNode(50);
		bst.insertNode(70);
		bst.insertNode(10);
		bst.insertNode(20);
		bst.insertNode(66);
		bst.insertNode(75);
		bst.insertNode(25);
		bst.insertNode(67);
		bst.insertNode(80);
		bst.insertNode(15);
		bst.insertNode(5);
		bst.insertNode(4);
		bst.deleteNode(70, bst.getRoot());
	}
	
	
}


class DuplicateElementException extends Exception{

	private static final long serialVersionUID = 1L;
	public DuplicateElementException(String message) {
		super(message);
	}
	
}

class EmptyTreeException extends Exception{

	private static final long serialVersionUID = 1L;
	public EmptyTreeException(String message) {
		super(message);
	}
	
}

class NoSuchElementException extends Exception{

	private static final long serialVersionUID = 1L;
	public NoSuchElementException(String message) {
		super(message);
	}
	
}