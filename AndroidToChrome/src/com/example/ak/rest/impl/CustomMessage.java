package com.example.ak.rest.impl;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.ak.database.TempDataHolder;

@Path("/CustomMessage/")
public class CustomMessage {
	
	//TempDataHolder dataHolder = new TempDataHolder();
	
	@GET
	@Produces("application/json")
	@Path("/message/{MESSAGE}/")
	public String getCustomMessage(@PathParam("MESSAGE") String MESSAGE) {
		TempDataHolder.addString(MESSAGE);
		return MESSAGE;
	}

}
