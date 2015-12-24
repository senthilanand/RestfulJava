package com.senthilc.java;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.json.JSONException;

@Path("/ftocservice")
public class FtoCService {
	
	@GET
	@Produces("application/json")
	public Response convertFtoC() {
		Double farenheit=98.2;
		Double celsius = (farenheit-32)*5/9;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("From, F Value", farenheit);
		jsonObject.put("To, C Value", celsius);
		
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoCInput(@PathParam("f") Double celsius) {
		Double farenheit = (celsius-32)*5/9;
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("From, F Value", farenheit);
		jsonObject.put("To, C Value", celsius);

		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();

	}
}
