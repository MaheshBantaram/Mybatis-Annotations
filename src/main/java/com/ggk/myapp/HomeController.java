package com.ggk.myapp;

import java.util.List;
import java.util.Locale;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ggk.myapp.domain.Person;
import com.ggk.myapp.service.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public PersonService personService;

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submit(@Param("id") int id, @Param("name") String name, Model model) {
		
		LOGGER.info("In Submit method....");
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		System.out.println(id + " " + name);
		Person person  = new Person();
		person.setId(id);
		person.setName(name);
		
		personService.insertPerson(person);
		
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		LOGGER.info("In home method....");

		List<Person> personlist = personService.selectAllPerson();

		System.out.println(personlist.size());

		for (Person p : personlist) {
			System.out.println(p.getId() + " " + p.getName());
		}

		System.out.println("By ID: "+ personService.selectPerson(2));

		List<Person> persons = personService.getPersonsByIdAndName(2,"Test");
		
		System.out.println("By Stored Procedure::");
		
		for (Person p : persons) {
			System.out.println(p.getName());
		}
		
		return "home";
	}

}
