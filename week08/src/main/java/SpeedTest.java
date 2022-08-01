import java.util.ArrayList;
import java.util.LinkedList;
 
public class SpeedTest {

	public static void main(String[] args)
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		//convert to seconds 
        double secs= 1000000000.0;
		
		// ArrayList add
		long startTime = System.nanoTime();
		 
		for (int i = 0; i < 200000; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("ArrayList add:  " + duration/secs);
		 
		// LinkedList add
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 200000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList add: " + duration/secs);
		 
		// ArrayList get
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 200000; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList get:  " + duration/secs);
		 
		// LinkedList get
		startTime = System.nanoTime();
		 
		for (int i = 0; i < 200000; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList get: " + duration/secs);
		 
		// ArrayList remove
		startTime = System.nanoTime();
		 
		for (int i = 199999; i >=0; i--) {
			arrayList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("ArrayList remove:  " + duration/secs);
		  
		 
		// LinkedList remove
		startTime = System.nanoTime();
		 
		for (int i = 199999; i >=0; i--) {
			linkedList.remove(i);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("LinkedList remove: " + duration/secs);
			
	}
}