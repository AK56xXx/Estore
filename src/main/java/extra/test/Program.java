package extra.test;

import dao.*;
import models.*;

@SuppressWarnings("unused")
public class Program {

	public static void main(String[] args) {
		
		Cart c1 = new Cart();
		ProductDAOImpl pd = new ProductDAOImpl();
		System.out.println(pd.getAllProducts());


	}

}
