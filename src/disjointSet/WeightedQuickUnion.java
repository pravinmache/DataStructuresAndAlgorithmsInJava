package disjointSet;

import java.util.Arrays;

public class WeightedQuickUnion {
	
	private int id[];
	private int w[];
	
	WeightedQuickUnion(int n){
		this.id = new int[n];
		this.w = new int[n];
		
		for(int i = 0;i<n;i++) {
			id[i] = i;
			w[i] = 1;
		}
	}
	
	
	private int getRoot(int p) {
		
		while(p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}	
		
		return p;
	}
	
	public boolean find(int p, int q) {
		return getRoot(p) == getRoot(q);
			
	}
	
	public void union(int p, int q) {
		int root_p = getRoot(p);
		int root_q = getRoot(q);
		//System.out.println("Root of "+p+ " - "+root_p);
		//System.out.println("Root of "+q+ " - "+root_q);
		if(root_p != root_q) {
			if(w[root_p] < w[root_q]) {
				id[root_p] = root_q;
				w[root_q] += w[root_p];
				
			}
			else {
				id[root_q] = root_p;
				w[root_p] += w[root_q];
			}
			
		}
		
	}
	
	public void printWeight() {
		System.out.println(Arrays.toString(w));
	}
	
	public void printId() {
		System.out.println(Arrays.toString(id));
	}
	
	
	public static void main(String[] args) {
		WeightedQuickUnion  qf = new WeightedQuickUnion(20);
	
		System.out.println("1 and 5 connected? - "+qf.find(1, 5));
		qf.union(1, 5);
		System.out.println("1 and 5 connected? - "+qf.find(1, 5));
		qf.union(10, 11);
		qf.union(11, 12);
		qf.union(12, 13);
		qf.union(13, 1);
		System.out.println("10 and 13 connected? - "+qf.find(10, 13));
		qf.union(7, 9);
		qf.union(1, 13);
		System.out.println("1 and 13 connected? - "+qf.find(1, 13));
		System.out.println("1 and 19 connected? - "+qf.find(1, 19));
		qf.printId();
		qf.printWeight();
	}
	

}
