import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private Image image_logo = new ImageIcon(LoginFrame.class.getResource("res/banl.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image image_user = new ImageIcon(LoginFrame.class.getResource("res/businessman.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image image_homeico = new ImageIcon(LoginFrame.class.getResource("res/banl.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image image_pencil= new ImageIcon(LoginFrame.class.getResource("res/pencil.png")).getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
	private Image image_lock = new ImageIcon(LoginFrame.class.getResource("res/lockl.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_userl = new ImageIcon(LoginFrame.class.getResource("res/user1.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_email = new ImageIcon(LoginFrame.class.getResource("res/email.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtemail;
	private JPasswordField txtpassword;
	private static String USER_ID = "";
	private static  int SAVINGS_ACC_NUMBER = 0;
	private static  int CURRENT_ACOUNT_NUMBER = 0;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 746, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblX = new JLabel("X");
		LblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you want to cancel your acount application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					RegisterFrame.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				LblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LblX.setForeground(Color.WHITE);
			}
		});
		LblX.setHorizontalAlignment(SwingConstants.CENTER);
		LblX.setForeground(Color.WHITE);
		LblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		LblX.setBounds(716, 10, 20, 20);
		contentPane.add(LblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon(image_logo));
		lblIconLogo.setBounds(238, 10, 238, 99);
		contentPane.add(lblIconLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(93, 144, 275, 40);
		contentPane.add(panel_1);
		
		txtfirstname = new JTextField();
		txtfirstname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtfirstname.getText().equals("First Name")) {
					txtfirstname.setText("");
				}else {
					txtfirstname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtfirstname.getText().equals(""))
					txtfirstname.setText("First Name");
			}
		});
		txtfirstname.setText("First Name");
		txtfirstname.setFont(new Font("Arial", Font.PLAIN, 12));
		txtfirstname.setColumns(10);
		txtfirstname.setBorder(null);
		txtfirstname.setBounds(10, 10, 198, 20);
		panel_1.add(txtfirstname);
		
		JLabel lbliconfirstname = new JLabel("");
		lbliconfirstname.setIcon(new ImageIcon(image_userl));
		lbliconfirstname.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconfirstname.setBounds(230, 0, 45, 40);
		panel_1.add(lbliconfirstname);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(378, 144, 275, 40);
		contentPane.add(panel_1_1);
		
		txtlastname = new JTextField();
		txtlastname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtlastname.getText().equals("Last Name")) {
					txtlastname.setText("");
				}else {
					txtlastname.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtlastname.getText().equals(""))
					txtlastname.setText("Last Name");
			}
		});
		txtlastname.setText("Last Name");
		txtlastname.setFont(new Font("Arial", Font.PLAIN, 12));
		txtlastname.setColumns(10);
		txtlastname.setBorder(null);
		txtlastname.setBounds(10, 10, 198, 20);
		panel_1_1.add(txtlastname);
		
		JLabel lbliconlastname = new JLabel("");
		lbliconlastname.setIcon(new ImageIcon(image_userl));
		lbliconlastname.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconlastname.setBounds(230, 0, 45, 40);
		panel_1_1.add(lbliconlastname);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(93, 204, 560, 40);
		contentPane.add(panel_1_2);
		
		txtemail = new JTextField();
		txtemail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtemail.getText().equals("Email")) {
					txtemail.setText("");
				}else {
					txtemail.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtemail.getText().equals(""))
					txtemail.setText("Email");
			}
		});
		txtemail.setText("Email");
		txtemail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtemail.setColumns(10);
		txtemail.setBorder(null);
		txtemail.setBounds(10, 10, 480, 20);
		panel_1_2.add(txtemail);
		
		JLabel lnliconemail = new JLabel("");
		lnliconemail.setIcon(new ImageIcon(image_email));
		lnliconemail.setHorizontalAlignment(SwingConstants.CENTER);
		lnliconemail.setBounds(515, 0, 45, 40);
		panel_1_2.add(lnliconemail);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(93, 254, 275, 40);
		contentPane.add(panel_1_1_1);
		
		txtpassword = new JPasswordField();
		txtpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtpassword.getText().equals("Password")) {
					txtpassword.setEchoChar('●');
					txtpassword.setText("");
				}else {
					txtpassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtpassword.getText().equals(""))
					txtpassword.setText("Password");
			    	txtpassword.setEchoChar('●');
					
			}
		});
		txtpassword.setText("Password");
		txtpassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpassword.setEchoChar(' ');
		txtpassword.setBorder(null);
		txtpassword.setBounds(10, 10, 201, 20);
		panel_1_1_1.add(txtpassword);
		
		JLabel lblconpassword = new JLabel("");
		lblconpassword.setIcon(new ImageIcon(image_lock));
		lblconpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblconpassword.setBounds(230, 0, 45, 40);
		panel_1_1_1.add(lblconpassword);
		
		JPanel pnlBtnRegister = new JPanel();
		pnlBtnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String alpha = getAlphaNumericString(10);
			//	System.out.println(alpha);
				CreateUserAcount();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnRegister.setBackground(new Color(100, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnRegister.setBackground(new Color(139, 0, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnRegister.setBackground(new Color(100, 0, 0));
			}
			public void mouseReleased(MouseEvent e) {
				pnlBtnRegister.setBackground(new Color(139, 0, 0));
			}
		});
		pnlBtnRegister.setLayout(null);
		pnlBtnRegister.setBackground(new Color(139, 0, 0));
		pnlBtnRegister.setBounds(267, 357, 275, 50);
		contentPane.add(pnlBtnRegister);
		
		JLabel lblCreatecount = new JLabel("CREATE ACOUNT");
		lblCreatecount.setVerifyInputWhenFocusTarget(false);
		lblCreatecount.setForeground(Color.WHITE);
		lblCreatecount.setFont(new Font("Arial", Font.BOLD, 14));
		lblCreatecount.setBounds(105, 10, 137, 30);
		pnlBtnRegister.add(lblCreatecount);
		
		JLabel lblbtnKeylogin = new JLabel("");
		lblbtnKeylogin.setIcon(new ImageIcon(image_pencil));
		lblbtnKeylogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblbtnKeylogin.setBounds(51, 1, 50, 50);
		pnlBtnRegister.add(lblbtnKeylogin);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account ? sign in.");
		lblAlreadyHaveAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				RegisterFrame.this.dispose(); 
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAlreadyHaveAn.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAlreadyHaveAn.setForeground(Color.WHITE);
			}
		});
		lblAlreadyHaveAn.setForeground(Color.WHITE);
		lblAlreadyHaveAn.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAlreadyHaveAn.setBounds(93, 318, 275, 13);
		contentPane.add(lblAlreadyHaveAn);
	}
	
	private void CreateUserAcount() {
		String first_name = txtfirstname.getText();
		String last_name = txtlastname.getText();
		String email = txtemail.getText();
		String password = txtpassword.getText();

	    String path  = "Customer.txt";
	    USER_ID = getAlphaNumericString(10);
		String userdata = USER_ID + " "+ first_name + " " + last_name  + " " + email + " " + password;
		
		System.out.println(path);
		
		writeTextCustomer(path, userdata);
       
	}
	
	private void CreateUserCurrent(String user_id) {
		String path  = "Account.txt";
		String acc_id = getAlphaNumericString(10);
		SAVINGS_ACC_NUMBER = generateAcountNumber();
		String accdata = acc_id  + " "+ SAVINGS_ACC_NUMBER + " " + 1 + " " + 0  + " " + 0 + " " + user_id;
		
		writeTextCurrent(path, accdata);
		
	}
	
	private void CreateUserSaving(String user_id) {
		String path  = "Account.txt";
		String acc_id = getAlphaNumericString(10);
		SAVINGS_ACC_NUMBER = generateAcountNumber();
		String accdata = acc_id  + " "+ SAVINGS_ACC_NUMBER + " " + 0 + " " + 500  + " " + 500 + " " + user_id;
		
		writeTextSavings(path, accdata);	
		
		LoginFrame loginframe = new LoginFrame();
		loginframe.readcustomerList();
		loginframe.setVisible(true);
		RegisterFrame.this.dispose(); 
	}
	
	private int generateAcountNumber() {
		  Random rand = new Random();
	      System.out.println("Random numbers...");
	      int resRandom = rand.nextInt((999999999 - 100) + 1) + 10;
	      System.out.println(resRandom);
	      
	      return resRandom;
	}
	
	static String getAlphaNumericString(int n)
	{
	  // choose a Character random from this String
	  String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	         + "0123456789"
	         + "abcdefghijklmnopqrstuvxyz";
	 
	  // create StringBuffer size of AlphaNumericString
	  StringBuilder sb = new StringBuilder(n);
	 
	  for (int i = 0; i < n; i++) {
	 
	   // generate a random number between
	   // 0 to AlphaNumericString variable length
	   int index = (int)(AlphaNumericString.length()
	      * Math.random());
	 
	    // add Character one by one in end of sb
	    sb.append(AlphaNumericString
	      .charAt(index));
	    }
	 
	  return sb.toString();
	 }
	
	public void writeTextCustomer(String path,String data) {
	    BufferedWriter bw = null;
	    try {
	        FileWriter fw = new FileWriter(path,true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	        bw.newLine();
	        System.out.println("done");
	        System.out.println(data);
	        CreateUserCurrent(USER_ID);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        if( bw != null ) {
	            try {
	                bw.close();
	            } catch (IOException e) {
	                // ignore
	            }
	        }
	    }
	}
	
	public void writeTextSavings(String path,String data) {
	    BufferedWriter bw = null;
	    try {
	        FileWriter fw = new FileWriter(path,true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	        bw.newLine();
	        System.out.println("done");
	        System.out.println(data);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        if( bw != null ) {
	            try {
	                bw.close();
	            } catch (IOException e) {
	                // ignore
	            }
	        }
	    }
	}
	
	public void writeTextCurrent(String path,String data) {
	    BufferedWriter bw = null;
	    try {
	        FileWriter fw = new FileWriter(path,true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	        bw.newLine();
	        System.out.println("done");
	        System.out.println(data);
	        CreateUserSaving(USER_ID);
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        if( bw != null ) {
	            try {
	                bw.close();
	            } catch (IOException e) {
	                // ignore
	            }
	        }
	    }
	}

	
}
