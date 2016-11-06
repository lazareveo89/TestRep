package com.test.filestatistics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FileNamePK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String fileName;
	@Column
	private Integer rowNum;
	
	public FileNamePK() {
	}
	
	public FileNamePK(String fileName, Integer rowNum) {
		this.fileName = fileName;
		this.rowNum = rowNum;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
}
