package com.test.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fileStatistics")
public class FileStatistic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String longWord;
	@Column
	private String shortWord;
	@Column
	private Integer rowsLength;
	@Column
	private BigDecimal avgRowLength;
	@OneToMany(mappedBy = "fileId")
	private Set<Statistic> statistics;
	
	public FileStatistic() {
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
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
		return rowsLength;
	}
	public void setRowLength(Integer rowLength) {
		this.rowsLength = rowLength;
	}

	public Set<Statistic> getStatistics() {
		return statistics;
	}

	public void setStatistics(Set<Statistic> statistics) {
		this.statistics = statistics;
	}
}