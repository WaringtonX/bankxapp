import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Acounts;
import model.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DashboardFrame extends JFrame {

	private JPanel panelMenu;
	private Image image_logo = new ImageIcon(DashboardFrame.class.getResource("res/banl.png")).getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
	private Image image_account = new ImageIcon(DashboardFrame.class.getResource("res/account.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_transfers = new ImageIcon(DashboardFrame.class.getResource("res/transfer.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_transactions = new ImageIcon(DashboardFrame.class.getResource("res/transaction.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_messages = new ImageIcon(DashboardFrame.class.getResource("res/messages.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private Image image_logout = new ImageIcon(DashboardFrame.class.getResource("res/shutdown.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	
	private PanelAccount panelaccount;
	private PanelTransfers paneltransfers;
	private PanelTransaction paneltransaction;
	private PanelMessages panelmessages;
	
	private static  Customer customer = new Customer();
	private static List<Acounts> acounts = new ArrayList<>();
	private static Acounts current_acount = new Acounts();
	private static Acounts savings_acount = new Acounts();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFrame frame = new DashboardFrame(customer);
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
	public DashboardFrame(Customer cust) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 521);
		panelMenu = new JPanel();
		panelMenu.setAutoscrolls(true);
		panelMenu.setBackground(new Color(165, 42, 42));
		setUndecorated(true);
		setLocationRelativeTo(null);;
		panelMenu.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelMenu);
		panelMenu.setLayout(null);
		
		customer = cust;
		readAccountList(customer.getUser_id());
		
		System.out.println("user_id = " + customer.getUser_id());
		
		//System.out.println("Main Panel  : "  + current_acount.getAcount_number() +" " + current_acount.getAvialable());
		//System.out.println("Main Panel  : "  +  savings_acount.getAcount_number() +" " + savings_acount.getAvialable());
		
		panelaccount = new PanelAccount(customer,savings_acount,current_acount);
		paneltransfers = new PanelTransfers(customer,savings_acount,current_acount);
		paneltransaction = new PanelTransaction();
		panelmessages = new PanelMessages();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 216, 521);
		panelMenu.add(panel);
		panel.setLayout(null);
		
		JLabel lblconlogo = new JLabel("");
		lblconlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblconlogo.setIcon(new ImageIcon(image_logo));
		lblconlogo.setBounds(10, 40, 196, 132);
		panel.add(lblconlogo);
		
		JPanel panelHome = new JPanel();
		panelHome.addMouseListener(new PanelButtonMouseAdapter(panelHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelaccount.updateUseracount(customer.getUser_id());
				menuClicked(panelaccount);
			}
		});
		panelHome.setBackground(new Color(139, 0, 0));
		panelHome.setBounds(0, 206, 216, 36);
		panel.add(panelHome);
		panelHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCOUNTS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 10, 144, 16);
		panelHome.add(lblNewLabel);
		
		JLabel lbliconaccount = new JLabel("");
		lbliconaccount.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconaccount.setIcon(new ImageIcon(image_account));
		lbliconaccount.setBounds(7, 0, 45, 36);
		panelHome.add(lbliconaccount);
		
		JPanel panelTrsansactions = new JPanel();
		panelTrsansactions.addMouseListener(new PanelButtonMouseAdapter(panelTrsansactions) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneltransaction);
			}
		});
		panelTrsansactions.setBackground(new Color(139, 0, 0));
		panelTrsansactions.setLayout(null);
		panelTrsansactions.setBounds(0, 276, 216, 36);
		panel.add(panelTrsansactions);
		
		JLabel lblTransactions = new JLabel("TRANSACTIONS");
		lblTransactions.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransactions.setForeground(Color.WHITE);
		lblTransactions.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTransactions.setBounds(62, 10, 144, 16);
		panelTrsansactions.add(lblTransactions);
		
		JLabel lblicontransactions = new JLabel("");
		lblicontransactions.setHorizontalAlignment(SwingConstants.CENTER);
		lblicontransactions.setIcon(new ImageIcon(image_transactions));
		lblicontransactions.setBounds(7, 0, 45, 36);
		panelTrsansactions.add(lblicontransactions);
		
		JPanel panelTransfers = new JPanel();
		panelTransfers.addMouseListener(new PanelButtonMouseAdapter(panelTransfers){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneltransfers);
			}
		});
		panelTransfers.setBackground(new Color(139, 0, 0));
		panelTransfers.setLayout(null);
		panelTransfers.setBounds(0, 242, 216, 36);
		panel.add(panelTransfers);
		
		JLabel lblTransfers = new JLabel("TRANSFERS");
		lblTransfers.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransfers.setForeground(Color.WHITE);
		lblTransfers.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTransfers.setBounds(62, 10, 144, 16);
		panelTransfers.add(lblTransfers);
		
		JLabel lblicontransfer = new JLabel("");
		lblicontransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblicontransfer.setIcon(new ImageIcon(image_transfers));
		lblicontransfer.setBounds(7, 0, 45, 36);
		panelTransfers.add(lblicontransfer);
		
		JPanel panelMessages = new JPanel();
		panelMessages.addMouseListener(new PanelButtonMouseAdapter(panelMessages){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelmessages);
			}
		});
		panelMessages.setBackground(new Color(139, 0, 0));
		panelMessages.setLayout(null);
		panelMessages.setBounds(0, 310, 216, 36);
		panel.add(panelMessages);
		
		JLabel lblMessages = new JLabel("MESSAGES");
		lblMessages.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessages.setForeground(Color.WHITE);
		lblMessages.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMessages.setBounds(62, 10, 144, 16);
		panelMessages.add(lblMessages);
		
		JLabel lbliconmessage = new JLabel("");
		lbliconmessage.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconmessage.setIcon(new ImageIcon(image_messages));
		lbliconmessage.setBounds(10, 0, 45, 36);
		panelMessages.add(lbliconmessage);
		
		JPanel panelSignout = new JPanel();
		panelSignout.addMouseListener(new PanelButtonMouseAdapter(panelSignout){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out?") == 0) {
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.setVisible(true);
					DashboardFrame.this.dispose();
				}
			}
		});
		panelSignout.setLayout(null);
		panelSignout.setBackground(new Color(139, 0, 0));
		panelSignout.setBounds(0, 345, 216, 36);
		panel.add(panelSignout);
		
		JLabel lblSignout = new JLabel("SIGN OUT");
		lblSignout.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignout.setForeground(Color.WHITE);
		lblSignout.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSignout.setBounds(62, 10, 144, 16);
		panelSignout.add(lblSignout);
		
		JLabel lbliconsignout = new JLabel("");
		lbliconsignout.setHorizontalAlignment(SwingConstants.CENTER);
		lbliconsignout.setIcon(new ImageIcon(image_logout));
		lbliconsignout.setBounds(10, 0, 45, 36);
		panelSignout.add(lbliconsignout);
		
		JLabel lblloginnamesurname = new JLabel(customer.getFirst_name() +" "+customer.getLast_name());
		lblloginnamesurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblloginnamesurname.setFont(new Font("Arial", Font.BOLD, 14));
		lblloginnamesurname.setForeground(new Color(255, 255, 255));
		lblloginnamesurname.setBounds(0, 170, 216, 36);
		panel.add(lblloginnamesurname);
		
		JLabel LblX = new JLabel("X");
		LblX.setHorizontalAlignment(SwingConstants.CENTER);
		LblX.setForeground(Color.WHITE);
		LblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		LblX.setBounds(895, 10, 20, 20);
		
		LblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you wamt to close this application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					DashboardFrame.this.dispose();
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
		panelMenu.add(LblX);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(226, 35, 669, 476);
		panelMenu.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		panelMainContent.add(panelaccount);
		panelMainContent.add(paneltransfers);
		panelMainContent.add(paneltransaction);
		panelMainContent.add(panelmessages);
		
		menuClicked(panelaccount);
	}
	
	public void menuClicked(JPanel panel) {
		panelaccount.setVisible(false);
		paneltransaction.setVisible(false);
		paneltransfers.setVisible(false);
		panelmessages.setVisible(false);
		
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(100, 0, 0));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(139, 0, 0));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(100, 0, 0));
		}
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(139, 0, 0));
		}
	}
	
	private static void readAccountList(String userid) {
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
		            
		            acounts.add(acou);
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
