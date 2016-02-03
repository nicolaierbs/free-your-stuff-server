package freeyourstuff.data.model;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ItemMapper {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String mapToJson(Item item) throws JsonGenerationException, JsonMappingException, IOException{
		return mapper.writeValueAsString(item);
		
	}

	public static Item mapToItem(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		return mapper.readValue(jsonString, Item.class);
		
	}

}
