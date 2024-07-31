package com.test.sku.inheritance;

public class Snake extends Pet {
	String pattern;
	float size;
	
	
	public Snake() {}
	public Snake(int price, String species,String pattern, float size) {
		super(price,species);
		setPattern(pattern);
		setSize(size);
		}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "뱀:\t\t"+super.toString()+"\t\t\t\t"+pattern+"\t\t\t\t"+size;//가격품종 나이무늬체중길이
	}
	
	
}
