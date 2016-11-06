package com.test.filestatistics.dao;

import java.util.List;

import com.test.filestatistics.model.FileInfo;

public interface FileStatisticDao {
	List<FileInfo> getFilesStatistics();
}