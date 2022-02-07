public class MyHashFunction {
	/*
	 * x is the string from which a hash key is generated from, and
	 * M is the size of the table
	 */
	public int myHashFunction(String x, int M) {
		
		char ch[] = x.toCharArray();
		int i, sum;
		for(sum = 0, i = 0; i < x.length(); i++) 
			sum+=ch[i];
		
		return sum % M;	
	}
}
