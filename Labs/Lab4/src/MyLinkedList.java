public class MyLinkedList<AnyType> implements SimpleLinkedList<AnyType> {
	MyNode<AnyType> head = new MyNode<>();

	@Override
	public void insert(AnyType x) {
		// TODO Auto-generated method stub
		MyNode<AnyType> node = new MyNode<>();
		node.data = x;
		
		if(head.next == null)
			head.next = node;
		
		else {
			node.next = head.next;
			head.next = node;
		}
	}

	@Override
	public void delete(AnyType x) {
		// TODO Auto-generated method stub
		if(contains(x)) {
			MyNode<AnyType> node = head.next;
			MyNode<AnyType> prev = head;
			while(node != null) {
				if(node.data == x) {
					prev.next = node.next;
					node.next = null;
					break;
				}
				prev = node;
				node = node.next;
			}
		}
	}

	@Override
	public boolean contains(AnyType x) {
		// TODO Auto-generated method stub
		if(head.next == null)
			return false;

		MyNode<AnyType> node = head.next;
		while(node != null) {
			if(node.data == x)
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
		if(head.next == null)
			return true;
		return false;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		MyNode<AnyType> node = head.next;
		while(node != null) {
			System.out.print(node.data+" ");
			node= node.next;
		}
		System.out.println();
	}
	
}
