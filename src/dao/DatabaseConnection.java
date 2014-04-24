package dao;
import java.sql.*;

public class DatabaseConnection {

	Connection connection = null;
	static ResultSet rs = null;
	Statement stmt = null;


	public DatabaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
					+ "user=root&password=dk"); // Once you are done with other stuff, move username and password to a config file.
			stmt = connection.createStatement();
			if(!connection.isClosed()){
				System.out.println("Connected Successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public Connection getConnection()	{
		return connection;
	}


	
	public String[] categories() throws SQLException{

		//boolean result = false;
		ResultSet resultSet;
		String query = "select * from PERSON";
		 
		//System.out.println(UserName + " " + Password);
		
			resultSet = stmt.executeQuery(query);
			resultSet.last();
			int size = resultSet.getRow();
			int i = 0;
			String[] result = new String[size];
			resultSet.beforeFirst();
			//System.out.println(rowcount.getString("username"));
			//System.out.println(rowcount);
			while (resultSet.next())
			{
				
				//result = true;
				String name = resultSet.getString("name");
				result[i]=name;
				i++;
				
			}
			
			return result;
		}
		
	public boolean insertBoard(String Name,String Description,String Categories) throws SQLException{

		//boolean result = false;
		int result;
		boolean boolresult;
		String query = "Insert into BOARD(Name,Description,Categories) Values('"+Name+"','"+Description+"','"+Categories+"')";
		 
		//System.out.println(UserName + " " + Password);
		
			result = stmt.executeUpdate(query);
					//System.out.println(rowcount.getString("username"));
			//System.out.println(rowcount);
			if (result>0)
			{
				
				boolresult = true;
								
			}
			else{
				boolresult=false;
			}
			return boolresult;
		}

		

	}

	

	





