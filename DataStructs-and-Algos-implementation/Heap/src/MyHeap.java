public class MyHeap<T extends Comparable<T>> implements Heap<T> {
	Object [] TObj;
	int currentSize, capacity;
	public MyHeap() {
		// TODO Auto-generated constructor stub
		this.capacity = 10;
		TObj = new Object[capacity];
	}
	public MyHeap(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity < 2 ? 2 : capacity;
		TObj = new Object[this.capacity];
	}
	public MyHeap(Object [] TObj) {
		// TODO Auto-generated constructor stub
		this.TObj = new Object[TObj.length*2];
		for(int i = 0; i < TObj.length; i++) 
			this.TObj[i+1] = TObj[i];
		currentSize = TObj.length;
		capacity = this.TObj.length;
		this.heapify();
	}
	
	@Override
	public void insert(T item) {
		// TODO Auto-generated method stub
		if(currentSize >= capacity/2)
			expandArray();
		TObj[++currentSize] = item;
		bubbleUp(currentSize);
	}
	@SuppressWarnings("unchecked")
	private void bubbleUp(int Tindex) {
		while(true) {
			if(Tindex == 1 || ((T)TObj[Tindex]).compareTo((T)TObj[Tindex/2]) < 0)
				break;
			else {
				Object temp = TObj[Tindex];
				TObj[Tindex] = TObj[Tindex/2];
				TObj[Tindex/2] = temp;
				Tindex = Tindex/2;
			}
		}	
	}
	public void printHeap() {
		System.out.print("[ ");
		if(currentSize > 0) {
			for(int i = 1; i < TObj.length-1; i++)
				if(TObj[i] != null)
					System.out.print(TObj[i]+" ");
			System.out.println("]");
		}else
			System.out.println("]");
	}
	private void expandArray() {
		capacity *= 2;
		Object[] TObj_New = new Object[capacity];
		for(int i = 0; i < capacity/2; i++)
			TObj_New[i] = TObj[i];
		TObj = TObj_New;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return currentSize == 0  ? true : false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public T deleteMax() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T tMax = (T)TObj[1]; 
		if(currentSize>0) {
			TObj[1] = TObj[currentSize];
			TObj[currentSize--] = null;
			bubbleDown(1);
		}
		return tMax;
	}
	@SuppressWarnings("unchecked")
	public void bubbleDown(int Tindex) {
		while(true) {
			Object temp = TObj[Tindex];
			if(TObj[Tindex*2+1] == null) {
				if(TObj[Tindex*2] != null) {
					if(((T)TObj[Tindex*2]).compareTo((T)TObj[Tindex]) > 0) {
						TObj[Tindex] = TObj[Tindex*2];
						TObj[Tindex*2] = temp;
					}
				}
				break;
			}
			if(Tindex > currentSize || ((T)TObj[Tindex]).compareTo((T)TObj[Tindex*2]) >= 0 && ((T)TObj[Tindex]).compareTo((T)TObj[Tindex*2+1]) >= 0)
				break;
			else {
				TObj[Tindex] = ((T)TObj[Tindex*2]).compareTo((T)TObj[Tindex*2 + 1]) > 0 ? TObj[Tindex*2] : TObj[Tindex*2 + 1];
				if(((T)TObj[Tindex]).compareTo((T)TObj[Tindex*2]) == 0) {
					Tindex*=2;
					TObj[Tindex] = temp;
				}
				else {
					Tindex=Tindex*2+1;
					TObj[Tindex] = temp;
				}
			}
		}
	}
	
	public void heapify() {
		int Tindex = currentSize/2;
		while(Tindex > 0) {
			bubbleDown(Tindex);
			Tindex--;
		}
	}
}
