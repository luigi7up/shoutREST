package com.shoutplatform.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import com.shoutplatform.domain.Group;
import com.sun.jersey.api.NotFoundException;
import com.sun.jersey.api.ParamException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Jersey provides a way of definibng your own Exception handlers through @Provide annotation and 
 * implementation of ExceptionMapper.
 * ParamException is thrown when a /resource/param is asked but the parameter type is not expected. 
 * For example if a client asks for /rest/groups/abc and the APIs expect int instead of String
 */
@Provider
public class BadParamExceptionMapper implements ExceptionMapper<ParamException> {
	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BadURIExceptionMapper.class.getName());	
        @Override
	public Response toResponse(ParamException exception){
            logger.log(Level.INFO, "{0} Resource can't be identified with parameter provided {1}", new Object[]{exception.getClass().toString(), exception.getMessage()});            
            // return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(exception.getClass().toString(), exception.getMessage())).build();
            return Response.status(Response.Status.BAD_REQUEST).build();
	}
}
