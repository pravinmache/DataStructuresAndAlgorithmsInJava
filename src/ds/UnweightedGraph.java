package ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Edge{
	
	int startVertex;
	int endVertex;
	
	Edge(int from, int to){
		startVertex = from;
		endVertex = to;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null) 
			return false;
		
		if(obj.getClass() != this.getClass())
			return false;
		
		Edge edge = (Edge)obj;
		return (this.startVertex == edge.startVertex && this.endVertex == edge.endVertex);
	}
}



public class UnweightedGraph<T> {

	private List<T> Vertices; 
	private List<Edge> Edges;
	
	UnweightedGraph(){
		Vertices = new ArrayList<>();
		Edges = new ArrayList<>();
	}
	
	public int getIndexOfVertex(T vertex) {
		return Vertices.indexOf(vertex);
	}
	
	public boolean addEdge(T fromVertex, T toVertex) {
		int from = getIndexOfVertex(fromVertex);
		int to = getIndexOfVertex(toVertex);
		//check if vertices exist in list or not
		if(from == -1 || to == -1) 
			return false;
		
		if(from == to)
			return false;
		
		//if both vertices exist first check if there is already edge between them
		Edge newEdge = new Edge(from, to);
		Edge newEdge2 = new Edge(to, from);
		//if there is an Edge between give to vertices don't add new edge
		if(Edges.contains(newEdge) || Edges.contains(newEdge2)) {
			
			return false;
		}
		//if Edge doesn't exist between vertices, add new edge
		else {
			Edges.add(newEdge);
			return true;
			
		}
		
	}
	
	public int addVertex(T data) {
		if(!Vertices.contains(data)) {
			Vertices.add(data);
			return Vertices.indexOf(data);
		}else {
			return -1;
		}
	}
	
	public Set<T> getListOfConnectedVertices(T vertex){
		Set<T> connectedVertices = new HashSet<>();
		
		if(!Vertices.contains(vertex)) {
			return connectedVertices;
		}
		else {
			int index = getIndexOfVertex(vertex);
			for(Edge edge : Edges) {
				if(edge.startVertex == index) {
					connectedVertices.add(Vertices.get(edge.endVertex));
				}
				else if(edge.endVertex == index) {
					connectedVertices.add(Vertices.get(edge.startVertex));
				}
				
			}
		}
		
		return connectedVertices;
	}
	
	//Remove vertex and all edges
	public boolean removeVertex(T vertex) {
		if(getIndexOfVertex(vertex) == -1) {
			return false;
		}
		else {
			int index = getIndexOfVertex(vertex);
			List<Integer> indexToRemove = new ArrayList<>();
			int i = 0;
			for(Edge edge : Edges) {
				
				if(index == edge.startVertex || index == edge.endVertex) {
					indexToRemove.add(i);
				}
				i++;
			}
			
			for(int j = 0; j < i;j++) {
				Edges.remove(j);
			}
			
		}
		return true;
		
	}
	
	public boolean removeEdge(Edge edge) {
		return Edges.remove(edge);
	}
	
	
	
	//finds Path Between to vertices using Breadth First Search
	public Set<T> findPathBetweenVertices(T from, T to) {
		Set<T> path = new LinkedHashSet<>();
		int fromIndex = getIndexOfVertex(from);
		int toIndex = getIndexOfVertex(to);
		//check if both vertices exist in list, if not return empty set
		if(fromIndex == -1 || toIndex == -1) {
			return path;
		}
		
		Set<T> connectedVertices = getListOfConnectedVertices(from);
		//check if Vertex is isolated vertex i.e. connected vertices are 0. 
		if(connectedVertices.size() == 0){
			return path;
		}
		//if from vertex is directly connected to vertex return path 
		else if(connectedVertices.contains(to)) {
			path.add(from);
			path.add(to);
			return path;
		}
		else {
			List<T> queue = new ArrayList<>();
			queue.addAll(connectedVertices);
			Set<T> visitedVertices = new HashSet<>();
			visitedVertices.add(from);
			path.add(from);
			while(true) {
				
				T current = queue.get(0);
				queue.remove(current);
				
				if(visitedVertices.contains(current)) {
					
				}else {
					visitedVertices.add(current);
					Set<T> connectedToCurrent = getListOfConnectedVertices(current);
				
					if(connectedToCurrent.contains(to)) {
						path.add(current);
						path.add(to);
						break;
					}
					else {
						path.add(current);
						for(T vertex : connectedToCurrent) {
							if(!visitedVertices.contains(vertex)) {
								queue.add(vertex);
							}
						}
						if(queue.size() == 0) {
							path.removeAll(visitedVertices);
							break;
						}
					}
				}
				
			}
			
		}
		
		return path;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnweightedGraph<String> cities =new UnweightedGraph<>();
		
		cities.addVertex("Pune");
		cities.addVertex("Mumbai");
		cities.addVertex("Nagpur");
		cities.addVertex("Chandrapur");
		cities.addVertex("Beed");
		cities.addVertex("Akola");
		cities.addEdge("Pune", "Mumbai");
		cities.addEdge("Pune", "Beed");
		cities.addEdge("Pune", "Nagpur");
		cities.addEdge("Nagpur","Chandrapur" );
		//Test - verify that duplicate vertex cannot be added
		System.out.println(cities.addEdge("Mumbai", "Pune"));
		System.out.println("Vertices connected to Pune :");
		System.out.println(cities.getListOfConnectedVertices("Pune"));
		System.out.println("Vertices connected to Mumbai :");
		System.out.println(cities.getListOfConnectedVertices("Mumbai"));
		System.out.println("Vertices connected to Chandrapur :");
		System.out.println(cities.getListOfConnectedVertices("Chandrapur"));
		
		System.out.println("Path Between Mumbai and Chandrapur :"+cities.findPathBetweenVertices("Mumbai", "Chandrapur"));
		
		System.out.println("Path Between Beed and Chandrapur :"+cities.findPathBetweenVertices("Beed", "Chandrapur"));
		System.out.println("Path Between Mumbai and Akola :"+cities.findPathBetweenVertices("Mumbai", "Akola"));
		cities.addEdge("Nagpur","Akola" );
		cities.addEdge("Mumbai", "Pune");
		System.out.println("Path Between Mumbai and Akola :"+cities.findPathBetweenVertices("Mumbai", "Akola"));
	}

}
