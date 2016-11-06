
package com.test.filestatistics.model;

import java.util.List;

public class FileInfo {
	private List<Statistic> listRowStatistics;
	private Statistic fileStatistics;
	
	public List<Statistic> getListRowStatistics() {
	    return listRowStatistics;
	}
	
	public void setListRowStatistics(List<Statistic> listRowStatistics) {
	    this.listRowStatistics = listRowStatistics;
	}

	public Statistic getFileStatistics() {
	    return fileStatistics;
	}

	public void setFileStatistics(Statistic fileStatistics) {
	    this.fileStatistics = fileStatistics;
	}
}