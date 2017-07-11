package codnect;

import codnect.dao.PersonDao;
import codnect.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Burak Köken on 11.7.2017.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

        PersonDao personDao = context.getBean("personDaoBean", PersonDao.class);

        Person person1 = new Person();
        person1.setName("Burak Köken");
        person1.setAge(22);

        personDao.add(person1);

        person1.setName("Şeyma Köken");
        personDao.update(person1, 3);
        personDao.delete(2);

        List<Person> personList = personDao.getPersonList();
        for (Person p : personList){
            System.out.println(p);
        }

        Person person2 = personDao.getPerson(3);
        System.out.println("-> "  + person2);
    }
}
