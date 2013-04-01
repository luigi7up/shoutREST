package com.shoutplatform.exceptions;

import com.shoutplatform.domain.objects.Category;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.sun.jersey.api.container.ContainerException;
import java.util.logging.Level;
import org.apache.log4j.Logger;

@Provider
public class UnavailableURIExceptionMapper implements ExceptionMapper<ContainerException> {

        private static Logger log = Logger.getLogger(BadURIExceptionMapper.class.getName());
        
	@Override
	public Response toResponse(ContainerException exception) {
                log.info(exception.getClass().toString()+" UnavailableURIExceptionMapper "+exception.getMessage());                
		//return Response.status(Response.Status.NOT_FOUND).entity(new ErrorResponse(exception.getClass().toString(), exception.getMessage())).build();
		return Response.status(Response.Status.BAD_REQUEST).entity("This URI is unavailable").build();
	}
}