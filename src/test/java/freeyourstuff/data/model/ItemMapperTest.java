package freeyourstuff.data.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;

public class ItemMapperTest {
	
	private Item item;
	private String jsonString;

	@Before
	public void setUp() throws Exception {
		item = Item.getDummyItem();
//		System.out.println(ItemMapper.mapToJson(item));
		
		jsonString = "{\"id\":\"Id0\",\"user\":\"User0\",\"summary\":\"summary\",\"description\":\"description\",\"longitude\":0.0,\"latitude\":0.0,\"type\":\"NEED\",\"date\":1451755891633}";
	}

	@Test
	public void testMapToJson() throws JsonGenerationException, JsonMappingException, IOException {
		assertEquals(jsonString, ItemMapper.mapToJson(item));
	}

	@Test
	public void testMapToItem() throws JsonParseException, JsonMappingException, IOException {
		Item item2 = ItemMapper.mapToItem(jsonString);
		System.out.println(item2);
		assertEquals(item.getId(), item2.getId());
	}

}
