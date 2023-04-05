import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
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

public class PanelTransfers extends JPanel implements ActionListener {

	private static  Customer customer = new Customer();
	private String[] acounts,nexts;
	private Acounts current_acount = new Acounts();
	private Acounts savings_acount = new Acounts();
	private JLabel lblrightavail;
	private JLabel lblrightbalance;
	private JLabel lblleftavail;
	private JLabel lblleftbalance;
	private JComboBox comboTo;
	private JComboBox combofrom;
	private JPanel panel_3;
	private JTextField txtAmount;
	
	private Image image_coin = new ImageIcon(PanelTransfers.class.getResource("res/coins.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	private JPanel pnlBtnLogin;
	private JLabel lblNewLabel;
	private JLabel lblapology;
	
	/**
	 * Create the panel.
	 */
	public PanelTransfers(Customer cust,Acounts savings,Acounts current) {
		setBackground(new Color(165, 42, 42));
		setBounds(0,0,669, 476);
		setLayout(null);
		
		customer = cust;
		current_acount = current;
		savings_acount = savings;
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
}
