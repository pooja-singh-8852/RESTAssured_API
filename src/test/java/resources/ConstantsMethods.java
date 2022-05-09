package resources;

public enum ConstantsMethods {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	deleteplaceapi("/maps/api/place/delete/json");
	private String resource;

	ConstantsMethods(String resource) 
	{
		this.resource=resource;
	}

	public String getresource()
	{
		return resource;
	}
}
