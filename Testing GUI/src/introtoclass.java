/*Example: Creating Class Person

package dalton;

import java.awt.TextArea;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Person {

private String firstname,lastname, idnumber;

private int age;

//constructor

public Person()

{

}

//parameterized constructor

public Person(String firstname, String lastname, String idnumber, int age) {

this.firstname=firstname;

this.lastname=lastname;

this.idnumber=idnumber;

this.age=age;

}

//setters

public void setFirstname(String firstname)

{

this.firstname=firstname;

}

public void setLastName(String lastname)

{

this.lastname=lastname;

}

public void setIdNumber(String idnumber)

{

this.idnumber=idnumber;

}

public void setAge(int age)

{

this.age=age;

}

//getters

public String getFirstName()

{

return firstname;

}

public String getLastName()

{

return lastname;

}

public String getIdNumber()

{

return idnumber;

}

public int getAge()

{

return age;

}

//@override toString()

public String toString() {

return getFirstName()+ "\t"+ getLastName()+ "\t"+ getIdNumber()+ "\t"+ getAge()+ "\n";

}

public static void main(String[] args) {

Scanner input=new Scanner(System.in);

TextArea output=new TextArea(10,10);

System.out.append("Enter firstname, lastname, idnumber and age");

for(int i=0; i<3; i++)//alternatively one can use input.hasNext()

{

Person p=new Person();

p.setFirstname(input.next());

p.setLastName(input.next());

p.setIdNumber(input.next());

p.setAge(input.nextInt());

output.append(p.toString());

}

JOptionPane.showMessageDialog(null, output);

}

}*/
