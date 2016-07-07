package org.andrbars.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import org.andrbars.api.ISample;
import org.andrbars.api.domain.Item;
import org.andrbars.rest4j.RestProxy;

public class Client
{

	private static final ObjectMapper mapper;

	static
	{
		mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	private static void logAsJson(Object value)
	{
		if (value != null)
		{
			try
			{
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				String valueOutput = mapper.writeValueAsString(value);
				String[] names = value.getClass().getName().split("\\.");
				System.out.println(names[names.length - 1] + " -> " + valueOutput);
			}
			catch (IOException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		else
		{
			System.out.println("null");
		}
	}

	public static void main(String[] args)
	{
		Item response;

		ISample client = RestProxy.get(ISample.class, "http://localhost:8080/server/items");

		System.out.println("getItem ====================");
		response = client.getItem(1L);
		logAsJson(response);

		System.out.println("updateItem =================");
		response = client.getItem(1L);
		response.setDate(new Date());
		client.updateItem(response);
		logAsJson(response);
		logAsJson(client.getItems());

		System.out.println("updateItem2 ================");
		response = client.getItem(1L);
		client.updateItem2(response.getId(), response.getCaption() + "_1", "Йо Йо",
			UUID.randomUUID(), "гр gr", "uзер");
		logAsJson(client.getItems());

		System.out.println("updateItem3 ================");
		response = client.getItem(1L);
		client.updateItem3(response.getId(), response.getCaption() + "_1", "Йо Йо",
			UUID.randomUUID(), "гр gr", "uзер");
		logAsJson(client.getItems());

		System.out.println("updateItem4 ================");
		response = client.getItem(1L);
		client.updateItem4(response.getId(), response.getCaption() + "_1", "Йо Йо",
			UUID.randomUUID(), "гр gr", "uзер");
		logAsJson(client.getItems());

		System.out.println("createItem =================");
		response = new Item(10L, "Item 10", new Date());
		client.createItem(response);
		logAsJson(response);
		logAsJson(client.getItems());

		System.out.println("deleteItem =================");
		client.deleteItem(response.getId());
		logAsJson(response);
		logAsJson(client.getItems());

		System.out.println("deleteItem =================");
		client.deleteItem(response.getId() + 1);
		logAsJson(response);
		logAsJson(client.getItems());
	}
}
