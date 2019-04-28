package ds;

import java.util.Arrays;

public class MaxHeap {

	private int heap[];	
	private int size;
	
	/**
	 * 
	 * @param capacity
	 */
	public MaxHeap(int capacity) {
		heap = new int[capacity];
		size = 0;
	}

	
	/**
	 * Returns count of elements in heap
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Check if Heap is empty	
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns index of parent node;
	 * @param index
	 * @return
	 */
	public int getParent(int index) {
		return (index - 1)/2;
		
	}
	
	/**
	 * Inserts node in Heap.
	 * @param data
	 * @throws IndexOutOfBoundsException is heap is full
	 */
	public void insert(int data) {
		if(isFull())
			throw new IndexOutOfBoundsException("Heap is full.");

		heap[size] = data; // initially node is inserted at the the end of array;
		if(size != 0) { // if inserted node is not root node fix the heap.
			fixHeapAbove(size); // Find right position for newly inserted element

		}
		size++;
	}
	
	/**
	 * We need to fix heap element is deleted from heap or new elment is inserted in heap
	 * @param index
	 */
	public void fixHeapAbove(int index) {
		int current = index;
		int parent = getParent(index);
		while(current > 0 && heap[current] > heap[parent] ) {
			int temp = heap[parent];
			heap[parent] = heap[current];
			heap[current] = temp;
			current = parent;
			parent = getParent(current);

		}
	}

	public int deleteNode(int index) {
		int deletedValue = heap[index];
		heap[index] = heap[size -1];
		int parentIndex = getParent(index);
		if(index == 0) {
			fixHeapBelow(index, size - 1);
			
		}
		else if(heap[parentIndex] < heap[index]) {
			fixHeapAbove(index);
		}
		else {
			fixHeapBelow(index, size -1 );
		}
		size--;
		return deletedValue;
	}

	public int getLeftChild(int index) {
		return 2 * index +1;
	}

	public int getRightChild(int index) {
		return 2 * index + 2;

	}

	public void fixHeapBelow(int current, int lastHeapIndex) {
		
		while(current <= lastHeapIndex) {
			int indexToSwap;
			
			int leftChildIndex = getLeftChild(current);
			int rightChildIndex = getRightChild(current);
			if(leftChildIndex <= lastHeapIndex) {
				if(rightChildIndex > lastHeapIndex) {
					indexToSwap = leftChildIndex;
				}
				else {
					indexToSwap = (heap[leftChildIndex] > heap[rightChildIndex]) ? leftChildIndex : rightChildIndex;
				}
				
				if(heap[indexToSwap] > heap[current]) {
					int temp = heap[indexToSwap];
					heap[indexToSwap] = heap[current];
					heap[current] = temp;;
				}
				else {
					break;
				}
				current = indexToSwap;
			}
			else {
				break;
			}
			
			
		}
	}

	/**
	 * Returns true if heap is full
	 * @return
	 */
	public boolean isFull() {
		return size == heap.length;

	}
	
	
	public void print() {
		System.out.println(Arrays.toString(heap));
	}

	//driver method
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(10);
		heap.insert(80);
		heap.insert(75);
		heap.insert(60);
		heap.insert(68);
		heap.insert(55);
		heap.insert(40);
		heap.insert(52);
		heap.insert(67);
		//heap.print();
		System.out.println("size:"+heap.getSize());
		heap.deleteNode(0);
		
		heap.print();
		
	}

}
