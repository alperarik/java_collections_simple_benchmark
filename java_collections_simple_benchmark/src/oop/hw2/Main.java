import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		//Sample words from top, middle and end of file
		String [] words = {"abacus","kite","zygote"};
		
		ArrayListDemo arrayList = new ArrayListDemo();
		LinkedListDemo linkedList = new LinkedListDemo();
		HashMapDemo hashMap = new HashMapDemo();
		
		arrayList.setFileName("en-US.dic");
		linkedList.setFileName("en-US.dic");
		hashMap.setFileName("en-US.dic");
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter("result.txt"))) {
			//Reading file for arrayList
			arrayList.readFromText();
			br.write("ArrayList "+Time.message); 	br.newLine(); 
			//Reading file for linkedList
			linkedList.readFromText();
			br.write("LinkedList "+Time.message);	br.newLine();	
			//Reading file for hashMap
			hashMap.readFromText();
			br.write("HashMap "+Time.message);	br.newLine(); br.newLine();
			
			//ArrayList binary search
			br.write("Array List Binary Search\n"); 
			for(String word : words){
				br.newLine();
				arrayList.binarySearch(word);
				br.write(Time.message);		
			}
			//LinkedList binary search
			br.newLine(); br.newLine();	
			br.write("Linked List Binary Search\n");
			for(String word : words){
				br.newLine();
				linkedList.binarySearch(word);
				br.write(Time.message);		
			}
			//ArrayList sequential search
			br.newLine(); 	br.newLine();	
			br.write("Array List Sequential Search\n");
			for(String word : words){
				br.newLine();
				arrayList.sequentialSearch(word);
				br.write(Time.message);		
			}
			//LinkedList sequential search
			br.newLine();	br.newLine();	
			br.write("Linked List Sequential Search\n");
			for(String word : words){
				br.newLine();
				linkedList.sequentialSearch(word);
				br.write(Time.message);		
			}
			//HashMap search
			br.newLine(); br.newLine();
			br.write("HashMap Search\n");
			for(String word : words){
				br.newLine();
				hashMap.searchHashMap(word);
				br.write(Time.message);		
			}
		} 
		catch (IOException e) {
			   e.printStackTrace();
		}
		catch(WordNotFoundException e){
			e.printStackTrace();
		}
	}
}
