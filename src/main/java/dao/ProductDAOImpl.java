package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Product;

public class ProductDAOImpl implements ProductDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public ProductDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addProduct(Product product) {
		try {
			ps=con.prepareStatement("INSERT INTO product (id_category,name_product,descreption,price,old_price,image) Values (?,?,?,?,?,?)");
			
			ps.setInt(1, product.getIdCategory());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			ps.setDouble(5, product.getOldPrice());
			
			
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : addProduct " +e );
		}
		return -1;		
	}

	@Override
	public int updateProduct(Product product) {
		try {
			ps=con.prepareStatement("update product set id_category=?, name_product=?, descreption=?, price=?, old_price=?, image=?"
					+ "where id_product=?");
			
			ps.setInt(1, product.getIdCategory());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			ps.setDouble(5, product.getOldPrice());
			

			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : updateProduct " +e );
		}
		return -1;		
	}

	@Override
	public Product getProductById(int id) {
		try {
			Product product = new Product();
			ps=con.prepareStatement("select * from product where id_product=?");
			
			ps.setInt(1,id);

			rs = ps.executeQuery();
	
			if (rs.next()) {
				
				product.setIdProduct(rs.getInt(1));
				product.setIdCategory(rs.getInt(2));
				product.setProductName(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getDouble(5));
				product.setOldPrice(rs.getDouble(6));
				product.setImage(rs.getString(7));
						
			}
			return product;

		} catch (Exception e) {
			System.out.println("Connection error : getProductById");
		}

		return null;
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		try {
			Product product = new Product();
			ArrayList<Product> list = new ArrayList<Product>();
			ps = con.prepareStatement("SELECT * from product");
			rs = ps.executeQuery();
			while (rs.next()) {
				
				product.setIdProduct(rs.getInt(1));
				product.setIdCategory(rs.getInt(2));
				product.setProductName(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getDouble(5));
				product.setOldPrice(rs.getDouble(6));
				product.setImage(rs.getString(7));
			
				list.add(product);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllProducts");
		}

		return null;
	}

	@Override
	public int deleteProduct(int id) {
		try {
			ps=con.prepareStatement("DELETE from product where id_product=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : deleteProduct " +e );
		}
		return -1;		
	}

	@Override
	public ArrayList<Product> getAllProductsByCategory(int id) {
		try {
			
			ArrayList<Product> list = new ArrayList<Product>();
			ps = con.prepareStatement("SELECT * from product where id_category=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setIdProduct(rs.getInt(1));
				product.setIdCategory(rs.getInt(2));
				product.setProductName(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setPrice(rs.getDouble(5));
				product.setOldPrice(rs.getDouble(6));
				product.setImage(rs.getString(7));
			
				list.add(product);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllProductsByCategory");
		}
		return null;
	}

}
