/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Entity.*;
import facade.*;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class DBIntegrationTest {

    private static DBInterface facade = new DBTestFacade();
    private static Person p1;
    private static Person p2;

    public DBIntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Persistence.generateSchema("CA2TESTPU", null);
        // Create 2 persons in the database as default
        p1 = new Person();
        p2 = new Person();

        p1.setFirstName("Michael");
        p1.setLastName("Overgaard");
        p1.setEmail("email@mail.dk");

        p2.setFirstName("Joachim");
        p2.setLastName("Jepsen");
        p2.setEmail("email2@mail.dk");

        facade.createPerson(p1);
        facade.createPerson(p2);
    }

    @AfterClass
    public static void tearDownClass() {
        facade.deletePerson(p1.getId());
        facade.deletePerson(p2.getId());
    }

    @Test
    public void testGetAll() {

        List<Person> listOfAll = facade.getAllPersons();

        for (Person p : listOfAll) {
            if (p.getId() == 1) {
                assertEquals("Person p1 is not equal to the Person p pulled from the db", p1, p);
            } else if (p.getId() == 2) {
                assertEquals("Person p2 is not equal to the Person p pulled from the db", p2, p);
            } else {
                fail("p.ID was not found equal to either 1 or 2");
            }
        }
    }

    @Test
    public void testCreateAndDelete() {
        //  Adding 1 more person should make the list.size() equals to 3
        
        Person newPerson = new Person("New", "Person");
        facade.createPerson(newPerson);
        List<Person> list= facade.getAllPersons();
        assertTrue("List is not 3 entries long", list.size() == 3);
        
        
        //  Deleting this last person should make the list.size() go back to 2
        
        facade.deletePerson(newPerson.getId());
        list = facade.getAllPersons();
        assertTrue("List is not 2 entries long", list.size() == 2);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
