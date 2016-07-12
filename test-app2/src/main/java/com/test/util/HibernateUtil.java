package com.test.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
					config.getProperties()).buildServiceRegistry();
			return config.buildSessionFactory(serviceRegistry);
		} catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}
}
