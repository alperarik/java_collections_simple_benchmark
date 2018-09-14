import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashMapDemo {
	private String fileName;
	private String line;
	
	HashMap <Integer,String> hashMap = new HashMap <Integer,String>();
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void readFromText(){
		int i = 0;
		long startTime = System.nanoTime();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    while ((line = br.readLine()) != null) {
		    	hashMap.put(i, line);
		    	i++;
		    }
		} 
		catch (IOException e) {
			   e.printStackTrace();
		}
		long endTime = System.nanoTime();
		Time.calculatePastMicroSeconds(startTime, endTime);
	}
	
	public void searchHashMap(String searchingWord) throws WordNotFoundException{
		long startTime = System.nanoTime(); 
		if(hashMap.containsValue(searchingWord)){
			long endTime = System.nanoTime(); 
			Time.calculatePastMicroSeconds(startTime, endTime,searchingWord);
		}
		else
			throw (new WordNotFoundException("Searching word has not been found in text!"));
	}
}
