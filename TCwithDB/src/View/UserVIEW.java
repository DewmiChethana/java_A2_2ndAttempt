package View;

import java.util.Scanner;
import domain.UserDOMAIN;


public class UserVIEW {
	
	public UserDOMAIN get_data() {
		String input;
		UserDOMAIN userDOMAIN =new UserDOMAIN();
		Scanner s1= new Scanner(System.in);
		System.out.println();
		System.out.print("Enter Customer Name : ");
		input=s1.nextLine();
		while(!userDOMAIN.setName(input)) {
			System.out.print("Enter Customer Name : ");
			input=s1.nextLine();
		}	
		System.out.print("Enter NIC No:");
		input=s1.nextLine();
		while(!userDOMAIN.setNic(input)) {
			System.out.print("Enter NIC No : ");
			input=s1.nextLine();
		}
		return userDOMAIN;
	}
	
	
}



