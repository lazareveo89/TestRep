package com.test.dao;

import java.util.List;

import com.test.model.FileStatistic;
import com.test.model.Statistic;

public interface FileStatisticDao {
	public List<FileStatistic> getFilesStatistic();
	public List<Statistic> getStatisticForFile(Long id);
	public void addFilesStatistic(FileStatistic fs);
	public void addStatisticForFile(Statistic s);
}