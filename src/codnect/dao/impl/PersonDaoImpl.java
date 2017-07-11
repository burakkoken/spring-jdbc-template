package codnect.dao.impl;


import codnect.dao.PersonDao;
import codnect.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Burak Köken on 11.7.2017.
 */
public class PersonDaoImpl implements PersonDao {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Person person) {
        String sql = "INSERT INTO springdb.person (name, age) VALUES (?, ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{ person.getName(), person.getAge() };
        int status = jdbcTemplate.update(sql, args);

        if(status != 0){
            /* */
        }
        else{
            /* fail */
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM springdb.person WHERE id = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{ id };
        int status = jdbcTemplate.update(sql, args);

        if(status != 0){
            /* */
        }
        else{
            /* fail */
        }
    }

    @Override
    public void update(Person person, long id) {
        String sql = "UPDATE springdb.person SET name = ?, age = ? WHERE id = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{ person.getName(), person.getAge(), id};
        int status = jdbcTemplate.update(sql, args);

        if(status != 0){
            /* */
        }
        else{
            /* fail */
        }
    }

    @Override
    public Person getPerson(long id) {

        String sql = "SELECT * FROM springdb.person WHERE id = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[]{ id };

        Person person = jdbcTemplate.queryForObject(sql, args, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {

                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));

                return person;
            }
        });

        return person;
    }

    @Override
    public List<Person> getPersonList() {
        List<Person> personList = null;

        String sql = "SELECT * FROM springdb.person";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        personList = jdbcTemplate.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));

                return person;
            }
        });

        return personList;
    }

}
