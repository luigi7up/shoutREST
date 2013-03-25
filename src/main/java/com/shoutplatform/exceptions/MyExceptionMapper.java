package com.shoutplatform.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/*
 * This is our custom Exception that encapsulates the "normal" Exception.
 * At the moment it's not doing a lot
 */
@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception> {

        private static Logger log = Logger.getLogger(ExceptionMapper.class.getName());
        
        @Override
	public Response toResponse(Exception exception){
               
               log.debug("MyException wraps: "+exception.getClass().toString()+ "message is " +exception.getMessage()); 
               
                // return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(exception.getClass().toString(), exception.getMessage())).build();
		return Response.status(Response.Status.NOT_FOUND).build();
	}

   
}
