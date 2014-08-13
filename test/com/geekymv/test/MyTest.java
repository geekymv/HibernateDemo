package com.geekymv.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.geekymv.pojo.Student;
import com.geekymv.utils.HibernateUtil;

public class MyTest {
	
	@Test
	public void test() throws Exception {
		
		Session session = HibernateUtil.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student stu = new Student();
		
		stu.setName("geekymv");
		stu.setAge(22);
		
		session.save(stu);

		tx.commit();
		
		session.close();
		HibernateUtil.getSessionFactory().close();
		
	}

}
