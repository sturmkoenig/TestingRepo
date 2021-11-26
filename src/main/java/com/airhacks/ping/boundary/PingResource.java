package com.airhacks.ping.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.airhacks.beans.MessageGenerator;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

	@Inject
	MessageGenerator messageGenerator;

	@GET
	public String ping() {
		return messageGenerator.getMessage();
	}

}
