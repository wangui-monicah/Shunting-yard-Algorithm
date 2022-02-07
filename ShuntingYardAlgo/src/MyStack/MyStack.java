package MyStack;
import MyLinkedList.MyLinkedList;

public class MyStack<AnyType> implements Stack<AnyType>{
	MyLinkedList<AnyType> list;
	public MyStack() {
		// TODO Auto-generated constructor stub
		 list = new MyLinkedList<AnyType>();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public void push(AnyType x) {
		// TODO Auto-generated method stub
		list.insert(x);
	}

	@Override
	public AnyType pop() {
		// TODO Auto-generated method stub
		if(!this.isEmpty())
			return list.pop().data;
		return null;
	}

	@Override	
	public AnyType peek() {
		// TODO Auto-generated method stub
		return list.peek();
	}

}
