import MyBST.MyBST;
import MyBST.MyTreeNode;

public class MyNewBST<T extends Comparable<T>> extends MyBST<T>{
	String strStruct;
	String[] arrData;
	int k;
	
	public MyNewBST(String strData, String strStruct){
		this.strStruct = strStruct;
		this.arrData = strData.split(",");
		root = newTreeBuilder();
		this.k = 0;
	}
	
	@SuppressWarnings("unchecked")
	public MyTreeNode<T> newTreeBuilder() {
		if(this.strStruct.charAt(0)== '0') {
			this.strStruct = this.strStruct.substring(1,this.strStruct.length());
			return null;
		}
		this.strStruct = this.strStruct.substring(1,this.strStruct.length());
		MyTreeNode<T> newNode = new MyTreeNode<T>();
		newNode.data = (T) arrData[this.k++];
		newNode.leftChild = newTreeBuilder();
		newNode.rightChild = newTreeBuilder();
		return newNode;
	}
}
