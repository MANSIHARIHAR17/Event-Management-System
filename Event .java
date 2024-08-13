package DBMS_PROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;
public class Event {
	Scanner sc = new Scanner(System.in);
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/project?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root"; 
	
	void display_event() {
		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement pstmt = null ;
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println(conn);
			stmt = conn.createStatement();
	        String query = "select * from event";
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery(query);
	        if(!rs.next()) {
				System.out.println("Error: No record is present.");
				System.out.println();
			}
	        else {
	        	rs.beforeFirst();
	        	while(rs.next()) {
					int Event_id = rs.getInt("event_id");
			        String Name = rs.getString("name");
			        String Date = rs.getString("date");
			        String Time = rs.getString("time");
			        String Venue = rs.getString("venue");
			        String Description = rs.getString("event_desc");
			        int Fees = rs.getInt("reg_charge");
			        int capacity = rs.getInt("capacity");
			       
			        System.out.println("Event ID : "+ Event_id);
		        	System.out.println("Name : "+Name);
		        	System.out.println("Date : "+Date);
		        	System.out.println("Time : "+Time);
		        	System.out.println("Venue : "+Venue);
		        	System.out.println("Description : "+Description );
		        	System.out.println("Fees : "+Fees);
		        	System.out.println("capacity : "+capacity);
		        	
			        System.out.println();
				}
	        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}	
	
	void event_delete() {
		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rs = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		PreparedStatement pstmt = null ;
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println(conn);
		stmt = conn.createStatement();
		String query = "delete from event where event_id = ?";
		System.out.println("Enter event id : ");
		int id = sc.nextInt();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			int rowsAffected = pstmt.executeUpdate();
			if(rowsAffected == 0) {
				System.out.println("Error: event with ID " + id + " does not exist.");
			}
			else {
		        System.out.println("Event information has been successfully deleted .");
			}
		}
		catch (SQLException e) {
		    System.out.println("Error deleting member information: " + e.getMessage());
		}
	}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void event_update() {
		Connection conn = null ;
		Statement stmt = null ;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement pstmt = null ;
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println(conn);
			stmt = conn.createStatement();
			System.out.println("Update a event information ");
			System.out.println("Enter event ID :");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("what do you want to update(name,date,time,venue,description,fees,capacity)");
	        String update = sc.nextLine();
	        String query;
			if(update.equalsIgnoreCase("name")){
				query = "update event set name = ?"+" where event_id = ?";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter name :");
				String name = sc.nextLine();
				pstmt.setString(1, name);
				pstmt.setInt(2, id);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 0) {
					System.out.println("Error: event with ID " + id + " does not exist.");
				}
				else {
			        System.out.println("Event information has been successfully updated .");
				}
		
			}
			else if(update.equalsIgnoreCase("date")) {
				query = "update event set date = ? where event_id = ?";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter address :");
				String add = sc.nextLine();
				pstmt.setString(1, add);
				pstmt.setInt(2, id);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 0) {
					System.out.println("Error: event with ID " + id + " does not exist.");
				}
				else {
			        System.out.println("Event information has been successfully updated .");
				}
			}
			else if(update.equalsIgnoreCase("time ")) {
				query = "update event set time = ? where event_id = ?";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter time :");
				String time = sc.nextLine();
				pstmt.setString(1,time);
				pstmt.setInt(2, id);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 0) {
					System.out.println("Error: event with ID " + id + " does not exist.");
				}
				else {
			        System.out.println("Event information has been successfully updated .");
				}
			}
			else if(update.equalsIgnoreCase("venue")) {
				query = "update event set venue = ? where event_id = ?";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter department :");
				String venue = sc.nextLine();
				pstmt.setString(1, venue);
				pstmt.setInt(2, id);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 0) {
					System.out.println("Error: event with ID " + id + " does not exist.");
				}
				else {
			        System.out.println("Event information has been successfully updated .");
				}
			}
			else if(update.equalsIgnoreCase("description")) {
				query = "update event set event_desc = ? where event_id = ?";
				pstmt = conn.prepareStatement(query);
				System.out.println("Write description :");
				String desc = sc.nextLine();
				pstmt.setString(1, desc);
				pstmt.setInt(2, id);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 0) {
					System.out.println("Error: event with ID " + id + " does not exist.");
				}
				else {
			        System.out.println("Event information has been successfully updated .");
				}
			}
			
			else if(update.equalsIgnoreCase("fees")) {
				query = "update event set reg_charge = ? where event_id = ?";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter fees :");
				String fees = sc.nextLine();
				pstmt.setString(1, fees);
				pstmt.setInt(2, id);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 0) {
					System.out.println("Error: event with ID " + id + " does not exist.");
				}
				else {
			        System.out.println("Event information has been successfully updated .");
				}
			}
			else if(update.equalsIgnoreCase("capacity")) {
				query = "update event set capacity = ? where event_id = ?";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter capacity :");
				String capacity = sc.nextLine();
				pstmt.setString(1, capacity);
				pstmt.setInt(2, id);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 0) {
					System.out.println("Error: event with ID " + id + " does not exist.");
				}
				else {
			        System.out.println("Event information has been successfully updated .");
				}
			}
			else {
				System.out.println("Invalid choice");
			}		
		}	
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	void event_insert () {
			Connection conn = null ;
			Statement stmt = null ;
			ResultSet rs = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				PreparedStatement pstmt = null ;
				conn=DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println(conn);
				stmt = conn.createStatement();
				String query = "insert into event(event_id,name,date,time,venue,event_desc,reg_charge,capacity,o_id,c_id)"+" values(?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(query);
				System.out.println("Enter event ID :");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter event name :");
				String name =  sc.nextLine();
				System.out.println("Enter date(YYYY-MM-DD) :");
				String date = sc.nextLine();
				System.out.println("Enter time :");
				String time = sc.nextLine();
				System.out.println("Enter venue :");
				String venue = sc.nextLine();
				System.out.println("Enter description :");
				String desc = sc.nextLine();
				System.out.println("Enter fees :");
				int fees = sc.nextInt();
				System.out.println("Enter capacity :");
				int capacity = sc.nextInt();
				System.out.println("Enter Oraganiser id:");
				int oid = sc.nextInt();
				System.out.println("Enter coordinator id :");
				int cid = sc.nextInt();
				try {
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, date);
					pstmt.setString(4,time);
					pstmt.setString(5, venue);
					pstmt.setString(6, desc);
					pstmt.setInt(7,fees);
					pstmt.setInt(8,capacity);
					pstmt.setInt(9,oid);
					pstmt.setInt(10,cid);
					int rowsAffected = pstmt.executeUpdate();
					if(rowsAffected == 0) {
						System.out.println("Error: Some error occur");
					}
					else {
				        System.out.println("Event information has been successfully updated .");
					}
					
					System.out.println("Record added successfully\n");
				}
				catch(java.sql.SQLIntegrityConstraintViolationException e){
					 System.out.println("Integrity Constrain violation! Skipping record !!!\n ");
				}
			}
			
		catch(Exception e) {
			System.out.println(e);
		}
	}
	void displayEventsOnDate() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            System.out.println("Enter the date (YYYY-MM-DD): ");
            String inputDate = sc.nextLine();
            
            String query = "SELECT * FROM event WHERE Date = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, inputDate);
            
            rs = pstmt.executeQuery();
            
            if (!rs.next()) {
                System.out.println("No events scheduled on " + inputDate);
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    int event_id = rs.getInt("event_id");
                    String name = rs.getString("name");
                    String date = rs.getString("date");
                    String time = rs.getString("time");
                    String venue = rs.getString("venue");
                    String event_desc = rs.getString("event_desc");
                    int reg_charge = rs.getInt("reg_charge");
                    int capacity = rs.getInt("capacity");

                    System.out.println("Event ID: " + event_id);
                    System.out.println("Name: " + name);
                    System.out.println("Date: " + date);
                    System.out.println("Time: " + time);
                    System.out.println("Venue: " + venue);
                    System.out.println("Description: " + event_desc);
                    System.out.println("Registration Charge: " + reg_charge);
                    System.out.println("Capacity: " + capacity);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
