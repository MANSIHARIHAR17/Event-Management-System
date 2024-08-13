package DBMS_PROJECT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;
public class Admin {
	Scanner sc = new Scanner(System.in);
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	static final String USER = "root";
	static final String PASS = "root"; 
	
	boolean checkAdmin () {
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
		String query = "select * from Admin where a_id = ? and password = ?";
		pstmt = conn.prepareStatement(query);
		System.out.println("Enter admin id : ");
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
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally{
			return search;
		}
	}
	 public void display_Admin() {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            PreparedStatement pstmt = null;
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println(conn);
	            stmt = conn.createStatement();
	            System.out.println("Display all Admin");
	            String query = "select * from Admin";
	            pstmt = conn.prepareStatement(query);
	            rs = pstmt.executeQuery();
	            if (!rs.next()) {
	                System.out.println("Error: No record is present.");
	                System.out.println();
	            } else {
	                rs.beforeFirst();
	                while (rs.next()) {
	                    int a_id = rs.getInt("A_id");
	                    String name = rs.getString("name");
	                    String email = rs.getString("email");
	                    String pass = rs.getString("password");

	                    System.out.println("Coordinator ID : " + a_id);
	                    System.out.println("Name : " + name);
	                    System.out.println("Email : " + email);
	                    System.out.println("Password :" + pass);
	                    System.out.println();
	                }
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    public void addAdmin() {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println("Enter Admin details:");
	            System.out.println("A_id: ");
	            int a_id = sc.nextInt();
	            System.out.println("Name: ");
	            String name = sc.next();
	            System.out.println("Email: ");
	            String email = sc.next();
	            System.out.println("Password: ");
	            String pass = sc.next();
	            String query = "INSERT INTO Admin (A_id, name, email, password) VALUES (?, ?, ?, ?)";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setInt(1, a_id);
	            pstmt.setString(2, name);
	            pstmt.setString(3, email);
	            pstmt.setString(4, pass);
	            int rowsInserted = pstmt.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Admin added successfully!!!");
	            }
	            else {
	            	System.out.println("Error : Admin not added.");
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    public void deleteAdmin() {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println("Enter Admin ID to delete: ");
	            int a_id = sc.nextInt();
	            String query = "DELETE FROM Admin WHERE A_id=?";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setInt(1, a_id);
	            int rowsDeleted = pstmt.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Admin deleted successfully!");
	            } else {
	                System.out.println("No Admin found with ID " + a_id);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    public void updateAdmin() {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println("Enter Admin ID to update: ");
	            int a_id = sc.nextInt();
	            System.out.println("Enter new name: ");
	            String name = sc.next();
	            System.out.println("Enter new email: ");
	            String email = sc.next();
	            System.out.println("Enter new password no.: ");
	            String pass = sc.next();
	            String query = "UPDATE coordinator SET name=?, email=?, password=? WHERE A_id=?";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, name);
	            pstmt.setString(2, email);
	            pstmt.setString(3, pass);
	            pstmt.setInt(4, a_id);
	            int rowsUpdated = pstmt.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Admin updated successfully!");
	            } else {
	                System.out.println("No Admin found with ID " + a_id);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}
