package com.test.filestatistics.dao;

import java.util.List;

import com.test.filestatistics.dao.impl.FileStatisticDaoImpl;
import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.model.Statistic;

public class Test {

	public static void main(String[] args) {
		FileStatisticDaoImpl f = new FileStatisticDaoImpl();
		List<FileInfo> fileInfo1 = f.getFilesStatistics();
		for(Statistic fileInfo : fileInfo1.get(0).getListRowStatistics()) {
			System.out.println(fileInfo.getLongWord()+fileInfo1.get(0).getFileStatistics().getFileNamePK().getFileName());
		}
	}
}