import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Myframe extends JFrame implements ActionListener {
	Myframe(){
		JLabel header = new JLabel();
		header.setBounds(150, 250, 150, 150);
		header.setText("Luthero");
		header.setSize(520,520);
		
		this.setLayout(null);
		this.setSize(500,500);
		this.add(header);
		
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
