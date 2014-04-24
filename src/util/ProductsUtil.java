package util;
import javax.jws.WebService;


//import beans.Product;
import dao.DatabaseConnection;
//import dao.ProductDAO;


import java.sql.*;
@WebService
public class ProductsUtil {
	public String[] categories() throws SQLException{
	    DatabaseConnection productDAOObj = new DatabaseConnection();
		String[] products = productDAOObj.categories();
		
		return products;
	}
	public boolean insertBoard(String Name,String Description,String Categories) throws SQLException{
	    DatabaseConnection productDAOObj = new DatabaseConnection();
		boolean result = productDAOObj.insertBoard(Name,Description,Categories);
		
		return result;
	}
}
