/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoutplatform.restresources;

import com.shoutplatform.domain.dao.ICategoryDAO;
import com.shoutplatform.domain.dao.MyBatisConnectionFactory;
import com.shoutplatform.domain.objects.Category;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 *
 * @author luka
 */
@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
public class Questions {
    
    private static final Logger log = Logger.getLogger(Categories.class);
    /**
     * This method responds to GET /rest/questions/_id where _id is the ID of a question
     * you want to fetch the details for
     * @return Returns a json with all the details for a question with the ID
     */
    @GET    
    @Path("/{id}")     
    public Response getByPK(@PathParam("id") int id){        
        
        SqlSession sqlSession = MyBatisConnectionFactory.getSession().openSession();
        Category category = null;
        try{            
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            category = categoryMapper.getCategoryWithQuestions(id);            
            sqlSession.commit();            
        }finally{
           sqlSession.close();
        }
        
        if(category!=null){
            return Response.status(Response.Status.OK).entity(category).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("Category with "+id+" not found").build();
        }
    }
}    