package com.rays.cache;

import java.util.Iterator;


import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDto;



public class TestQuerryCache {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q1 = session.createQuery("from UserDto where id = 1");

		q1.setCacheable(true);

		List list1 = q1.list();

		Iterator it1 = list1.iterator();

		while (it1.hasNext()) {

			UserDto Dto1 = (UserDto) it1.next();

			System.out.print(Dto1.getId());
			System.out.print("\t" + Dto1.getFirstName());
			System.out.print("\t" + Dto1.getLastName());
			System.out.print("\t" + Dto1.getLoginId());
			System.out.print("\t" + Dto1.getPassword());
			System.out.print("\t" + Dto1.getDob());
			System.out.println("\t" + Dto1.getAddress());

		}

		Query q2 = session.createQuery("from UserDto where id = 1");

		q2.setCacheable(true);

		//q2.setCacheMode(CacheMode.REFRESH);

		List list2 = q2.list();

		Iterator it2 = list2.iterator();

		while (it2.hasNext()) {

			UserDto Dto2 = (UserDto) it2.next();

			System.out.print(Dto2.getId());
			System.out.print("\t" + Dto2.getFirstName());
			System.out.print("\t" + Dto2.getLastName());
			System.out.print("\t" + Dto2.getLoginId());
			System.out.print("\t" + Dto2.getPassword());
			System.out.print("\t" + Dto2.getDob());
			System.out.println("\t" + Dto2.getAddress());

		}
		tx.commit();
		session.close();

	}

}