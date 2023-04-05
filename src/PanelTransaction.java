import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PanelTransaction extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelTransaction() {
		setBackground(new Color(165, 42, 42));
		setBounds(0,0,669, 476);
		setLayout(null);
        
        JLabel lblNewLabel = new JLabel("THIS IS TRANSACTIONS");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 37));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(105, 127, 438, 247);
        add(lblNewLabel);
	}

}
