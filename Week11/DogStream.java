package com.promineotech.sorting;

import java.util.stream.Collectors;

public class DogStream {

	public static void main(String[] args) {
		new DogStream().run();		
	}

	private void run() {
		//a.	Create a Stream from the list of objects.
		//b.	Turn the Stream of object to a Stream of String (use the map method for this).
		//c.	Sort the Stream in the natural order. (Note: The String class implements the Comparable interface, so you won't have to supply a Comparator to do the sorting.)
		//d.	Collect the Stream and return a comma-separated list of names as a single String. Hint: use Collectors.joining(", ") for this.

		String dogs = Dog.getDogs().stream().map((dog) -> dog.toString()).sorted().collect(Collectors.joining(", "));
		
		//e.	Print the resulting String.
		System.out.println(dogs);
	}

}
