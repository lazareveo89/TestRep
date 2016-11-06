package com.test.filestatistics.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.test.filestatistics.dao.FileStatisticDao;
import com.test.filestatistics.model.FileInfo;
import com.test.filestatistics.model.Statistic;
import com.test.filestatistics.util.HibernateUtil;

public class FileStatisticDaoImpl implements FileStatisticDao {

	private static Session session = null;

	@Override
	public List<FileInfo> getFilesStatistics() {
		List<FileInfo> listFile = new ArrayList<>();
		List<Statistic> list = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query queryStat = session.createQuery("from Statistic where rowNum = 0");
			list = queryStat.list();
			for (Statistic s : list) {
				FileInfo fi = new FileInfo();
				fi.setFileStatistics(s);
				Query queryStatForFile = session
						.createQuery("from Statistic where " + "fileName = " + ":fileName" + " and rowNum != 0");
				queryStatForFile.setParameter("fileName", s.getFileNamePK().getFileName());
				fi.setListRowStatistics(queryStatForFile.list());
				listFile.add(fi);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return listFile;
	}

	private List<Statistic> getStatForFile(Statistic s) {
		List<Statistic> list = new ArrayList<>();
		try {
			if (session != null && session.isConnected()) {
				Query queryStatForFile = session.createQuery(
						"from statistic where " + "fileName = " + s.getFileNamePK().getFileName() + " and rowNum != 0");
				list = queryStatForFile.list();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return list;
	}
}