package com.senthilc.java;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.json.JSONException;

@Path("/ctofservice")
public class CtoFService {
	
	@GET
	@Produces("application/json")
	public Response convertCtoF() {
		Double farenheit;
		Double celsius = 36.8;
		farenheit = (celsius*9/5)+32;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("F Value", farenheit);
		jsonObject.put("C Value", celsius);
		
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@Path("{c}")
	@GET
	@Produces("application/json")
	public Response convertCToFInput(@PathParam("c") Double celsius) {
		Double farenheit = (celsius*9/5)+32;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("F Value", farenheit);
		jsonObject.put("C Value", celsius);

		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();

	}
}
