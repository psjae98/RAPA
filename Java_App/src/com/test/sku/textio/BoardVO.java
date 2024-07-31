package com.test.sku.textio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class BoardVO {
private int no;
private String title;
private String author;
private String content;
private int hits;
private Date regdate;

public BoardVO(String line ) {
	String[] token= line.split("\\|");
	setNo(Integer.parseInt(token[0]));
	setTitle(token[1]);
	setAuthor(token[2]);
	SimpleDateFormat sdf= new SimpleDateFormat ("yyyy-MM-dd");
	try {
	setRegdate(sdf.parse(token[3]));
	}
	catch(ParseException e) {
		e.printStackTrace();
	}
	setHits(Integer.parseInt(token[4]));
	setContent(token[5]);
	
}
public BoardVO() {}			//생성자 만들어줄때 빈 생성자 만들어주는 이유: 아무 생성자도 없을때는 
							//자동으로 기본 생성자를 만들어주지만 생성자를 하나 만들어주면 빈 생성자를 만들어줘야 한다
							//생성자 없으면 자바 문법에 어긋남

	

@Override
public int hashCode() {
	return Objects.hash(author, content, hits, no, regdate, title);
}
@Override
public boolean equals(Object obj) {
BoardVO other= (BoardVO) obj;
return this.getNo()==other.getNo();

}

@Override
public String toString() {
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	String sdate=sdf.format(regdate);
	
String s= String.format("%d\t%-20s\t%s\t%s\t%d\t%s",
		no,title,author,sdate,hits,content);

return s;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getHits() {
	return hits;
}
public void setHits(int hits) {
	this.hits = hits;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}


}
