package freeyourstuff.data.store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import freeyourstuff.data.model.Item;

public class ItemStore {
	
	private static ItemStore itemStore;
	
	private List<Item> items;
	
	private ItemStore(){
		items = new ArrayList<Item>();
	}
	
	private static void initialize(){
		itemStore = new ItemStore();
	}
	
	public static List<Item> getItems(double longitude, double latitude){
		if(itemStore == null){
			initialize();
		}
		List<Item> filteredItems = new ArrayList<Item>();
		for(Item item : itemStore.items){
			if(item.isValid(longitude, latitude)){
				filteredItems.add(item);
			}
		}
		return filteredItems;
	}
	
	public static void addItem(Item item){
		if(itemStore == null){
			initialize();
		}
		item.setDate(new Date());
		itemStore.items.add(item);
	}

}
