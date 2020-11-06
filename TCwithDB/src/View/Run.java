package View;

import java.util.Scanner;

import domain.TrialDOMAIN;
import domain.UserDOMAIN;
import service.impl.TrialService;
import service.impl.UserService;

public class Run {
	
	public static void main(String args[]) {
		
		UserDOMAIN userDOMAIN = new UserDOMAIN();
		TrialDOMAIN trialDOMAIN = new TrialDOMAIN();
		UserService userService = new UserService();
		TrialService trialService = new TrialService();
		UserVIEW userVIEW = new UserVIEW();
		TrialVIEW trialVIEW = new TrialVIEW();
		
		String input;
		Scanner s1= new Scanner(System.in);
		
		System.out.println();
		System.out.println("\t T: Trial calculation");
		System.out.println("\t S: Summary of trial calculation");
		System.out.println("\t E: Exit");
		System.out.println();
		System.out.print("Select a letter : ");
		input=s1.nextLine();
		while(!(input.equals("E"))) {
			if(input.equals("T")){
				System.out.println("You selected trial calculation ");
				userDOMAIN = userVIEW.get_data();
				userService.checkUser(userDOMAIN);
				userDOMAIN = userService.getcid(userDOMAIN);
				trialDOMAIN = trialVIEW.getTrialData();
				trialDOMAIN = trialService.DoTrialCalculation(trialDOMAIN);
				trialService.saveTrial(userDOMAIN, trialDOMAIN);
				System.out.println("Press Enter to new session");
				String x=s1.nextLine();
			}
			else if(input.equals("S")) {
				System.out.println("You selected sumamary of trial calculation");				
					trialService.printTrial();
					System.out.println("");
					System.out.println("Press Enter to new session");
					String x=s1.nextLine();
			}
			else {
				System.out.println("Invalid input.Please try again");
			}
			System.out.println();
			System.out.println("\t T: Trial calculation");
			System.out.println("\t S: Summary of trial calculation");
			System.out.println("\t E: Exit");
			System.out.println();
			System.out.print("Select a letter : ");
			input=s1.nextLine();
		}
		s1.close();
		System.out.println();
		System.out.println("       SYSTEM OFF");
		
	}
}
