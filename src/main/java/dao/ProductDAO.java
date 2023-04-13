package dao;

import java.util.ArrayList;

import models.Product;


public interface ProductDAO {
	
	public int addProduct(Product product);
	public int updateProduct(Product product);
	public Product getProductById(int id);
	public ArrayList<Product> getAllProducts();
	public int deleteProduct(int id);

}
