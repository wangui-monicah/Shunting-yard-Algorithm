public class Main {
	public static void main(String[] args) {
		MyHeap<Integer> heap = new MyHeap<>(1);
		heap.insert(9);
		heap.insert(6);
		heap.insert(3);
		heap.insert(4);
		heap.insert(1);
		heap.insert(3);
		heap.insert(2);
		heap.insert(1);
		heap.insert(10);
		System.out.println(heap.size());
		System.out.println(heap.isEmpty());
		heap.printHeap();
		System.out.println(heap.deleteMax());
		heap.printHeap();
		System.out.println(heap.deleteMax());
		heap.printHeap();
		System.out.println(heap.deleteMax());
		heap.printHeap();
		MyHeap<Integer> heap2 = new MyHeap<>(new Object [] {3,2,30,1,9,12,4,13,6,28,1,3});
		heap2.printHeap();
	}
}