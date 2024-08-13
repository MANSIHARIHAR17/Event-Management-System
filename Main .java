package DBMS_PROJECT;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Admin a = new Admin();
		User u = new User();
		Event e = new Event();
		Organiser o = new Organiser();
		Coordinator co = new Coordinator();
		Participants p = new Participants();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag != false) {
			System.out.println("+---------------------------------------------+");
			System.out.println("|                 WELCOME                     |");
			System.out.println("|              TECHNICAL EVENT                |");
			System.out.println("|                EVENTEASE                    |");
			System.out.println("|                                             |");
			System.out.println("|               1. Login as admin             |");
			System.out.println("|               2. Login as user              |");
			System.out.println("|               3. New registration           |");
			System.out.println("|               4. Exit                       |");
			System.out.println("|                                             |");
			System.out.println("+---------------------------------------------+");

			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			int c = 0;

			switch (ch) {
			case 1:
				boolean validAdmin = a.checkAdmin();
				if (validAdmin) {
					while (c != 21) {
						System.out.println("+---------------------------------------------+");
						System.out.println("|               Welcome Admin                 |");
						System.out.println("|                                             |");
						System.out.println("|              Choose option:                 |");
						System.out.println("|              1. Display all admins          |");
						System.out.println("|              2. Add new Admin               |");
						System.out.println("|              3. Update an admin information |");
						System.out.println("|              4. Delete an admin             |");
						System.out.println("|              5. Display all event           |");
						System.out.println("|              6. Add new event               |");
						System.out.println("|              7. Update an event information |");
						System.out.println("|              8. Delete an event             |");
						System.out.println("|              9. Display all organiser       |");
						System.out.println("|             10. Add new organiser           |");
						System.out.println("|             11. Update an organiser info    |");
						System.out.println("|             12. Delete an organiser         |");
						System.out.println("|             13. Display all coordinator     |");
						System.out.println("|             14. Add new coordinator         |");
						System.out.println("|             15. Update a coordinator info   |");
						System.out.println("|             16. Delete a coordinator        |");
						System.out.println("|             17. No.of Participants per event|");
						System.out.println("|             18. No.of Participants          |");
						System.out.println("|             19. Per Day Events              |");
						System.out.println("|             20. Max Registered Event        |");
						System.out.println("|             21. Logout                      |");
						System.out.println("+---------------------------------------------+");

						c = sc.nextInt();
						if (c == 1) {
							a.display_Admin();
						} else if (c == 2) {
							a.addAdmin();
						} else if (c == 3) {
							a.updateAdmin();
						} else if (c == 4) {
							a.deleteAdmin();
						} else if (c == 5) {
							e.display_event();
						} else if (c == 6) {
							e.event_insert();
						} else if (c == 7) {
							e.event_update();
						} else if (c == 8) {
							e.event_delete();
						} else if (c == 9) {
							o.displayOrganiser();
						} else if (c == 10) {
							o.addOrganiser();
						} else if (c == 11) {
							o.updateOrganiser();
						} else if (c == 12) {
							o.deleteOrganiser();
						} else if (c == 13) {
							co.display_Coordinator();
						} else if (c == 14) {
							co.addCoordinator();
						} else if (c == 15) {
							co.updateCoordinator();
						} else if (c == 16) {
							co.deleteCoordinator();
						} else if (c == 17) {
							p.display_all_registration();
						} else if (c == 18) {
							p.getEventRegistrationCount();
						} else if (c == 19) {
							e.displayEventsOnDate();
						} else if (c == 20) {
							p.display_max_registration();
						} else if (c == 21) {
							System.out.println("Sucessfully logout");
							System.exit(c);
						} else if (c == 22) {
							e.display_event();
						}

						else {
							System.out.println("Invalid choice");
						}
					}
				} else {
					System.out.println("Invalid Credential");
				}

				break;
			case 2:

				boolean validUser = u.checkUser();
				if (validUser) {
					// Get the user ID
					System.out.println("Enter your user ID:");
					int userId = sc.nextInt();

					while (c != 4) {
						System.out.println("Welcome user");
						System.out.println();
						System.out.println("Choose option:");
						System.out.println("1.Display all event");
						System.out.println("2.Register for event ");
						System.out.println("3.My Registration");
						// System.out.println("3.Cancel Registration");
						System.out.println("4.Logout");
						c = sc.nextInt();
						if (c == 1) {
							e.display_event();
						} else if (c == 2) {
							e.display_event();
							u.registerEvent();
							u.sendEventNotifications(userId); // Pass userId to the function
						} else if (c == 3) {
							u.my_registration(userId);
						} else if (c == 4) {
							System.out.println("Sucessfully logout");
						} else {
							System.out.println("Invalid Choice");
						}
					}
				} else {
					System.out.println("Invalid credential");
				}
				break;

			case 3:
				u.NewUser();
				e.display_event();
				u.registerEvent();
				break;
			case 4:
				flag = false;
			}

		}
	}

}

