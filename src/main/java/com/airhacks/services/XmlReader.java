package com.airhacks.services;

import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.airhacks.entities.Car;

@Consumes(MediaType.APPLICATION_XML)
@Path("xml")
@Stateless
public class XmlReader {
	
	@POST
	@Path("read")
	public Response readXml(@Valid Car car) {
		System.out.println(car);
		return Response.ok().status(Status.OK).build();
	}
}