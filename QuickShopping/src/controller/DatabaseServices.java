package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Shop;

public class DatabaseServices {

	   public Connection connectionInit()
	   {
			Connection conn = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/QuickShopping","root","root");
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

	       return conn;
	   }

		public int getIntFromDB(String selectWhat, String fromWhere, String whereWhat)
		{
			Connection conn = connectionInit();
	                Statement stmt = null;
			String query = "SELECT "+selectWhat+" FROM "+fromWhere+" WHERE " +whereWhat;
	                int i = 0;
			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				if (rs.next())
				{
				i = rs.getInt(selectWhat);
				}
				rs.close();
				conn.close();
				stmt.close();

			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	                    return i;

		}

			public int getRecordQuantityFromDB(String fromWhere)
		{
			Connection conn = connectionInit();
	        Statement stmt = null;
			String query = "SELECT * FROM "+fromWhere;
	        int i = 0;
			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
			    while(rs.next())
					{
						i++;
					}
				rs.close();
				conn.close();
				stmt.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	                    return i;

		}

		public String getStringFromDB(String selectWhat, String fromWhere, String whereWhat)
		{
		    Connection conn = connectionInit();
	            Statement stmt = null;
			String query = "SELECT "+selectWhat+" FROM "+fromWhere+" WHERE " +whereWhat;
			String s ="";
			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next())
				{
					s = rs.getString(selectWhat);
				}
				rs.close();
				conn.close();
				stmt.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return s;
		}

		public void insertDataToDB(String intoWhere, String insertWhat, String insertWhat2 )
		{
			Connection conn = connectionInit();
			PreparedStatement stmt = null;

			String query = "INSERT INTO "+intoWhere+" VALUES ( '" + insertWhat + "' , '" + insertWhat2+ "' )";

			try
			{
				stmt = conn.prepareStatement(query);
				stmt.executeUpdate(query);

			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}


		public void insertDataToDB(String intoWhere, String insertWhat )
		{
			Connection conn = connectionInit();
	                Statement stmt = null;
			String query = "INSERT INTO "+intoWhere+" VALUES ("+insertWhat+")";
			try
			{
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				conn.close();
				stmt.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public void updateDataToDB(String intoWhere, String setWhat, String whereWhat)
		{
			Connection conn = connectionInit();
	                Statement stmt = null;
			String query = "UPDATE "+intoWhere+" SET "+setWhat+" WHERE "+whereWhat;
			try
			{
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
				conn.close();
				stmt.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public void deleteDataFromDB(String fromWhere, String whereWhat)
		{
			Connection conn = connectionInit();
	                Statement stmt = null;
			String query = "DELETE FROM "+fromWhere+" WHERE "+whereWhat;
			try
			{
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			conn.close();
			stmt.close();
			}
			catch(SQLException se)
			{
			se.printStackTrace();
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
		}

		public List<String> getStringFromDBList(String selectWhat, String fromWhere, String whereWhat)
		{
		    Connection conn = connectionInit();
	            Statement stmt = null;
			String query = "SELECT "+selectWhat+" FROM "+fromWhere+" WHERE " +whereWhat;
			String s ="";
			List<String> list = new ArrayList<>();
			try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next())
				{
					s = rs.getString(selectWhat);
					list.add(s);

				}
				rs.close();
				conn.close();
				stmt.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}

		public List<Shop> getAllShop(){
			List<Shop> shops = new ArrayList<>();

			String query = "select * from quickShopping.t_sklepy";
			Connection conn = connectionInit();
			PreparedStatement stmt = null;

			try{

				stmt = conn.prepareStatement(query);
				ResultSet resultSet = stmt.executeQuery();

				 while (resultSet.next()){
					 shops.add(new Shop(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
		         }
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return shops;
		}

		public List<Category> getCategoryFromDBList(String selectWhat, String fromWhere, String whereWhat) {
			 Connection conn = connectionInit();
	            PreparedStatement stmt = null;
			String query = "SELECT "+selectWhat+" FROM "+fromWhere+" WHERE " +whereWhat;
			List<Category> list = new ArrayList<>();
			try
			{
				stmt = conn.prepareStatement(query);

				ResultSet rs = stmt.executeQuery();

				while (rs.next())
				{
					list.add(new Category(rs.getInt(1), rs.getString(2), rs.getInt(3) , rs.getInt(4)));

				}

			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			} finally {

				try {
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			return list;
		}



}
