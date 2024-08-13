package DBMS_PROJECT;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;

public class Coordinator {
	 Scanner sc = new Scanner(System.in);
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/project";
    static final String USER = "root";
    static final String PASS = "root";

    public void display_Coordinator() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            PreparedStatement pstmt = null;
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(conn);
            stmt = conn.createStatement();
            System.out.println("Display all coordinator");
            String query = "select * from coordinator";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Error: No record is present.");
                System.out.println();
            } else {
                rs.beforeFirst();
                while (rs.next()) {
                    int c_id = rs.getInt("C_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String contact_no = rs.getString("contact_no");

                    System.out.println("Coordinator ID : " + c_id);
                    System.out.println("Name : " + name);
                    System.out.println("Email : " + email);
                    System.out.println("Contact No. : " + contact_no);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addCoordinator() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Enter coordinator details:");
            System.out.println("C_id: ");
            int c_id = sc.nextInt();
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Email: ");
            String email = sc.next();
            System.out.println("Contact No: ");
            String contact = sc.next();
            String query = "INSERT INTO coordinator (C_id, name, email, contact_no) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, c_id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, contact);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Coordinator added successfully!!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCoordinator() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Enter coordinator ID to delete: ");
            int c_id = sc.nextInt();
            String query = "DELETE FROM coordinator WHERE C_id=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, c_id);
            int rowsDeleted = pstmt.executeUpdate();
            
            if (rowsDeleted > 0) {
            	//coo.createAfterDeleteCoordinatorTrigger();
                System.out.println("Coordinator deleted successfully!");
            } else {
                System.out.println("No coordinator found with ID " + c_id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCoordinator() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Enter coordinator ID to update: ");
            int c_id = sc.nextInt();
            System.out.println("Enter new name: ");
            String name = sc.next();
            System.out.println("Enter new email: ");
            String email = sc.next();
            System.out.println("Enter new contact no.: ");
            String contact = sc.next();
            String query = "UPDATE coordinator SET name=?, email=?, contact_no=? WHERE C_id=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, contact);
            pstmt.setInt(4, c_id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Coordinator updated successfully!");
            } else {
                System.out.println("No coordinator found with ID " + c_id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   

    


}