import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class ArrayListDemo {
	private String fileName;
	private String line;
	
	List <String> arrayList = new ArrayList<String>();

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void readFromText(){
		long startTime = System.nanoTime();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    while ((line = br.readLine()) != null) {
		    	arrayList.add(line);
		    }
		}
		catch (IOException e) {
			   e.printStackTrace();
		}
		long endTime = System.nanoTime();
		Time.calculatePastMicroSeconds(startTime, endTime);
	}
	
	public void shuffle(){
		Collections.shuffle(arrayList);
	}
	
	public void binarySearch(String searchingWord)throws WordNotFoundException {
		//before binary search arrayList is sorting
		Collections.sort(arrayList);
		long result = 0;
		long startTime = System.nanoTime(); 
		result = Collections.binarySearch(arrayList, searchingWord);
		long endTime = System.nanoTime(); 
		Time.calculatePastMicroSeconds(startTime, endTime,searchingWord);		
		if(result < 0)
			throw (new WordNotFoundException("Searching word has not been found in text!"));
	}
	
	public void sequentialSearch(String searchingWord)throws WordNotFoundException  {
		boolean found = false;
		Iterator <String> arrayListIterator = arrayList.iterator();
		long startTime = System.nanoTime(); 
		while(arrayListIterator.hasNext() && !found){
			if(arrayListIterator.next().equals(searchingWord)){
				found = true;
			}
		}
		if(found == false)
			throw (new WordNotFoundException("Searching word has not been found in text!"));
		
		long endTime = System.nanoTime(); 
		Time.calculatePastMicroSeconds(startTime, endTime,searchingWord);
	}
}

