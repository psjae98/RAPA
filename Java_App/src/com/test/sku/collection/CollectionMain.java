package com.test.sku.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
public class CollectionMain {
public static void main(String[] args) {
	
//Set, map
	/*
	 * List: 순서있음, 중복됨
	 * Set: 순서 없음, 중복안됨
	 * Map: key 와 value가 쌍으로 저장되는 자료구조
	 * 	 
	  */
	/*Set<String> set= new HashSet<>();
	set.add("smith");
	set.add("james");
	set.add("julie");
	set.add("Laura");
	set.add("james");
	System.out.println("원소의 개수"+set.size());
	System.out.println(set);
	Iterator<String> it= set.iterator(); 
	while (it.hasNext()) {
		String value= it.next();
		System.out.println(value);
		*/
		//collection은 오브젝트만 원소로 받는다
		//그러므로 원칙적으로 기본형 데이터를 저장할 수 없다
		Set<Integer> iSet= new HashSet<>();
		//Integer one= Integer.valueOf(1);	// 기본형 데이터는 각 자료형의 Wrapper 오브젝트를  생성하여 컬렉션에 저장할 수 있다
	

	//iSet.add(one);
	//iSet.add(2);		//얼마전까진 이거 안됐음 Auto Boxing(기본형 데이터를 그대로 저장한는게 아니라 내부에서 Wrapper 클래스를 
						//사용하여 오브젝트를 생성하고 그 참조를 컬렉션에 저장한다)
	//iSet.add(Integer.valueOf(2));
	//System.out.println(iSet);
	//무작위 정수(1~20)를 중복되지 않게 10개 추출하고자 한다
	//iSet.add(Integer.valueOf(2));
	
	/*Random rd= new Random();
	 * 	while (iSet.size()<10) {
		int j=rd.nextInt(20)+1;
		iSet.add(j);
	}
	System.out.println(iSet);
	 */

	Random rd= new Random();
	while(iSet.size()<10) {
		iSet.add(rd.nextInt(20)+1);
}
	List<Integer> iList= new ArrayList<>(iSet);
	Collections.sort(iList);
	System.out.println(Arrays.toString(iList.toArray()));

//중복되지 않도록 Employee 오브젝트를 저장하려고 한다
//Employee 오브젝트 2개를 생성할 때 사번을 동일하게 설정하여 Set에 저장
	Set<Employee> empSet= new HashSet<>();
	Employee emp1= new Employee(11);
	Employee emp2= new Employee(11);
	
	empSet.add(emp1);
	empSet.add(emp2);
	
	System.out.println("원소의 갯수"+empSet.size()); //2개나옴
	
		
		mapTest();
		
		
}//main함수 닫는중괄호

private static void mapTest() {
	//map:key,value가 연결되어 쌍으로 저장되는 자료구조
	//key를 해싱하여 value가 저장되는 메모리 위치를 계산한다.
	Map<String, String> map = new HashMap<>();
	map.put("smith","010-9984-5216");
	map.put("james","010-9876-5432");
	map.put("laura","010-1234-5678");
	map.put("kate","010-9012-3456");
	map.put("sam","010-7890-1234");

	String res=map.get("sam");
	System.out.println(res);

}



}
