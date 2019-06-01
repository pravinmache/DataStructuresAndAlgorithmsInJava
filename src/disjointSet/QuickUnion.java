package disjointSet;

public class QuickUnion {
	
	private int[] id;
	public QuickUnion(int n) {
		this.id = new int[n];
		for(int i = 0;i < n;i++)
			id[i] = i;
	}
	
	public void union(int p, int q) {
		if(getRoot(p) == getRoot(q))
			return;
		
		id[p] = q;
	}
	
	private int getRoot(int p) {
		while(id[p] != p)
			p = id[p];
		
		return p;
	} 
	
	public boolean find(int p, int q) {
		if(getRoot(p) == getRoot(q))
			return true;
		
		return false;
	}
	
	//driver method
	public static void main(String[] args) {
		QuickUnion  qf = new QuickUnion(20);
		System.out.println("1 and 5 connected? - "+qf.find(1, 5));
		qf.union(1, 5);
		System.out.println("1 and 5 connected? - "+qf.find(1, 5));
		qf.union(10, 11);
		qf.union(11, 12);
		qf.union(12, 13);
		System.out.println("10 and 13 connected? - "+qf.find(10, 13));
		qf.union(7, 9);
		qf.union(1, 13);
		System.out.println("1 and 13 connected? - "+qf.find(1, 13));
		System.out.println("1 and 19 connected? - "+qf.find(1, 19));
		
	}
	
}
