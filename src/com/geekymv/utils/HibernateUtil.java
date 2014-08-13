package com.geekymv.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/**
	 * SessionFactory可以创建并打开新的Session。
	 * 一个Session代表一个单线程的单元操作。
	 * SessionFactory是一个线程安全的全局对象，只需要被实例化一次。
	 */
	private static SessionFactory sessionFactory = null;
	
	static {

		try {
			try {
				Configuration configuration = new AnnotationConfiguration().configure();
				
//				Configuration configuration = new Configuration().configure();
//				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()	//
//									.applySettings(configuration.getProperties()).buildServiceRegistry();

				sessionFactory = configuration.buildSessionFactory();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	/**
	 * 打开Session
	 * @return
	 */
	public static Session openSession(){

		return sessionFactory.openSession();
	}
	
	/**
	 * 关闭Session
	 * @param session
	 */
	public static void closeSession(Session session){
		
		if(null != session){
			session.close();
		}
	}
	
}

























