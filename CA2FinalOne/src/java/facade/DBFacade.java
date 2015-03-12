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

    private static DBFacade instance = null;

    public DBFacade() {

    }

//    public static DBFacade getInstance() {
//        if (instance == null) {
//            instance = new DBFacade();
//        }
//        return instance;
//    }

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

    public void deletePerson(Long id){
         
        Query query = em.createQuery("DELETE FROM Person p WHERE p.id = "+id);
//        Query query2 = em.createQuery("DELETE FROM InfoEntity ie WHERE ie.id = "+id);
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
        
        
    }
    
    public void createPerson(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public void updatePerson(Person p) {
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
