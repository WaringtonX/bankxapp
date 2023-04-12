import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.Color;
import javax.swing.SwingConstants;

import model.Acounts;
import model.Customer;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PanelTransfers extends JPanel implements ActionListener {

	private static  Customer customer = new Customer();
	private String[] acounts,nexts;
	private static Acounts current_acount = new Acounts();
	private static Acounts savings_acount = new Acounts();
	private static JLabel lblrightavail;
	private static JLabel lblrightbalance;
	private static JLabel lblleftavail;
	private static JLabel lblleftbalance;
	private static JComboBox comboTo;
	private static JComboBox combofrom;
	private JPanel panel_3;
	private JTextField txtAmount;
	
	private Image image_coin = new ImageIcon(PanelTransfers.class.getResource("res/coins.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private JPanel pnlBtnLogin;
	private JLabel lblNewLabel;
	private JLabel lblapology;
	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public PanelTransfers(Customer cust,Acounts savings,Acounts current) {
		setBackground(new Color(165, 42, 42));
		setBounds(0,0,669, 476);
		setLayout(null);
		
		customer = cust;
		current_acount = current;
		savings_acount = savings;
		//System.out.print("savaings : " + savings_acount.getAcount_id() +  " Current acount : " + current_acount.getAcount_id());
		nexts = new String[] {"Savings Account (" + savings_acount.getAcount_number() +")","Current Account (" + current_acount.getAcount_number() +")"};
		acounts = new String[] {"Savings Account (" + savings_acount.getAcount_number() +")","Current Account (" + current_acount.getAcount_number() +")"};
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(44, 69, 287, 172);
		add(panel);
		panel.setLayout(null);
		
	    combofrom = new JComboBox(acounts);
	    combofrom.setSelectedIndex(0);
	    combofrom.addActionListener(this);
		combofrom.setBackground(new Color(255, 255, 255));
		combofrom.setBounds(10, 50, 268, 42);
		panel.add(combofrom);
		
		JLabel lblfrom = new JLabel("From");
		lblfrom.setFont(new Font("Arial", Font.BOLD, 14));
		lblfrom.setHorizontalAlignment(SwingConstants.LEFT);
		lblfrom.setForeground(new Color(255, 255, 255));
		lblfrom.setBounds(10, 10, 268, 30);
		panel.add(lblfrom);
		
		lblleftavail = new JLabel("Avialable : R"+ savings_acount.getAvialable());
		lblleftavail.setFont(new Font("Arial", Font.BOLD, 12));
		lblleftavail.setForeground(new Color(255, 255, 255));
		lblleftavail.setBounds(10, 102, 268, 23);
		panel.add(lblleftavail);
		
		lblleftbalance = new JLabel("Balance : R" + savings_acount.getBalance());
		lblleftbalance.setForeground(Color.WHITE);
		lblleftbalance.setFont(new Font("Arial", Font.BOLD, 12));
		lblleftbalance.setBounds(10, 123, 268, 27);
		panel.add(lblleftbalance);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(165, 42, 42));
		panel_1.setBounds(329, 69, 296, 172);
		add(panel_1);
		
	    comboTo = new JComboBox(nexts);
		comboTo.setSelectedIndex(1);
		comboTo.addActionListener(this);
		comboTo.setBackground(Color.WHITE);
		comboTo.setBounds(10, 50, 268, 42);
		panel_1.add(comboTo);
		
		
		JLabel lblTop = new JLabel("Top");
		lblTop.setHorizontalAlignment(SwingConstants.LEFT);
		lblTop.setForeground(Color.WHITE);
		lblTop.setFont(new Font("Arial", Font.BOLD, 14));
		lblTop.setBounds(10, 10, 268, 30);
		panel_1.add(lblTop);
		
		lblrightavail = new JLabel("Avialable : R" + current_acount.getAvialable());
		lblrightavail.setForeground(Color.WHITE);
		lblrightavail.setFont(new Font("Arial", Font.BOLD, 12));
		lblrightavail.setBounds(10, 102, 268, 23);
		panel_1.add(lblrightavail);
		
		lblrightbalance = new JLabel("Balance : R" + current_acount.getBalance());
		lblrightbalance.setForeground(Color.WHITE);
		lblrightbalance.setFont(new Font("Arial", Font.BOLD, 12));
		lblrightbalance.setBounds(10, 123, 268, 27);
		panel_1.add(lblrightbalance);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(165, 42, 42));
		panel_2.setBounds(44, 256, 581, 172);
		add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 10, 268, 43);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		txtAmount = new JTextField();
		txtAmount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAmount.getText().equals("Amount")) {
					txtAmount.setText("");
				}else {
					txtAmount.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAmount.getText().equals(""))
					txtAmount.setText("Amount");
			}
		});
		txtAmount.setBorder(null);
		txtAmount.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAmount.setText("Amount");
		txtAmount.setBounds(57, 10, 201, 23);
		panel_3.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblamounticon = new JLabel("");
		lblamounticon.setIcon(new ImageIcon(image_coin));
		lblamounticon.setHorizontalAlignment(SwingConstants.CENTER);
		lblamounticon.setBounds(0, 0, 47, 43);
		panel_3.add(lblamounticon);
		
		pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblapology.setText("I 'am sorry i didnt have enough time , to complete this!");
				
				if(combofrom.getSelectedIndex() == 0) {
					System.out.println("Proccess from savings to current Started");
					double transferamount = Double.parseDouble(txtAmount.getText());
					
				    double savingAvial  = savings_acount.getAvialable() - transferamount;
				    double savingBalance  = savings_acount.getBalance() - transferamount;
				    
				    double currentAvial = current_acount.getAvialable() + transferamount;
				    double currentBalance = current_acount.getBalance() + transferamount;
				   
				    String savingsaccount = savings_acount.getAcount_id()  + " "+ savings_acount.getAcount_number() + " " + savings_acount.getAcount_type() + " " + savingAvial  + " " + savingBalance + " " + savings_acount.getUser_id();
				    String currentacount =  current_acount.getAcount_id()  + " "+ current_acount.getAcount_number() + " " + current_acount.getAcount_type() + " " + currentAvial  + " " + currentBalance + " " + current_acount.getUser_id();
					
				    replaceSelected(savings_acount.getAcount_id(),savingsaccount,current_acount.getAcount_id(),currentacount);
				    
				    String trans_id = getAlphaNumericString(10);
				    String date = new Date().toLocaleString();
				    String description = "BannkX Transfer to Current Acount " +  current_acount.getAcount_id();
				    String TransferString = trans_id + " " + date + " " + transferamount + " " + savingAvial + " 0 " + savings_acount.getAcount_id() + " " + customer.getUser_id() +  " " + description;
				    WriteTextTransfer("Transactions.txt", TransferString);
				 }else if(combofrom.getSelectedIndex() == 1) {
					 System.out.println("Proccess from current to savings Started");
					 double transferamount = Double.parseDouble(txtAmount.getText());
					 
					 double  currentAvial= current_acount.getAvialable() - transferamount;
					 double  currentBalance = current_acount.getBalance() - transferamount; 
					 
					 double savingAvial = savings_acount.getAvialable() + transferamount;
					 double savingBalance = savings_acount.getBalance() + transferamount;
					 
					 String savingsaccount = savings_acount.getAcount_id()  + " "+ savings_acount.getAcount_number() + " " + savings_acount.getAcount_type() + " " + savingAvial  + " " + savingBalance + " " + savings_acount.getUser_id();
					 String currentacount =  current_acount.getAcount_id()  + " "+ current_acount.getAcount_number() + " " + current_acount.getAcount_type() + " " + currentAvial  + " " + currentBalance + " " + current_acount.getUser_id();
						
					 replaceSelected(savings_acount.getAcount_id(),savingsaccount,current_acount.getAcount_id(),currentacount);
					 
					   String trans_id = getAlphaNumericString(10);
					    String date = new Date().toLocaleString();
					    String description = "BannkX Transfer to Savings Acount " +  savings_acount.getAcount_id();
					    String TransferString = trans_id + " " + date + " " + transferamount + " " + savingAvial + " 0 " + savings_acount.getAcount_id() + " " + customer.getUser_id() +  " " + description;
					    WriteTextTransfer("Transactions.txt", TransferString);
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
		pnlBtnLogin.setLayout(null);
		pnlBtnLogin.setBackground(new Color(139, 0, 0));
		pnlBtnLogin.setBounds(10, 97, 275, 50);
		panel_2.add(pnlBtnLogin);
		
		lblNewLabel = new JLabel("TRANSFER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 10, 275, 30);
		pnlBtnLogin.add(lblNewLabel);
		
		lblapology = new JLabel("");
		lblapology.setForeground(new Color(240, 230, 140));
		lblapology.setFont(new Font("Arial", Font.PLAIN, 14));
		lblapology.setBounds(10, 63, 551, 30);
		panel_2.add(lblapology);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == combofrom ) {
			int indexfrom = combofrom.getSelectedIndex();
			System.out.println("from : " + indexfrom);
					
			if(indexfrom == 0) {
				comboTo.setSelectedIndex(1);
				lblleftavail.setText("Avialable : R"+ savings_acount.getAvialable());
				lblleftbalance.setText("Balance : R" + savings_acount.getBalance());
				lblrightavail.setText("Avialable : R" + current_acount.getAvialable());
				lblrightbalance.setText("Balance : R" + current_acount.getBalance());
			}else if(indexfrom == 1) {
				lblleftavail.setText("Avialable : R"+ current_acount.getAvialable());
				lblleftbalance.setText("Balance : R" + current_acount.getBalance());
				lblrightavail.setText("Avialable : R" + savings_acount.getAvialable());
				lblrightbalance.setText("Balance : R" + savings_acount.getBalance());
		     	comboTo.setSelectedIndex(0);				
			}
		}
		
		if(e.getSource() == comboTo) {
			int indexto = comboTo.getSelectedIndex();
			System.out.println("to : " + indexto);			
			if(indexto == 0) {
				combofrom.setSelectedIndex(1);
			}else if(indexto == 1) {
				combofrom.setSelectedIndex(0);
			}
			
		//	int index = comboTo.getSelectedIndex();
			/*ifif(index == 0) {
						
				lblleftavail.setText("Avialable : R"+ savings_acount.getAvialable());
				lblleftbalance.setText("Balance : R" + savings_acount.getBalance());
				lblrightavail.setText("Avialable : R" + current_acount.getAvialable());
				lblrightbalance.setText("Balance : R" + current_acount.getBalance());
				combofrom.setSelectedIndex(1);
				
			}else if (index == 1) {
				lblrightavail.setText("Avialable : R"+ savings_acount.getAvialable());
				lblrightbalance.setText("Balance : R" + savings_acount.getBalance());
				lblleftavail.setText("Avialable : R" + current_acount.getAvialable());
				lblleftbalance.setText("Balance : R" + current_acount.getBalance());
				
				combofrom.setSelectedIndex(0);
			}*/
		}
	}
	
	public static void replaceSelected(String oldline, String newline,String oldlinec, String newlinec) {
		 try {
		        // input the (modified) file content to the StringBuffer "input"
		        BufferedReader file = new BufferedReader(new FileReader("Account.txt"));
		        StringBuffer inputBuffer = new StringBuffer();
		        String line;

		        System.out.println("Savings acount id = " + oldline + " Replace with =" +newline );
		        System.out.println("Current acount id = " + oldlinec + " Replace with =" +newlinec); 
		        while ((line = file.readLine()) != null) {
		             // replace the line here
		        	StringTokenizer token = new StringTokenizer(line);
		        	String acountId = token.nextToken();

		            if(acountId.equals(oldline)) {
		            	 System.out.println("Savings account found!");
			            inputBuffer.append(newline);
			            inputBuffer.append('\n');
		            }else if (acountId.equals(oldlinec)) {
		            	 System.out.println("Current acount found!");
		            	 inputBuffer.append(newlinec);
				         inputBuffer.append('\n');
		            }else {
		            	 inputBuffer.append(line);
				         inputBuffer.append('\n');
		            }
		        }
		        	        
		        file.close();

		        // write the new string with the replaced line OVER the same file
		        FileOutputStream fileOut = new FileOutputStream("Account.txt");
		        fileOut.write(inputBuffer.toString().getBytes());
		        fileOut.close();
		        
		        System.out.println("Data updated!");
		        updateUseracount(customer.getUser_id());

		    } catch (Exception e) {
		        System.out.println("Problem reading file.");
		    }
	}
	
	private static void updateUseracount(String userid) {
		 // File path is passed as parameter
   File file = new File("Account.txt");
   // Note:  Double backquote is to avoid compiler
   BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
		      String st;
		        while ((st = br.readLine()) != null){
		            System.out.println(st);
		            StringTokenizer token = new StringTokenizer(st);
		            String acount_id = token.nextToken();
		            int acount_number = Integer.parseInt(token.nextToken());
		            int accounttype = Integer.parseInt(token.nextToken());
		            double avialable = Double.parseDouble(token.nextToken());
		            double balance =  Double.parseDouble(token.nextToken());
		            String user_id = token.nextToken();
		              
		            Acounts acou = new Acounts(acount_id,acount_number,accounttype,avialable,balance,user_id);
		            
                   if(user_id.equals(userid)) {
		            	if(accounttype == 0) {
		            	   savings_acount = acou;
		            	}else if(accounttype == 1) {
		            		current_acount = acou;
		            	}
		            }
		            
		        }
		        
		        updateTransactiondata();
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
	
	private static void updateTransactiondata() {
		int indexfrom = combofrom.getSelectedIndex();
		if(indexfrom == 0) {
			comboTo.setSelectedIndex(1);
			lblleftavail.setText("Avialable : R"+ savings_acount.getAvialable());
			lblleftbalance.setText("Balance : R" + savings_acount.getBalance());
			lblrightavail.setText("Avialable : R" + current_acount.getAvialable());
			lblrightbalance.setText("Balance : R" + current_acount.getBalance());
		}else if(indexfrom == 1) {
			lblleftavail.setText("Avialable : R"+ current_acount.getAvialable());
			lblleftbalance.setText("Balance : R" + current_acount.getBalance());
			lblrightavail.setText("Avialable : R" + savings_acount.getAvialable());
			lblrightbalance.setText("Balance : R" + savings_acount.getBalance());
	     	comboTo.setSelectedIndex(0);				
		}
	}
	
	public void WriteTextTransfer(String path,String data) {
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
}
