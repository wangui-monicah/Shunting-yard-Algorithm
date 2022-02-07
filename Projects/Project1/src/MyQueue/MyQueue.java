package MyQueue;
import MyDoublyLinkedList.MyDoublyLinkedList;

public class MyQueue<AnyType> implements Queue<AnyType>{
	MyDoublyLinkedList<AnyType> list = new MyDoublyLinkedList<AnyType>();
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void enqueue(AnyType x) {
		// TODO Auto-generated method stub
		list.enqueue(x);
	}

	@Override
	public AnyType dequeue() {
		// TODO Auto-generated method stub
		if(!this.isEmpty()) 
			return list.dequeue().data;
		return null;
	}

	@Override
	public AnyType peek() {
		// TODO Auto-generated method stub
		return list.peek();
	}

}
