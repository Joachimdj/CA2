/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;
  
import Entity.Person;
import Entity.exceptions.NonexistentEntityException; 
import facade.DBFacade;
/**
 *
 * @author JoachimDittman
 */
public class Exercise4 {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) throws NonexistentEntityException, Exception {
             DBFacade facade = new DBFacade();
             Person p = new Person("Lars", "Larsen");
             Person p1 = new Person("Mads", "Larsen");
      
             facade.createPerson(p);
             facade.createPerson(p1);
             
    }
    
}
