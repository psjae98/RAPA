package com.test.sku.inheritance;

public class Dog extends Pet {
	float age;
	float weight;
	String pattern;
	public Dog() {}
	
	public Dog(int price, String species,float age,float weight) {
		super(price,species);
		setWeight(weight);
		setAge(age);
		
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getPattern() {
		return null;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String toString() {
		return "강아지:\t\t"+super.toString()+"\t\t"+age+"\t\t\t\t"+weight;//가격품종 나이무늬체중길이
	}
	
	
	
}
