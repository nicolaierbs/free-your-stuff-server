package freeyourstuff.rest.jersey.server;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import freeyourstuff.data.model.Item;
import freeyourstuff.data.store.ItemStore;

@Path("/")
public class RestServer {
	
	@GET
	@Path("query")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems(
			@QueryParam("lon") double longitude,
			@QueryParam("lat") double latitude){
		System.out.println("Query at: " + longitude + " " + latitude);
		return ItemStore.getItems(longitude, latitude);
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addItem(Item item){
		String result = "Record entered: "+ item;
		System.out.println("Added item: " + item.toString());
		ItemStore.addItem(item);
		return Response.status(201).entity(result).build();
	}
}
