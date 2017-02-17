package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
				if (rs.next())
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

			String query = "INSERT INTO "+intoWhere+" VALUES ( ?,?,? )";
			try
			{
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, 1);
				stmt.setString(2, insertWhat);
				stmt.setString(3, insertWhat2);
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
				if (rs.next())
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

}