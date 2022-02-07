public class Main {
	
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		
		System.out.println(list.isEmpty());
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		list.printList();
		
		System.out.println(list.contains(4));
		
		System.out.println(list.lookup(2));
		
		list.delete(1);
		
		list.printList();
	}
}
