package com.example.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoIml {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public int getCircleCount(){
		String hql = "SELECT COUNT(*) FROM Circle";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		return ((Long) query.uniqueResult()).intValue();
	}
}
