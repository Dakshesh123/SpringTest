package com.dd.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.dd.demo.modal.Person;

@Repository("fakeDAO")
public class PersonInjection implements PersonDAO {

	private static List<Person> personList = new ArrayList<Person>();

	@Override
	public int insertPerson(UUID id, Person person) {
		personList.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> getAllPersons() {
		return personList;
	}

	@Override
	public int deletePersonByID(UUID personID) {
		Optional<Person> isPerson = selectPerson(personID);
		if (isPerson.equals(null)) {
			return 0;
		}
		personList.remove(isPerson.get());
		return 1;
	}

	@Override
	public int updatePersonByID(UUID personID, Person updatePerson) {
		return selectPerson(personID).map(person -> {
			int indexOfPersonToDelete = personList.indexOf(person);
			if (indexOfPersonToDelete >= 0) {
				personList.set(indexOfPersonToDelete, new Person(personID, updatePerson.getName()));
				return 1;
			}
			return 0;
		}).orElse(0);

	}

	@Override
	public Optional<Person> selectPerson(UUID personId) {
		return personList.stream().filter(person -> person.getId().equals(personId)).findFirst();
	}

}
