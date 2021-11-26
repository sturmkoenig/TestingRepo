package com.airhacks.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;

import com.airhacks.entities.Car;

@Consumes(MediaType.APPLICATION_XML)
@Path("xml")
@Stateless
public class XmlReader {

	@Inject
	Logger logger;

	@POST
	@Path("read")
	public Response readXml(@Valid Car car) {
		String msg = "Reading car from Xml: " + car.toString();
		logger.info(msg);
		return Response.ok().status(Status.OK).build();
	}
}