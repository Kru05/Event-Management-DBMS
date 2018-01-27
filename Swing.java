import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Swing {
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/root";
	static final String USER="vedika";
	static final String PASSWORD="Vedika@31";
	private JFrame frame,frame1,frame2,frame4;
	private JTextField addr;
	private JTextField name;
	private JTextField phno;
	private JTextField email; 
	JRadioButton select=null,sel;
	private JTextField no,total,advanced;
	private JTextField dateofevent; 
	private JTextField custno,eventid,txt_weight,txt_flavour;
	private JCheckBox select1;
	int veg_ni=250;
	int veg_mh=200;
	int veg_c=300;
	int nveg_ni=350;
	int nveg_mh=300;
	int nveg_c=400;
	int cake=250;
	int totalcost=0;
	int abill=0;
	String mode=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					window.frame.setVisible(true);
					//Swing window1 = new Swing();
					//window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("CUSTOMER INFORMATION");
		lblNewLabel.setBounds(119, 36, 250, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCustid = new JLabel("Name");
		lblCustid.setBounds(31, 110, 70, 15);
		frame.getContentPane().add(lblCustid);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(31, 140, 70, 15);
		frame.getContentPane().add(lblAddress);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setBounds(31, 165, 94, 15);
		frame.getContentPane().add(lblPhoneNo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 192, 70, 15);
		frame.getContentPane().add(lblEmail);

		addr = new JTextField();
		addr.setBounds(220, 138, 114, 19);
		frame.getContentPane().add(addr);
		addr.setColumns(10);
		//textField.addActionListener((ActionListener) this);
		//frame.getContentPane().add(addr);
		//String str1 = textField.getText();


		name = new JTextField();
		name.setBounds(220, 108, 114, 19);
		frame.getContentPane().add(name);
		name.setColumns(10);
		//addActionListener((ActionListener) this);
		//frame.getContentPane().add(name);
		//String str = textField_1.getText();

		phno = new JTextField();
		phno.setBounds(220, 163, 114, 19);
		frame.getContentPane().add(phno);
		phno.setColumns(10);
		//textField_2.addActionListener((ActionListener) this);
		//frame.getContentPane().add(phno);
		/*String str4= textField_1.getText();
		int cn = Integer.parseInt(str4);*/

		email = new JTextField();
		email.setBounds(220, 190, 114, 19);
		frame.getContentPane().add(email);
		email.setColumns(10);
		//textField_3.addActionListener((ActionListener) this);
		//frame.getContentPane().add(email);
		//String str3 = textField_3.getText();


		JButton Next = new JButton("Next");
		Next.setBounds(153, 235, 117, 25);
		frame.getContentPane().add(Next);

		JLabel lblCustomerId = new JLabel("Customer id");
		lblCustomerId.setBounds(31, 80, 147, 15);
		frame.getContentPane().add(lblCustomerId);

		custno = new JTextField();
		custno.setBounds(220, 77, 114, 19);
		frame.getContentPane().add(custno);
		custno.setColumns(10);
		Next.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				final String JDBC_DRIVER="com.mysql.jdbc.Driver";
				final String DB_URL="jdbc:mysql://localhost:3306/root";
				final String USER="vedika";
				final String PASSWORD="Vedika@31";
				PreparedStatement pstmt=null;
				Connection conn=null;
				try{
					String str5=custno.getText();
					int cn1 = Integer.parseInt(str5);
					String str = name.getText();
					String str1 = addr.getText();
					String str4= phno.getText();
					int cn = Integer.parseInt(str4);
					String str3 = email.getText();
					Class.forName(JDBC_DRIVER);
					conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
					pstmt=conn.prepareStatement("insert into customer(cust_id,cust_name,address,contact_no,email)values(?,?,?,?,?);");
					pstmt.setInt(1,cn1);
					pstmt.setString(2,str);
					pstmt.setString(3,str1);
					pstmt.setInt(4,cn);
					pstmt.setString(5,str3);

					pstmt.executeUpdate();




					frame1 = new JFrame();
					frame1.setBounds(100, 100, 450, 300);
					frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame1.getContentPane().setLayout(null);
					frame1.setVisible(true);

					JLabel lblEventInformation = new JLabel("EVENT INFORMATION");
					lblEventInformation.setBounds(145, 32, 131, 15);
					frame1.getContentPane().add(lblEventInformation);

					JLabel lblType = new JLabel("Type");
					lblType.setBounds(32, 73, 70, 15);
					frame1.getContentPane().add(lblType);
					JRadioButton Birthday = new JRadioButton("Birthday");
					Birthday.setBounds(166, 69, 149, 23);
					frame1.getContentPane().add(Birthday);

					JRadioButton Reunion = new JRadioButton("Reunion");
					Reunion.setBounds(166, 96, 149, 23);
					frame1.getContentPane().add(Reunion);

					JRadioButton Anniversary = new JRadioButton("Anniversary");
					Anniversary.setBounds(166, 125, 149, 23);
					frame1.getContentPane().add(Anniversary);

					JRadioButton Engagement = new JRadioButton("Engagement");
					Engagement.setBounds(166, 152, 149, 23);
					frame1.getContentPane().add(Engagement);






					JLabel lblDate = new JLabel("Date");
					lblDate.setBounds(32, 187, 70, 15);
					frame1.getContentPane().add(lblDate);

					JLabel NoOfGuests = new JLabel("No. of Guests");
					NoOfGuests.setBounds(32, 208, 101, 15);
					frame1.getContentPane().add(NoOfGuests);

					no = new JTextField();
					no.setBounds(166, 206, 114, 19);
					frame1.getContentPane().add(no);
					no.setColumns(10);

					dateofevent = new JTextField();
					dateofevent.setBounds(166, 183, 114, 19);
					frame1.getContentPane().add(dateofevent);
					dateofevent.setColumns(10);
					JLabel lblEventid = new JLabel("Event_id");
					lblEventid.setBounds(32, 54, 70, 15);
					frame1.getContentPane().add(lblEventid);

					eventid = new JTextField();
					eventid.setBounds(166, 49, 114, 19);
					frame1.getContentPane().add(eventid);
					eventid.setColumns(10);

					JLabel lblDdmmyyyy = new JLabel("(dd-mm-yyyy)");
					lblDdmmyyyy.setBounds(298, 183, 95, 15);
					frame1.getContentPane().add(lblDdmmyyyy);

					ButtonGroup but=new ButtonGroup();
					but.add(Birthday);
					but.add(Reunion);
					but.add(Anniversary);
					but.add(Engagement);
					JButton btnNext = new JButton("Next");
					btnNext.setBounds(166, 233, 117, 25);
					frame1.getContentPane().add(btnNext);
					btnNext.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{

							PreparedStatement pstmt=null;
							Connection conn=null;


							try{
								if (Birthday.isSelected()) {
									select = Birthday;
								} else if (Reunion.isSelected()) {
									select = Reunion;
								} else if (Anniversary.isSelected()) {
									select = Anniversary;
								}
								else if(Engagement.isSelected())
								{
									select = Engagement;
								}
								String choice = select.getText();
								String str4= no.getText();
								int cn5 = Integer.parseInt(str4);
								String str=dateofevent.getText();
								String str1=eventid.getText();
								int cn8 = Integer.parseInt(str1);
								Class.forName(JDBC_DRIVER);
								conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
								pstmt=conn.prepareStatement("insert into event(event_id,ename,noofguests)values(?,?,?);");
								pstmt.setInt(1,cn8);
								pstmt.setString(2,choice);
								pstmt.setInt(3,cn5);
								pstmt.executeUpdate();
								pstmt=conn.prepareStatement("insert into registersfor(event_id,cust_id,date_of_event)values(?,?,?);");
								pstmt.setInt(1,cn8);
								pstmt.setInt(2,cn1);
								pstmt.setString(3,str);
								//pstmt.setDate(3,(java.sql.Date) date);
								pstmt.executeUpdate();

								conn.close();
								pstmt.close();

								frame2= new JFrame();
								frame2.setBounds(100, 100, 500, 400);
								frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame2.getContentPane().setLayout(null);
								frame2.setVisible(true);

								JLabel lblServiceInformation = new JLabel("SERVICE INFORMATION");
								lblServiceInformation.setBounds(158, 24, 157, 15);
								frame2.getContentPane().add(lblServiceInformation);

								JRadioButton rdbtnFood = new JRadioButton("Food");
								rdbtnFood.setBounds(25, 35, 129, 23);
								frame2.getContentPane().add(rdbtnFood);


								JRadioButton rdbtnCake = new JRadioButton("Cake");
								rdbtnCake.setBounds(25, 138, 129, 23);
								frame2.getContentPane().add(rdbtnCake);



								JRadioButton rdbtnEggless = new JRadioButton("Eggless");
								rdbtnEggless.setBounds(25, 165, 87, 23);
								frame2.getContentPane().add(rdbtnEggless);

								JRadioButton rdbtnWithEgg = new JRadioButton("With Egg");
								rdbtnWithEgg.setBounds(122, 165, 103, 23);
								frame2.getContentPane().add(rdbtnWithEgg);

								JLabel lblFalour = new JLabel("Flavour");
								lblFalour.setBounds(31, 196, 70, 15);
								frame2.getContentPane().add(lblFalour);

								txt_weight = new JTextField();
								txt_weight.setBounds(111, 196, 114, 19);
								frame2.getContentPane().add(txt_weight);
								txt_weight.setColumns(10);

								JLabel lblWeight = new JLabel("Weight");
								lblWeight.setBounds(31, 220, 70, 15);
								frame2.getContentPane().add(lblWeight);

								txt_flavour = new JTextField();
								txt_flavour.setBounds(111, 220, 114, 19);
								frame2.getContentPane().add(txt_flavour);
								txt_flavour.setColumns(10);

								JRadioButton rdbtnVeg = new JRadioButton("VEG");
								rdbtnVeg.setBounds(25, 62, 68, 23);
								frame2.getContentPane().add(rdbtnVeg);

								JRadioButton rdbtnNonVeg = new JRadioButton("Non-Veg");
								rdbtnNonVeg.setBounds(111, 62, 117, 23);
								frame2.getContentPane().add(rdbtnNonVeg);

								JRadioButton rdbtnMaharastrian = new JRadioButton("Maharastrian");
								rdbtnMaharastrian.setBounds(156, 89, 149, 23);
								frame2.getContentPane().add(rdbtnMaharastrian);

								JRadioButton rdbtnNorthIndian = new JRadioButton("North Indian");
								rdbtnNorthIndian.setBounds(25, 89, 150, 23);
								frame2.getContentPane().add(rdbtnNorthIndian);

								JRadioButton rdbtnContinental = new JRadioButton("Continental");
								rdbtnContinental.setBounds(309, 89, 149, 23);
								frame2.getContentPane().add(rdbtnContinental);
								ButtonGroup b=new ButtonGroup();
								b.add(rdbtnVeg);
								b.add(rdbtnNonVeg);
								ButtonGroup b1=new ButtonGroup();
								b1.add(rdbtnContinental);
								b1.add(rdbtnMaharastrian);
								b1.add(rdbtnNorthIndian);

								JButton btnConfirmFood = new JButton("Confirm Food");
								btnConfirmFood.setBounds(319, 120, 157, 25);
								frame2.getContentPane().add(btnConfirmFood);
								JButton btnConfirmCake = new JButton("Confirm Cake");
								btnConfirmCake.setBounds(319, 193, 157, 25);
								frame2.getContentPane().add(btnConfirmCake);

								JButton btnMusic = new JButton("Music");
								btnMusic.setBounds(25, 267, 117, 25);
								frame2.getContentPane().add(btnMusic);

								JButton btnPhotography = new JButton("Photography");
								btnPhotography.setBounds(163, 267, 141, 25);
								frame2.getContentPane().add(btnPhotography);

								JButton Decoration = new JButton("Decoration");
								Decoration.setBounds(319, 267, 157, 25);
								frame2.getContentPane().add(Decoration);

								JButton next_1 = new JButton("Next");
								next_1.setBounds(187, 339, 117, 25);
								frame2.getContentPane().add(next_1);
								btnConfirmFood.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										try
										{

											PreparedStatement pstmt1=null;
											Connection conn1=null;
											String strk= null,str1 = null,str2,str3,str4,str5,str6,str7,str8,str9;
											Class.forName(JDBC_DRIVER);
											conn1=DriverManager.getConnection(DB_URL,USER,PASSWORD);
											if(rdbtnFood.isSelected())
											{

												if(rdbtnVeg.isSelected())
												{
													strk="Food,";
													sel=rdbtnVeg;
													strk+=sel.getText();
													strk+=",";
													if(rdbtnNorthIndian.isSelected())
													{
														sel=rdbtnNorthIndian;
														strk+=sel.getText();
														System.out.println(strk);
													}
													else if(rdbtnMaharastrian.isSelected())
													{
														sel=rdbtnMaharastrian;
														strk+=sel.getText();
														System.out.println(strk);
													}
													else if(rdbtnContinental.isSelected())
													{
														sel=rdbtnContinental;
														strk+=sel.getText();
														System.out.println(strk);
													}
												}

												else 
												{
													strk="Food,";
													sel=rdbtnNonVeg;
													strk+=sel.getText();
													strk+=",";
													if(rdbtnNorthIndian.isSelected())
													{
														sel=rdbtnNorthIndian;
														strk+=sel.getText();
													}
													else if(rdbtnMaharastrian.isSelected())
													{
														sel=rdbtnMaharastrian;
														strk+=sel.getText();
													}
													else if(rdbtnContinental.isSelected())
													{
														sel=rdbtnContinental;
														strk+=sel.getText();
													}
												}


											}

											System.out.println(cn5);
											System.out.println(cn8);
											System.out.println(strk);
											int tfood=0;
											if(strk.equals("Food,Non-Veg,North Indian"))
											{
												tfood=cn5*nveg_ni;
											}
											else if(strk.equals("Food,Non-Veg,Maharastrian"))
											{
												tfood=cn5*nveg_mh;
											}
											else if(strk.equals("Food,Non-Veg,Continental"))
											{
												tfood=cn5*nveg_c;
											}
											else if(strk.equals("Food,VEG,North Indian"))
											{
												tfood=cn5*veg_ni;
											}
											else if(strk.equals("Food,VEG,Maharastrian"))
											{
												tfood=cn5*veg_mh;
											}
											else if(strk.equals("Food,VEG,Continental"))
											{
												tfood=cn5*veg_c;
											}

											pstmt1=conn1.prepareStatement("insert into event_service (event_id,ser_name,qut,totalcost,date_of_event) values (?,?,?,?,?);");
											pstmt1.setInt(1,cn8);
											pstmt1.setString(2,strk);
											pstmt1.setInt(3, cn5);
											pstmt1.setInt(4,tfood );
											pstmt1.setString(5, str);

											pstmt1.executeUpdate();
											pstmt1.close();
											conn1.close();

										}
										catch(ClassNotFoundException ce)
										{
											System.out.println("Cannot find driver");
											ce.printStackTrace();
										}
										catch(SQLException se){
											System.out.println("Error in SQL syntax");
											se.printStackTrace();
										} 
									}
								});

								btnConfirmCake.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										try
										{
											ButtonGroup b2=new ButtonGroup();
											b2.add(rdbtnEggless);
											b2.add(rdbtnWithEgg);
											PreparedStatement pstmt2=null;
											Connection conn2=null;
											String str2=null,str3,str4,str5,str6,str7,str8,str9;
											Class.forName(JDBC_DRIVER);
											conn2=DriverManager.getConnection(DB_URL,USER,PASSWORD);
											if(rdbtnCake.isSelected())
											{
												if(rdbtnEggless.isSelected())
												{
													str2="Cake,";
													sel=rdbtnEggless;
													str2+=sel.getText();
													str2+=",";
													System.out.println(str2);

												}
												else
												{
													str2="Cake,";
													sel=rdbtnWithEgg;
													str2+=sel.getText();
													str2+=",";
													System.out.println(str2);
												}
												str2+=txt_weight.getText();
												//str2+=",";
												System.out.println(str2);
												str3=txt_flavour.getText();
												int a=Integer.parseInt(str3);
												int tcake=0;
												pstmt2=conn2.prepareStatement("insert into event_service (event_id,ser_name,qut,totalcost,date_of_event) values (?,?,?,?,?);");
												pstmt2.setInt(1,cn8);
												pstmt2.setString(2,str2);
												pstmt2.setInt(3, a);
												tcake=cake*a;
												pstmt2.setInt(4,tcake );
												pstmt2.setString(5, str);

												pstmt2.executeUpdate();
												pstmt2.close();
												conn2.close();


											}
										}
										catch(ClassNotFoundException ce)
										{
											System.out.println("Cannot find driver");
											ce.printStackTrace();
										}
										catch(SQLException se){
											System.out.println("Error in SQL syntax");
											se.printStackTrace();
										} 

									}
								});


								btnMusic.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										try
										{
											PreparedStatement stmt=null;
											Connection conn4=null;
											Class.forName(JDBC_DRIVER);
											conn4=DriverManager.getConnection(DB_URL,USER,PASSWORD);
											stmt=conn4.prepareStatement("insert into event_service (event_id,ser_name,totalcost,date_of_event) values (?,?,?,?);");
											stmt.setInt(1,cn8);
											stmt.setString(2,"Music");
											stmt.setInt(3,10000);
											stmt.setString(4, str);

											stmt.executeUpdate();
											stmt.close();
											conn4.close();

										}
										catch(ClassNotFoundException ce)
										{
											System.out.println("Cannot find driver");
											ce.printStackTrace();
										}
										catch(SQLException se){
											System.out.println("Error in SQL syntax");
											se.printStackTrace();
										} 
									}
								});


								btnPhotography.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										try
										{
											PreparedStatement stmt=null;
											Connection conn4=null;
											Class.forName(JDBC_DRIVER);
											conn4=DriverManager.getConnection(DB_URL,USER,PASSWORD);
											stmt=conn4.prepareStatement("insert into event_service (event_id,ser_name,totalcost,date_of_event) values (?,?,?,?);");
											stmt.setInt(1,cn8);
											stmt.setString(2,"Photography");
											stmt.setInt(3,8000);
											stmt.setString(4, str);

											stmt.executeUpdate();
											stmt.close();
											conn4.close();

										}
										catch(ClassNotFoundException ce)
										{
											System.out.println("Cannot find driver");
											ce.printStackTrace();
										}
										catch(SQLException se){
											System.out.println("Error in SQL syntax");
											se.printStackTrace();
										} 
									}
								});
								Decoration.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										try
										{
											PreparedStatement stmt=null;
											Connection conn4=null;
											Class.forName(JDBC_DRIVER);
											conn4=DriverManager.getConnection(DB_URL,USER,PASSWORD);
											stmt=conn4.prepareStatement("insert into event_service (event_id,ser_name,totalcost,date_of_event) values (?,?,?,?);");
											stmt.setInt(1,cn8);
											stmt.setString(2,"Decoration");
											stmt.setInt(3,15000);
											stmt.setString(4, str);

											stmt.executeUpdate();
											stmt.close();
											conn4.close();

										}
										catch(ClassNotFoundException ce)
										{
											System.out.println("Cannot find driver");
											ce.printStackTrace();
										}
										catch(SQLException se){
											System.out.println("Error in SQL syntax");
											se.printStackTrace();
										} 
									}
								});


								next_1.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										frame4 = new JFrame();
										frame4.setBounds(100, 100, 450, 300);
										frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										frame4.getContentPane().setLayout(null);
										frame4.setVisible(true);

										JLabel lblBillingInformation = new JLabel("BILLING INFORMATION");
										lblBillingInformation.setBounds(147, 34, 211, 15);
										frame4.getContentPane().add(lblBillingInformation);

										JLabel lblTotalBill = new JLabel("Total Bill");
										lblTotalBill.setBounds(80, 61, 70, 15);
										frame4.getContentPane().add(lblTotalBill);

										total = new JTextField();
										total.setBounds(244, 61, 114, 19);
										frame4.getContentPane().add(total);
										total.setColumns(10);

										

										
										JLabel lblPaymentMode = new JLabel("Payment Mode");
										lblPaymentMode.setBounds(80, 151, 137, 15);
										frame4.getContentPane().add(lblPaymentMode);

										JRadioButton cash = new JRadioButton("Cash");
										cash.setBounds(244, 147, 149, 23);
										frame4.getContentPane().add(cash);

										JRadioButton rdbtnCheque = new JRadioButton("Cheque");
										rdbtnCheque.setBounds(244, 171, 149, 23);
										frame4.getContentPane().add(rdbtnCheque);

										JRadioButton rdbtnCardPayment = new JRadioButton("Card Payment");
										rdbtnCardPayment.setBounds(244, 198, 149, 23);
										frame4.getContentPane().add(rdbtnCardPayment);
										JButton btnConfirmEvent = new JButton("Confirm Event");
										btnConfirmEvent.setBounds(147, 229, 154, 25);
										frame4.getContentPane().add(btnConfirmEvent);


										ButtonGroup butt=new ButtonGroup();
										butt.add(cash);
										butt.add(rdbtnCheque);
										butt.add(rdbtnCardPayment);
										
										

										try
										{
											
											Statement stmt1=null;
											String query;
											Connection conn4=null;
											ResultSet rs=null;
											Class.forName(JDBC_DRIVER);
											conn4=DriverManager.getConnection(DB_URL,USER,PASSWORD);
											query="select event_id,sum(totalcost) from event_service group by event_id";
											stmt1=conn4.createStatement();
											rs=stmt1.executeQuery(query);
											while(rs.next())
											{
												int r=rs.getInt("event_id");
												
												if(r==cn8)
												{
													 totalcost=rs.getInt("sum(totalcost)");
													total.setText(String.valueOf(totalcost));
												}
											}
											
											
											stmt1.close();
											conn4.close();
											rs.close();
											
											
											
											

										}
										catch(ClassNotFoundException ce)
										{
											System.out.println("Cannot find driver");
											ce.printStackTrace();
										}
										catch(SQLException se){
											System.out.println("Error in SQL syntax");
											se.printStackTrace();
										} 
										
										btnConfirmEvent.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e)
											{
												try
												{
													if (cash.isSelected()) {
													    select = cash;
													    mode=select.getText();
													} else if (rdbtnCheque.isSelected()) {
														select = rdbtnCheque;
													    mode=select.getText();
													    } 
													else if (rdbtnCardPayment.isSelected())
													{
													    select =rdbtnCardPayment ;
													    mode=select.getText();
													}
													
													
													PreparedStatement stmt=null;
													Connection conn5=null;
													Class.forName(JDBC_DRIVER);
													conn5=DriverManager.getConnection(DB_URL,USER,PASSWORD);
													stmt=conn5.prepareStatement("insert into bill(total,payment_mode,event_id) values (?,?,?);");
													stmt.setInt(1,totalcost);
													
													
									
													stmt.setString(2,mode);
													stmt.setInt(3,cn8);
													stmt.executeUpdate();
													stmt.close();
													conn5.close();
												}
												catch(ClassNotFoundException ce)
												{
													System.out.println("Cannot find driver");
													ce.printStackTrace();
												}
												catch(SQLException se){
													System.out.println("Error in SQL syntax");
													se.printStackTrace();
												} 
											}
										});
									}
								});
							}


							catch(ClassNotFoundException ce)
							{
								System.out.println("Cannot find driver");
								ce.printStackTrace();
							}
							catch(SQLException se){
								System.out.println("Error in SQL syntax");
								//se.printStackTrace();
							} 



						}
					});

				}
				catch(ClassNotFoundException ce)
				{
					System.out.println("Cannot find driver");
					ce.printStackTrace();
				}
				catch(SQLException se){
					System.out.println("Error in SQL syntax");
					//se.printStackTrace();
				}



			}
		});
	}
}
