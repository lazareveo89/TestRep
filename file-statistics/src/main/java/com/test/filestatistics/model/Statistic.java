package com.test.filestatistics.model;

import java.math.BigDecimal;

public class Statistic {
	private String longWord;
	private String shortWord;
	private Integer lengthRow;
	private BigDecimal avgLengthRow;
	private Integer rowNum;
	private String fileName;
	
	public String getLongWord() {
		return longWord;
	}
	public void setLongWord(String longWord) {
		this.longWord = longWord;
	}
	public String getShortWord() {
		return shortWord;
	}
	public void setShortWord(String shortWord) {
		this.shortWord = shortWord;
	}
	public Integer getLengthRow() {
		return lengthRow;
	}
	public void setLengthRow(Integer lengthRow) {
		this.lengthRow = lengthRow;
	}
	public BigDecimal getAvgLengthRow() {
		return avgLengthRow;
	}
	public void setAvgLengthRow(BigDecimal avgLengthRow) {
		this.avgLengthRow = avgLengthRow;
	}
	public Integer getRowNum() {
		return rowNum;
	}
	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}