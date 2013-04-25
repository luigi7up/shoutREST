package com.shoutplatform.restresources;
import com.shoutplatform.domain.objects.Category;
import com.shoutplatform.domain.dao.ICategoryDAO;
import com.shoutplatform.domain.dao.MyBatisConnectionFactory;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * Categories is a resource available at /rest/groups. Check out each of the methods and paths to which they
 * respond
 */
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class Categories{
    private static Logger log = Logger.getLogger(Categories.class);
    /**
     * This method responds to GET /rest/categories/
     * @return a json containing all the groups this user can see with the status code
     */
    @GET
    public Response getAll(){                
        log.info("getting /categories");
        //GET ALL CATEGORIES
        SqlSession sqlSession = MyBatisConnectionFactory.getSession().openSession();
        List<Category> categories = null;
        try{
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            categories = categoryMapper.getAllCategories();
            sqlSession.commit();            
        }finally{
           sqlSession.close();
        }
        return Response.status(Response.Status.OK).entity(categories).build();
    }
    
    /**
     * This method responds to GET /rest/groups/_id where _id is the ID of a group
     * you want to fetch the details for
     * @return Returns a json with all the questions found in that group
     */
    @GET    
    @Path("/{id}")     
    public Response getByPK(@PathParam("id") int id){        
        log.info("getting /categories/"+id);
        SqlSession sqlSession = MyBatisConnectionFactory.getSession().openSession();
        Category category = null;
        try{            
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            category = categoryMapper.getCategoryWithQuestions(id);            
            sqlSession.commit();            
        }catch(Exception e){
            log.error("Exception caught in Categories.getByPK("+id+"). Details"+e.getMessage()+e.getStackTrace());
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An exception caught! Sorry").build();
        }finally{
           sqlSession.close();
        }
        
        if(category!=null){
            return Response.status(Response.Status.OK).entity(category).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("Category with "+id+" not found").build();
        }
    }
    
 
    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)    
    public Response insertCategory(Category category) {
        SqlSession sqlSession = MyBatisConnectionFactory.getSession().openSession();
        try{            
            ICategoryDAO categoryMapper = sqlSession.getMapper(ICategoryDAO.class);
            categoryMapper.insertCategory(category);         
            sqlSession.commit();              
            log.info("New category \""+category.getName()+"\" added");
        }catch(Exception e){
            log.error("Exception caught in Categories.insertCategory(). Details"+e.getMessage()+e.getStackTrace());
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An exception caught! Sorry").build();
        }finally{
           sqlSession.close();
        }
        
        return Response.status(Response.Status.OK).entity(category).build();
        
    }
    
    
}
