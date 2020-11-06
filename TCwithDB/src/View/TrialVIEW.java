package View;

import java.util.Scanner;

import domain.TrialDOMAIN;

public class TrialVIEW {
	public TrialDOMAIN getTrialData() {
		TrialDOMAIN trialDOMAIN = new TrialDOMAIN();
		String input;
		Scanner sc=new Scanner(System.in);
		System.out.print("Lease/Loan Amount(L) : Rs. ");
		input=sc.nextLine();
		while(!trialDOMAIN.setLoan_amount(input)) {
			System.out.print("Lease/Loan Amount(L) : Rs.");
			input=sc.nextLine();
		}

		System.out.print("Enter Repayment Period in months : ");
		input=sc.nextLine();
		while(!trialDOMAIN.setNo_of_month(input)) {
			System.out.print("Enter Repayment Period in months : ");
			input=sc.nextLine();
		}
		
		System.out.print("Enter Annum Interest Rate : ");
		input=sc.nextLine();
		while(!trialDOMAIN.setInterest_rate(input)) {
			System.out.print("Enter Annum Interest Rate : ");
			input=sc.nextLine();
		}
		return trialDOMAIN;
	}
}
