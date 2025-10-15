package in.sp.text;

import java.security.DrbgParameters.NextBytes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class patient
{
	 
	
	private Connection connection;
	private Scanner scanner;
	
	public patient(Connection connection , Scanner scanner)
	{
		this.connection = connection;
		this.scanner = scanner;
	}
	
	public void Addpatient()
	{
		System.out.println("Enter patient Name : ");
		String name = scanner.next();
		System.out.println("Enter the patient Age :");
		int Age = scanner.nextInt();
		System.out.println("Enter the Gender of Patient :");
		String gender = scanner.next();
		String query = "insert into patient(name, age, gender) values(?,?,?) ";
		
		try {
			PreparedStatement pre = connection.prepareStatement(query);
			pre.setString(1, name);
			pre.setInt(2, Age);
			pre.setString(3, gender);
			int affectedRows = pre.executeUpdate();
			
			if(affectedRows>0)
			{
				System.out.println("Successfully Add patient Data");
			}
			else
			{
				System.out.println("failed to Add patient ");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
  
	public void ViewPatient()
	{ 
		String query = "select * from patient";
		try {
			PreparedStatement pre = connection.prepareStatement(query);
			ResultSet result = pre.executeQuery();
			
			System.out.println("Patients :");
			System.out.println("+-----+------------------+--------+-----------+");
			System.out.println("|Id   |  Name            | Age    | Gender    |");
			System.out.println("+-----+------------------+--------+-----------+");
			
			while(result.next())
			{
				
				int  id = result.getInt("id");
				String name = result.getString("name");
				int age = result.getInt("age");
				String gender = result.getString("gender");
				System.out.printf("|%-5s|%-18s|%-8s|%-11s|\n",id,name,age,gender);
				System.out.println("+-----+------------------+--------+-----------+");
					
			}
		 } catch (SQLException e)
		{
			e.printStackTrace();
		}
	  }
	
	public boolean getPatientById(int id)
	{
		String quary =" select * from patient where id =?";
		
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

