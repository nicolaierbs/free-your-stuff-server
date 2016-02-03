package freeyourstuff.data.model;

import java.util.Date;

public class Item {

	private String id;
	private String user;
	private String summary;
	private String description;
	private double longitude;
	private double latitude;
	private Type type;
	private Date date;
	
	public enum Type {NEED, GIVE};
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString(){
		return id+" "
				+user+" "
				+summary+" "
				+description+" "
				+longitude+" "
				+latitude+" "
				+date+" "
				+type;
	}

	public static Item getDummyItem() {
		Item item = new Item();
		item.setId("Id0");
		item.setUser("User0");
		item.setSummary("summary");
		item.setDescription("description");
		item.setLatitude(0.00);
		item.setLongitude(0.00);
		item.setDate(new Date());
		item.setType(Type.NEED);
		return item;
	}

	public boolean isValid(double userLongitude, double userLatitude) {
		// TODO Auto-generated method stub
		return true;
	}
}