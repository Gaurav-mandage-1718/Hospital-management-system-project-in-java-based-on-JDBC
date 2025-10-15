package in.sp.text;

import java.awt.DefaultFocusTraversalPolicy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;



public class Hospital {
	
	private static final String url ="jdbc:mysql://localhost:3306/HospitalManagmentSystem";
	private static final String username = "root";
	private static final String password ="Gaurav@31";

	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url,username,password);
		patient patient = new patient(connection, scanner);
		Doctor doctor = new Doctor(connection);
		
		while(true)
		{
			System.out.println("HOSPITAL MANAGEMENT SYSTEM :");
			System.out.println("1 :Add Patient");
			System.out.println("2 :View Patient");
			System.out.println("3 :View Doctor");
			System.out.println("4 :Book Appointment");
			System.out.println("5 :Exit");
			System.out.println("Enter the Choice :");
			int choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1 :patient.Addpatient();System.out.println();break;
			  
			case 2 :patient.ViewPatient();System.out.println();break;
			case 3 :doctor.ViewDoctor();System.out.println();break;
			case 4 :bookAppointment(patient,doctor,connection,scanner);System.out.println();break;
			case 5: System.out.println("Thank you ");
			    return;
					
			default :System.out.println("Invalid Choice");
			}
		}
	}
	
	public static void bookAppointment(patient patient ,Doctor doctor ,Connection connection , Scanner scanner)
	{
		System.out.println("Enter the Patient ID :");
		int patientId = scanner.nextInt();
		System.out.println("Enter the Doctor ID :");
		int doctorId = scanner.nextInt();
		System.out.println("Enter the Appointment Date (YYYY-MM-DD):");
		String appointmenDate = scanner.next();
		
		  if(patient.getPatientById(patientId) && doctor.getDoctorById(doctorId))
		  {
			  if(checkAppointment(doctorId,appointmenDate,connection))
			  {
				  
				  
				  try
				  {
					  String query = "insert into Appointment(patient_id,doctor_id,appointment_date) values(?,?,?)";
					  PreparedStatement ps = connection.prepareStatement(query);
					  ps.setInt(1,patientId);
					  ps.setInt(2, doctorId);
					  ps.setString(3,appointmenDate);
					  int affectedRows = ps.executeUpdate();
					  
					  if(affectedRows>0)
					  {
						  System.out.println("Appointment Booked !!");
					  }
					  else
						  System.out.println("Failed to Book!");
				  }
				  catch(SQLException e)
				  {
					  e.printStackTrace();
				  }
			  }
			  else
				  System.out.println("Doctor not available on this date");
		  }
		  else
			  System.out.println("Either Doctor or Patient doesn't exit !!!!");		
	}
	public static boolean checkAppointment(int doctorId , String appointmenDate ,Connection connection)
	{
		String query = "select Count(*) From appointment where doctor_id =? and appointment_date =?";
		try
		{
			 PreparedStatement ps = connection.prepareStatement(query);
			 ps.setInt(1, doctorId);
			 ps.setString(2,appointmenDate);
			 ResultSet result = ps.executeQuery();	 
			 
			 if(result.next())
			 {
				 int count = result.getInt(1);
				 if(count==0)
				 {
					 return true;
				 }
				 else
					 return false;
			 }
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}
}
