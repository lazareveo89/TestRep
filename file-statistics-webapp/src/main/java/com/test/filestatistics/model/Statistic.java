package com.test.filestatistics.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
public class Statistic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private FileNamePK fileNamePK; 
	
	@Column
	private String longWord;
	@Column
	private String shortWord;
	@Column
	private Integer lengthRow;
	@Column
	private BigDecimal avgLengthRow;
	
	public Statistic() {
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

	public FileNamePK getFileNamePK() {
		return fileNamePK;
	}

	public void setFileNamePK(FileNamePK fileNamePK) {
		this.fileNamePK = fileNamePK;
	}
}