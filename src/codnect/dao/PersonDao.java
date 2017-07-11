package codnect.dao;

import codnect.model.Person;

import java.util.List;

/**
 * Created by Burak Köken on 11.7.2017.
 */
public interface PersonDao {

    void add(Person person);

    void delete(long id);

    void update(Person person, long id);

    Person getPerson(long id);

    List<Person> getPersonList();

}
