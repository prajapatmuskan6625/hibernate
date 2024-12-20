
package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDto;

public class TestUpdateMerge {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto Dto1 = (UserDto) session.get(UserDto.class, 1);

		session.close();

		Dto1.setFirstName("salma");

		Session session2 = sf.openSession();

		Transaction tx = session2.beginTransaction();

		// session2.merge(Dto1);

		session2.update(Dto1);

		tx.commit();

		session2.close();

	}

}
