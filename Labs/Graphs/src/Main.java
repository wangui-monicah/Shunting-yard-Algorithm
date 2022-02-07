public class Main {
	public static void main(String[] args) {
		Graph g = new Graph(4, true);
		g.insert(new Edge(0, 1));
		g.insert(new Edge(0, 3));
		g.insert(new Edge(2, 0));
//		System.out.println(g.connected(3,0));
		g.show();
	}
}
