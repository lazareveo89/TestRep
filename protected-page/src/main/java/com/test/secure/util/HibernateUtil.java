package com.test.secure.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

	 private static StandardServiceRegistry serviceRegistry;
	 private static SessionFactory sessionFactory;
	 
	 private final static String CONFIG_FILE_HBN = "/hibernate.cfg.xml";
	 
	 private HibernateUtil() {
	}
	
	private static SessionFactory buildSessionFactory() {
		if(sessionFactory == null) {
		try {
		Configuration configuration = new Configuration().configure(CONFIG_FILE_HBN);
        serviceRegistry = new StandardServiceRegistryBuilder().
        		applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.configure().buildSessionFactory(serviceRegistry);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}
}
