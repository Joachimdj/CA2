/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Michael
 */
public class DBFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");
    private EntityManager em = emf.createEntityManager();

    public Person getPerson(Long id) {
        Person found = em.find(Person.class, id);
        return found;
    }

    public List<Person> getAllPersons() {
        List<Person> allPersons = new ArrayList();
        Query query = em.createQuery("SELECT e FROM Person e");
        allPersons = query.getResultList();
        return allPersons;
    }

    public void createPerson(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void updatePerson(Person p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    public List<Person> findByHobby(Hobby h) {
        Query query = em.createQuery("SELECT p FROM Person p JOIN p.Hobby h WHERE h = " + h.getName());
        List<Person> byHobby = query.getResultList();
        return byHobby;
    }
    
    public List<String> getAllZipCodes() {
        Query query = em.createQuery("SELECT z.zipcode FROM CityInfo");
        List<String> zipcodes = query.getResultList();
        return zipcodes;
        
        /*
        Query query = em.createQuery("SELECT c FROM CityInfo");
        List<CityInfo> ciList = query.getResultList();
        List<String> zipcodes = new ArrayList();
        for(CityInfo ci : ciList){
            zipcodes.add(ci.getZipcode());
        }
        return zipcodes;
        */
    }
}
