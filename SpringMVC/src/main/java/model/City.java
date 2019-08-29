package model;

public class City {
	private int id;
	private String cityID;
	private String city;
	private String father;
	private String province;
	
	public City() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityID() {
		return cityID;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

}
