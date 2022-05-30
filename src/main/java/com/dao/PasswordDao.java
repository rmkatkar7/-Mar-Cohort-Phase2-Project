package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Admin;
import com.util.HibernateUtil;

public class PasswordDao {

	public boolean resetPassword(Admin admin,String pwd) {
		boolean isChanged = false;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			admin.setPassword(pwd);
			session.update(admin);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();

		}
		return isChanged;
	}
}
