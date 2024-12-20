
package com.rays.hql;

import java.util.Iterator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDto;


public class TestHQLAll {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from UserDto");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			UserDto Dto = (UserDto) it.next();

			System.out.print(Dto.getId());
			System.out.print("\t" + Dto.getFirstName());
			System.out.print("\t" + Dto.getLastName());
			System.out.print("\t" + Dto.getLoginId());
			System.out.print("\t" + Dto.getPassword());
			System.out.print("\t" + Dto.getDob());
			System.out.println("\t" + Dto.getAddress());

		}

		tx.commit();

		session.close();

	}
}