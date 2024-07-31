package com.test.sku.pet;

import com.test.sku.textio.UserIO;

public class PetMain 
{

	public static void main(String[] args) 
	{
	/* Pet Store 관리 프로그램
	 * Pet(번호(no),품종명(species),체중(weight),가격(price))
	 * pets.data
	 * 이용자 입출력, 파일 입출력, PetVO ,Main
	 * 추가(a),목록(s), 검색(f), 수정(u), 삭제(d), 종료(x)
	 */
		boolean go = true;
		while (go)
		{
			//메뉴를 보여준다
			String m= PetUserIO.showMenu(); //UserIO에서 가져옴
			switch(m)
			{
			case "a": PetUserIO.add();		break;
				
			case "s":PetUserIO.show();		break;
				
			case "f":PetUserIO.findByNo();		break;
					
			case "u":PetUserIO.update();	break;
				
			case "d":PetUserIO.delete();	break;
				
			case "x" :go=false;			break;
			}
			//go=false;
		}
		System.out.println("프로그램 종료");
	}//메인끝

}//클래스끝
