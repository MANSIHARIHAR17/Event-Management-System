package DBMS_PROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Participants {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/project?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";
	// static final String DB_URL =
	// "jdbc:mysql://localhost:3306/project?useSSL=false";

	public void display_all_registration() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(conn);

			// Prepare and execute the query
			String query = "SELECT e.Name AS Event_Name, COUNT(p.p_id) AS Enrolled_Students_Count " + "FROM event e "
					+ "INNER JOIN participants p ON e.Event_Id = p.event_id " + "GROUP BY e.Name";
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// Display the results
			if (!rs.next()) {
				System.out.println("No registrations found.");
			} else {
				rs.beforeFirst();
				while (rs.next()) {
					String eventName = rs.getString("Event_Name");
					int enrolledCount = rs.getInt("Enrolled_Students_Count");
					System.out.println("Event: " + eventName + ", Enrolled Students Count: " + enrolledCount);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void getEventRegistrationCount() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(conn);

			// Prepare and execute the query
			String query = "SELECT e.Name AS Event_Name, COUNT(p.p_id) AS Enrolled_Students_Count " + "FROM event e "
					+ "INNER JOIN participants p ON e.Event_Id = p.event_id " + "GROUP BY e.Name";
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			// Display the results
			if (!rs.next()) {
				System.out.println("No registrations found.");
			} else {
				rs.beforeFirst();

				// Display the total registration count
				int totalRegistrationCount = 0;
				while (rs.next()) {
					totalRegistrationCount += rs.getInt("Enrolled_Students_Count");
				}
				System.out.println("Total Registration Count: " + totalRegistrationCount);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void display_max_registration() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(conn);

			// Prepare and execute the query
			String query = "SELECT e.Event_Id, e.Name AS Event_Name, COUNT(p.u_id) AS Total_Participants "
					+ "FROM event e " + "LEFT JOIN participants p ON e.Event_Id = p.event_id "
					+ "GROUP BY e.Event_Id, e.Name " + "ORDER BY Total_Participants DESC " + "LIMIT 3";
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			// Display the results
			if (!rs.next()) {
				System.out.println("No registrations found.");
			} else {
				rs.beforeFirst();
				while (rs.next()) {
					int eventId = rs.getInt("Event_Id");
					String eventName = rs.getString("Event_Name");
					int totalParticipants = rs.getInt("Total_Participants");
					System.out.println("Event ID: " + eventId + ", Event Name: " + eventName + ", Total Participants: "
							+ totalParticipants);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
