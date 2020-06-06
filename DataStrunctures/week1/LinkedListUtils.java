import java.util.LinkedList;
import java.util.List;

public class LinkedListUtils {
	static LinkedList<Integer> listInt = new LinkedList<>();
	static LinkedList<String> listStr = new LinkedList<>();
	static LinkedList<Integer> second = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listCreation();
	}


	public static void listCreation(){
		//create test list from 1...20 only even
		for (int i = 0; i < 20; i++) {
			if(i%2 == 0) {
				listInt.add(i);
			}
		}
		System.out.println("created list: " + listInt);
//		insertSorted(listInt, -1);
		
		//for second method
		listStr.add("Steve");
	    listStr.add("Carl");
	    listStr.add("Raj");
	    listStr.add("Negan");
	    listStr.add("Rick");
//	    removeMaximumValues(listStr, 3);
	    
	    
	    //for third method
	    second.add(0);
	    second.add(2);
	    second.add(4);
	    second.add(6);
//	    second.add("Rick");
	    boolean result = containsSubsequence(listInt, second);
	    System.out.println("containsSubsequence: " + result);
	}
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		/* IMPLEMENT THIS METHOD! */
		if(list == null) {
			return;
		}
		if (value > list.getLast()) {//if value greater than last element in list
			list.offerLast(value);
		}else if(value < list.getFirst()) {//if value smaller than first element in list
			list.offerFirst(value);
		}else {
			//insert value at that location
			int idx = 0;
			for (int i = 0; i < list.size(); i++) {//find index where to plug it in
				if (value < list.get(i)) {
					idx = i;
					break;
				}
				
			}
			System.out.println("we found index: " + idx);
			list.add(idx, value);
		}
		System.out.println(list);
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
		/* IMPLEMENT THIS METHOD! */
		if (list == null || N < 0) {
			return;
		}
		
		System.out.println("second method input: " + list);
		//using compareTo to compare Strings
//		if (string1 > string2) it returns a positive value.
//		if both the strings are equal lexicographically
//		i.e.(string1 == string2) it returns 0.
//		if (string1 < string2) it returns a negative value.
		String initialStr = list.get(0);
		int comp;
		for (int i = 1; i<list.size(); i++) {
			comp = initialStr.compareTo(list.get(i));
			System.out.println(comp);
			if(comp < N) {
				System.out.println("remove at index: " + i);
				list.remove(i);
			}
		}
		System.out.println(list);
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		/* IMPLEMENT THIS METHOD! */
		//we can use containsAll(Collection) to get true or false;
		System.out.println(one + " " + two + " : " + one.containsAll(two));
//		if(one.containsAll(two)){//that mean one collection contains the other
//			return false;
//		}
		int twoLength = two.size();
		for (int i = 0; i < one.size(); i++) {
			if(one.get(i).equals(two.get(0))) {
				System.out.println ("let's investigate, we may have something");
				try {
					//let's cut a chunk of list one, the size of list 2 if we have enought elements;
					List cutout = one.subList(i, twoLength);
//					System.out.println(cutout);
					for (int y = 0; y < cutout.size(); y++) {
						if(cutout.get(y) != two.get(y)){
							return false;
						}
					}
					//next let's see if they are in the same sequence
					
				}catch(Exception ex) {
					System.out.println(ex);
					return false;//automatic false return
				}
			}
		}
		
		return true; // this line is here only so this code will compile if you don't modify it
	}

}
