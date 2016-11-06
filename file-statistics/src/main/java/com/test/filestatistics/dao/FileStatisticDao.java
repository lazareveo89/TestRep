package com.test.filestatistics.dao;

import com.test.filestatistics.model.FileInfo;

public interface FileStatisticDao {
	void saveStatistic(FileInfo fileInfo);
}