package extra.test;

import java.util.ArrayList;
import java.util.Iterator;

import dao.*;
import models.*;

@SuppressWarnings("unused")
public class Program {

	public static void main(String[] args) {

		UserDAOImpl ud = new UserDAOImpl();
		CategoryDAOImpl ctg = new CategoryDAOImpl();
		ProductDAOImpl p = new ProductDAOImpl();
		CartItemDAOImpl ci = new CartItemDAOImpl();
		OrderDAOImpl o = new OrderDAOImpl();
		CartDAOImpl cd = new CartDAOImpl();

		// System.out.println(ud.getAllUsers());
		// System.out.println(ctg.getAllCategories());
		// System.out.println(p.getProductById(1));
		// System.out.println(ci.getCartItemById(3));
		// System.out.println(o.getAllOrdersByCart(1002));

	}

}
