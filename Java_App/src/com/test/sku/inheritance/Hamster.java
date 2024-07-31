package com.test.sku.inheritance;

public class Hamster extends Pet {
float size;

public Hamster() {}

public Hamster(int price, String species,float size) {
	super(price,species);
	setSize(size);
	
}

public float getSize() {
	return size;
}

public void setSize(float size) {
	this.size = size;
}

@Override
public String toString() {
	return "햄스터:\t\t"+super.toString()+"\t\t\t\t\t\t\t\t"+size;//가격품종 나이무늬체중길이
}




}
