import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.AcountTypeEnum;
import model.Acounts;
import model.Customer;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class LoginFrame extends JFrame {
	
	private Image image_logo = new ImageIcon(LoginFrame.class.getResource("res/banl.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image image_user = new ImageIcon(LoginFrame.class.getResource("res/businessman.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image image_homeico = new ImageIcon(LoginFrame.class.getResource("res/banl.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image image_key= new ImageIcon(LoginFrame.class.getResource("res/key.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_lock = new ImageIcon(LoginFrame.class.getResource("res/lockl.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_userl = new ImageIcon(LoginFrame.class.getResource("res/user1.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JLabel lblloginmessage;
	
	private static List<Customer> customerslist = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					readcustomerList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(160, 137, 275, 40);
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtusername = new JTextField();
		txtusername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtusername.getText().equals("email")) {
					txtusername.setText("");
				}else {
					txtusername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtusername.getText().equals(""))
					txtusername.setText("email");
			}
		});
		txtusername.setBorder(null);
		txtusername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtusername.setText("email");
		txtusername.setBounds(10, 10, 198, 20);
		panel_1.add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblconusername = new JLabel("");
		lblconusername.setHorizontalAlignment(SwingConstants.CENTER);
		lblconusername.setBounds(230, 0, 45, 40);
		lblconusername.setIcon(new ImageIcon(image_userl));
		panel_1.add(lblconusername);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(160, 187, 275, 40);
		panel_1_1.setBackground(Color.WHITE);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		txtpassword = new JPasswordField();
		txtpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtpassword.getText().equals("password")) {
					txtpassword.setEchoChar('●');
					txtpassword.setText("");
				}else {
					txtpassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtpassword.getText().equals(""))
					txtpassword.setText("password");
			    	txtpassword.setEchoChar('●');
					
			}
		});
		txtpassword.setBorder(null);
		txtpassword.setEchoChar((char)0);
		txtpassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpassword.setText("password");
		txtpassword.setBounds(10, 10, 201, 20);
		panel_1_1.add(txtpassword);
		
		JLabel lblconpassword = new JLabel("");
		lblconpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblconpassword.setBounds(230, 0, 45, 40);
		lblconpassword.setIcon(new ImageIcon(image_lock));
		panel_1_1.add(lblconpassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customerslist.clear();;
				readcustomerList();
				
				boolean isuerfound = false;
				String username  = txtusername.getText();
				String password = txtpassword.getText();
				Customer cus = new Customer();
				
				for (Customer customer : customerslist) {
					if(customer.getEmail_acount().equals(username)) {
						if(customer.getPassword().equals(password)) {
							cus = customer;
							isuerfound = true;
						}
					}
				}
			
				
				
				if(isuerfound) {
						lblloginmessage.setText("");
						JOptionPane.showMessageDialog(null, "Login Successful");
						DashboardFrame dashboard = new DashboardFrame(cus);
						dashboard.setVisible(true);
						dispose();
					
				}else if(txtusername.getText().equals("") ||txtusername.getText().equals("username") ||  txtpassword.getText().equals("") ||  txtpassword.getText().equals("password")) {
					lblloginmessage.setText("Please input all required fields!");
				}else {
					lblloginmessage.setText("Username and password did'nt match!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(100, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(139, 0, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(100, 0, 0));
			}
			public void mouseReleased(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(139, 0, 0));
			}
		});
		pnlBtnLogin.setBounds(160, 297, 275, 50);
		pnlBtnLogin.setBackground(new Color(139, 0, 0));
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setBounds(111, 10, 102, 30);
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lblbtnKeylogin = new JLabel("");
		lblbtnKeylogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblbtnKeylogin.setBounds(51, 1, 50, 50);
		lblbtnKeylogin.setIcon(new ImageIcon(image_key));
		pnlBtnLogin.add(lblbtnKeylogin);
		
		JLabel LblX = new JLabel("X");
		LblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you wamt to close this application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					LoginFrame.this.dispose();
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
		
		LblX.setForeground(new Color(255, 255, 255));
		LblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		LblX.setHorizontalAlignment(SwingConstants.CENTER);
		LblX.setBounds(570, 10, 20, 20);
		contentPane.add(LblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(160, 10, 275, 117);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(image_logo));
		
		lblloginmessage = new JLabel("");
		lblloginmessage.setForeground(new Color(255, 218, 185));
		lblloginmessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblloginmessage.setBounds(160, 274, 275, 13);
		contentPane.add(lblloginmessage);
		
		JLabel lblcreateacount = new JLabel("Dont have an account ? create one.");
		lblcreateacount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterFrame registerFrame = new RegisterFrame();
				registerFrame.setVisible(true);
				LoginFrame.this.dispose(); 
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblcreateacount.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblcreateacount.setForeground(Color.WHITE);
			}
		});
		lblcreateacount.setForeground(new Color(255, 255, 255));
		lblcreateacount.setFont(new Font("Arial", Font.PLAIN, 14));
		lblcreateacount.setBounds(160, 237, 275, 13);
		contentPane.add(lblcreateacount);
		setLocationRelativeTo(null);
		
	}
	
	public static void readcustomerList() {
		 // File path is passed as parameter
        File file = new File("Customer.txt");
        // Note:  Double backquote is to avoid compiler
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
		      String st;
		        while ((st = br.readLine()) != null){
		            System.out.println(st);
		            StringTokenizer token = new StringTokenizer(st);
		            String user_id = token.nextToken();
		            String firstname = token.nextToken();
		            String lastname = token.nextToken();
		            String email = token.nextToken();
		            String password = token.nextToken();
		            
		            Customer cus = new Customer(user_id,firstname,lastname,email,password);
		            customerslist.add(cus);
		        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Declaring a string variable
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	}
	

}
