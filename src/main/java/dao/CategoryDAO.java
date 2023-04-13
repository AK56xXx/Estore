package dao;

import java.util.ArrayList;

import models.Category;

public interface CategoryDAO {
	
	public int addCategory(Category category);
	public int updateCategory(Category category);
	public Category getCategoryById(int id);
	public ArrayList<Category> getAllCategories();
	public int deleteCategory(int id);
	

}
