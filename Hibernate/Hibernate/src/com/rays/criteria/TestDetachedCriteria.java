package com.rays.criteria;

import java.util.Iterator;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.rays.user.UserDto;


public class TestDetachedCriteria {

	public static void main(String[] args) {

		DetachedCriteria dc = DetachedCriteria.forClass(UserDto.class);

		dc.add(Restrictions.like("firstName", "abc"));

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		List<UserDto> list = dc.getExecutableCriteria(session).list();

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
		session.close();
	}
}