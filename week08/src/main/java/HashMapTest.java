import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HashMapTest {

	public static void main(String[] args) {

		Map<Integer, String> states = new HashMap<Integer, String>();
		// store values in map
		states.put(1, "California");
		states.put(12, "Arizona");
		states.put(3, "Minnesota");
		states.put(4, "New Jersey");
		states.put(1, "New California");

		// retrieve values from map
		// states.get(1); // returns "New California"
		// states.get(4); // returns "New Jersey"

		// Pull out live Collection of all the values.
		// Collection<String> values = states.values();
		// System.out.println(values); // [Minnesota, New Jersey,… Arizona]

		// Use keySet to pull out live set of the keys -- use to print //key->value for
		// the whole map.
		// The order of the keys is random for a HashSet.

		
		Set<Integer> keys = states.keySet();
        keys.stream().sorted().forEachOrdered(key->System.out.println(key + "->" + states.get(key)));
        keys.forEach(key->System.out.println(key + "->" + states.get(key)));
//		for (Integer key:keys) { System.out.println(key + "->" + states.get(key)); }
		
		// how to sort??
		/*
		 * TreeSet keySort = new TreeSet<Integer>(states.keySet());
		 * 
		 * 
		 * for (Object key:keySort) { System.out.println(key + "->" + states.get(key));
		 * }
		 */
		Map<String, Integer> m = new HashMap<>();
		Integer ACOUNT = 0, ECOUNT = 0;
		String letter = "A";
		// store values in map
		switch (letter) {
		case "A":
			ACOUNT++;
			break;
		case "E":
			ECOUNT++;
			break;
		}
		m.put("A", ACOUNT);
		m.put("E", ECOUNT);

		Set<String> vals = m.keySet();

		for (String key : vals)
			System.out.println(key + "->" + m.get(key));

	}

}