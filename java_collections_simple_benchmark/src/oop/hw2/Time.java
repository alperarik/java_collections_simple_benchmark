
public class Time {
	public static String message;
	
	public static void calculatePastMicroSeconds(long start , long end , String searchingWord){
		long estimatedTime = end - start;
		double microSeconds = estimatedTime / 1000;
		message = "Estimated time is : " + microSeconds+" microseconds for "+""+searchingWord+"";
	}
	//overloading
	public static void calculatePastMicroSeconds(long start , long end){
		long estimatedTime = end - start;
		double microSeconds = estimatedTime / 1000;
		message = "creating time is : " + microSeconds+" microseconds";
	}
}
