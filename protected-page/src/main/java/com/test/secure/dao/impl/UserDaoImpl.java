package com.test.secure.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.test.secure.dao.UserDao;
import com.test.secure.model.User;
import com.test.secure.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User checkUser(User user) {
		Session session = null;
		User userFromDb = null;
		try {
		session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from User where login = :login");
		query.setParameter("login", user.getLogin());
		userFromDb = (User)query.uniqueResult();
		return userFromDb;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public void addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} catch(HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}