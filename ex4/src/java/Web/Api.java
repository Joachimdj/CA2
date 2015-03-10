/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;
 
import com.google.gson.Gson; 
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;   
import Entity.exceptions.NonexistentEntityException;
import java.util.Date;
import javax.ws.rs.DELETE; 
import javax.ws.rs.FormParam;
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
     
    Gson gson = new Gson();
    /**
     * Creates a new instance of Api
     */
    public Api() throws NonexistentEntityException, Exception { 
       
    }

    /**
     * Retrieves representation of an instance of api.Api
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {  
         return "";
    }

        @GET
      @Path("{id}")
     @Produces("application/json")
    public String getone(@PathParam("id") long id) { 
           
          return "" ;   
    }
      @POST
      @Path("add/{type}")
     @Produces("application/json")
    public void addPerson(@PathParam("type") int type) {
         
          
        
       
    } 
         @PUT
      @Path("edit/{id}")
     @Produces("application/json")
    public String editPerson(@PathParam("id") int id) {
         return "";  
    } 
      @GET
      @Path("delete/{id}")
     @Produces("application/json")
    public void deletePerson(@PathParam("id") int id) throws NonexistentEntityException {
   
      
    } 
    
    
}
