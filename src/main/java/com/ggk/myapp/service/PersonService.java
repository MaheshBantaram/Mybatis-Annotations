package com.ggk.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ggk.myapp.dao.PersonDao;
import com.ggk.myapp.domain.Person;

public class PersonService {

	@Autowired
	private PersonDao personDao;

	public List<Person> selectAllPerson() {
		return personDao.selectAllPerson();
	}

	public Person selectPerson(int id) {
		return personDao.selectPerson(id);
	}

	public int insertPerson(Person person) {
		return personDao.insertPerson(person);
	}

	public List<Person> getPersonsByIdAndName(int id, String name) {
		return personDao.getPersonsByIdAndName(id, name);
	}

}
