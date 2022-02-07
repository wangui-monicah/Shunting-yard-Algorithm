package MyDoublyLinkedList;
public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType>{
	MyDoubleNode<AnyType> head = new MyDoubleNode<>();
	MyDoubleNode<AnyType> tail = new MyDoubleNode<>();
	public MyDoublyLinkedList() {
		// TODO Auto-generated constructor stub
		head.next = tail;
		tail.prev = head;
	}
	@Override
	public void insert(AnyType x) {
		// TODO Auto-generated method stub
		if(!this.contains(x)) {
			MyDoubleNode<AnyType> newNode = new MyDoubleNode<>();
			newNode.data = x;
			newNode.prev = head;
			newNode.next = head.next;
			head.next.prev = newNode;
			head.next = newNode;
		}
	}

	@Override
	public void delete(AnyType x) {
		// TODO Auto-generated method stub
		MyDoubleNode<AnyType> node = head.next;
		if(this.contains(x)) {
			while(node!=tail) {
				if(node.data.equals(x)) {
					node.prev.next = node.next;
					node.next.prev = node.prev;
					node.next = null;
					node.prev = null;
					break;
				}
				node = node.next;
			}
		}
		
	}

	@Override
	public boolean contains(AnyType x) {
		// TODO Auto-generated method stub
		MyDoubleNode<AnyType> node = head.next;
		while(node != tail) {
			if(node.data.equals(x))
				return true;
			node = node.next;
		}
		return false;
	}

	@Override
	public AnyType lookup(AnyType x) {
		// TODO Auto-generated method stub
		if(contains(x))
			return x;
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(head.next == tail)
			return true;
		return false;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		MyDoubleNode<AnyType> node = head.next;
		while(node != tail) {
			System.out.print(node.data +" ");
			node = node.next;
		}
		System.out.println();
	}

	@Override
	public void printListRev() {
		// TODO Auto-generated method stub
		MyDoubleNode<AnyType> node = tail.prev;
		while(node != head) {
			System.out.print(node.data +" ");
			node = node.prev;
		}
		System.out.println();
		
	}
	
	public void enqueue(AnyType x) {
		MyDoubleNode<AnyType> node = new MyDoubleNode<AnyType>();
		node.data = x;
		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
	}
	
	public MyDoubleNode<AnyType> dequeue() {
		MyDoubleNode<AnyType> first = head.next;
		head.next = first.next;
		first.next.prev = head;
		first.next = null;
		first.prev = null;
		return first;
	}
	public AnyType peek() {
		return head.next.data;
	}
}
