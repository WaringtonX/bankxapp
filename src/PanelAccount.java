import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.List;
import model.Acounts;

import model.Customer;
import javax.swing.JEditorPane;

public class PanelAccount extends JPanel {

	private Image image_current = new ImageIcon(PanelAccount.class.getResource("res/current.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image image_savings = new ImageIcon(PanelAccount.class.getResource("res/passbook.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	
	private static  Customer customer = new Customer();
	private Acounts current_acount = new Acounts();
	private Acounts savings_acount = new Acounts();
	
	/**
	 * Create the panel.
	 */
	public PanelAccount(Customer cust,Acounts savings,Acounts current) {
		setBackground(new Color(165, 42, 42));
		setForeground(new Color(0, 0, 0));
		setBounds(0,0,669, 476);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(77, 76, 521, 140);
		add(panel);
		panel.setLayout(null);
		customer = cust;
		current_acount = current;
		savings_acount = savings;
		
		//System.out.println("Current Panel  : "  + current_acount.getAcount_number() +" " + current_acount.getAvialable());
		//System.out.println("Savings Panel  : "  +  savings_acount.getAcount_number() +" " + savings_acount.getAvialable());
		//System.out.println("From Acount Panel  : "  + customer.getFirst_name() +" " + customer.getLast_name());
		
		JLabel lblcurrencavialable = new JLabel("Avialable R" + current_acount.getAvialable());
		lblcurrencavialable.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrencavialable.setFont(new Font("Arial", Font.BOLD, 14));
		lblcurrencavialable.setForeground(new Color(255, 255, 255));
		lblcurrencavialable.setBounds(0, 61, 521, 32);
		panel.add(lblcurrencavialable);
		
		JLabel lblcurrentbalance = new JLabel("Balance R"+current_acount.getBalance());
		lblcurrentbalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrentbalance.setForeground(Color.WHITE);
		lblcurrentbalance.setFont(new Font("Arial", Font.BOLD, 14));
		lblcurrentbalance.setBounds(0, 93, 521, 26);
		panel.add(lblcurrentbalance);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 0, 0));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 521, 55);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CURRENT ACCOUNT");
		lblNewLabel.setBounds(178, 10, 343, 19);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JLabel lblcurrenticon = new JLabel("");
		lblcurrenticon.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrenticon.setIcon(new ImageIcon(image_current));
		lblcurrenticon.setBounds(107, 0, 61, 53);
		panel_1.add(lblcurrenticon);
		
		JLabel lblcurrentacountnumber = new JLabel("(" + current_acount.getAcount_number() +")");
		lblcurrentacountnumber.setFont(new Font("Arial", Font.BOLD, 14));
		lblcurrentacountnumber.setForeground(new Color(255, 255, 255));
		lblcurrentacountnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrentacountnumber.setBounds(163, 34, 182, 19);
		panel_1.add(lblcurrentacountnumber);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(139, 0, 0));
		panel_2.setBounds(77, 244, 521, 140);
		add(panel_2);
		
		JLabel lblsavingsavialable = new JLabel("Avialable R"+ savings_acount.getAvialable());
		lblsavingsavialable.setHorizontalAlignment(SwingConstants.CENTER);
		lblsavingsavialable.setForeground(Color.WHITE);
		lblsavingsavialable.setFont(new Font("Arial", Font.BOLD, 14));
		lblsavingsavialable.setBounds(0, 61, 521, 32);
		panel_2.add(lblsavingsavialable);
		
		JLabel lblsavingsbalance = new JLabel("Balance R"+ savings_acount.getAvialable());
		lblsavingsbalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblsavingsbalance.setForeground(Color.WHITE);
		lblsavingsbalance.setFont(new Font("Arial", Font.BOLD, 14));
		lblsavingsbalance.setBounds(0, 93, 521, 26);
		panel_2.add(lblsavingsbalance);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setForeground(Color.WHITE);
		panel_1_1.setBackground(new Color(139, 0, 0));
		panel_1_1.setBounds(0, 0, 521, 55);
		panel_2.add(panel_1_1);
		
		JLabel lblSavingsAccount = new JLabel("SAVINGS ACCOUNT");
		lblSavingsAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblSavingsAccount.setForeground(Color.WHITE);
		lblSavingsAccount.setFont(new Font("Arial", Font.BOLD, 16));
		lblSavingsAccount.setBounds(178, 10, 343, 19);
		panel_1_1.add(lblSavingsAccount);
		
		JLabel lblsavingsicon = new JLabel("");
		lblsavingsicon.setIcon(new ImageIcon(image_savings));
		lblsavingsicon.setHorizontalAlignment(SwingConstants.CENTER);
		lblsavingsicon.setBounds(107, 0, 61, 53);
		panel_1_1.add(lblsavingsicon);
		
		JLabel lblsavingsacountnumber_1 = new JLabel("(" + savings_acount.getAcount_number() +")");
		lblsavingsacountnumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblsavingsacountnumber_1.setForeground(Color.WHITE);
		lblsavingsacountnumber_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblsavingsacountnumber_1.setBounds(163, 34, 182, 19);
		panel_1_1.add(lblsavingsacountnumber_1);
	}
}
