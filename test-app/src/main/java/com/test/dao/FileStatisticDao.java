package com.test.dao;

import java.util.List;

import com.test.model.FileStatistic;
import com.test.model.Statistic;

public interface FileStatisticDao {
	public List<FileStatistic> getFilesStatistic(Long id);
	public List<Statistic> getStatisticForFile();
	public void addFilesStatistic(FileStatistic fs);
	public void addStatisticForFile(Statistic s);
}