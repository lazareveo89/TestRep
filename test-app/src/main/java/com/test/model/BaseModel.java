package com.test.model;

import java.math.BigDecimal;

public class BaseModel {
	private Long id;
	private String longWord;
	private String shortWord;
	private Integer rowLength;
	private BigDecimal avgRowLength;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public BigDecimal getAvgRowLength() {
		return avgRowLength;
	}
	public void setAvgRowLength(BigDecimal avgRowLength) {
		this.avgRowLength = avgRowLength;
	}
	public Integer getRowLength() {
		return rowLength;
	}
	public void setRowLength(Integer rowLength) {
		this.rowLength = rowLength;
	}	
}