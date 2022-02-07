public class Main {
	
	public static void main(String [] args) {
		
		MyBST<Integer> bst = new MyBST<>();
//		bst.insert(50);
//		bst.insert(50);
//		bst.insert(75);
//		bst.insert(37);
//		bst.insert(25);
//		bst.insert(61);
//		bst.insert(55);
//		bst.insert(30);
//		bst.insert(15);
//		bst.insert(68);
//		bst.insert(71);
//		bst.insert(32);
//		bst.insert(36);
//		bst.insert(28);
//		bst.insert(80);
//		bst.insert(59);
		
		System.out.print("PreOrder: ");
		bst.printPreOrder();
		System.out.println();
		
		System.out.print("InOrder: ");
		bst.printInOrder();
		System.out.println();
		
		System.out.print("PostOrder: ");
		bst.printPostOrder();
		System.out.println();
		
		System.out.println(bst.lookup(50));
		System.out.println(bst.lookup(65));
		System.out.println(bst.lookup(28));
		
		bst.delete(36);
		bst.delete(55);
		bst.delete(75);
		bst.delete(61);
		System.out.print("InOrder: ");
		bst.printInOrder();
		
	}
}
