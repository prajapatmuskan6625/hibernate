package com.rays.user;

import java.util.Date;

import java.util.Iterator;
import java.util.List;

import com.rays.user.UserDto;

public class TestUser {

	public static void main(String[] args) {

		 testAdd();
		 //testUpdate();
		// testGet();
		// testDelete();
		// testAuth();
		// testSearch();

	}

	private static void testAdd() {

		UserDto Dto = new UserDto();
		Dto.setId(2);
		Dto.setFirstName("ranu");
		Dto.setLastName("verma");
		Dto.setLoginId("ranua@gmail.com");
		Dto.setPassword("1234");
		Dto.setDob(new Date());
		Dto.setAddress("bhopal");

		UserModel model = new UserModel();

		model.add(Dto);

	}

	private static void testGet() {

		UserModel model = new UserModel();

		UserDto Dto = model.findByPk(1);

		System.out.println(Dto.getId());
		System.out.println(Dto.getFirstName());
		System.out.println(Dto.getLastName());
		System.out.println(Dto.getLoginId());
		System.out.println(Dto.getPassword());
		System.out.println(Dto.getDob());
		System.out.println(Dto.getAddress());

	}

	private static void testUpdate() {

		UserModel model = new UserModel();

		UserDto Dto = model.findByPk(1);

		Dto.setFirstName("abcd");
		Dto.setLastName("xyz");
		Dto.setLoginId("abc@gmail.com");

		model.update(Dto);

	}

	private static void testDelete() {

		UserDto Dto = new UserDto();
		Dto.setId(2);

		UserModel model = new UserModel();

		model.delete(Dto);

	}

	private static void testAuth() {

		UserModel model = new UserModel();

		UserDto Dto = model.authenticate("sagar@gmail.com", "123");

		if (Dto != null) {
			System.out.println(Dto.getId());
			System.out.println(Dto.getFirstName());
			System.out.println(Dto.getLastName());
			System.out.println(Dto.getLoginId());
			System.out.println(Dto.getPassword());
			System.out.println(Dto.getDob());
			System.out.println(Dto.getAddress());
		} else {
			System.out.println("Authentication failed..!!");
		}
	}

	private static void testSearch() {

		UserDto Dto = new UserDto();

		Dto.setFirstName("b");

		UserModel model = new UserModel();

		List list = model.search(Dto, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Dto = (UserDto) it.next();

			System.out.print(Dto.getId());
			System.out.print("\t" + Dto.getFirstName());
			System.out.print("\t" + Dto.getLastName());
			System.out.print("\t" + Dto.getLoginId());
			System.out.print("\t" + Dto.getPassword());
			System.out.print("\t" + Dto.getDob());
			System.out.println("\t" + Dto.getAddress());
		}
	}
}