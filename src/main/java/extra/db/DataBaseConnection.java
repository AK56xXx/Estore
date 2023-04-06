package extra.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/*
* DataBaseConnection.java
* Permet de se connecter et de se d�connecter � une base de donn�e mysql
* Permet de v�rifier le login d'un utilisateur
* Permet d'ajouter un nouveau utilisateur
*/

public class DataBaseConnection {
	
	public static String url;
	public static String dataBaseHot = "localhost";
	public static String dataBasePort = "3306";
	public static String dataBaseName = "estore";
	public static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static String dataBaseUser = "admin";
	public static String dataBasePassword = "";
	
	public static Connection con;
	public static PreparedStatement ps;
	public static Statement st;
	public static ResultSet rs;
	String query;
	

	/**
	 * Returns la connexion de notre base de donn�es
	 * @return cn
     */
	public static Connection getConnected()   {
		try{
			url = "jdbc:mysql://"+dataBaseHot+":"+dataBasePort+"/"+dataBaseName+timeZone;
			
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, dataBaseUser, dataBasePassword);
		}
		catch(Exception e){
			System.out.println("Connection failed : "+e);
			return null;
		}
		
		return con;
	}
	 
	/**
	 * Permet de se d�connecter de la base de donn�es
     */
	public static void releaseConnection()  {
		try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

    /**
     * Returns l'�tat de la v�rification d'un utilisateur
     * @param email
     * @param password
     * @return un entier O, 1 ou -1
     */
	public static int verifyLogin(String email, String password) {
		 try {
			  ps=con.prepareStatement("SELECT * from users where email=? and password=?");
			  ps.setString(1, email);
			  ps.setString(2, password);
			  rs=ps.executeQuery();
			  if(rs.next())
				  return 1;
			  else
				  return 0;
		}catch(Exception e) {
				System.out.println("Connection error : verifyLogin");
			}
			
		return -1;
	}
	
	
	public static String getUserByEmail(String email) {
		 try {
			  ps=con.prepareStatement("SELECT * from users where email=?");
			  ps.setString(1, email);
			  rs=ps.executeQuery();
			  if(rs.next())
				  return rs.getString(2);
			  else
				  return null;
		}catch(Exception e) {
				System.out.println("Connection error : verifyLogin");
			}
			
		return null;
	}
	
	
	public static String getUserNameByEmail(String email) {
		 try {
			  ps=con.prepareStatement("SELECT * from users where email=?");
			  ps.setString(1, email);
			  rs=ps.executeQuery();
			  if(rs.next())
				  return rs.getString(2);
			  else
				  return null;
		}catch(Exception e) {
				System.out.println("Connection error : verifyLogin");
			}
			
		return null;
	}
	
	public static int exist(String email) {
		 try {
			  ps=con.prepareStatement("SELECT * from users where email=?");
			  ps.setString(1, email);
			  rs=ps.executeQuery();
			  if(rs.next())
				  return 1;
			  else
				  return 0;
		}catch(Exception e) {
				System.out.println("Connection error : exist");
			}
			
		return -1;
	}
	
	
	/**
     * Ajouter un nouveau utilisateur dans la base de donn�es
     * @param email
     * @param fullName
     * @param password
     */
	public static int createUser(String fullName, String email, String password) {
		try {
			ps=con.prepareStatement("INSERT INTO users (fullName,email,password) Values (?, ?, ?)");
			ps.setString(1,fullName);
			ps.setString(2,email);
		    ps.setString(3,password);
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : createUser " +e );
		}
		return -1;		
	}
}
