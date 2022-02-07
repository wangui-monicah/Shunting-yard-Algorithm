public class Main {
	
	public static void main(String[] args) {
		MyQueue<String> stack = new MyQueue<>();
		System.out.println(stack.isEmpty());
		stack.enqueue("girl");
		stack.enqueue("boy");
		stack.enqueue("woman");
		stack.enqueue("man");
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.dequeue());
		System.out.println(stack.peek());
	}
}
