/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Entity.*;
import facade.DBFacade;
import Entity.exceptions.*;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author JoachimDittman
 */
@Path("person")
public class Api {

    @Context
    private UriInfo context;
    private Object rand;
    private DBFacade facade = new DBFacade();

    private Gson gson = new Gson();

    /**
     * Creates a new instance of Api
     */
    public Api() throws NonexistentEntityException, Exception {

    }

    
    @POST
    @Consumes("text/plain")
    public String addPerson(String s) {
        
        Map<String,String> map = new HashMap();
        String[] entities = s.split(",");
        
        for (String str : entities){
            String[] keyValue = str.split(": ");
            keyValue[0] = keyValue[0].replace("\"", "");
            keyValue[1] = keyValue[1].replace("\"", "");
            
            map.put(keyValue[0], keyValue[1]);
        }
        
        String firstName = map.get("firstName");
        String lastName = map.get("lastName");
        
        Person p = new Person(firstName, lastName);
        
        facade.createPerson(p);
        return p.getId()+"";
    }
    /**
     * Retrieves representation of an instance of api.Api
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getAllPersons() throws NonexistentEntityException {
        
        //  Meget forsimplet, man får ikke alle oplysninger med,
        //  men det kan umiddelbart være fint, bare man kan se personerne
        //  så kan man finde en specifik person senere og få mere info
        List<Person> allPersons = facade.getAllPersons();
        if (allPersons == null){
            throw new NonexistentEntityException("404: No persons in database");
        }
        String json = gson.toJson(allPersons);
        return json;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getSinglePerson(@PathParam("id") long id) throws NonexistentEntityException {
        
        Person p = facade.getPerson(id);
        if(p == null){
            throw new NonexistentEntityException("404: Person not found");
        }
        String json = gson.toJson(p);
        return json;
        
        /*
        
            Mangler nogle JOIN statements for at få addresse/phone fra databasen
        */
//        JsonObject jo = new JsonObject();
//        jo.addProperty("firstName", p.getFirstName());
//        jo.addProperty("lastName", p.getLastName());
//        jo.addProperty("email", );
    }


    @PUT
    @Produces("application/json")
    public String editPerson(@PathParam("id") Long id) {
        return "";
    }

    @DELETE
    @Consumes("application/json")
    public void deletePerson(Person p) throws NonexistentEntityException {
        
    }

}
