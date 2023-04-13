package models;

public class Product {
	
	private int idProduct;
	private int idCategory;
	private String productName;
	private String description;
	private double price;
	private double oldPrice;
	private String image;
	
	public Product() {
		super();
	}

	public Product(int idProduct, int idCategory, String productName, String description, double price, double oldPrice,
			String image) {
		super();
		this.idProduct = idProduct;
		this.idCategory = idCategory;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.oldPrice = oldPrice;
		this.image = image;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", idCategory=" + idCategory + ", productName=" + productName
				+ ", description=" + description + ", price=" + price + ", oldPrice=" + oldPrice + ", image=" + image
				+ "]";
	}
	
	
	
	
	

}
