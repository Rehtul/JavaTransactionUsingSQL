import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Trial1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		
		JLabel label = new JLabel(); //create a label
		label.setText("Luthero"); //set text of label
		label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER, RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
		label.setForeground(new Color(0x00FF00)); //set font color of text
		label.setFont(new Font("MV Boli",Font.PLAIN,15)); //set font of text
		label.setIconTextGap(-25); //set gap of text to image
		label.setBackground(Color.black); //set background color
		label.setOpaque(true); //display background color
		//label.setBorder(border); //sets border of label (not image+text)
		label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
		label.setBounds(100, 100, 250, 250); //set x,y position within frame as well as dimensions
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setSize(420,420);
		//frame.setLayout(null);
		frame.setVisible(true);	 
		frame.add(label);
		frame.pack();
	
	}

}
