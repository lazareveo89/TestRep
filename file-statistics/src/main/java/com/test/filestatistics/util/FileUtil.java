package com.test.filestatistics.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.model.Statistic;

public class FileUtil {
	public static List<Statistic> parseUtil(String filename) {
		List<Statistic> rowStatistic = new ArrayList<Statistic>();
		File f = new File(filename);
		String str = null;
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			while ((str = br.readLine()) != null) {
				if (!str.trim().isEmpty()) {
					Statistic s = new Statistic();
					s.setFileName(f.getName());
					s.setLengthRow(str.length());
					s.setLongWord(getMaxLengthWordInRow(str.split(" ")));
					s.setShortWord(getMinLengthWordInRow(str.split(" ")));
					s.setAvgLengthRow(getAvgLengthInRow(str.split(" "), str.length()));
					s.setRowNum(++i);
					rowStatistic.add(s);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return rowStatistic;
	}

	public static String getMaxLengthWordInRow(String[] arrStr) {
		int maxWordLength = arrStr[0].trim().length();
		String word = "";
		for (String str : arrStr) {
			if (maxWordLength <= str.trim().length()) {
				word = str.trim();
				maxWordLength = str.trim().length();
			}
		}
		return word;
	}

	public static String getMinLengthWordInRow(String[] arrStr) {
		int minWordLength = arrStr[0].trim().length();
		String word = "";
		for (String str : arrStr) {
			if (minWordLength >= str.trim().length()) {
				word = str.trim();
				minWordLength = str.trim().length();
			}
		}
		return word;
	}

	public static BigDecimal getAvgLengthInRow(String[] arrStr, int lengthRow) {
		return new BigDecimal((double) lengthRow / arrStr.length).setScale(2, RoundingMode.UP);
	}

	public static FileInfo getFile(List<Statistic> statisticRowInfoList) {
		Statistic stat = new Statistic();
		FileInfo fi = new FileInfo();
		String[] arrMinLengthWords = new String[statisticRowInfoList.size()];
		String[] arrMaxLengthWords = new String[statisticRowInfoList.size()];
		int allLengthTotal = 0;
		double avgLengthTotal = 0;
		
		for(int i=0; i < statisticRowInfoList.size(); i++) {
		    arrMinLengthWords[i]=statisticRowInfoList.get(i).getShortWord();
		    arrMaxLengthWords[i]=statisticRowInfoList.get(i).getLongWord();
		    allLengthTotal+=statisticRowInfoList.get(i).getLengthRow();
		    avgLengthTotal+=statisticRowInfoList.get(i).getAvgLengthRow().doubleValue();
		}
		stat.setFileName(statisticRowInfoList.get(0).getFileName());
		stat.setShortWord(getMinLengthWordInRow(arrMinLengthWords));
		stat.setLongWord(getMaxLengthWordInRow(arrMaxLengthWords));
		stat.setLengthRow(allLengthTotal);
		stat.setAvgLengthRow(new BigDecimal(avgLengthTotal/statisticRowInfoList.size()).
				setScale(2, RoundingMode.UP));
		stat.setRowNum(0);
		fi.setFileStatistics(stat);
		fi.setListRowStatistics(statisticRowInfoList);
		return fi;
	}
}