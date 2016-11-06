package com.test.filestatistics.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration config = new Configuration().configure();
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

		    serviceRegistryBuilder.applySettings(config.getProperties());

		    ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

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
