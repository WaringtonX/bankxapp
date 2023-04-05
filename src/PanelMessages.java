import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelMessages extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelMessages() {
		setBackground(new Color(165, 42, 42));
		setBounds(0,0,669, 476);
		setLayout(null);
		
		JLabel lblThisIsMessages = new JLabel("THIS IS MESSAGES");
		lblThisIsMessages.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisIsMessages.setForeground(new Color(255, 255, 255));
		lblThisIsMessages.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblThisIsMessages.setBounds(103, 126, 438, 247);
		add(lblThisIsMessages);
	}

}
