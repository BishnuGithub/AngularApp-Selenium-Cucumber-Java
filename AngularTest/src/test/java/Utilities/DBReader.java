package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class DBReader {

	public LinkedHashMap<String, String> getDBmap(String query) throws Exception
	{

		//Connection URL Syntax: "sqlserver://ipaddress:portnumber/db_name"		

		String dbUrl=PropertyReader.getValue("DBurl");
		//Database Username		
		String username =PropertyReader.getValue("DBusername") ;	

		//Database Password		
		String password =PropertyReader.getValue("DBpassword");					


		//Load mysql jdbc driver		
		Class.forName("com.sqlserver.jdbc.Driver");			

		//Create Connection to DB		
		Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
		Statement stmt = con.createStatement();					

		// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);	
		
		ResultSetMetaData md=rs.getMetaData();
		LinkedHashMap<String, String> map= new LinkedHashMap<String, String>();

		// While Loop to iterate through all data and print results		
		while (rs.next()){
			for(int i=1;i<=md.getColumnCount();i++)
			{
				map.put(md.getColumnName(i), rs.getString(i));


			}	
		}

		System.out.println(map);

		// closing DB Connection		
		con.close();	
		return map;
	}


}
