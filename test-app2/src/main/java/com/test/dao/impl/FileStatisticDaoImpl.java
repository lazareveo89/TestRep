package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.apache.log4j.Logger;

import com.test.dao.FileStatisticDao;
import com.test.model.FileStatistic;
import com.test.model.Statistic;
import com.test.util.HibernateUtil;

public class FileStatisticDaoImpl implements FileStatisticDao{
	
	private static final Logger LOG = Logger.getLogger(FileStatisticDaoImpl.class);

	@Override
	public List<FileStatistic> getFilesStatistic() {
		List<FileStatistic> list = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from FileStatistic"); 
		list = query.list();
		return list;
	}

	@Override
	public List<Statistic> getStatisticForFile(Long id) {
		List<Statistic> list = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Statistics where fileId = :id"); 
		query.setParameter("id", id);
		list = query.list();
		return list;
	}

	@Override
	public void addFilesStatistic(FileStatistic fs) {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(fs);
		session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	}

	@Override
	public void addStatisticForFile(Statistic s) {
		Session session = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
		}
	}

}