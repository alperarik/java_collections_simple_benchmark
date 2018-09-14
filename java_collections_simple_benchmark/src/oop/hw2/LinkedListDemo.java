import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class LinkedListDemo {
	private String fileName;
	private String line;
	
	List <String> linkedList = new LinkedList<String>();
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void readFromText(){
		long startTime = System.nanoTime();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    while ((line = br.readLine()) != null) {
		    	linkedList.add(line);
		    }
		} 
		catch (IOException e) {
			   e.printStackTrace();
		}
		long endTime = System.nanoTime();
		Time.calculatePastMicroSeconds(startTime, endTime);
	}

	public void shuffle(){
		Collections.shuffle(linkedList);
	}
	
	public void binarySearch(String searchingWord)throws RuntimeException {
		//before binary search arrayList is sorting
		Collections.sort(linkedList);
		int result;
		long startTime = System.nanoTime(); 
		result = Collections.binarySearch(linkedList, searchingWord);
		long endTime = System.nanoTime(); 
		Time.calculatePastMicroSeconds(startTime, endTime,searchingWord);
		if(result < 0)
			throw (new RuntimeException ("Searching word has not been found in text!"));
	}
	
	public void sequentialSearch(String searchingWord)throws RuntimeException  {
		boolean found = false;
		Iterator <String> arrayListIterator = linkedList.iterator();
		long startTime = System.nanoTime(); 
		while(arrayListIterator.hasNext() && !found){
			if(arrayListIterator.next().equals(searchingWord)){
				found = true;
			}
		}
		if(found == false)
			throw (new RuntimeException ("Searching word has not been found in text!"));
		long endTime = System.nanoTime(); 
		Time.calculatePastMicroSeconds(startTime, endTime,searchingWord);

	}
}
