package product.entities;

public class Product {
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", brand=" + brand + ", description="
				+ description + "]\n";
	}
	private int id;
	private String name;
	private float price;
	private String brand;
	private String description;
	public Product(String name, float price, String brand, String description) {
		super();
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.description = description;
	}
	
	public Product() {
		super();
	}

	public Product(int id, String name, float price, String brand, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
