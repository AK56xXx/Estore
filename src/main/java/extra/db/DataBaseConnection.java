package extra.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import extra.values.Strings;

import java.sql.SQLException;

/*
* DataBaseConnection.java
* Permet de se connecter et de se d�connecter � une base de donn�e mysql
* Permet de v�rifier le login d'un utilisateur
* Permet d'ajouter un nouveau utilisateur
*/

public class DataBaseConnection {

	public static String url;
	public static Connection con;
	public static PreparedStatement ps;
	public static Statement st;
	public static ResultSet rs;
	String query;

	/**
	 * Returns la connexion de notre base de donn�es
	 * 
	 * @return cn
	 */
	public static Connection getConnected() {
		try {
			url = "jdbc:mysql://" + Strings.DB_HOST + ":" + Strings.DB_PORT + "/" + Strings.DB_NAME
					+ Strings.DB_TIMEZONE;

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, Strings.DB_USER, Strings.DB_PASSWORD);
		} catch (Exception e) {
			System.out.println("Connection failed : " + e);
			return null;
		}

		return con;
	}

	/**
	 * Permet de se d�connecter de la base de donn�es
	 */
	public static void releaseConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
