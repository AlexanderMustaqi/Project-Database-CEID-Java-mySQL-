package Project2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class LoginGUI implements ActionListener{
	JFrame frame;
	JPanel panel;
	JTextField UserEmailT;
	JButton LoginButton;
	JLabel UserEmail;
	JLabel Result; 
	public LoginGUI() {
		UserEmailT = new JTextField();
		UserEmailT.setBounds(100, 50, 265, 25);
		
		LoginButton = new JButton("Login");
		LoginButton.addActionListener(this);
		LoginButton.setBounds(100, 110, 165, 25);
		
		UserEmail = new JLabel("User Email");
		UserEmail.setBounds(15, 50, 165, 25);
		
		Result = new JLabel("");
		Result.setBounds(15, 195, 350, 25);
		
		panel = new JPanel(null);
		panel.add(UserEmail);
		panel.add(UserEmailT);
		panel.add(LoginButton);
		panel.add(Result);
		
		frame = new JFrame();
		frame.setTitle("Welcome To On DemandTV");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = new Object();
		obj = e.getSource();
		Connection Conn;
		String userType="";
		String answer;
		String NameText=UserEmailT.getText();

		try {
			Conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Projet2022","root","piggyface123");
			Statement st = Conn.createStatement();
			ResultSet res;
			res = st.executeQuery("SELECT user_id FROM USER WHERE EMAIL=\""+NameText+"\"");
			res.next();
			Integer UserId = res.getInt("user_id");
			String statement ="SELECT EXISTS(SELECT * FROM USER INNER JOIN CUSTOMER ON \""+UserId+"\"=customer.user_id)";
			res = st.executeQuery(statement);
			res.next();
			if (res.getInt("EXISTS(SELECT * FROM USER INNER JOIN CUSTOMER ON \""+UserId+"\"=customer.user_id)")==1)
				{
				userType="1";
				}
			statement = "SELECT EXISTS(SELECT * FROM USER INNER JOIN EMPLOYEE ON \""+UserId+"\"=employee.user_id)";
			res = st.executeQuery(statement);
			res.next();
			if (res.getInt("EXISTS(SELECT * FROM USER INNER JOIN EMPLOYEE ON \""+UserId+"\"=employee.user_id)")==1)
				{
				userType="2";
				}
			statement ="SELECT EXISTS(SELECT * FROM USER INNER JOIN administrator ON \""+UserId+"\"=administrator.user_id)";
			res = st.executeQuery(statement);
			res.next();
			if (res.getInt("EXISTS(SELECT * FROM USER INNER JOIN administrator ON \""+UserId+"\"=administrator.user_id)")==1)
				{
				userType="3";
				}
			res = st.executeQuery("SELECT EXISTS(SELECT * FROM USER WHERE EMAIL=\""+NameText+"\")");
			res.next();
			answer=res.getString("EXISTS(SELECT * FROM USER WHERE EMAIL=\""+NameText+"\")");
			if (answer.equals("1")) {
				if (userType.equals("1")) {CustomerInterface I = new CustomerInterface(NameText);}
				else if (userType.equals("2")) {EmployeeInterface I = new EmployeeInterface(NameText);}
				else if (userType.equals("3")) {AdminInterface I = new AdminInterface(NameText);}
			}
			else {
				Result.setText("Your Email or Password are incorrect!"); 
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		}
	}

