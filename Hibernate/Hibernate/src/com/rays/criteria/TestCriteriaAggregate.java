package com.rays.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.rays.user.UserDto;


public class TestCriteriaAggregate {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDto.class);

		ProjectionList p = Projections.projectionList();

		// p.add(Projections.count("id"));

		p.add(Projections.rowCount());

		// p.add(Projections.max("id"));

		// p.add(Projections.min("id"));

		p.add(Projections.groupProperty("firstName"));

		criteria.setProjection(p);

		List list = criteria.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object[] Dto = (Object[]) it.next();
			System.out.print(Dto[0]);
			System.out.println("\t" + Dto[1]);

			/*
			 * Object Dto = (Object) it.next();
			 * 
			 * System.out.println(Dto);
			 */

		}

		tx.commit();

		session.close();

	}

}