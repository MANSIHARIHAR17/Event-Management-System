package DBMS_PROJECT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;
public class User {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/project?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";
	Scanner sc =new Scanner(System.in);
	boolean checkUser () {
		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rs = null;
		boolean search =false;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		PreparedStatement pstmt = null ;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println(conn);
		stmt = conn.createStatement();
		String query = "select * from user where u_id = ? and password = ?";
		pstmt = conn.prepareStatement(query);
		System.out.println("Enter user id : ");
		int id = sc.nextInt();
		System.out.println("Enter password : ");
		sc.nextLine();
		String password = sc.nextLine();
		pstmt.setInt(1, id);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			search =true;
		}
		else
		{
			System.out.println("User not found!");
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			return search;
		}
	}
	  void NewUser() {
			Connection conn = null ;
			Statement stmt = null ;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		conn=DriverManager.getConnection(DB_URL,USER,PASS);
	    		System.out.println(conn);
	    		stmt = conn.createStatement();
	            System.out.print("Enter username: ");
	            String username = sc.nextLine();
	            System.out.print("Enter name: ");
	            String name = sc.nextLine();
	            System.out.print("Enter email: ");
	            String email = sc.nextLine();
	            System.out.print("Enter contact number: ");
	            String contact_no = sc.nextLine();
	            System.out.print("Enter password: ");
	            String pass = sc.nextLine();
	            String query = "INSERT INTO user ( username, name, email, contact_no, password) VALUES (?, ?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, username);
	            pstmt.setString(2, name);
	            pstmt.setString(3, email);
	            pstmt.setString(4, contact_no);
	            pstmt.setString(5, pass);
	            int rowsAffected = pstmt.executeUpdate();
	            String query2 = "select u_id from user where email = ?";
	            pstmt = conn.prepareStatement(query2);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
	            if(rowsAffected == 0) {
					System.out.println("Error: Some error occur");
				}
				else {
			        System.out.println("registration done successfully.");
			        while(rs.next()) {
			        	int id = rs.getInt("u_id");
			        	System.out.println("User Id -"+id);
			        }
				}
	        }
	        catch (Exception e) {
	        	System.out.println(e);
	        }
	    }
	  
	  void registerEvent() {
		  Connection conn = null ;
			Statement stmt = null ;
			ResultSet rs = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				PreparedStatement pstmt = null ;
				conn=DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println(conn);
				stmt = conn.createStatement();
				String query = "insert into Participants(event_id,u_id)"+" values(?,?)";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter event ID :");
				int eid = sc.nextInt();
				System.out.println("Enter user ID :");
				int uid =  sc.nextInt();
				try {
					pstmt.setInt(1, eid);
					pstmt.setInt(2, uid);
					int rowsAffected = pstmt.executeUpdate();
					if(rowsAffected == 0) {
						System.out.println("Error: Some error occur");
					}
					else {
				        System.out.println("Successfully registered for event .");
					}
				}
				catch(java.sql.SQLIntegrityConstraintViolationException e){
					 System.out.println("Integrity Constrain violation! Skipping record !!!\n ");
				}
			}
			
		catch(Exception e) {
			System.out.println(e);
		}
	  }
	  void my_registration(int userId) {
		    Connection conn = null ;
		    PreparedStatement pstmt = null ;
		    ResultSet rs = null;

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        System.out.println(conn);

		        String query = "SELECT * FROM participants " +
		                       "JOIN event ON participants.event_id = event.event_id " +
		                       "WHERE participants.u_id = ?";
		        pstmt = conn.prepareStatement(query);
		        pstmt.setInt(1, userId);
		        rs = pstmt.executeQuery();

		        if (!rs.isBeforeFirst()) {
		            System.out.println("No registrations found for user ID: " + userId);
		        } else {
		            System.out.println("Registrations for user ID: " + userId);
		            System.out.println("Event ID\tEvent Name\tEvent Date\tEvent Location");
		            while (rs.next()) {
		                int eventId = rs.getInt("event_id");
		                String eventName = rs.getString("name");
		                Date eventDate = rs.getDate("date");
		                String eventLocation = rs.getString("venue");

		                System.out.println(eventId + "\t" + eventName + "\t" + eventDate + "\t" + eventLocation);
		            }
		        }
		    } catch (Exception e) {
		        System.out.println(e);
		    } finally {
		        try {
		            if (rs != null) rs.close();
		            if (pstmt != null) pstmt.close();
		            if (conn != null) conn.close();
		        } catch (SQLException e) {
		            System.out.println(e);
		        }
		    }
		}
	  void sendEventNotifications(int userId) {
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;

		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        System.out.println(conn);

		        String query = "SELECT e.event_id, e.name AS event_name, e.date AS event_date, e.time AS event_time, e.venue AS event_venue " +
		                       "FROM event e " +
		                       "JOIN participants p ON e.Event_Id = p.event_id " +
		                       "WHERE p.u_id = ?";
		        pstmt = conn.prepareStatement(query);
		        pstmt.setInt(1, userId);
		        rs = pstmt.executeQuery();

		        while (rs.next()) {
		            int eventId = rs.getInt("event_id");
		            String eventName = rs.getString("event_name");
		            Date eventDate = rs.getDate("event_date");
		            String eventTime = rs.getString("event_time");
		            String eventVenue = rs.getString("event_venue");

		            // Assuming you have a method to send notifications
		            sendNotification(eventName, eventDate, eventTime, eventVenue);
		        }
		    } catch (Exception e) {
		        System.out.println(e);
		    } finally {
		        try {
		            if (rs != null) rs.close();
		            if (pstmt != null) pstmt.close();
		            if (conn != null) conn.close();
		        } catch (SQLException e) {
		            System.out.println(e);
		        }
		    }
		}

		void sendNotification(String eventName, Date eventDate, String eventTime, String eventVenue) {
		    // Implement your logic for sending notifications here
		    System.out.println("Notification: Event '" + eventName + "' is scheduled on " + eventDate + " at " + eventTime + " in " + eventVenue);
		}


	
}