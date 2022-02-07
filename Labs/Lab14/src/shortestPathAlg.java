import MyGraph.Graph;
import MyQueue.MyQueue;
import MyStack.MyStack;

public class shortestPathAlg {
	static class Vertex {
		int data;
		Vertex prev;
		Vertex(int data, Vertex prev) {
			this.data = data;
			this.prev = prev;
		}
	}
	public static void unweighted (Graph g, int start, int end) {
		MyQueue<Vertex> queue = new MyQueue<>();
		boolean [] isVisited = new boolean[g.vertices()];
		queue.enqueue(new Vertex(start, null));
		isVisited[start] = true;
		Vertex V = null;
		while(!queue.isEmpty()) {
			V = queue.dequeue();
			if (V.data == end)
				break;
			for(Integer data : g.adj(V.data)) {
				if(!isVisited[data]) {
					queue.enqueue(new Vertex(data, V));
					isVisited[data] = true;
				}
			}
		}
		MyStack<Integer> stack = new MyStack<>();
		if(V.data == end) {
			while(V.prev != null) {
				stack.push(V.data);
				V = V.prev;
			}
			stack.push(V.data);
			System.out.print("Path: ");
			while(!stack.isEmpty()) System.out.print(stack.pop()+" ");
		}else {
			System.out.println("no path");
		}
	}
}