package org.andrbars.server;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.andrbars.api.ISample;
import org.andrbars.api.domain.Item;
import org.andrbars.api.exception.SampleException;
import org.andrbars.rest4j.RestConst;

@Path(ISample.RESOURCE)
@Produces(RestConst.APPLICATION_JSON_UTF_8)
@Consumes(MediaType.APPLICATION_JSON)
public class Sample implements ISample
{

	private static final Map<Long, Item> items;

	static
	{
		items = new HashMap<Long, Item>()
		{
			{
				put(1L, new Item(1L, "Йо Йо 1", new Date()));
				put(2L, new Item(2L, "Item 2", new Date()));
				put(3L, new Item(3L, "Item 3", new Date()));
				put(4L, new Item(4L, "Item 4", new Date()));
				put(5L, new Item(5L, "Item 5", new Date()));
				put(6L, new Item(6L, "Item 6", new Date()));
				put(7L, new Item(7L, "Item 7", new Date()));
				put(8L, new Item(8L, "Item 8", new Date()));
				put(9L, new Item(9L, "Item 9", new Date()));
			}
		};
	}

	@Override
	public Collection<Item> getItems()
	{
		if (items.isEmpty())
		{
			throw new SampleException("привет");
		}

		return items.values();
	}

	@Override
	public Item getItem(Long itemId)
	{
		if (itemId == null)
		{
			throw new IllegalArgumentException("Не задано значение параметра itemId");
		}

		return items.get(itemId);
	}

	@Override
	public boolean createItem(Item item)
	{
		return items.put(item.getId(), item) == null;
	}

	@Override
	public boolean updateItem(Item item)
	{
		if (item == null)
		{
			throw new IllegalArgumentException("Не задано значение параметра item");
		}
		if (item.getId() == null)
		{
			throw new IllegalArgumentException("Не задано значение идентификатора item.getId()");
		}

		return items.put(item.getId(), item) != null;
	}

	@Override
	public boolean deleteItem(Long itemId)
	{
		if (itemId == null)
		{
			throw new IllegalArgumentException("Не задано значение параметра itemId");
		}

		return items.remove(itemId) != null;
	}

	@Override
	public boolean updateItem2(Long itemId, String caption, String description,
		UUID tag, String group, String userAgent)
	{
		Item item = items.get(itemId);
		if (item != null)
		{
			item.setCaption(caption);
			item.setDescription(description);
			item.setTag(tag);
			item.setGroup(group);
		}

		return item != null;
	}

	@Override
	public boolean updateItem3(Long itemId, String caption, String description,
		UUID tag, String group, String userAgent)
	{
		Item item = items.get(itemId);
		if (item != null)
		{
			item.setCaption(caption);
			item.setDescription(description);
			item.setTag(tag);
			item.setGroup(group);
		}

		return item != null;
	}

	@Override
	public boolean updateItem4(Long itemId, String caption, String description,
		UUID tag, String group, String userAgent)
	{
		Item item = items.get(itemId);
		if (item != null)
		{
			item.setCaption(caption);
			item.setDescription(description);
			item.setTag(tag);
			item.setGroup(group);
		}

		return item != null;
	}
}
