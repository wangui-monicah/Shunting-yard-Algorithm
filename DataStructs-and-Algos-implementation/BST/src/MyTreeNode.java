public class MyTreeNode<T extends Comparable<T>> {
	public T data;
	public MyTreeNode<T> leftChild;
	public MyTreeNode<T> rightChild;
	public MyTreeNode<T> parent;
	
	public void insert(MyTreeNode<T> newNode) {
		if(newNode.data.compareTo(this.data) < 0) {
			if(this.leftChild == null) {
				this.leftChild = newNode;
				this.leftChild.parent = this;
			}
			else
				this.leftChild.insert(newNode);
		}
		else {
			if(this.rightChild == null) {
				this.rightChild = newNode;
				this.rightChild.parent = this;
			}
			else
				this.rightChild.insert(newNode);
		}
	}
	
	public void printPreOrder() {
		System.out.print(this.data+" ");
		if(this.leftChild != null) {
			this.leftChild.printPreOrder();
		}
		if(this.rightChild != null) {
			this.rightChild.printPreOrder();
		}
	}
	
	public void printInOrder() {
		if(this.leftChild != null) {
			this.leftChild.printInOrder();
		}
		System.out.print(this.data+" ");
		if(this.rightChild != null) {
			this.rightChild.printInOrder();
		}
	}
	
	public void printPostOrder() {
		if(this.leftChild != null) {
			this.leftChild.printPostOrder();
		}
		if(this.rightChild != null) {
			this.rightChild.printPostOrder();
		}
		System.out.print(this.data+" ");
	}

	public MyTreeNode<T> lookup(T x) {
		if(this.data == x) 
			return this;
		if(x.compareTo(this.data) < 0) {
			if(this.leftChild != null)
				return this.leftChild.lookup(x);
			else
				return null;
		}else {
			if(this.rightChild != null) 
				return this.rightChild.lookup(x);
			else
				return null;
		}
	}
	public void delete(MyTreeNode<T> node) {
		// if node = leaf node
		if(node.leftChild == null && node.rightChild == null) {
			if(node.parent.rightChild == node)
				node.parent.rightChild = null;
			else
				node.parent.leftChild = null;
		}// else if node has only one child
		else if(node.leftChild == null || node.rightChild == null) {
			if(node.leftChild != null) {
				node.leftChild.parent = node.parent;
				if(node.parent.leftChild == node)
					node.parent.leftChild = node.leftChild;
				else
					node.parent.rightChild = node.leftChild;
			}else {
				node.rightChild.parent = node.parent;
				if(node.parent.leftChild == node)
					node.parent.leftChild = node.rightChild;
				else
					node.parent.rightChild = node.rightChild;
			}
		}else {// else, node has 2 children
			MyTreeNode<T> nodeSmall = node.rightChild;
			while(nodeSmall.leftChild != null) 
				nodeSmall = nodeSmall.leftChild;
			if(nodeSmall.leftChild == null && nodeSmall.rightChild == null) {
				if(nodeSmall.parent.leftChild == nodeSmall)
					nodeSmall.parent.leftChild = null;
				else
					nodeSmall.parent.rightChild = null;
				node.data = nodeSmall.data;
			}
			else {
				if(node.rightChild != nodeSmall) {
					nodeSmall.rightChild.parent = nodeSmall.parent;
					nodeSmall.parent.leftChild = nodeSmall.rightChild;
					node.data = nodeSmall.data;
				}else {
					nodeSmall.parent = node.parent;
					if(node.parent.leftChild == node)
						node.parent.leftChild = node.rightChild;
					else
						node.parent.rightChild = node.rightChild;
					nodeSmall.leftChild = node.leftChild;
					node.leftChild.parent = nodeSmall;
				}
			}
		}
	}
}