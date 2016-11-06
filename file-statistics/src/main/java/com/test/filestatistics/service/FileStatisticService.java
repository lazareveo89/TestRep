package com.test.filestatistics.service;

import com.test.filestatistics.model.FileInfo;

public interface FileStatisticService {
	FileInfo getFileStatistic(String fileName);
	void saveStatistics(String fileName);
}