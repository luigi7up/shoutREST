
package com.shoutplatform.restresources;

import com.shoutplatform.domain.Group;
import com.shoutplatform.domain.Question;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/groups")
 
@Produces(MediaType.APPLICATION_JSON)
public class Groups{
   
    /*
     * Returns all groups an User can see/subscribe to
     */
    @GET
    public Response getAll(){                
        
        //MOCKED
        ArrayList<Group> allGroupsMock = new ArrayList<Group>();
        
        for(int i=0; i<10; i++){
            allGroupsMock.add(new Group(i, "Group "+i, i+i%2));
        }        
        return Response.status(Response.Status.OK).entity(allGroupsMock).build();
        
    }
    
    /*
     * Returns all details about a certain group with all Questions that belong to it
     */
    @GET    
    @Path("/{id}")     
    public Response getByPK(@PathParam("id") int id){        
        
        
        ArrayList<Question> questionsMock = new ArrayList<Question>();        
        for(int i=0; i<10; i++){
            if(i%3 == 0) questionsMock.add(new Question(i, "Title of a question"+i, false));
            else questionsMock.add(new Question(i, "Title of a question"+i, true));
        }
        
        Group group = new Group(id, "Group "+id, 4);
        group.setQuestions(questionsMock);
        
        if(id < 10){
            return Response.status(Response.Status.OK).entity(group).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
       
    }    
}
