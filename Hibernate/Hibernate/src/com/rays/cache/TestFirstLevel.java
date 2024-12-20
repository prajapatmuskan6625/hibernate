package com.rays.cache;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDto;




public class TestFirstLevel {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		UserDto Dto1 = (UserDto) session.get(UserDto.class, 1);

		System.out.print(Dto1.getId());
		System.out.print("\t" + Dto1.getFirstName());
		System.out.print("\t" + Dto1.getLastName());
		System.out.print("\t" + Dto1.getLoginId());
		System.out.print("\t" + Dto1.getPassword());
		System.out.print("\t" + Dto1.getDob());
		System.out.println("\t" + Dto1.getAddress());

		session.evict(Dto1);

		UserDto Dto2 = (UserDto) session.get(UserDto.class, 1);

		System.out.print(Dto2.getId());
		System.out.print("\t" + Dto2.getFirstName());
		System.out.print("\t" + Dto2.getLastName());
		System.out.print("\t" + Dto2.getLoginId());
		System.out.print("\t" + Dto2.getPassword());
		System.out.print("\t" + Dto2.getDob());
		System.out.println("\t" + Dto2.getAddress());

		tx.commit();
		session.close();

	}

}