package com.promineotech.sorting;

import java.util.List;

public class DogSort {

	//g.	In another class, write a method to sort the objects using a Lambda expression using the compare method you created earlier.
	private List<Dog> lambdaSort (List<Dog> dogs) {
		List<Dog> result = dogs;
		result.sort((dogA, dogB) -> Dog.compare(dogA, dogB));
		return result;
	}
	
	//h.	Write a method to sort the objects using a Method Reference to the compare method you created earlier.
	private List<Dog> methodRefSort (List<Dog> dogs) {
		List<Dog> result = dogs;
		result.sort(Dog::compare);
		return result;
	}
	
	//i.	Create a main method to call the sort methods.
	public static void main(String[] args) {
		new DogSort().run();
	}
	
	private void run() {
		//j.	Print the list after sorting (System.out.println).
		List<Dog> lambdaSortDogs = lambdaSort(Dog.getDogs());
		System.out.println(lambdaSortDogs);
		
		List<Dog> methodReferenceSortDogs = methodRefSort(Dog.getDogs());
		System.out.println(methodReferenceSortDogs);
		
	}
}
