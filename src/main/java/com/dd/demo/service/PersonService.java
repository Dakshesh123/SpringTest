package com.dd.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dd.demo.dao.PersonDAO;
import com.dd.demo.modal.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonService.
 */
@Service
public class PersonService {

	/** The person DAO. */
	private final PersonDAO personDAO;

	/**
	 * Instantiates a new person service.
	 *
	 * @param personDAO the person DAO
	 */
	@Autowired
	public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	/**
	 * Adds the person.
	 *
	 * @param person the person
	 * @return the int
	 */
	public int addPerson(Person person) {
		return personDAO.insertPerson(person);

	}
	
	public List<Person> getAllUsers()
	{
		return personDAO.getAllPersons();
	}

	public Optional<Person> getPersonById(UUID id)
	{
		return personDAO.selectPerson(id);
	}
	
	public int deletePerson(UUID id)
	{
		return personDAO.deletePersonByID(id);
	}
	
	public int updatePerson(UUID id, Person person)
	{
		return personDAO.updatePersonByID(id, person);
	}
}
