package org.andrbars.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Item implements Serializable
{

	private Long id;
	private String caption;
	@JsonFormat(shape = JsonFormat.Shape.NUMBER)
	private Date date;
	private String description;
	private String group;
	private UUID tag;

	public Item()
	{
	}

	public Item(Long id, String caption, Date date)
	{
		this.id = id;
		this.caption = caption;
		this.date = date;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCaption()
	{
		return caption;
	}

	public void setCaption(String caption)
	{
		this.caption = caption;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getGroup()
	{
		return group;
	}

	public void setGroup(String group)
	{
		this.group = group;
	}

	public UUID getTag()
	{
		return tag;
	}

	public void setTag(UUID tag)
	{
		this.tag = tag;
	}

	@Override
	public String toString()
	{
		return "Item{" + "id=" + id + ", caption=" + caption + ", date=" + date + ", description=" + description + ", group=" + group + ", tag=" + tag + '}';
	}

}
