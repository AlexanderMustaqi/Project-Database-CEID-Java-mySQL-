package Project2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class EmployeeInterface  implements ActionListener{

	int Count=0;
	int userID;
	int addressID;
	int countryID;
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JTextArea T = new JTextArea();
	JScrollPane sc = new JScrollPane(T);
	JButton SearchEnter = new JButton("Enter");
	JLabel SearchEmail = new JLabel("Enter Customer's email:");
	JTextField Search = new JTextField();
	String customerEmail="";
	JLabel FNameL = new JLabel();
	JLabel LNameL;
	JLabel EmailL;
	JLabel PhoneL;
	JLabel Postal_codeL;
	JLabel CountryL;
	JLabel CityL;
	JLabel DistrictL;
	JLabel AddressL;
	JLabel TypeL;
	JLabel CDateL;
	JButton Edit1 = new JButton("Edit");
	JButton Edit2 = new JButton("Edit");
	JButton Edit3 = new JButton("Edit");
	JButton Edit4 = new JButton("Edit");
	JButton Edit5 = new JButton("Edit");
	JButton Edit6 = new JButton("Edit");
	JButton Edit7 = new JButton("Edit");
	JButton Edit8 = new JButton("Edit");
	JButton Edit9 = new JButton("Edit");
	JTextField EditT = new JTextField();
	JTextField EditTables = new JTextField();
	JButton Okay = new JButton("Okay");
	JButton CheckRental = new JButton("Check Rentals");
	JButton CheckUsers = new JButton("Check Users");
	JButton CheckAvailableTables = new JButton("Check Tables");
	JButton EnterTables = new JButton("Enter");
	JLabel Tables= new JLabel("Enter  the Table's Name:");
	JButton bestOf = new JButton("Top 5 Films/Series");
	String statement="";
	Connection Conn;
	public EmployeeInterface(String Uemail) {
		try {
		
		Conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Projet2022","root","piggyface123");
		Statement st = Conn.createStatement();
		ResultSet res;
		String txt="USER \n";
		statement = "SELECT * FROM USER inner join customer on user.user_id=customer.user_id";
		res = st.executeQuery(statement);
		while (res.next()) {
			txt=txt+res.getString("first_name")+" "+res.getString("last_name")+" | "+res.getString("email")+" \n";
		}
		T.setText(txt);
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sc.setBounds(50, 50, 600, 600);
		SearchEmail.setBounds(50, 650, 165, 25);
		Tables.setBounds(350, 650, 165, 25);
		EditTables.setBounds(350, 675, 165, 25);
		CheckAvailableTables.setBounds(350,730,165,25);
		CheckAvailableTables.addActionListener(this);
		EnterTables.setBounds(350, 700, 165, 25);
		EnterTables.addActionListener(this);
		Search.setBounds(50, 675, 265, 25);
		SearchEnter.setBounds(50, 700, 165, 25);
		SearchEnter.addActionListener(this);
		CheckRental.setBounds(50, 730, 165, 25);
		CheckRental.addActionListener(this);
		CheckUsers.setBounds(50, 760, 165, 25);
		CheckUsers.addActionListener(this);
		bestOf.setBounds(350, 760, 165, 25);
		bestOf.addActionListener(this);
		
		
		panel.setLayout(null);
		panel.add(sc);
		panel.add(SearchEmail);
		panel.add(Search);
		panel.add(SearchEnter);
		panel.add(CheckRental);
		panel.add(CheckUsers);
		panel.add(EditTables);
		panel.add(CheckAvailableTables);
		panel.add(EnterTables);
		panel.add(Tables);
		panel.add(bestOf);
		
		frame.setTitle("Employee Interface");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		}catch(SQLException e1) {e1.printStackTrace();}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		Conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Projet2022","root","piggyface123");
		Statement st = Conn.createStatement();
		ResultSet res;
		
		Object obj = new Object();
		obj=e.getSource();
		
		if (obj==SearchEnter) {
			if (FNameL.isDisplayable()) {
				panel.remove(FNameL);
				panel.remove(LNameL);
				panel.remove(EmailL);
				panel.remove(PhoneL);
				panel.remove(AddressL);
				panel.remove(CDateL);
				panel.remove(Postal_codeL);
				panel.remove(CityL);
				panel.remove(CountryL);
				panel.remove(EditT);
				panel.remove(Okay);
				panel.remove(Edit1);
				panel.remove(Edit2);
				panel.remove(Edit3);
				panel.remove(Edit4);
				panel.remove(Edit5);
				panel.remove(Edit6);
				panel.remove(Edit7);
				panel.remove(Edit8);
				panel.remove(Edit9);
				
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			customerEmail=Search.getText();
			statement="SELECT * FROM USER INNER JOIN CUSTOMER ON USER.USER_ID=CUSTOMER.USER_ID "
					+ "WHERE email=\""+customerEmail+"\"";
			res=st.executeQuery(statement);
			res.next();
			userID = Integer.parseInt(res.getString("user_id"));
			addressID = Integer.parseInt(res.getString("address_id"));
			FNameL.setText("First Name :"+res.getString("first_name"));
			FNameL.setBounds(700, 50, 165, 25);
			Edit1 = new JButton("Edit");
			Edit1.setBounds(1000, 50, 165, 25);
			Edit1.addActionListener(this);
			LNameL = new JLabel("Last Name :"+res.getString("last_name"));
			LNameL.setBounds(700, 80, 165, 25);
			Edit2 = new JButton("Edit");
			Edit2.setBounds(1000, 80, 165, 25);
			Edit2.addActionListener(this);
			EmailL = new JLabel("Email :"+customerEmail);
			EmailL.setBounds(700,110,265,25);
			Edit3 = new JButton("Edit");
			Edit3.setBounds(1000, 110, 165, 25);
			Edit3.addActionListener(this);
			TypeL = new JLabel("Type :"+res.getString("type"));
			TypeL.setBounds(700, 290, 165, 25);
			Edit9 = new JButton("Edit");
			Edit9.setBounds(1000, 290, 165, 25);
			Edit9.addActionListener(this);
			CDateL = new JLabel("Creation Date :"+res.getString("create_date"));
			CDateL.setBounds(700, 320, 265, 25);
			statement="select * from address inner "
					+ "join user on address.address_id=user.address_id where user.email=\""+customerEmail+"\"; ";
			res=st.executeQuery(statement);
			res.next();
			AddressL = new JLabel("Address :"+res.getString("address"));
			AddressL.setBounds(700, 170, 265, 25);
			Edit5 = new JButton("Edit");
			Edit5.setBounds(1000, 170, 165, 25);
			Edit5.addActionListener(this);
			Postal_codeL = new JLabel("Postal code :"+res.getString("postal_code"));
			Postal_codeL.setBounds(700, 200, 165, 25);
			Edit6 = new JButton("Edit");
			Edit6.setBounds(1000, 200, 165, 25);
			Edit6.addActionListener(this);
			PhoneL = new JLabel("Phone :"+res.getString("phone"));
			PhoneL.setBounds(700, 140, 165, 25);
			Edit4 = new JButton("Edit");
			Edit4.setBounds(1000, 140, 165, 25);
			Edit4.addActionListener(this);
			String cityID =res.getString("city_id");
			statement="select city,country,country.country_id from city inner join country on "
					+ "city.country_id=country.country_id where city.city_id=\""+cityID+"\";\r\n";
			res = st.executeQuery(statement);
			res.next();
			countryID=Integer.parseInt(res.getString("country_id"));
			CityL = new JLabel("City :"+res.getString("city"));
			CityL.setBounds(700, 230, 165, 25);
			Edit7 = new JButton("Edit");
			Edit7.setBounds(1000, 230, 165, 25);
			Edit7.addActionListener(this);
			CountryL = new JLabel("Country :"+res.getString("country"));
			CountryL.setBounds(700, 260, 165, 25);
			Edit8 = new JButton("Edit");
			Edit8.setBounds(1000, 260, 165, 25);
			Edit8.addActionListener(this);
			
			panel.add(FNameL);
			panel.add(LNameL);
			panel.add(EmailL);
			panel.add(PhoneL);
			panel.add(AddressL);
			panel.add(CDateL);
			panel.add(Postal_codeL);
			panel.add(CityL);
			panel.add(CountryL);
			panel.add(TypeL);
			panel.add(Edit1);
			panel.add(Edit2);
			panel.add(Edit3);
			panel.add(Edit4);
			panel.add(Edit5);
			panel.add(Edit6);
			panel.add(Edit7);
			panel.add(Edit8);
			panel.add(Edit9);
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
		
			}
		if (obj==Edit1||obj==Edit2||obj==Edit3||obj==Edit4||obj==Edit5||obj==Edit6||obj==Edit7||obj==Edit8||obj==Edit9) {
			Count=0;
			Okay.addActionListener(this);
			if (EditT.isDisplayable()) {
				panel.remove(EditT);
				panel.remove(Okay);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			if (obj==Edit1) {
				EditT.setBounds(1170, 50, 165, 25);
				Okay.setBounds(1340, 50, 165, 25);
				Count=1;
			}
			if (obj==Edit2) {
				EditT.setBounds(1170, 80, 165, 25);
				Okay.setBounds(1340, 80, 165, 25);
				Count=2;
			}
			if (obj==Edit3) {
				EditT.setBounds(1170, 110, 165, 25);
				Okay.setBounds(1340, 110, 165, 25);
				Count=3;
			}
			if (obj==Edit4) {
				EditT.setBounds(1170, 140, 165, 25);
				Okay.setBounds(1340, 140, 165, 25);
				Count=4;
			}
			if (obj==Edit5) {
				EditT.setBounds(1170, 170, 165, 25);
				Okay.setBounds(1340, 170, 165, 25);
				Count=5;
			}
			if (obj==Edit6) {
				EditT.setBounds(1170, 200, 165, 25);
				Okay.setBounds(1340, 200, 165, 25);
				Count=6;
			}
			if (obj==Edit7) {
				EditT.setBounds(1170, 230, 165, 25);
				Okay.setBounds(1340, 230, 165, 25);
				Count=7;
			}
			if (obj==Edit8) {
				EditT.setBounds(1170, 260, 165, 25);
				Okay.setBounds(1340, 260, 165, 25);
				Count=8;
			}
			if (obj==Edit9) {
				EditT.setBounds(1170, 290, 165, 25);
				Okay.setBounds(1340, 290, 165, 25);
				Count=9;
			}
			panel.add(EditT);
			panel.add(Okay);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		
		}
		if (obj==Okay) {
			String NewT="";
			NewT=EditT.getText();
			if (Count==1) {
				statement="update user "
						+ "set first_name=\""+NewT+"\""
								+ " where user_id=\""+userID+"\"";
				st.executeUpdate(statement);
				FNameL.setText("First Name :"+NewT);
			}
			if (Count==2) {
				statement="update user "
						+ "set last_name=\""+NewT+"\""
								+ " where user_id=\""+userID+"\"";
				st.executeUpdate(statement);
				LNameL.setText("Last Name :"+NewT);
				}
			if (Count==3) {
				statement="update user "
						+ "set email=\""+NewT+"\""
								+ " where user_id=\""+userID+"\"";
				st.executeUpdate(statement);
				EmailL.setText("Email :"+NewT);
				}
			if (Count==4) {
				statement="update address "
						+ "set phone=\""+NewT+"\""
								+ " where address_id=\""+addressID+"\"";
				st.executeUpdate(statement);
				PhoneL.setText("Phone :"+NewT);
				}
			if (Count==5) {
				statement="update address "
						+ "set address=\""+NewT+"\""
								+ " where address_id=\""+addressID+"\"";
				st.executeUpdate(statement);
				AddressL.setText("Address :"+NewT);
				}
			if (Count==6) {
				statement="update address "
						+ "set postal_code=\""+NewT+"\""
								+ " where address_id=\""+addressID+"\"";
				st.executeUpdate(statement);
				Postal_codeL.setText("Postal code :"+NewT);
				}
			if (Count==7) {
				statement="update city "
						+ "set city=\""+NewT+"\""
								+ " where country_id=\""+countryID+"\"";
				st.executeUpdate(statement);
				CityL.setText("City :"+NewT);
				}
			if (Count==8) {
				statement="update country "
						+ "set country=\""+NewT+"\""
								+ " where country_id=\""+countryID+"\"";
				st.executeUpdate(statement);
				CountryL.setText("Country :"+NewT);
				}
			if (Count==9) {
				statement="update customer "
						+ "set type=\""+NewT+"\""
								+ " where user_id=\""+userID+"\"";
				st.executeUpdate(statement);
				TypeL.setText("Type :"+NewT);
				}
			panel.remove(Okay);
			panel.remove(EditT);
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
			}
		
		if (obj==CheckRental) {
			statement="select * from rental";
			res = st.executeQuery(statement);
			String txt="RENTAL ID | RENTAL DATE | INVENTORY ID | CUSTOMER ID | TYPE \n";
			while (res.next()) {
				txt=txt+res.getString("rental_id")+" | "+res.getString("rental_date")+" | "+res.getShort("inventory_id")+" | "+res.getString("customer_id")
				+" | "+res.getString("type")+" \n";
			}
			T.setText(txt);
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==CheckUsers) {
			String txt="USER \n";
			statement = "SELECT * FROM USER where user_id>10";
			res = st.executeQuery(statement);
			while (res.next()) {
				txt=txt+res.getString("first_name")+" "+res.getString("last_name")+" | "+res.getString("email")+" \n";
			}
			T.setText(txt);
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==CheckAvailableTables) {
			String txt="Available Tables\n"
					+ "actor | film | series \n"
					+ "language | category | address\n"
					+ "city | country | inventory";
			T.setText(txt);
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		/*if (obj==EnterTables) {
			String ans = EditTables.getText();
			String txt="";
			statement="select * from "+ans;
			res=st.executeQuery(statement);
			while (res.next()) {
				txt=txt+res.getRow();
			}
			T.setText(txt);
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
			
		}*/
		if (obj==bestOf) {
			statement="call ask1(\"m\",5,now()-interval 1 month,now())";
			res=st.executeQuery(statement);
			String txt="The best Movies of the Last Month are :\n";
			while(res.next()) {
				txt=txt+res.getString("title")+" | With "+res.getString("VIEWS")+" Views"+"\n";
			}
			statement="call ask1(\"s\",5,now()-interval 1 month,now())";
			res=st.executeQuery(statement);
			txt=txt+"\nThe best Serieses of the Last Month are :\n";
			while(res.next()) {
				txt=txt+res.getString("title")+" | With "+res.getString("telika_views")+" Views"+"\n";
			}
			T.setText(txt);
			
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		}catch (SQLException e1) {
			e1.printStackTrace(); 
		}
	}
}
