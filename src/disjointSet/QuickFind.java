package disjointSet;

public class QuickFind {
	
	private int[]  id;
	
	public QuickFind(int n) {
		this.id = new int[n];
		for(int i = 0;i < n;i++)
			id[i] = i;
	}
	
	
	public boolean find(int p,int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		if(id[p] ==  id[q]) //check if two components are already connected. if connected, return
			return;
		
		int id_p = id[p];
		int id_q = id[q];
		for(int i= 0; i < id.length; i++)
			if(id[i] == id_q)
				id[q] = id_p;
		
	}
	
	
	//driver method
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(20);
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
