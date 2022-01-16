

import javax.swing.JOptionPane;

public class Password {

	public static void main(String[] args) {
		// Public is for visibility
		// Void does not return any method
		// Static means that the method will not require an object/invoke any and are called from the class
		
		double r;
		String s;
		
		s = JOptionPane.showInputDialog("Enter the password ");
		r = Double.parseDouble(s);
		
		
		if(r==2173) {
			JOptionPane.showMessageDialog(null, "Correct Password");
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect Password! Try again");
			
		}
		}
		
	}

