package com.airhacks.providers;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.validation.Path;


@Provider
@Produces(MediaType.APPLICATION_XML)
public class JaxRSExceptionMapper implements ExceptionMapper<ConstraintViolationException>{

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response.status(Status.BAD_REQUEST).entity(prepareResponse(exception)).build();
	}
	
	private List<String> prepareResponse(ConstraintViolationException exception) {
		List<String> msg=exception.getConstraintViolations()
				.stream()
				.map(ConstraintViolation->ConstraintViolation.getPropertyPath() + ": " + ConstraintViolation.getMessage())
				.collect(Collectors.toList());
		return msg;
	}


}
