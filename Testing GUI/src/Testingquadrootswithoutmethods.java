import java.util.Scanner;

public class Testingquadrootswithoutmethods {

	public double getval()
	{
		double a;
		Scanner input = new Scanner(System.in);
		a=input.nextDouble();
		return a;
	}
	
	public double compute(double a)
	{
		double b;
		b= (4)*Math.pow(a, 3);
		return b;
	}
	
	public void display(double b)
	{
		System.out.print("The volume of the sphere is "+b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testingquadrootswithoutmethods luther = new Testingquadrootswithoutmethods();
		double radius,volume;
		radius=luther.getval();
		volume=luther.compute(radius);
		luther.display(volume);

	}


}
