package com.promineotech.sorting;

import java.util.NoSuchElementException;
import java.util.Optional;

public class DogOptional {
	
	//a.	The method should return the object unwrapped from the Optional if the object is present. 
	//b.	The method should throw a NoSuchElementException with a custom message if the object is not present.
	public Dog dogMethodA(Optional<Dog> optionalDog) {
		return optionalDog.orElseThrow(() -> new NoSuchElementException("No Dog"));
	}
	
	//c.	Create another method (method b) that calls method a with an object wrapped by an Optional. 
	
	public void dogMethodB(Optional<Dog> dog) {
		System.out.println(dogMethodA(dog));
	}
	
		public static void main(String[] args) {
		new DogOptional().run();
	}

	private void run() {
	
		//c.	Show that the object is returned unwrapped from the Optional (i.e., print the object).
		dogMethodB(Optional.of(new Dog("Husky")));
		
		//d.	Method b should also call method a with an empty Optional. Show that a NoSuchElementException is 
		//	thrown by method a by printing the exception message. Hint: catch the NoSuchElementException as parameter 
		//	named "e" and do System.out.println(e.getMessage()).
		try {
		dogMethodB(Optional.empty());
		} catch (NoSuchElementException e){ 
			System.out.println(e.getMessage());
		}
	}
	
	
}
