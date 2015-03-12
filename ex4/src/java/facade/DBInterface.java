/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Hobby;
import Entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Michael
 */
public interface DBInterface {
    public Person getPerson(Long id);

    public List<Person> getAllPersons();

    public void deletePerson(Long id);
    
    public void createPerson(Person p);

    public void updatePerson(Person p);

    public List<Person> findByHobby(Hobby h);

    public List<String> getAllZipCodes();
}
