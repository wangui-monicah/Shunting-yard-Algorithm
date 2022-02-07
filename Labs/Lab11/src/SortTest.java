import java.util.Arrays;

public class SortTest {
	private static int count;
	
	public static void main(String args[]) {
		long startTime, endTime, elapsedTime;
		
		int size = Integer.parseInt(args[0]);
		Integer [] a = new Integer[size];
		Integer [] b = new Integer[size];
		Integer [] c = new Integer[size];
		Integer [] d = new Integer[size];
		for (int i = 0; i < size; i++)
			a[i] = b[i] = c[i] = d[i] = (int)(Math.random() * 100);
		System.out.println(Arrays.toString(a)+"\n");
		
		count = 0;
		startTime = System.currentTimeMillis();
		bubblesort(a);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.println(Arrays.toString(a));
		System.out.println("bubblesort took "+ count + " moves to sort "+ size + " items");
		System.out.println("\t in : "+ elapsedTime + " millesec\n");
		
		count = 0;
		startTime = System.currentTimeMillis();
		insertionSort(b);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.println(Arrays.toString(b));
		System.out.println("insertiosort took "+ count + " moves to sort "+ size + " items");
		System.out.println("\t in : "+ elapsedTime + " millesec\n");
		
		count = 0;
		startTime = System.currentTimeMillis();
		shellSort(c);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.println(Arrays.toString(c));
		System.out.println("shell took "+ count + " moves to sort "+ size + " items");
		System.out.println("\t in : "+ elapsedTime + " millesec\n");
		
		startTime = System.currentTimeMillis();
		Arrays.sort(d);
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		System.out.println(Arrays.toString(d));
		System.out.println("Java sort(), sorted "+ size + " items");
		System.out.println("\t in : "+ elapsedTime + " millesec\n");
		
		
	}
	
	public static <AnyType extends Comparable<? super AnyType>> void bubblesort(AnyType[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					AnyType tmp = a[j];
					count++;
					a[j] = a[j + 1];
					count++;
					a[j + 1] = tmp;
					count++;
				}
			}
			
		}
	}
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] t) {
		for(int i = 1; i < t.length; i++) {
			int j;
			T tmp = t[i];
			count++;
			for(j=i; j>0 && tmp.compareTo(t[j-1])<0; j--) {
				t[j]=t[j-1];
				count++;
			}
			t[j] = tmp;
			count++;
		}
	}
	
	public static <T extends Comparable<? super T>> void shellSort(T[] t) {
		int j;
		for(int gap = t.length/2; gap > 0; gap/=2) {
			for(int i = gap; i < t.length; i++) {
				T tmp = t[i];
				count++;
				for(j = i; j >= gap && tmp.compareTo(t[j-gap])<0; j-=gap) {
					t[j] = t[j-gap];
					count++;
				}
				t[j] = tmp;
				count++;
			}
		}
	}
	
}