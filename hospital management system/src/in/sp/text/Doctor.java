package in.sp.text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
	
	Scanner in = new Scanner(System.in);
	private Connection connection;

	public Doctor(Connection connection)
	{
		this.connection = connection;
	}
	
	
  
	public void ViewDoctor()
	{ 
		String query = "select * from Doctor";
		try {
			PreparedStatement pre = connection.prepareStatement(query);
			ResultSet result = pre.executeQuery();
			
			System.out.println("Doctors :");
			System.out.println("+-----+-----------------+---------------------+");
			System.out.println("| Id  | Name            | specialization      |");
			System.out.println("+-----+-----------------+---------------------+");
			
			while(result.next())
			{
				
				int  id = result.getInt("id");
				String name = result.getString("name");
				String specialization = result.getString("specialization");
				System.out.printf("|%-5s|%-17s| %-20s|\n",id,name,specialization);
				System.out.println("+-----+-----------------+---------------------+");
					
			}
		 } catch (SQLException e)
		{
			e.printStackTrace();
		}
	  }
	
	public boolean getDoctorById(int id)
	{
		String quary =" select * from Doctor where id =?";
		
		try 
		{
			PreparedStatement pre = connection.prepareStatement(quary);
			pre.setInt(1, id);
			ResultSet result = pre.executeQuery();
			
			if(result.next())
			{
				return true;
				
			}else
				return false;
			
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

}
