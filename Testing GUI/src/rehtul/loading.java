package rehtul;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class loading {
	
	JFrame frame = new JFrame();
	JProgressBar bar  = new JProgressBar();
	JLabel head = new JLabel();
	
	public loading()
	{
		head.setText("Mzalendo Bank");
		head.setBounds(160, 25, 300, 50);
		head.setFont(new Font("Script MT Bold",Font.PLAIN,27));
		
		bar.setValue(0);
		bar.setBounds(2,240,530,20);
		bar.setStringPainted(true);
		bar.setVisible(true);
		bar.setForeground(Color.blue);
		bar.setBackground(Color.black);
			
		frame.add(bar);
		frame.add(head);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(0, 0);
		frame.setSize(550, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		
		fill();
	}

	public void fill() {
		// TODO Auto-generated method stub
		int counter =0;
		
		while(counter<=100) {
			
			bar.setValue(counter);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter +=1;
		}
		bar.setString("Thank you for waiting");
	}
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		loading usiu = new loading();
	}

}