/*
 +---------------------------------------------+
|                 WELCOME                     |
|              TECHNICAL EVENT                |
|                EVENTEASE                    |
|                                             |
|               1. Login as admin             |
|               2. Login as user              |
|               3. New registration           |
|               4. Exit                       |
|                                             |
+---------------------------------------------+
Enter your choice:
3
com.mysql.cj.jdbc.ConnectionImpl@d706f19
Enter username: vaishnavi21
Enter name: Vaishnavi Kori
Enter email: vaishnavi21@gmail.com
Enter contact number: 8569231450
Enter password: qazwsx
registration done successfully.
User Id -313
com.mysql.cj.jdbc.ConnectionImpl@72a7c7e0
Event ID : 401
Name : Tech Jumanji
Date : 2024-04-04
Time : 10 AM
Venue : Main Building
Description : Coding Competition
Fees : 100
capacity : 10

Event ID : 402
Name : Codigo
Date : 2024-04-03
Time : 10 AM
Venue : Main Building
Description : MCQ based Competition
Fees : 100
capacity : 15

Event ID : 403
Name : Soch Machine
Date : 2024-04-05
Time : 8 AM
Venue : Mechanical Building
Description : Present an idea for problem given
Fees : 150
capacity : 15

Event ID : 404
Name : Tech Quiz
Date : 2024-04-05
Time : 9 AM
Venue : IT Building
Description : Technology Quiz
Fees : 100
capacity : 10

Event ID : 405
Name : Aero Show
Date : 2024-04-06
Time : 10 AM
Venue : Instrumentation Building
Description : Aviation Exhibition
Fees : 100
capacity : 30

Event ID : 406
Name : AVCF
Date : 2024-04-17
Time : 10AM
Venue : Coolege
Description : Hackathon event
Fees : 100
capacity : 20

com.mysql.cj.jdbc.ConnectionImpl@e056f20
Enter event ID :
404
Enter user ID :
313
Successfully registered for event .
+---------------------------------------------+
|                 WELCOME                     |
|              TECHNICAL EVENT                |
|                EVENTEASE                    |
|                                             |
|               1. Login as admin             |
|               2. Login as user              |
|               3. New registration           |
|               4. Exit                       |
|                                             |
+---------------------------------------------+
Enter your choice:
2
com.mysql.cj.jdbc.ConnectionImpl@19bb07ed
Enter user id : 
313
Enter password : 
qazwsx
Enter your user ID:
313
Welcome user

Choose option:
1.Display all event
2.Register for event 
3.My Registration
4.Logout
3
com.mysql.cj.jdbc.ConnectionImpl@353d0772
Registrations for user ID: 313
Event ID	Event Name	Event Date	Event Location
404	Tech Quiz	2024-04-05	IT Building
Welcome user

Choose option:
1.Display all event
2.Register for event 
3.My Registration
4.Logout
4
Sucessfully logout
+---------------------------------------------+
|                 WELCOME                     |
|              TECHNICAL EVENT                |
|                EVENTEASE                    |
|                                             |
|               1. Login as admin             |
|               2. Login as user              |
|               3. New registration           |
|               4. Exit                       |
|                                             |
+---------------------------------------------+
Enter your choice:
1
Thu Apr 18 20:09:57 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@18271936
Enter admin id : 
101
Enter password : 
gth
Invalid Credential
+---------------------------------------------+
|                 WELCOME                     |
|              TECHNICAL EVENT                |
|                EVENTEASE                    |
|                                             |
|               1. Login as admin             |
|               2. Login as user              |
|               3. New registration           |
|               4. Exit                       |
|                                             |
+---------------------------------------------+
Enter your choice:
1
Thu Apr 18 20:10:11 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@68c9133c
Enter admin id : 
101
Enter password : 
abc
+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
4
Thu Apr 18 20:10:55 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Enter Admin ID to delete: 
102
Admin deleted successfully!
+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
1
Thu Apr 18 20:11:07 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@16eb3ea3
Display all Admin
Coordinator ID : 101
Name : Diksha Singh
Email : dikshasingh@gmail.com
Password :abc

+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
13
Thu Apr 18 20:11:33 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@33bc72d1
Display all coordinator
Coordinator ID : 201
Name : Neha Jadhav
Email : neha.j@gmail.com
Contact No. : 9897887870

Coordinator ID : 202
Name : Kajal Jadhav
Email : kajal.j@gmail.com
Contact No. : 9897777870

Coordinator ID : 203
Name : Jiya Raj
Email : jiya.r@gmail.com
Contact No. : 8794554553

Coordinator ID : 204
Name : Arun Singh
Email : arun.s@gmail.com
Contact No. : 7897978657

Coordinator ID : 205
Name : Tarun Sharma
Email : tarun.s@gmail.com
Contact No. : 9879789790

+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
19
Enter the date (YYYY-MM-DD): 
2024-04-06
Event ID: 405
Name: Aero Show
Date: 2024-04-06
Time: 10 AM
Venue: Instrumentation Building
Description: Aviation Exhibition
Registration Charge: 100
Capacity: 30

+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
20
com.mysql.cj.jdbc.ConnectionImpl@48bb62
Event ID: 401, Event Name: Tech Jumanji, Total Participants: 3
Event ID: 402, Event Name: Codigo, Total Participants: 2
Event ID: 403, Event Name: Soch Machine, Total Participants: 2
+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
18
com.mysql.cj.jdbc.ConnectionImpl@57a78e3
Total Registration Count: 10
+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
21
Sucessfully logout

+---------------------------------------------+
|                 WELCOME                     |
|              TECHNICAL EVENT                |
|                EVENTEASE                    |
|                                             |
|               1. Login as admin             |
|               2. Login as user              |
|               3. New registration           |
|               4. Exit                       |
|                                             |
+---------------------------------------------+
Enter your choice:
1
Thu Apr 18 20:23:45 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@3527942a
Enter admin id : 
101
Enter password : 
abc
+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
9
Thu Apr 18 20:23:54 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@53fb3dab
Display all Organiser
Organiser ID : 1
Name : Dassault
Email : abc@gmail.com
Contact No. : 9989898988

Organiser ID : 2
Name : UBS
Email : def@gmail.com
Contact No. : 9989822332

Organiser ID : 3
Name : BNY mellon
Email : ghi@gmail.com
Contact No. : 9923222332

Organiser ID : 4
Name : Ansys
Email : jkl@gmail.com
Contact No. : 8967662332

Organiser ID : 5
Name : upstop
Email : mno@gmail.com
Contact No. : 7878962332

+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
13
Thu Apr 18 20:23:57 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@196a42c3
Display all coordinator
Coordinator ID : 201
Name : Neha Jadhav
Email : neha.j@gmail.com
Contact No. : 9897887870

Coordinator ID : 202
Name : Kajal Jadhav
Email : kajal.j@gmail.com
Contact No. : 9897777870

Coordinator ID : 203
Name : Jiya Raj
Email : jiya.r@gmail.com
Contact No. : 8794554553

Coordinator ID : 204
Name : Arun Singh
Email : arun.s@gmail.com
Contact No. : 7897978657

Coordinator ID : 205
Name : Tarun Sharma
Email : tarun.s@gmail.com
Contact No. : 9879789790

+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
17
com.mysql.cj.jdbc.ConnectionImpl@7f485fda
Event: Tech Jumanji, Enrolled Students Count: 3
Event: Codigo, Enrolled Students Count: 2
Event: Soch Machine, Enrolled Students Count: 2
Event: Tech Quiz, Enrolled Students Count: 2
Event: Aero Show, Enrolled Students Count: 1
+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
10
Thu Apr 18 20:24:54 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
Enter Organiser details:
O_id: 
6
Name: 
Ganesh Jadhav
Email: 
Contact No: 
9652841250
Organiser added successfully!!!
+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
13
Thu Apr 18 20:25:31 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@5f049ea1
Display all coordinator
Coordinator ID : 201
Name : Neha Jadhav
Email : neha.j@gmail.com
Contact No. : 9897887870

Coordinator ID : 202
Name : Kajal Jadhav
Email : kajal.j@gmail.com
Contact No. : 9897777870

Coordinator ID : 203
Name : Jiya Raj
Email : jiya.r@gmail.com
Contact No. : 8794554553

Coordinator ID : 204
Name : Arun Singh
Email : arun.s@gmail.com
Contact No. : 7897978657

Coordinator ID : 205
Name : Tarun Sharma
Email : tarun.s@gmail.com
Contact No. : 9879789790

+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
9
Thu Apr 18 20:25:43 IST 2024 WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
com.mysql.cj.jdbc.ConnectionImpl@5afa3c9
Display all Organiser
Organiser ID : 1
Name : Dassault
Email : abc@gmail.com
Contact No. : 9989898988

Organiser ID : 2
Name : UBS
Email : def@gmail.com
Contact No. : 9989822332

Organiser ID : 3
Name : BNY mellon
Email : ghi@gmail.com
Contact No. : 9923222332

Organiser ID : 4
Name : Ansys
Email : jkl@gmail.com
Contact No. : 8967662332

Organiser ID : 5
Name : upstop
Email : mno@gmail.com
Contact No. : 7878962332

Organiser ID : 6
Name : Ganesh Jadhav
Email : ganeshjadhav@gmail.com
Contact No. : 9652841250

+---------------------------------------------+
|               Welcome Admin                 |
|                                             |
|              Choose option:                 |
|              1. Display all admins          |
|              2. Add new Admin               |
|              3. Update an admin information |
|              4. Delete an admin             |
|              5. Display all event           |
|              6. Add new event               |
|              7. Update an event information |
|              8. Delete an event             |
|              9. Display all organiser       |
|             10. Add new organiser           |
|             11. Update an organiser info    |
|             12. Delete an organiser         |
|             13. Display all coordinator     |
|             14. Add new coordinator         |
|             15. Update a coordinator info   |
|             16. Delete a coordinator        |
|             17. No.of Participants per event|
|             18. No.of Participants          |
|             19. Per Day Events              |
|             20. Max Registered Event        |
|             21. Logout                      |
+---------------------------------------------+
21
Sucessfully logout

 */
 