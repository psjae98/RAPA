package com.test.sku.pet;

import java.io.Serializable;
import java.text.NumberFormat;

public class PetBoardVO implements Comparable<PetBoardVO>,Serializable
{
//	The type PetBoardVO must implement the inherited abstract method Comparable<PetBoardVO>.compareTo(PetBoardVO)
int no;
String species;
double weight;
int price;
	
	
 public PetBoardVO(String line) {
	 String[] token=line.split("\\|");
	 no= Integer.parseInt(token[0]);
	 species=token[1];
	 weight= Double.parseDouble(token[2]);
	 price= Integer.parseInt(token[3]);
 
 }
public PetBoardVO(int no) {
	this.no= no;
	
}
public PetBoardVO(int no, double weight) 
{
	this.no=no;
	this.weight=weight;
	}
	public PetBoardVO() {
		
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		NumberFormat nf= NumberFormat.getInstance();
		String s =String.format("%d\t%s\t%.2f\t%s",no,species,weight,nf.format(price));
		
		return s;
	}
	@Override
	public int compareTo(PetBoardVO other) {
		//왼쪽의 객체가 크면 양수 동일하면 0 작으면 음수
		if(this.getNo()>other.getNo())
		{
			return 1;
		}

		else if(this.getNo()==other.getNo())
		{
			return 0;
		}
		else return -1;
		
	}
	//저장 obj-> text-> file에 저장
	//출력 file ->text ->obj 화면에표시
	//객체의 직렬와(object Serialization)
	// 객체에 파일을 저장한다
	//ObjectInputStream
	//ObjectOutputStream
}
