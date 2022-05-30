package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.SubjectTeacherClass;
import com.util.HibernateUtil;

public class AssignTeachersDao {
		
public void AssignTeacher(SubjectTeacherClass subjectTeacherClass) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.persist(subjectTeacherClass);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
}
	public List<SubjectTeacherClass> classReportByID(int cid) {
	//boolean isAdded = false;
	Transaction transaction = null;
	List <SubjectTeacherClass> classList = null;
	List<SubjectTeacherClass> singleClass = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		System.out.println("Inside Dao id :"+cid);
		singleClass = new ArrayList<SubjectTeacherClass>();
		classList = session.createNamedQuery("GET_CLASS_REPORT", SubjectTeacherClass.class).getResultList();
		System.out.println("Class list is : "+classList.size());
		for (SubjectTeacherClass each:classList) {
			if(each.getClassId()==cid)
				singleClass.add(each);
		}
		System.out.println("After removal "+singleClass.size());
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			//transaction.rollback();
		}
		e.printStackTrace();

	}
	return singleClass;
}

public void DeleteAssignTeacher(SubjectTeacherClass subjectTeacherClass) {
	
	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		session.delete(subjectTeacherClass);
		
		transaction.commit();
	} catch (Exception e) {
		if (transaction != null) {
			//transaction.rollback();
		}
		e.printStackTrace();

	}
}

}
