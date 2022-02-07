public class Main {
	
	public static void main(String[] args) {
		
		MyDoublyLinkedList<String> list = new MyDoublyLinkedList<>();
		System.out.println(list.isEmpty());
		list.insert("men");
		list.insert("women");
		list.insert("girls");
		list.printList();
		list.printListRev();
		list.insert("girls");
		list.printList();
		list.printListRev();
		System.out.println(list.lookup("girls"));
		list.delete("girls");
		System.out.println(list.lookup("girls"));
		list.printList();
		list.printListRev();
	}
}
