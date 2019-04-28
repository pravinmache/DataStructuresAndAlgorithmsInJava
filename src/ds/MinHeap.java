package ds;

import java.util.Arrays;

public class MinHeap {
	
	private int heap[];
	private int size;
	
	public MinHeap(int capacity) {
		heap = new int[capacity];
		size = 0;
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == heap.length;
	}
	
	public int getParent(int index) {
		if(index > 0)
			return (index -1)/2;
		else
			return -1;
	}
	
	public void insert(int data) {
		if(isFull())
			throw new IndexOutOfBoundsException("Heap is full.");
		
		heap[size] = data;
		if(size > 0) {
			fixHeapAbove(size);
		}
		
		size++;
	}
	
	public void fixHeapAbove(int index) {
		int current = index;
		int parent = getParent(index);
		while(heap[current] < heap[parent] && current >0) {
			int temp = heap[current];
			heap[current] = heap[parent];
			heap[parent] = temp;
			current = parent;
			parent = getParent(current);
			
		}
	}
	
	public void print() {
		
		System.out.println(Arrays.toString(heap));
		
	}
	
	
	//driver method
	public static void main(String[] args) {
		MinHeap heap = new MinHeap(10);
		heap.insert(4);
		heap.insert(10);
		heap.insert(12);
		heap.insert(19);
		heap.print();
	}
	
	

}
