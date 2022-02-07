import java.util.Arrays;

public class Main2 {
	
	static int calls;
	static int[][] table;
	
	public static void main(String [] args) {
		calls = 0;
		int [] denominations = {10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
		int amount = 12392849; // 0.63, or 63 pennies
		if (args.length == 1)
			amount = Integer.parseInt(args[0]);
		
		int [] change = makeChange(amount, denominations);
		System.out.print("Change for " + amount + " is ");
		System.out.print(Arrays.toString(change)+"\n");
		System.out.println("Made "+calls+" calls");
	}
	
	static int[] makeChange(int amount, int[] denominations) {
		table = new int [amount + 1][];
		int[] counts = new int[denominations.length+1];
		recMakeChange(amount, denominations, counts);
		int[] countformat = new int[counts[denominations.length]];
		for(int i = 0; i < denominations.length; i++) {
			for(int j = 0; j < counts[i] && counts[i] != 0; j++) {
				int k = 0;
				while(countformat[k] != 0) k++;
				countformat[k] = denominations[i];
			}
		}
		return countformat;
	}
	
	static boolean recMakeChange(int amount, int[] denominations, int[] counts) {
		++calls;
		if(amount == 0 ) return true;
		if(amount < 0) return false;
		if (table[amount] != null) {
			for (int k = 0; k < table[amount].length; k++)
				counts[k] = table[amount][k];
			return true;
		}
		boolean rvalue = false;
		int[] temp = new int[counts.length];
		int[] best = new int[counts.length];
		best[best.length-1] = amount + 1;
		
		for(int i = 0; i < denominations.length; i++) {
			for(int j = 0; j < temp.length; j++) 
				temp[j] = 0;
			if(recMakeChange(amount-denominations[i], denominations, temp)) {
				if(temp[temp.length-1] < best[best.length-1]) {
					temp[i]++;
					temp[temp.length-1]++;
					for(int k = 0; k < best.length; k++)
						best[k] = temp[k];
				}	
				rvalue = true;
			}
		}
		if(rvalue) {
			table[amount] = new int[counts.length];
			for(int i = 0; i < best.length; i++)
				table[amount][i] = counts[i] = best[i];
		}
		return rvalue;
	}
	
}
