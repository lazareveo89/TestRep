package com.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.test.model.FileStatistic;
import com.test.model.Statistic;

public class FileUtil {
	
	public static List<String[]> parseUtil(String filename) {
		File f = new File(filename);
		List<String[]> list = new ArrayList<String[]>();
		String str = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			while((str=br.readLine()) != null){
				if(!str.trim().isEmpty()) {
					String[] arrStr = str.split(" ");
					list.add(arrStr);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return list;
	}
	
	public static List<Statistic> getStatisticForFile(List<String[]> list) {
		List<Statistic> list2 = new ArrayList<Statistic>();
		for(String[] masStr : list) {
	    	int maxWordLength = masStr[0].length();
	    	int minWordLength = masStr[0].length();
	    	int sumCharOfWord = 0;
	    	Statistic tf = new Statistic();
		for(String str2 : masStr){
		    sumCharOfWord+=str2.length();
		    if(maxWordLength <= str2.length()) {
			tf.setLongWord(str2);
			maxWordLength = str2.trim().length();
		    }
		    if(minWordLength >= str2.length()) {
			tf.setShortWord(str2);
			minWordLength = str2.trim().length();
		    }
		}
		tf.setRowLength(sumCharOfWord);
		tf.setAvgRowLength(new BigDecimal((double)sumCharOfWord/masStr.length)
				.setScale(2, RoundingMode.UP));
		list2.add(tf);
	}
		return list2;
	}
	
	public static List<FileStatistic> getFileStatistic(List<Statistic> list) {
		List<FileStatistic> resList = new ArrayList<FileStatistic>();
		int sumLengthFile = 0;
		int max = list.get(0).getLongWord().length();
		int min = list.get(0).getShortWord().length();;
		double avg = 0.00;
		FileStatistic statFiles = new FileStatistic();
		for(Statistic tf : list) {
		    sumLengthFile+=tf.getRowLength();
		    avg+=tf.getAvgRowLength().doubleValue();
		    if(max <= tf.getLongWord().length()) {
		    	statFiles.setLongWord(tf.getLongWord());
		    	max = tf.getLongWord().length();
		    }
		    if(min >= tf.getShortWord().length()) {
		    	statFiles.setShortWord(tf.getShortWord());
		    	min = tf.getShortWord().length();
		    }
		    statFiles.setAvgRowLength(
		    		new BigDecimal((double)avg/list.size()).setScale(2, RoundingMode.UP));
		    statFiles.setRowLength(sumLengthFile);
		}
		resList.add(statFiles);
		return resList;
	}
}