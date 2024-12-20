package com.rays.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.user.UserDto;

public class UserModel {

	public void add(UserDto Dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(Dto);

		tx.commit();

		session.close();

	}

	public void update(UserDto Dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(Dto);

		tx.commit();

		session.close();

	}

	public void delete(UserDto Dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(Dto);

		tx.commit();

		session.close();

	}

	public UserDto findByPk(int pk) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDto Dto = (UserDto) session.get(UserDto.class, 1);

		session.close();

		return Dto;

	}

	public UserDto authenticate(String login, String password) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Query q = session.createQuery("from UserDto where loginId = ? and password = ?");

		q.setString(0, login);
		q.setString(1, password);

		List list = q.list();

		UserDto Dto = null;

		if (list.size() > 0) {

			Dto = (UserDto) list.get(0);

		}
		session.close();
		return Dto;
	}

	public List search(UserDto Dto, int pageNo, int pageSize) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(UserDto.class);

		if (Dto != null) {

			if (Dto.getFirstName() != null && Dto.getFirstName().length() > 0) {

				criteria.add(Restrictions.like("firstName", Dto.getFirstName() + "%"));

			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}

		List list = criteria.list();

		session.close();

		return list;

	}

}