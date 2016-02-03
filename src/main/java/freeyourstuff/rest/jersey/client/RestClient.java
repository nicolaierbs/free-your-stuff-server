package freeyourstuff.rest.jersey.client;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {

	Client client = Client.create();
//	String getUrl = "http://localhost:8080/freeyourstuff/rest/query";
//	String postUrl = "http://localhost:8080/freeyourstuff/rest/add";
	String getUrl = "http://54.93.62.108:8080/freeyourstuff/rest/query";
	String postUrl = "http://54.93.62.108:8080/freeyourstuff/rest/add";
	
	public void getRequest(){
//		WebResource webResource = client.resource(getUrl);
		WebResource webResource = client.resource(getUrl + "?lat=0.01&lon=0.02");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		
		String result = response.getEntity(String.class);
		System.out.println("Response from the Server: ");
		System.out.println(result);
	}
	
	public void postRequest(){
		WebResource webResource = client.resource(postUrl);
		String inputData = 
				"{\"id\":\"Id0\",\"user\":\"User0\",\"summary\":\"summary\",\"description\":\"description\",\"longitude\":0.0,\"latitude\":0.0,\"type\":\"NEED\",\"date\":1451755891633}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,inputData);
		if(response.getStatus()!=201){
			throw new RuntimeException("HTTP Error: "+ response.getStatus());
		}
		
		String result = response.getEntity(String.class);
		System.out.println("Response from the Server: ");
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		RestClient restClient = new RestClient();
		//fire the get request
		restClient.getRequest();
		
		//fire the post request
		restClient.postRequest();
	}
}
