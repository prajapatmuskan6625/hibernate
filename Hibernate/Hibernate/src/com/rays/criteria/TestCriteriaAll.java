package com.rays.criteria;

import java.util.Iterator;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDto;


public class TestCriteriaAll {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDto.class);

		List list = criteria.list();

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