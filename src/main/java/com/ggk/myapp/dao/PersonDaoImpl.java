package com.ggk.myapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ggk.mapper.PersonMapper;
import com.ggk.myapp.domain.Person;

public class PersonDaoImpl implements PersonDao {

	@Autowired
	private PersonMapper personmapper;

	@Override
	public List<Person> selectAllPerson() {
		return personmapper.selectAllPerson();
	}

	@Override
	public Person selectPerson(int id) {
		return personmapper.selectPerson(id);
	}

	@Override
	public int insertPerson(Person person) {
		return personmapper.insertPerson(person);
	}

	@Override
	public List<Person> getPersonsByIdAndName(int id , String name) {
		Map<String, Object> params = new HashMap<String, Object>();
	    params.put("id",id);
	    params.put("name",name);
	    List<Person> persons = personmapper.getPersonsByIdAndName(params);
		return persons;
		
	}

}
