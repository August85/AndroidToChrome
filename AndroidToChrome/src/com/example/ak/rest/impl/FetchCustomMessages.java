package com.example.ak.rest.impl;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.ak.database.TempDataHolder;

@Path("/FetchCustomMessage/")
public class FetchCustomMessages {
	
	@GET
	@Produces("application/json")
	@Path("/AllMessages")
	public String getAllCustomMessages( ) {
		String returnString = "";
		List<String> tempMessages = new ArrayList<String>();
		tempMessages = TempDataHolder.getMessages();
		for(String message: tempMessages) {
			returnString = returnString.concat(message);
			returnString = returnString.concat(":");
		}
		return returnString;
		
		//return TempDataHolder.getMessages();
	}
	
	@GET
	@Produces("application/json")
	@Path("/LastMessage")
	public String getLastCustomMessages( ) {
		
		return TempDataHolder.getLastString();
		
		//return TempDataHolder.getMessages();
	}



}
