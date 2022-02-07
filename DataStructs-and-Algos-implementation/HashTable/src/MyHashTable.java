public class MyHashTable {
	MyHashFunction h;
	String [] table;
	int tSize, n;
	public MyHashTable() {
		tSize = 13;
		n = 0;
		table = new String[tSize];
		h = new MyHashFunction();
	}
	public int capacity() {return table.length;}
	public int numItems() {return n;}
	public double loadFactor() {return (double)n/(double)table.length;}
	public void insert(String s) {
		if(lookUp(s))return;
		System.out.println(loadFactor() + ": "+n+"/"+table.length);
		if(loadFactor() > .5) rehash();
		int probe = h.myHashFunction(s, table.length);
		while(probe < table.length && table[probe] != null) probe++;
		if(probe >= table.length) {
			int i;
			for(i = 0; i < table.length && table[i] != null; i++);
			probe = i;
		}
		table[probe] = s;
		n++;
	}
	public boolean lookUp(String s) {
		// should add the given string to the table if it's not already present
		int probe = h.myHashFunction(s, table.length);
		int k = probe;
		while(probe < table.length && table[probe]!=null) {
			if(table[probe].equals(s))
				return true;
			probe++;
		}
		for(int i = 0; i < k; i++)
			if(table[i]!=null && table[i].equals(s))
				return true;
		return false;
	}
	private void rehash() {
		System.out.println("rehashing "+this.toString());
		String[] tmpTable = new String[table.length*2];
		for(int i = 0; i < table.length; i++)
			tmpTable[i] = table[i];
		table = tmpTable;
	}
	public String toString() {
		String rval = "{";
		for(int i = 0; i < table.length; i++)
			if(table[i] != null)
				rval+= table[i]+", ";
		return rval.substring(0, rval.length()-2) +"}";
	}
}
