public class Graph {
	private class AdjArray implements AdjList {
		private int v; // what vertex we are interested in
		private int i; // so we can keep track of where we are
		public AdjArray(int v) {
		// write the code for the constructors
		// save the value of the vertex passed in
		// (that will be where the iterator starts)
		// start the “i” counter at negative one
			this .v = v;
			this.i = -1;
		}
		public int next() { // perhaps the trickiest method
		// use a for loop to advance the value of “i”
		// “for (++i; i < vertices(); i++)”
		// and search the appropriate row return the index
		// of the next true value found
		// “if (connected(v,i) == true) return i;”
		// if the loop completes without finding anything return -1
			for(++i; i < vertices(); i++)
				if(connected(v,i))
					return i;
			return -1;
		}
		public int begin() {
		// reset “i” back to negative one
		// return the value of a call to “next”
			i = -1;
			return this.next();
		}
		public boolean end() {
		// if “i” is less than the number of vertices return false
			return (i < vertices()) ? false : true;
		}
	}
	private int vertexCount, edgeCount;
	boolean directed;
	private boolean adj[][];
	public Graph(int numVerticies, boolean isDirected) { 
		this.vertexCount = numVerticies;
		this.directed = isDirected;
		adj = new boolean[vertexCount][vertexCount];
	}
	public boolean isDirected() { 
		// your code here 
		return directed;
	}
	public int vertices() { 
		// return the number of vertices 
		return vertexCount;
	}
	public int edges() { 
		// return number of edges 
		return edgeCount;
	}
	public void insert(Edge e) { 
		// your code here 
		if(adj[e.v][e.w]) return;
		if(isDirected())adj[e.v][e.w] = true;
		else adj[e.v][e.w] = adj[e.w][e.v] = true;
		edgeCount++;
	}	
	public void delete(Edge e) { 
		// your code here 
		if(!adj[e.v][e.w]) return;
		if(isDirected())adj[e.v][e.w] = false;
		else adj[e.v][e.w] = adj[e.w][e.v] = false;
		edgeCount++;
	}
	public boolean connected(int node1, int node2) { 
		//are they connected? 
		return adj[node1][node2];
	}
	public AdjList getAdjList(int vertex) { 
		// your code here 
		return new AdjArray(vertex);
	}
	public void show () {
		for (int s = 0; s < vertices(); s++) {
			System.out.print(s + ": ");
			AdjList A = getAdjList(s);
			int t;
			for (t = A.begin(); !A.end(); t = A.next()) // use of iterator
				System.out.print(t +" ");
			System.out.println();
		}
	}
}