package org.andrbars.client;

import java.util.Date;
import java.util.UUID;
import org.andrbars.api.ISample;
import org.andrbars.api.domain.Item;
import org.andrbars.rest4j.RestProxy;

public class Client
{

	public static void main(String[] args)
	{
		ISample client = RestProxy.get(ISample.class, "http://localhost:8080/server/items");

		Item response = client.getItem(1L);

		response.setDate(new Date());
		client.updateItem(response);

		client.updateItem2(response.getId(), response.getCaption() + "_1", "Йо Йо",
			UUID.randomUUID(), "гр gr", "uзер");

		client.updateItem3(response.getId(), response.getCaption() + "_1", "Йо Йо",
			UUID.randomUUID(), "гр gr", "uзер");

		client.updateItem4(response.getId(), response.getCaption() + "_1", "Йо Йо",
			UUID.randomUUID(), "гр gr", "uзер");

		response = new Item(10L, "Item 10", new Date());
		client.createItem(response);

		client.deleteItem(response.getId());

		client.deleteItem(response.getId() + 1);
	}
}
