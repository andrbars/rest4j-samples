package org.andrbars.api;

import org.andrbars.rest4j.RestConst;
import java.util.Collection;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.andrbars.api.domain.Item;

public interface ISample
{

	@GET
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	Collection<Item> getItems();

	@GET
	@Path("{itemId: \\d+}")
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("itemId") Long itemId)
		throws IllegalArgumentException;

	@POST
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean createItem(Item item);

	@PUT
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateItem(Item item)
		throws IllegalArgumentException;

	@DELETE
	@Path("{itemId: \\d+}")
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteItem(@PathParam("itemId") Long itemId)
		throws IllegalArgumentException;

	@PUT
	@Path("ext")
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateItem2(@QueryParam("itemId") Long itemId, @QueryParam("caption") String caption,
		@QueryParam("description") String description, @QueryParam("tag") UUID tag,
		@CookieParam("group") String group, @HeaderParam("userAgent") String userAgent);

	@PUT
	@Path("ext2")
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateItem3(@MatrixParam("itemId") Long itemId, @MatrixParam("caption") String caption,
		@MatrixParam("description") String description, @QueryParam("tag") UUID tag,
		@CookieParam("group") String group, @HeaderParam("userAgent") String userAgent);

	@PUT
	@Path("ext3")
	@Produces(RestConst.APPLICATION_JSON_UTF_8)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean updateItem4(@FormParam("itemId") Long itemId, @FormParam("caption") String caption,
		@FormParam("description") String description, @QueryParam("tag") UUID tag,
		@CookieParam("group") String group, @HeaderParam("userAgent") String userAgent);
}
