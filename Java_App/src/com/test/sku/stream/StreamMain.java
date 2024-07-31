package com.test.sku.stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class StreamMain {

	public static void main(String[] args) {
	/**
	 * JAVA의 Stream API 다루기
	 * 	Stream: 데이터의 흐름	
	 *System.out.println(name);  //메모리에 있는 데이터를 모니터에 표시
	 *new Scanner(System.in); // 키보드에서 들어오는 데이터를 메모리에 복사
	 *채팅:com1,com2 
	 *문자 데이터(텍스트): Character Stream, 바이너리 데이터(비문자): Byte Stream
	 *Reader,Writer 글자를 읽고 쓰는 스트림			InputStream, OutputStream:글자가 아닌걸 읽고 쓰는 스트림
	 *
	 *스트림은 파이프처럼 연결하여 사용할 수 있다
	 *Node Stream, Filter Stream
	 *Node: 데이터가 흐르기 시작하는 위치, 데이터가 흐름을 마치는 끝에 위치하는 스트림
	 *Filter: Node의 위치에 올수 없다
	 *
	 *입력스트림, 출력스트림
	 *입력스트림(Reader, InputStream): 데이터를 가져오는 스트림
	 *출력스트림(Writer, OutputStream): 데이터를 특정 장소로 보내는 스트림
	 */
//memList();
	//textUpdate();	
		textDelete();
		
		
	}//main함수끝 중괄호

	//텍스트 파일을 읽어서 내용을 화면에 표시한다
	//텍스트 파일을 읽을때는 Reader-->data	
	//화면에 표시: System.out.println(data);
	private static void textInput() {	//한글자 읽기
		
		try {
		FileReader fr= new FileReader("C:/test/sample.txt");
		int ch=fr.read();
		 System.out.println("읽어온 데이터:"+(char)ch);
		 fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
private static void textInput2() {	//글자수만큼 읽기
		
		try {
		FileReader fr= new FileReader("C:/test/sample.txt");
		char[] cbuf= new char[12];
		
		int cnt=fr.read(cbuf);
		String sdata= new String(cbuf);
				System.out.print(sdata);		
		 fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
private static void textInput3() { // 끝날때까지 읽기(char[n] 에서 n배수만큼 읽고 나머지엔 더미가 저장돼있음) if (cnt!=-1)로 더미데이터 안뜨게할수있음
	
	try {
	FileReader fr= new FileReader("C:/test/sample.txt");
	int cnt=0;
	char[] cbuf= new char[12];
do  {
	cnt=fr.read(cbuf);
	if(cnt!=-1) {
	String sdata= new String(cbuf,0,cnt);
			System.out.print(sdata);		
	}	}
while(cnt!=-1);
fr.close();
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
private static void textInput4() {  //한줄씩 읽기  (while (br.readLine()!=null) 로 모든행읽기)
	
	try {
	FileReader fr= new FileReader("C:/test/sample.txt");
	BufferedReader br= new BufferedReader(fr);
	String line = null;
	while ((line= br.readLine())!=null) {
	System.out.println(line);
	}
fr.close();
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

private static void textInput5() {  //전체내용 읽기, FileReader 말고 FileInputStream써야함
									//파일 읽기전에 크기부터 알아냄
	
	File textFile= new File("C:/test/sample.txt");	
	int len= (int)textFile.length();
	try {
		FileInputStream fin= new FileInputStream(textFile);
		byte[] buf= new byte[len]; // 파일 크기만큼의 메모리 공간 준비
		fin.read(buf);
		String str= new String(buf);
		System.out.println(str);
		fin.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
}


private static void textInput6() {  //members.txt파일
	/*한 행에 한 회원의 정보가 기록되어 있다.
	 *번호|이름|전화|이메일 형태로 저장됨
	 * |으로 쪼개서 데이터 저장(String[] token=split("\\|");)
	 * List<Member> list;  --> 여기서 구현안됨
	 * 텍스트 파일(member.txt)에서 목록을 가져와서 화면에 표시한다.
	 */

	try {
	FileReader fr= new FileReader("C:/test/members.txt");
	BufferedReader br= new BufferedReader(fr);

	String line = null;
	while ((line= br.readLine())!=null) {
		String[] token= line.split("\\|");
		String no=token[0];
		String name=token[1];
		String phone=token[2];
		String mail=token[3];
	System.out.println("번호:"+no+" 이름:"+name+ " 전화번호:"+phone+" 이메일:" +mail );
	}

	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
private static List<Member> listFromFile() {  //members.txt파일
	/*한 행에 한 회원의 정보가 기록되어 있다.
	 *번호|이름|전화|이메일 형태로 저장됨
	 * |으로 쪼개서 데이터 저장(String[] token=split("\\|");)
	 * List<Member> list;
	 * 텍스트 파일(member.txt)에서 목록을 가져와서 화면에 표시한다.
	 */

	try {
	FileReader fr= new FileReader("C:/test/members.txt");
	BufferedReader br= new BufferedReader(fr);
	List<Member> list= new ArrayList<>();
	
	String line = null;
	while ((line= br.readLine())!=null) {
		String[] token= line.split("\\|");
		//String no=token[0];
		//String name=token[1];
		//String phone=token[2];
		//String mail=token[3];
		if(token.length==4) {
			Member m = new Member(token);
		list.add(m);
		}
	}
	/*while((line=br.readLine())!=null) {
		
		list.add(new Member(line));
		
	}*/
	br.close();
	return list;

	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

private static void memList() {
	List <Member> list= listFromFile();
	for(int i=0;i<list.size();i++) {
	Member member= list.get(i);
	System.out.println(member);
	}
}

private static void textUpdate() {
	//텍스트를 로드하고 메모리에서 수정한 다음 메모리에서 수정된 내용을 기존파일에 덮어쓰기 한다
	File f= new File("C:/test/members.txt"); //파일 오브젝트, 파일의 존재 유무도 확인가능함
	if(!f.exists()) {
		System.err.println("지정된 파일이 존재하지 않습니다");
		return;
	}
	else {
		try 
		{
			BufferedReader br= new BufferedReader(new FileReader(f));
			String line = null;
			List<Member> list= new ArrayList<>();
			while((line=br.readLine())!=null) 
			{
				list.add(new Member(line));
			}
			br.close();
			
			//15번의 전화번호를 010-3333-7777로 변경
			Member key= new Member(22);
			if(list.contains(key)) {
				list.get(list.indexOf(key)).setPhone("010-9494-1313");
				
			}
			//메모리에서 변경된 데이터를 파일에 덮어쓰기한다
			PrintWriter out= new PrintWriter(new FileWriter(f)); //덮어쓰기
			for(int i=0; i<list.size();i++) {
				Member m=list.get(i);
				out.printf("%d|%s|%s|%s\n",m.getNo(),m.getName(),m.getPhone(),m.getMail());
				out.flush();
			}
			out.close();
			System.out.println("전화번호 변경 완료");
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}

	}
}
private static void textDelete() {
	//텍스트를 로드하고 메모리에서 수정한 다음 메모리에서 수정된 내용을 기존파일에 덮어쓰기 한다
	File f= new File("C:/test/members.txt"); //파일 오브젝트, 파일의 존재 유무도 확인가능함
	if(!f.exists()) {
		System.err.println("지정된 파일이 존재하지 않습니다");
		return;
	}
	else {
		try 
		{
			BufferedReader br= new BufferedReader(new FileReader(f));
			String line = null;
			List<Member> list= new ArrayList<>();
			while((line=br.readLine())!=null) 
			{
				list.add(new Member(line));
			}
			br.close();
			
			//22번의 전화번호를 010-3333-7777로 변경
			Member key= new Member(22);
			if(list.contains(key)) {
				list.remove(key);
				
			}
			//메모리에서 변경된 데이터를 파일에 덮어쓰기한다
			PrintWriter out= new PrintWriter(new FileWriter(f)); //덮어쓰기
			for(int i=0; i<list.size();i++) {
				Member m=list.get(i);
				out.printf("%d|%s|%s|%s\n",m.getNo(),m.getName(),m.getPhone(),m.getMail());
				out.flush();
			}
			out.close();
			System.out.println("전화번호 삭제 완료");
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}

	}
}

}//클래스 끝 중괄호
class Member{
	int no;
	String name;
	String phone;
	String mail;
	
	public Member(String[] token) {
		
		this.no=Integer.parseInt(token[0]);
		this.name=token[1];
		this.phone=token[2];
		this.mail=token[3];
	}
	public Member(String line) {
		String[]token = line.split("\\|");
		setNo(Integer.parseInt(token[0]));
		setName(token[1]);
		setPhone(token[2]);
		setMail(token[3]);
	}
	public Member(int no,String name, String phone,String mail) {
		this.no= no;
		this.name= name;
		this.phone= phone;
		this.mail= mail;
	}

	public Member (int no) {
		this.no=no;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "번호:"+no+" 이름:"+name+ " 전화번호:"+phone+" 이메일:" +mail;
	}

	
	@Override
	public boolean equals(Object obj) {
		Member other = (Member) obj;
		return this.getNo()==other.getNo();
	
	}

	
}