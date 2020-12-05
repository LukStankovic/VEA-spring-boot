package cz.vsb.fei.veadu.entities.jdbc;

public class Stock {

	private long id;
	
	private String name;
	
	private String location;
	
	private int area;
	
	public Stock() {
		super();
	}

	public Stock(int id, String name, String location, int area) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.area = area;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
}
