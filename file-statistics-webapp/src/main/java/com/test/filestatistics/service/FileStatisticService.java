package com.test.filestatistics.service;

import java.util.List;

import com.test.filestatistics.model.FileInfo;

public interface FileStatisticService {
	List<FileInfo> getFilesStatistics();
}