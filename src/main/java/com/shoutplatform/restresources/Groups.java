
package com.shoutplatform.restresources;

import com.shoutplatform.domain.Group;
import com.shoutplatform.domain.GroupQuestion;
import com.shoutplatform.domain.Question;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/groups")
@Produces(MediaType.APPLICATION_JSON)
public class Groups{


    @GET
    @Path("/test")
    public String testing(){
        return "OK";
    }
    @GET
    @Path("/test2")
    public Response testing2(){
         return Response.status(Response.Status.OK).entity("OK").build();
    }


    /*
      Returns all groups an User can see/subscribe to
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
      Returns all details about a certain group with all Questions that belong to it
     */
    @GET
    @Path("/{id}")
    public Response getByPK(@PathParam("id") int id){

        /*
        

        
        group.setQuestions(questionsMock);

        if(id < 10){
            return Response.status(Response.Status.OK).entity(group).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        * */
        
        Group group = new Group(id, "Group "+id, 4);
        List<Question> questionsMock = new ArrayList<Question>();
        
        for(int i=0; i<10; i++){
            if(i%3 == 0) questionsMock.add(new Question(i, "Tittttle of a question"+i, false));
            else questionsMock.add(new Question(i, "Tixxle of a question"+i, true));
        }
        GroupQuestion groupQuestion = new GroupQuestion(group, questionsMock);
        
        if(id < 10){
            return Response.status(Response.Status.OK).entity(groupQuestion).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("id:"+id+" no no").build();
        }

    }

    /*
    //EXAMPLES!!!

	  //Return a meter for an ID
	 
	  @GET
	 
	  @Path("/{param}") public Meter getMeterByPK(@PathParam("param") int
	  meterId) { return meterDao.findMeterById(meterId); }
	 
	  //Create a new meter when a POST request for /meters comes
	 
	  @POST
	 
	  @Consumes(MediaType.APPLICATION_JSON) public Response createMeter(Meter
	  newMeter) { //The JSON found in body will automagically be converted into
	  Meter object
	 
	  //If the returned meter is null and id 0 it means that there was a
	  request to UPDATE something that doesn't exist.... if(newMeter.getName()
	  == ""){ return Response.status(404).build(); }else if(newMeter.getName()
	  == null){ return Response.status(404).build(); }else { return
	  Response.status(200).entity(meterDao.createMeter(newMeter)).build(); }
	 
	  }
	 
	  //Updates existing meter
	 
	  @PUT
	 
	  @Path("/{param}")
	 
	  @Consumes(MediaType.APPLICATION_JSON) public Response
	  updateMeter(@PathParam("param") int meterId, Meter meterJson) { //The
	  JSON found in body will automagically be converted into Meter object
	 
	  Meter meter = meterDao.updateMeter(meterId, meterJson);
	 
	  //If the returned meter is null and id 0 it means that there was a
	  request to UPDATE something that doesn't exist.... if(meter.getName() ==
	  null){ return Response.status(404).build(); } else { return
	  Response.status(200).entity(meterDao.updateMeter(meterId,
	  meterJson)).build(); } }
	 
	 
	  //Delete existing meter
	 
	  @DELETE
	 
	  @Path("/{param}")
	 
	  @Consumes(MediaType.APPLICATION_JSON) public Response
	  updateMeter(@PathParam("param") int meterId) { //The JSON found in body
	  will automagically be converted into Meter object
	 
	  //If the returned meter is null and id 0 it means that there was a
	  request to UPDATE something that doesn't exist....
	  if(meterDao.deleteMeter(meterId) != false){ return
	  Response.status(200).build(); } else { return
	  Response.status(200).build(); } }
          */

}
