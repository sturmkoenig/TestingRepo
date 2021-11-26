package com.airhacks.services;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.airhacks.entities.User;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SQLRequest {

	@Inject
	QueryService queryService;

	@Context
	UriInfo uriInfo;

	@Path("query")
	@GET
	public List<User> getUser() {
		List<User> users = queryService.getUsers();
		return users;
	}

	@GET
	@Path("user/{id: \\d+}")
	public Response getUserById(@PathParam("id") Long id) {
		System.out.println(id);
		User user = queryService.findUserById(id);
		return Response.ok(user).status(Response.Status.OK).build();
	}

	@POST
	@Path("user")
	public Response setUser(User user) {
		queryService.setUser(user);
		URI uri = uriInfo.getAbsolutePathBuilder().path(user.getUserId().toString()).build();
		return Response.created(uri).status(Response.Status.CREATED).build();
	}

}
