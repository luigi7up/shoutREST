package com.shoutplatform.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import com.sun.jersey.api.NotFoundException;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/*
 * Jersey provides a way of definibng your own Exception handlers through @Provide annotation and 
 * implementation of ExceptionMapper.
 * NotFoundException is thrown when a unknown resource is asked for. For example if a client asks for
 * /rest/unknown-resource this exception will be thrown. The server returns 404
 */
@Provider
public class BadURIExceptionMapper implements ExceptionMapper<NotFoundException> {

	private static Logger log = Logger.getLogger(BadURIExceptionMapper.class.getName());
	
        @Override
	public Response toResponse(NotFoundException exception){
            log.info(exception.getClass()+": Client asked for an unknown resource. e.getMessage(): "+exception.getMessage());            
            // return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(exception.getClass().toString(), exception.getMessage())).build();
            return Response.status(Response.Status.NOT_FOUND).entity("Guess we don't have this URI :( ").build();
	}
}
