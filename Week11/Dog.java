package com.promineotech.sorting;

import java.util.ArrayList;
import java.util.List;

public class Dog {
	//b.	Add a name instance variable so that you can tell the objects apart.
	private String name;

	//c.	Add getters, setters and/or a constructor as appropriate.
	public Dog (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//d.	Add a toString method that returns the name and object type (like "Pentax Camera").
	@Override
	public String toString() {
		return name + " Dog";
	}

	//e.	Create a static method named compare in the class that returns an int and takes two 
	//	of the objects as parameters. Return -1 if parameter 1 is "less than" parameter 2. Return 
	//	1 if parameter 1 is "greater than" parameter 2. Return 0 if the two parameters are "equal".
	public static int compare (Dog dogA, Dog dogB) {
		return dogA.name.compareTo(dogB.name);
	}

	//f.	Create a static list of these objects, adding at least 4 objects to the list.
	private static List<Dog> dogs = List.of(
			new Dog("Labrador"),
			new Dog("Dachsund"),
			new Dog("Bulldog"),
			new Dog("Chihuahua"),
			new Dog("Boxer"),
			new Dog("German Shepherd"),
			new Dog("Poodle")
			);	

	public static List<Dog> getDogs() {
		return new ArrayList<>(dogs);
	}

}
