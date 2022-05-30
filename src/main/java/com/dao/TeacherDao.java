package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.Teacher;
import com.util.HibernateUtil;

public class TeacherDao {
	
	public List<Teacher> showAllTeachers() {
		//boolean isAdded = false;
		Transaction transaction = null;
		List <Teacher> teachers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			teachers = session.createNamedQuery("GET_ALL_TEACHERS", Teacher.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return teachers;
}
public Teacher selectTeacher(int id) {
		
		Transaction transaction = null;
		Teacher teacher= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return teacher;
	}
	public void addTeacher(Teacher teacher) {
		//boolean isAdded = false;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.persist(teacher);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}

}
public void updateTeacher(Teacher teacher) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.update(teacher);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}
	
	public void deleteTeacher(Teacher teacher) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.delete(teacher);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
	}

}
