package com.test.test;

import java.util.List;

import com.test.dao.impl.FileStatisticDaoImpl;
import com.test.model.FileStatistic;
import com.test.model.Statistic;
import com.test.util.FileUtil;

public class Test {

	public static void main(String[] args) {
		List<String[]> list = FileUtil.parseUtil("./files/sputnik.txt");
		List<Statistic> list2 = FileUtil.getStatisticForFile(list);
		List<FileStatistic> list3 = FileUtil.getFileStatistic(list2);
		FileStatisticDaoImpl fileStat = new FileStatisticDaoImpl();
		System.out.println("All row count:"+list.size());
		for(Statistic tf : list2) {
		    System.out.println("Row:"+list2.indexOf(tf)+","+" maxWord:"+tf.getLongWord()+","
		+" minWord:"+tf.getShortWord()+","+" rowLength:"+tf.getRowLength()+", "+"avgWordLength:"
		    		+tf.getAvgRowLength());
		    fileStat.addStatisticForFile(tf);
		}
		System.out.println("Summary for file");
		System.out.println("Summary:");
		System.out.println("All files:"+list3.size()+","+" maxWord:"+list3.get(0).getLongWord()+","
		+" minWord:"+list3.get(0).getShortWord()+","+" rowLength:"+list3.get(0).getRowLength()+", "
				+"avgWordLength:"+list3.get(0).getAvgRowLength());
		for(FileStatistic fs : list3){
			if(fs.getFileId() == null) {
				fs.setFileId(1L);
			}
			fileStat.addFilesStatistic(fs);
		}
	}
}