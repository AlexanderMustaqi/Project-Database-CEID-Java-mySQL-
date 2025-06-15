package Project2022;	

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


public class CustomerInterface implements ActionListener{
	JTextField RentT;
	JTextArea T;
	JButton ConfirmB = new JButton("Confirm");
	JScrollPane sc = new JScrollPane(T);
	JLabel Error = new JLabel("You can only Enter OO/OS/OM/MS");
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel panelC = new JPanel();
	JLabel FName = new JLabel();
	JLabel LName = new JLabel();
	JLabel Email = new JLabel();
	JLabel Address = new JLabel();
	JLabel Type = new JLabel();
	JLabel CDate = new JLabel();
	JLabel Disctrict = new JLabel();
	JLabel CityL = new JLabel();
	JLabel phoneL = new JLabel();
	JLabel countryL = new JLabel();
	JLabel postal_codeL = new JLabel();
	JTextField Edit = new JTextField();
	JButton Back = new JButton("Back");
	JButton Edit1;
	JButton Edit2;
	JButton Edit4;
	JButton Edit5;
	JButton Edit6;
	JButton Edit7;
	JButton Edit8;
	JButton Edit9;
	JButton Edit10;
	JTextField EditT1;
	JTextField EditT2;
	JTextField EditT4;
	JTextField EditT5;
	JTextField EditT6;
	JTextField EditT7;
	JTextField EditT8;
	JTextField EditT9;
	JTextField EditT10;
	JButton Ok1 = new JButton("OK");
	JButton Ok2= new JButton("OK");
	JButton Ok4= new JButton("OK");
	JButton Ok5= new JButton("OK");
	JButton Ok6= new JButton("OK");
	JButton Ok7= new JButton("OK");
	JButton Ok8= new JButton("OK");
	JButton Ok9= new JButton("OK");
	JButton Ok10= new JButton("OK");
	JButton CheckInv = new JButton("Check your Rentals");
	JButton ViewInv = new JButton("View renting Options");
	JButton Rent = new JButton("Rent");
	JButton Close = new JButton("Close");
	JLabel sample;
	int cityID;
	int countryID;
	int userID;
	int addressID;
	int customerID;
	String type;
	
