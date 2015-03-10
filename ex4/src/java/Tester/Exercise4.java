/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;
  
import Entity.Person;
import Entity.exceptions.NonexistentEntityException; 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author JoachimDittman
 */
public class Exercise4 {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) throws NonexistentEntityException, Exception {
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");
             EntityManager em = emf.createEntityManager(); 
             
           Person p1 = new Person("Hans","Christian");
        
           em.getTransaction().begin();
           em.persist(p1);
           em.getTransaction().commit();
      
    }
    
}
