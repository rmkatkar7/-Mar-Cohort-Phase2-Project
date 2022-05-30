package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.ClassTable;
import com.util.HibernateUtil;

public class ClassDao {
	
	public List<ClassTable> selectClass() {
		//boolean isAdded = false;
		Transaction transaction = null;
		List <ClassTable> classes = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			classes = session.createNamedQuery("GET_ALL_CLASSES", ClassTable.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return classes;
}
public ClassTable selectClass(int id) {
		
		Transaction transaction = null;
		ClassTable classTable= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			classTable = session.get(ClassTable.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return classTable;
	}

	public List<ClassTable> showAllClasses() {
		//boolean isAdded = false;
		Transaction transaction = null;
		List <ClassTable> classes = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			classes = session.createNamedQuery("GET_ALL_CLASSES", ClassTable.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return classes;
}
	public void AddClass(ClassTable classObj) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.persist(classObj);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}

	public void updateClass(ClassTable classObj) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.update(classObj);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}
	
	public void deleteClass(ClassTable classObj) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.delete(classObj);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}
}
