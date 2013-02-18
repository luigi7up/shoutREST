package com.shoutplatform.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import com.shoutplatform.domain.Group;
import com.sun.jersey.api.container.ContainerException;
import java.util.logging.Level;

@Provider
public class UnavailableURIExceptionMapper implements ExceptionMapper<ContainerException> {

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BadURIExceptionMapper.class.getName());
        
	@Override
	public Response toResponse(ContainerException exception) {
                logger.log(Level.INFO, "ContainerException {0}", exception.getClass().toString());                
		//return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(exception.getClass().toString(), exception.getMessage())).build();
		return Response.status(Response.Status.BAD_REQUEST).entity(new Group(100,"aaa",12)).build();
	}
}