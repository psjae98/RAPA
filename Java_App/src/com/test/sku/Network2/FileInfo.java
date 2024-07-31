package com.test.sku.Network2;

import java.io.Serializable;
import java.util.Date;

public class FileInfo implements Serializable{
	private int id;
    private String fileName;
    private String author;
    private long fileSize;
    private String description;

    public FileInfo(int id, String fileName, String author, long fileSize, String description) {
        this.id = id;
        this.fileName = fileName;
        this.author = author;
        this.fileSize = fileSize;
        this.description = description;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nFileInfo [번호:" + id + ", 파일명:" + fileName + ", 작성자:" + author + ", 파일크기:" + fileSize
				+ ", 설명:" + description + "]\n";
	}
    
    
}
