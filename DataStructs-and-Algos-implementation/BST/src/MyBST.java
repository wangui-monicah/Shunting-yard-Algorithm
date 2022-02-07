public class MyBST<T extends Comparable<T>> implements BST<T> {
	
	private MyTreeNode<T> root;
	
	public MyBST() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	@Override
	public void insert(T x) {
		// TODO Auto-generated method stub
		MyTreeNode<T> newNode = new MyTreeNode<>();
		newNode.data = x;
		if(root == null) {
			root = newNode;
			root.parent = root;
		}else{
			if(!this.lookup(x))
				root.insert(newNode);
		}
	}

	@Override
	public void delete(T x) {
		// TODO Auto-generated method stub
		if(lookup(x)) {
			if(x == root.data) {
				if(root.leftChild == null && root.rightChild == null)
					root = null;
				else if(root.leftChild == null || root.rightChild == null) {
					if(root.leftChild != null) 
						root = root.leftChild;
					else 
						root = root.rightChild;
				}else {
					MyTreeNode<T> nodeSmall = root.rightChild;
					if(nodeSmall.leftChild == null && nodeSmall.rightChild!=null) {
						nodeSmall.leftChild = root.leftChild;
						root = nodeSmall;
					}else 
						root.delete(root);
				}
			}
			else {
				MyTreeNode<T> node = root.lookup(x);
				root.delete(node);
			}
		}
	}

	@Override
	public boolean lookup(T x) {
		// TODO Auto-generated method stub
		if(root != null)
			if(root.lookup(x) != null)
				return true;
		return false;
	}

	@Override
	public void printPreOrder() {
		// TODO Auto-generated method stub
		if(root != null)
			root.printPreOrder();
	}

	@Override
	public void printInOrder() {
		// TODO Auto-generated method stub
		if(root != null)	
			root.printInOrder();
	}

	@Override
	public void printPostOrder() {
		// TODO Auto-generated method stub
		if(root != null)
			root.printPostOrder();
	}	
	
}