	Connection conn;
	public CustomerInterface(String Uemail) {
			sample = new JLabel(Uemail);
		try {
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Projet2022","root","piggyface123");
			Statement st = conn.createStatement();
			ResultSet res;
			String firstName="";
			String lastName="";
			String Saddress="";
			String Stype="";
			String SCdate="";
			String district="";
			String City="";
			String postal_code="";
			String phone="";
			String country="";
			
			String statement="SELECT * FROM USER WHERE email=\""+Uemail+"\"";
			res = st.executeQuery(statement);
			res.next();
			firstName=res.getString("first_name");
			lastName=res.getString("last_name");
			SCdate=res.getString("create_date");
			userID=res.getInt("user_id");
			addressID=res.getInt("address_id");
			statement="SELECT * FROM CUSTOMER WHERE user_id=\""+userID+"\"";
			res = st.executeQuery(statement);
			res.next();
			Stype=res.getString("type");
			type=Stype;
			statement="SELECT * FROM ADDRESS WHERE address_id=\""+addressID+"\"";
			res=st.executeQuery(statement);
			res.next();
			Saddress=res.getString("address");
			district=res.getString("district");
			postal_code=res.getString("postal_code");
			phone=res.getString("phone");
			cityID=res.getInt("city_id");
			statement="SELECT * FROM CITY WHERE city_id=\""+cityID+"\"";
			res=st.executeQuery(statement);
			res.next();
			City=res.getString("city");
			countryID=res.getInt("country_id");
			statement="SELECT * FROM COUNTRY WHERE country_id=\""+countryID+"\"";
			res=st.executeQuery(statement);
			res.next();
			country=res.getString("country");
			statement="SELECT * FROM CUSTOMER WHERE user_id=\""+userID+"\"";
			res=st.executeQuery(statement);
			res.next();
			customerID = res.getInt("customer_id");
			
			FName.setText("First Name: "+firstName);
			FName.setBounds(100, 50, 165, 25);
			Edit1 = new JButton("Edit");
			Edit1.setBounds(400, 50, 75, 25);
			Edit1.addActionListener(this);
			LName.setText("Last Name : "+lastName);
			LName.setBounds(100, 80, 165, 25);
			Edit2 = new JButton("Edit");
			Edit2.setBounds(400, 80, 75, 25);
			Edit2.addActionListener(this);
			Email.setText("Email : "+Uemail);
			Email.setBounds(100, 110, 265, 25);
			phoneL.setText("Phone : "+phone);
			phoneL.setBounds(100, 140, 165, 25);
			Edit4 = new JButton("Edit");
			Edit4.setBounds(400, 140, 75, 25);
			Edit4.addActionListener(this);
			postal_codeL.setText("Postal Code : "+postal_code);
			postal_codeL.setBounds(100, 170, 165, 25);
			Edit5 = new JButton("Edit");
			Edit5.setBounds(400, 170, 75, 25);
			Edit5.addActionListener(this);
			Address.setText("Address : "+Saddress);
			Address.setBounds(100, 200, 165, 25);
			Edit6 = new JButton("Edit");
			Edit6.setBounds(400, 200, 75, 25);
			Edit6.addActionListener(this);
			CityL.setText("City : "+City);
			CityL.setBounds(100, 230, 165, 25);
			Edit7 = new JButton("Edit");
			Edit7.setBounds(400, 230, 75, 25);
			Edit7.addActionListener(this);
			countryL.setText("Country : "+country);
			countryL.setBounds(100, 260, 165, 25);
			Edit8 = new JButton("Edit");
			Edit8.setBounds(400, 260, 75, 25);
			Edit8.addActionListener(this);
			Disctrict.setText("District : "+district);
			Disctrict.setBounds(100,290,165,25);
			Edit9 = new JButton("Edit");
			Edit9.setBounds(400, 290, 75, 25);
			Edit9.addActionListener(this);
			Type.setText("Type : "+Stype);
			Type.setBounds(100, 320, 165, 25);
			Edit10 = new JButton("Edit");
			Edit10.setBounds(400, 320, 75, 25);
			Edit10.addActionListener(this);
			CDate.setText("Creation Date : "+SCdate);
			CDate.setBounds(100, 350, 200, 25);
			CheckInv.setBounds(100, 380, 165, 25);
			ViewInv.setBounds(270, 380, 165, 25);
			Rent.setBounds(440, 380, 165, 25);
			CheckInv.addActionListener(this);
			ViewInv.addActionListener(this);
			Rent.addActionListener(this);
			Ok1.addActionListener(this);
			Ok2.addActionListener(this);
			Ok4.addActionListener(this);
			Ok5.addActionListener(this);
			Ok6.addActionListener(this);
			Ok7.addActionListener(this);
			Ok8.addActionListener(this);
			Ok9.addActionListener(this);
			Ok10.addActionListener(this);
			
			panel.add(CheckInv);
			panel.add(ViewInv);
			panel.add(Rent);
			panel.add(Edit1);
			panel.add(Edit2);
			panel.add(Edit4);
			panel.add(Edit5);
			panel.add(Edit6);
			panel.add(Edit7);
			panel.add(Edit8);
			panel.add(Edit9);
			panel.add(Edit10);
			panel.setLayout(null);
			panel.add(FName);
			panel.add(LName);
			panel.add(Email);
			panel.add(phoneL);
			panel.add(Type);
			panel.add(Address);
			panel.add(countryL);
			panel.add(CityL);
			panel.add(Disctrict);
			panel.add(postal_codeL);
			panel.add(CDate);
			
			frame.setTitle("Customer Interface");
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.add(panel,BorderLayout.CENTER);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		panelC=panel;
		String Uemail = sample.getText();
		try {
		conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Projet2022","root","piggyface123");
		Statement st = conn.createStatement();
		ResultSet res;
		String statement="";
		Object obj = new Object();
		obj = e.getSource();
		if (obj==Edit1) {
			EditT1 = new JTextField();
			EditT1.setBounds(500,50,165,25);
			Ok1.setBounds(680, 50, 75, 25);
			panel.add(Ok1);
			panel.add(EditT1);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
			
			
		}
		if (obj==Edit2) {
			EditT2 = new JTextField();
			EditT2.setBounds(500,80,165,25);
			Ok2.setBounds(680, 80, 75, 25);
			panel.add(Ok2);
			panel.add(EditT2);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Edit4) {
			EditT4 = new JTextField();
			EditT4.setBounds(500,140,165,25);
			Ok4.setBounds(680, 140, 75, 25);
			panel.add(Ok4);
			panel.add(EditT4);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Edit5) {
			EditT5 = new JTextField();
			EditT5.setBounds(500,170,165,25);
			Ok5.setBounds(680, 170, 75, 25);
			panel.add(Ok5);
			panel.add(EditT5);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Edit6) {
			EditT6 = new JTextField();
			EditT6.setBounds(500,200,165,25);
			Ok6.setBounds(680, 200, 75, 25);
			panel.add(Ok6);
			panel.add(EditT6);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Edit7) {
			EditT7 = new JTextField();
			EditT7.setBounds(500,230,165,25);
			Ok7.setBounds(680, 230, 75, 25);
			panel.add(Ok7);
			panel.add(EditT7);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Edit8) {
			EditT8 = new JTextField();
			EditT8.setBounds(500,260,165,25);
			Ok8.setBounds(680, 260, 75, 25);
			panel.add(Ok8);
			panel.add(EditT8);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Edit9) {
			EditT9 = new JTextField();
			EditT9.setBounds(500,290,165,25);
			Ok9.setBounds(680, 290, 75, 25);
			panel.add(Ok9);
			panel.add(EditT9);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Edit10) {
			EditT10 = new JTextField();
			EditT10.setBounds(500,320,165,25);
			Ok10.setBounds(680, 320, 75, 25);
			panel.add(Ok10);
			panel.add(EditT10);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok1) {
			String newS=EditT1.getText();
			statement="UPDATE USER"
					+ " SET first_name=\""+newS+"\""
							+ " WHERE EMAIL=\""+Uemail+"\"";
			st.executeUpdate(statement);
			FName.setText("First Name : "+newS);
			panel.remove(EditT1);panel.remove(Ok1);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok2) {
			String newS=EditT2.getText();
			statement="UPDATE USER"
					+ " SET last_name=\""+newS+"\""
							+ " WHERE EMAIL=\""+Uemail+"\"";
			st.executeUpdate(statement);
			LName.setText("Last Name : "+newS);
			panel.remove(EditT2);panel.remove(Ok2);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok4) {
			String newS=EditT4.getText();
			statement="UPDATE ADDRESS"
					+ " SET phone=\""+newS+"\""
							+ " WHERE city_id=\""+cityID+"\"";
			st.executeUpdate(statement);
			phoneL.setText("Phone : "+newS);
			panel.remove(EditT4);panel.remove(Ok4);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok5) {
			String newS=EditT5.getText();
			statement="UPDATE ADDRESS"
					+ " SET postal_code=\""+newS+"\""
							+ " WHERE city_id=\""+cityID+"\"";
			st.executeUpdate(statement);
			panel.remove(EditT5);panel.remove(Ok5);
			postal_codeL.setText("Postal Code : "+newS);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok6) {
			String newS=EditT6.getText();
			statement="UPDATE ADDRESS"
					+ " SET address=\""+newS+"\""
							+ " WHERE city_id=\""+cityID+"\"";
			st.executeUpdate(statement);
			Address.setText("Address : "+newS);
			panel.remove(EditT6);panel.remove(Ok6);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok7) {
			String newS=EditT7.getText();
			statement="UPDATE CITY"
					+ " SET city=\""+newS+"\""
							+ " WHERE city_id=\""+cityID+"\"";
			st.executeUpdate(statement);
			CityL.setText("City : "+newS);
			panel.remove(EditT7);panel.remove(Ok7);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok8) {
			String newS=EditT8.getText();
			statement="UPDATE COUNTRY"
					+ " SET country=\""+newS+"\""
							+ " WHERE country_id=\""+countryID+"\"";
			st.executeUpdate(statement);
			countryL.setText("Country : "+newS);
			panel.remove(EditT8);panel.remove(Ok8);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok9) {
			String newS=EditT9.getText();
			statement="UPDATE ADDRESS"
					+ " SET district=\""+newS+"\""
							+ " WHERE city_id=\""+cityID+"\"";
			st.executeUpdate(statement);
			Disctrict.setText("District : "+newS);
			panel.remove(EditT9);panel.remove(Ok9);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Ok10) {
			if (Error.isDisplayable()) {
				panel.remove(Error);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			try {
			String newS=EditT10.getText();
			statement="UPDATE CUSTOMER"
				+ " SET type=\""+newS+"\""
						+ " WHERE user_id=\""+userID+"\"";
			st.executeUpdate(statement);
			Type.setText("Type : "+newS);
			panel.remove(EditT10);panel.remove(Ok10);
			frame.invalidate();
			frame.validate();
			frame.repaint();
			}catch (java.sql.SQLException e2) {
				Error.setBounds(500, 355, 300, 25);
				panel.add(Error);
				frame.add(panel);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
		}
		if (obj==CheckInv) {
			if (sc.isDisplayable()) {
				panel.remove(sc);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			statement="SELECT * FROM RENTAL Inner join inventory ON inventory.inventory_id=rental.inventory_id where rental.customer_id=\""+customerID+"\"";
			res = st.executeQuery(statement);
			String txt="TYPE | TITLE | ACTIVE | DATE | RENTAL_ID | INVENTORY_ID\n";
			while(res.next()) {
				txt=txt+res.getString("type")+" | "+res.getString("title")+" | "+res.getString("active")+" | "+res.getString("rental_date")+" | "+res.getString("rental_id")+" | "+res.getString("inventory_id")+"\n";
			}
			T = new JTextArea(txt,600,600);
			sc = new JScrollPane(T);
			sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sc.setBounds(800, 50, 600, 600);
			panel.add(sc);
			Close.setBounds(100, 410, 165, 25);
			Close.addActionListener(this);
			panel.add(Close);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Close) {
			if (RentT.isDisplayable()) {
				panel.remove(RentT);
				panel.remove(Close);
				panel.remove(ConfirmB);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			else if (sc.isDisplayable()) {
				panel.remove(sc);
				panel.remove(Close);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
		}
		if (obj==ViewInv) {
			if (sc.isDisplayable()) {
				panel.remove(sc);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			String txt="";
			if (type.equals("OO")) {
				txt="You aren't obliged to anything";
			}
			if (type.equals("OS")) {
				statement="SELECT * FROM INVENTORY INNER JOIN RENTAL ON INVENTORY.INVENTORY_ID=RENTAL.INVENTORY_ID "
						+ "WHERE INVENTORY.TYPE=\"s\" AND ACTIVE=1 AND RENTAL.CUSTOMER_ID!=\""+customerID+"\"";
				res=st.executeQuery(statement);
				txt="TITLE | ID\n";
				while(res.next()) {
					txt=txt+res.getString("title")+" | "+res.getString("inventory_id")+"\n";
				}
			}
			if (type.equals("OM")) {
				statement="SELECT * FROM INVENTORY INNER JOIN RENTAL ON INVENTORY.INVENTORY_ID=RENTAL.INVENTORY_ID "
						+ "WHERE INVENTORY.TYPE=\"s\" AND ACTIVE=1 AND RENTAL.CUSTOMER_ID!=\""+customerID+"\"";
				res=st.executeQuery(statement);
				txt="TITLE | ID\n";
				while(res.next()) {
					txt=txt+res.getString("title")+" | "+res.getString("inventory_id")+"\n";
				}
			}
			if (type.equals("MS")) {
				statement="SELECT * FROM INVENTORY INNER JOIN RENTAL ON INVENTORY.INVENTORY_ID=RENTAL.INVENTORY_ID "
						+ "WHERE INVENTORY.TYPE=\"s\" AND ACTIVE=1 AND RENTAL.CUSTOMER_ID!=\""+customerID+"\"";
				res=st.executeQuery(statement);
				txt="TITLE | ID\n";
				while(res.next()) {
					txt=txt+res.getString("title")+" | "+res.getString("inventory_id")+"\n";
				}
			}
			T = new JTextArea(txt);
			sc = new JScrollPane(T);
			sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			sc.setBounds(800, 50, 600, 600);
			panel.add(sc);
			Close.setBounds(270, 410, 165, 25);
			Close.addActionListener(this);
			panel.add(Close);
			frame.add(panel);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
		if (obj==Rent) {
			if (Close.isDisplayable()) {
				panel.remove(Close);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			
				RentT = new JTextField();
				RentT.setBounds(440,440,165,25);
				Close.setBounds(440, 410, 165, 25);
				Close.addActionListener(this);
				ConfirmB.setBounds(440,470,165,25);
				ConfirmB.addActionListener(this);
				panel.add(RentT);
				panel.add(Close);
				panel.add(ConfirmB);
				frame.invalidate();
				frame.validate();
				frame.repaint();
		}
		if (obj==ConfirmB) {
			if (Error.isDisplayable()) {
				panel.remove(Error);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
			try {
			int input;
			input = Integer.parseInt(RentT.getText());
			statement="SELECT * FROM INVENTORY WHERE INVENTORY_ID=\""+input+"\"";
			res=st.executeQuery(statement);
			res.next();
			String type1=res.getString("type");
			statement="insert into rental values (default,now(),"+input+","+customerID+",\""+type1+"\")";
			st.executeUpdate(statement);
			panel.remove(ConfirmB);
			panel.remove(RentT);
			panel.remove(Close);
			frame.invalidate();
			frame.validate();
			frame.repaint();
			}catch (Exception e2) {
				e2.printStackTrace();
				Error.setText("Please enter a valid ID!");
				Error.setBounds(440, 500, 165, 25);
				panel.add(Error);
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
		}
	}catch(Exception e1) {e1.printStackTrace();} 
	}
}
