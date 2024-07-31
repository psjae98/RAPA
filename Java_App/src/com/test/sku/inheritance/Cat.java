package com.test.sku.inheritance;

public class Cat extends Pet {
	String pattern;
	float age;
	
	public Cat() {}
	
	public Cat(int price, String species,String pattern, float age) {
		super(price,species);
	setPattern(pattern);
	setAge(age);
	
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "고양이:\t\t"+super.toString()+"\t\t"+age+"\t\t"+pattern;	//가격품종 나이무늬체중길이
	}
	
	
}
