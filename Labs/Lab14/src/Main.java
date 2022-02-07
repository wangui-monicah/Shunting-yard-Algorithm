import MyGraph.Graph;

public class Main {
	public static void main(String [] args) {
		Graph g = Graph.createFromFile("910");
		g.show();
		shortestPathAlg.unweighted(g, 2, 6);
	}
}