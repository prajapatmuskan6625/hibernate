package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDto;

public class TestGetLoad {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto Dto1 = (UserDto) session.load(UserDto.class, 3);

		//UserDto Dto1 = (UserDto) session.get(UserDto.class, 3);

		System.out.println(Dto1);

	}

}