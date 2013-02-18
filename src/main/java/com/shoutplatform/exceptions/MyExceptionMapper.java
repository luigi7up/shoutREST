package com.shoutplatform.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import com.shoutplatform.domain.Group;
import com.sun.jersey.api.NotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception> {

	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ExceptionMapper.class.getName());
	
        @Override
	public Response toResponse(Exception exception){
               
               logger.log(Level.INFO, "*/*/*/*/ MyException {0}", exception.getClass().toString());

                // return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(exception.getClass().toString(), exception.getMessage())).build();
		return Response.status(Response.Status.NOT_FOUND).build();
	}

   
}
