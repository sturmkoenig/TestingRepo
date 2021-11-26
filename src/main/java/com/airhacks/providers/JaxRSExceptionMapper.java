package com.airhacks.providers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class JaxRSExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response.status(Status.BAD_REQUEST).entity(prepareResponse(exception)).build();
	}

	private List<String> prepareResponse(ConstraintViolationException exception) {
		return exception.getConstraintViolations()
				.stream()
				.map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
				.collect(Collectors.toList());
	}

}
