package com.senthilc.java;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.inject.Singleton;

import java.io.InputStream;
import java.net.URI;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONException;


@Singleton
@Path("/customers")
public class CustomerResource {
	private Map<Integer, Customer> customerDB 
		= new ConcurrentHashMap<Integer, Customer>();
	private AtomicInteger idCounter = new AtomicInteger();
	
	public CustomerResource() {
		
	}
	
	@GET
	@Produces("application/json")
	public Response listCustomers() {
		
		org.json.JSONArray jsonArray = new JSONArray();
										
		System.out.println("Size:"+customerDB.size());
		for (Integer key: customerDB.keySet()) {
			Customer cust = customerDB.get(key);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", cust.getId());
			jsonObject.put("firstName", cust.getFirstName());
			jsonArray.put(jsonObject);
		}
		String result = "@Produces(\"application/json\")" + jsonArray;
		System.out.println("Output:"+result);
		System.out.println("GET:"+this);
		return Response.status(200).entity(result).build();
	}

	
	@POST
	@Consumes("application/json")
	public Response createCustomer(InputStream is) {
		Customer customer = readCustomer (is);
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(idCounter.get(), customer);
		System.out.println("Created customer:" +customer.getId());
		System.out.println("Size:"+customerDB.size());
		System.out.println("POST:"+this);

		return Response.created(
				URI.create("/customers/"+customer.getId())
				).build();
	}
	
	/*
	 {
		"id": "1",
		"firstName": "senthilanand",
		"lastName": "chandrasekaran",
		"street": "erran street",
		"city": "chennai",
		"state": "tamilnadu",
		"zip": "600007",
		"country": "india"
	}
	 */
	Customer readCustomer (InputStream is) {
		try {
		       BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		       StringBuilder responseStrBuilder = new StringBuilder();

		       String inputStr;
		       while ((inputStr = streamReader.readLine()) != null)
		           responseStrBuilder.append(inputStr);

		       JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

		       //returns the json object
		       return new Customer(jsonObject);

		   } catch (IOException e) {
		       e.printStackTrace();
		   } catch (JSONException e) {
		       e.printStackTrace();
		   }
		return null;
		}
}	
