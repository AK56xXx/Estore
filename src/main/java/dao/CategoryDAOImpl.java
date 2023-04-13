package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Category;

public class CategoryDAOImpl implements CategoryDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CategoryDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addCategory(Category category) {	
		try {
			ps=con.prepareStatement("INSERT INTO category (name) Values (?)");
			ps.setString(1,category.getNameCategory());
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : addCategory " +e );
		}
		return -1;		
	}

	@Override
	public int updateCategory(Category category) {
		try {
			ps=con.prepareStatement("update category set name=?"
					+ "where id_category=?");
			
			ps.setString(1,category.getNameCategory());
			ps.setInt(2,category.getIdCategory());

			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : updateCategory " +e );
		}
		return -1;		
	}

	@Override
	public Category getCategoryById(int id) {	
		try {
			Category category = new Category();
			ps=con.prepareStatement("select * from category where id_category=?");
			
			ps.setInt(1,id);

			rs = ps.executeQuery();
	
			if (rs.next()) {
				
				category.setIdCategory(rs.getInt(1));
				category.setNameCategory(rs.getString(2));
		
			}
			return category;

		} catch (Exception e) {
			System.out.println("Connection error : getCategoryById");
		}

		return null;
		
	}

	@Override
	public ArrayList<Category> getAllCategories() {
		try {
			ArrayList<Category> list = new ArrayList<Category>();
			ps = con.prepareStatement("SELECT * from category");
			rs = ps.executeQuery();
			while (rs.next()) {
			Category category = getCategoryById(rs.getInt(1));
				list.add(category);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllCategories");
		}

		return null;
	}

	@Override
	public int deleteCategory(int id) {
		try {
			ps=con.prepareStatement("DELETE from category where id_category=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : deleteCategory " +e );
		}
		return -1;		
	}

}
