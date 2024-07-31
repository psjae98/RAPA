package com.test.sku.inheritance;

public class Pet {
		int price;
		String species;
		
		
	public Pet() {}
	
	public Pet(int price, String species) {
		this.price=price;
		this.species=species;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public String toString() {
		String s= String.format("%d\t\t%s",price,species);
		return s;
	}
	
	
	
}
