package com.test.sku.inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class InheritanceMain 
{	static List<Pet> p= new ArrayList<>();	
	static Scanner kb= new Scanner(System.in);

	public static void main(String[] args) 
	{
		//상속(Inheritance),구현(Implements)
		//MyClass extends Thread{}	//Thread를 상속해서 만든 myClass
		//MyClass implements Runnable{}// Runnable 상속해서 만든 myClass
		/*쉽게 하위 클래스를 파생하여 사용할 수 있다
		 * 클래스 간의 관계(Parent/Child)를 설정할 수 있다
		 * IS-A Relationship (A 'is a' B)  
		 * A extends B ( A는 B이다(O),B는 A이다(X)  )
		 *  OOP의3대특징(상속성(Inheritance),다형성(Polymorphism),은닉성(Encapsulation))
		 *  다형성:override(ex.), overload( ex.생성자)
		 *  은닉성:private ~~~
		 *  상속성:extends,implements
		 */
		
		/*Pet store
		 * cat dog snake hamster Pet(int price String species)
		 * Cat(String Pattern, float age ,int price, String species) /4개 무늬 나이 가격 종
		 * Dog( float weight, float age ,int price, String species)/4개	무게 나이 가격 종
		 * Snake(String Pattern, float size ,int price, String species)/4개	무늬 크기 가격 종
		 * Hamster( float size ,int price, String species)/3개			크기 가격 종
		 * 
		 * List<pet> list= new ArrayList<>();
		 */
//		Inheritance1();
//		Inheritance2();
//		Inheritance3();
		Inheritance4();
//		petTest();
	}

private static void Inheritance4() 
{
		//이용자가 마우스,모니터를 살때
		//ArrayList를 사용하여 장바구니에 넣는 기능(각 배열 원소의 마지막 속성이 다른데 어케함?)
	List<Item> cart= new ArrayList<>();											//Item 배열로 하면 모든 물건 다 포함가능
	//Generics(메소드,클래스)List list= 아무 자료형이나 다 담음 List<Item> list = Item 자료형만 담음
	Monitor monitor= new Monitor("Udea 커브드모니터","Udea",240000,"2022-09-13",22.6); //마우스랑 모니터 선언해줘야함
	Mouse mouse= new Mouse("로지텍 G102","logitech",64000,"2022-05-09","무선");
	
	cart.add(mouse);
	cart.add(monitor);
	
//	for (int i=0; i<cart.size();i++) 
	//{
//	System.out.println(cart.get(i));
	//}
	for(Item item:cart) //for(Item item:cart(컬렉션 자리(item의 집합)))
	{
		if (item instanceof Mouse) 
		{ Mouse ms=(Mouse) item;
			System.out.printf("%s \t %s \t %s \n",item.name,ms.made,ms.wireless); // item 클래스에 wireless가 없어서 못씀 --> instanceof 써줘야함
		}
		else if (item instanceof Monitor) {
			Monitor mt=(Monitor) item;
			System.out.printf("%s \t %s \t%2f \n",item.name,mt.made,mt.size);
		}
	}
}

private static void Inheritance2() {
		Mouse mouse= new Mouse("로지텍 G102","logitech",64000,"2022-05-09","무선");
		mouse.getWireless();
		System.out.println(mouse);
		
	}
private static void Inheritance3() {
	Monitor monitor= new Monitor("삼성듀얼모니터","samsung",240000,"2022-09-13",22.6);
	monitor.getSize();
	System.out.println(monitor);
	
}
private static void Inheritance1() {
	Item item= new Item();
	item.setName("Memory");
	item.setMade("한국디지털");
	item.setpDate("2020-12-23");
	item.setPrice(52000);
	
	System.out.println(item);
}
	
private static void petTest() {
	
	 
	 while(true) {
	System.out.println("추가(a),목록(l) 종료 (x)");
	String m= kb.nextLine();
	switch (m) {
	case "a":
	
	System.out.println("고양이(c) 강아지(d) 뱀(s) 햄스터(h)");
	String add=kb.nextLine();
	switch (add) {
	case "c": addcat();	break;
	case "d":	adddog();	break;
	case "s": 	addsnake(); break;
	case "h":	addhamster();	break;
	}break;
//	List<Pet> p= new ArrayList<>();											//Item 배열로 하면 모든 물건 다 포함가능
//	Cat cat= new Cat(250000,"코리안숏헤어","고등어",2.5f); //마우스랑 모니터 선언해줘야함		// 가격 품종 무늬 나이
//	Dog dog= new Dog(3000000,"비숑프리제",3.6f, 0.3f);				//가격  품종 무게 나이
//	Snake snake= new Snake(800000,"보아뱀","비단무늬",0.8f);			//가격 품종 무늬 크기
//	Hamster hamster= new Hamster(650000,"햄찌",3.6f);		//가격 품종 크기
//	p.add(cat);
//	p.add(dog);
//	p.add(snake);
//	p.add(hamster);
//	for (int i=0; i<p.size();i++) {
//	System.out.println(p.get(i));
//	
	
	
	case "l": show();break;
	}
	}
}

private static void addhamster() {
	 
	System.out.println("햄스터의 가격 품종 길이 입력:");
	String ham= kb.nextLine().trim();
	String[] token=ham.split(" ");
	 int price=Integer.parseInt(token[0]);
	 String spc=token[1];
	float len =Float.parseFloat(token[2]);
	Hamster hamster= new Hamster(price,spc,len);
	p.add(hamster);
}

private static void addsnake() {
	 
	System.out.println("뱀의 가격 품종 무늬 길이 입력:");
	String sna= kb.nextLine().trim();
	String[] token=sna.split(" ");
	 int price=Integer.parseInt(token[0]);
	 String spc=token[1];
	 String pat=token[2];
	float len =Float.parseFloat(token[3]);
	Snake snake= new Snake(price,spc,pat,len);
	p.add(snake);
	
}

private static void adddog() {
	
	System.out.println("강아지의 가격 품종 나이 체중 입력:");
	String d= kb.nextLine().trim();
	String[] token=d.split(" ");
	 int price=Integer.parseInt(token[0]);
	 String spc=token[1];
	 float age=Float.parseFloat(token[2]);
	float weight =Float.parseFloat(token[3]);
	Dog dog= new Dog(price,spc,age,weight);
	p.add(dog);
	
}

private static void addcat() {
	
	System.out.println("고양이의 가격 품종 나이 무늬 입력:");
	String ca= kb.nextLine().trim();
	String[] token=ca.split(" ");
	 int price=Integer.parseInt(token[0]);
	 String spc=token[1];
	 float age =Float.parseFloat(token[2]);
	 String pat=token[3];
	
	 Cat cat= new Cat(price,spc,pat,age); //순서주의
	p.add(cat);
	
}

private static void show() {
	
	System.out.println("\t\t\t ***동물 리스트***");
	System.out.println("동물 종류 \t\t가격 \t\t품종 \t\t나이 \t\t무늬 \t\t체중 \t\t길이");
	for (int i=0; i<p.size();i++) {
		System.out.println(p.get(i));
	
}
}
}