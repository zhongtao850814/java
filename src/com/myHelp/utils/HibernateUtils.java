package com.myHelp.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@WebListener
public class HibernateUtils implements ServletContextListener {

	private static SessionFactory sf;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if (sf != null) {
			sf.close();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		if (sf != null) {
			return sf.openSession();
		} else
			throw new RuntimeException("Session Factory not created yet!");
	}

}
