package com.airhacks.services;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import com.airhacks.entities.Car;

@Path("XSD")
public class XsdRequestService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public void xsd(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Car.class);
		jc.generateSchema(new SchemaOutputResolver() {
			@Override
			public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
				return new StreamResult(suggestedFileName);
			}

		});
	}

}
