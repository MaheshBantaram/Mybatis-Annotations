package com.ggk.myapp.dao;

import java.util.List;

import com.ggk.myapp.domain.Person;

public interface PersonDao {

	public List<Person> selectAllPerson();

	public Person selectPerson(int id);

	public int insertPerson(Person person);

	public List<Person> getPersonsByIdAndName(int id, String name);

}
