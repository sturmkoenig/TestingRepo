package com.airhacks;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
@RequestScoped
public class Root {
	@GET
	public Response index() {
		return Response.ok().build();
	}

}
