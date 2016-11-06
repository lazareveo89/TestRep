package com.test.filestatistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.filestatistics.dao.FileStatisticDao;
import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.service.FileStatisticService;

public class FileStatisticServiceImpl implements FileStatisticService {
	
	@Autowired
	private FileStatisticDao fileStatisticDao;

	@Override
	public List<FileInfo> getFilesStatistics() {
		return getFileStatisticDao().getFilesStatistics();
	}
	
	public FileStatisticDao getFileStatisticDao() {
		return fileStatisticDao;
	}
}