import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
	
	public static void main(String [] args) {
		MyHashTable t = new MyHashTable();
	     try {
	        	BufferedReader buf = new BufferedReader(new FileReader("dummy"));
	        	BufferedWriter br = new BufferedWriter(new FileWriter("Named_Entities.txt", true));
	        	String lineJustFetched2;
	        	String[] wordsArray;
	        	while(true) {
	        		lineJustFetched2 = buf.readLine();
	        		if(lineJustFetched2 == null) 
	                    break; 
	                else{
	                    wordsArray = lineJustFetched2.split(" ");
	        			for(String str: wordsArray)
	        				t.insert(str);
	                }
	        	}
	        	buf.close();
	        	br.close();
	        }catch(FileNotFoundException e) {
				e.printStackTrace();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	     System.out.println(t.capacity());
	     System.out.println(t.numItems());
	     System.out.println(t.toString());
	}
}
