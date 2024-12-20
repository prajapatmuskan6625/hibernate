package com.rays.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDto;

public class TestFlush {

	public static void main(String[] args) {

		UserDto Dto = new UserDto();

		// Dto.setId(4);
		Dto.setFirstName("abhinandan");
		Dto.setLastName("singh");
		Dto.setLoginId("abhinandan@gmail.com");
		Dto.setPassword("123");
		Dto.setDob(new Date());
		Dto.setAddress("indore");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(Dto);

		//session.flush();

		System.out.println("id = " + Dto.getId());

		Dto = (UserDto) session.get(UserDto.class, 2);

		System.out.println("first name = " + Dto.getFirstName());

		tx.commit();

		session.close();

	}

}