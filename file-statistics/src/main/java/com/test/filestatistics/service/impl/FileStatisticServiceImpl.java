package com.test.filestatistics.service.impl;

import java.util.List;

import com.test.filestatistics.dao.FileStatisticDao;
import com.test.filestatistics.dao.impl.FileStatisticDaoImpl;
import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.model.Statistic;
import com.test.filestatistics.service.FileStatisticService;
import com.test.filestatistics.util.FileUtil;

public class FileStatisticServiceImpl implements FileStatisticService {

	private List<Statistic> getListRowStatistics(String fileName) {
		return FileUtil.parseUtil(fileName);
	}

	public FileInfo getFileStatistic(String fileName) {
		return FileUtil.getFile(getListRowStatistics(fileName));
	}

	public void saveStatistics(String fileName) {
		FileStatisticDao fileStatisticDao = new FileStatisticDaoImpl();
		fileStatisticDao.saveStatistic(getFileStatistic(fileName));
	}
}