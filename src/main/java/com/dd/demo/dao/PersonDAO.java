package com.dd.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dd.demo.modal.Person;

/**
 * The Interface PersonDAO.
 */
public interface PersonDAO {
	
	/**
	 * Insert person.
	 *
	 * @param id the id
	 * @param person the person
	 * @return the int
	 */
	int insertPerson(UUID id, Person person);

	/**
	 * Adds the person.
	 *
	 * @param person the person
	 * @return the int
	 */
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
	List<Person> getAllPersons();
	
	int deletePersonByID(UUID personID);
	
	int updatePersonByID(UUID personID, Person person);
	
	Optional<Person> selectPerson(UUID personId); 
}
