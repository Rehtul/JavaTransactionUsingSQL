import java.awt.TextArea;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Usersinmethod {

	public double getval1()
		{
			Double a;
			String s;
			s=JOptionPane.showInputDialog("Enter the amount");
			a=Double.parseDouble(s);
			return a;
		}
		
		public double getval2()
		{
			Double a;
			String s;
			//Scanner input = new Scanner(System.in);
			//a=input.nextDouble();
			s=JOptionPane.showInputDialog("Enter the years");
			a=Double.parseDouble(s);
			return a;
		}

		public double compute(Double a,Double b)
		{
			Double p;
			DecimalFormat df = new DecimalFormat("0,000.00");
			p=a*Math.pow(1+0.12, b);
			return p;
		}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usersinmethod luthe = new Usersinmethod();
		int a;
		String s;
		TextArea output=new TextArea(20,40);
		DecimalFormat df = new DecimalFormat("000.00");
		JOptionPane.showMessageDialog(null, "Interest rate is 12%");
		s=JOptionPane.showInputDialog("Enter the number of users ");
		a=Integer.parseInt(s);
		output.append("Captured records are:");
		double b,d,p;
		for(int n=1;n<=a;n++)
		{
			JOptionPane.showMessageDialog(null,"Enter for the user no "+n);
			b=luthe.getval1();
			d=luthe.getval2();
			p=luthe.compute(b, d);
			output.append("\nUser number "+n+"\nAmount= "+b+"\nYears= "+d+"\nAmount "+b+" *(1+0.12)^"+d+" = "+df.format(p)+"\n");
		}
		JOptionPane.showMessageDialog(null, output);
		
		
		

	}

}
