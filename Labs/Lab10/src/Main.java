import MyBST.MyBST;

public class Main {
	
	public static void main(String [] args) {
		MyBST<Integer> bst = new MyBST<>();
		bst.insert(37);
		bst.insert(24);
		bst.insert(42);
		bst.insert(7);
		bst.insert(2);
		bst.insert(40);
		bst.insert(42);
		bst.insert(32);
		bst.insert(120);
		
		System.out.print("PreOrder: ");
		bst.printPreOrder();
		System.out.println();
		
		System.out.print("InOrder: ");
		bst.printInOrder();
		System.out.println();
		
		System.out.print("PostOrder: ");
		bst.printPostOrder();
		System.out.println();
		
		
		System.out.println(bst.strDataInOrder());
		System.out.println(bst.strStructInorder());
		
		MyNewBST<Integer> newBST = new MyNewBST<>(bst.strDataInOrder(), bst.strStructInorder()) ;
		System.out.print("PreOrder: ");
		newBST.printPreOrder();
		System.out.println();
		
		System.out.print("InOrder: ");
		newBST.printInOrder();
		System.out.println();
		
		System.out.print("PostOrder: ");
		newBST.printPostOrder();
		System.out.println();
		
		System.out.println(newBST.strDataInOrder());
		System.out.println(newBST.strStructInorder());
	}
}
