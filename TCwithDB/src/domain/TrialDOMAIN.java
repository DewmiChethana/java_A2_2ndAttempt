package domain;

import java.math.BigDecimal;

public class TrialDOMAIN {
	
private int trial_id;
private int customer_id;
private String date;
private BigDecimal loan_amount;
private int no_of_month;
private double interest_rate;
private BigDecimal rental_amount;

public int getTrial_id() {
	return trial_id;
}
public void setTrial_id(int trial_id) {
	this.trial_id = trial_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public BigDecimal getLoan_amount() {
	return loan_amount;
}
public boolean setLoan_amount(String loan_amount) {
	boolean verify=true;
	if(this.validatedouble(loan_amount)) {
		this.loan_amount= new BigDecimal(loan_amount);
				
	}
	else {
		verify=false;
	}
	return verify;
}	
	

public int getNo_of_month() {
	return no_of_month;
}
public boolean setNo_of_month(String no_of_month) {
	boolean verify=true;
	if(this.validateint(no_of_month)) {
		this.no_of_month=Integer.parseInt(no_of_month);
	}
	else {
		verify=false;
	}
	return verify;
}
	
public double getInterest_rate() {
	return interest_rate;
}
public boolean setInterest_rate(String interest_rate) {
	boolean verify=true;
	if(this.validatedouble(interest_rate)) {
		this.interest_rate=(Double.parseDouble(interest_rate)/100);
	}
	else {
		verify=false;
	}
	return verify;
}
public BigDecimal getRental_amount() {
	return rental_amount;
}
public void setRental_amount(BigDecimal rental_amount) {
	this.rental_amount = rental_amount;
}
public TrialDOMAIN() {
	
}

public boolean validatedouble(String num) {
	boolean validate=true;
	int size =num.length();
	for(int index=0;index<size;index++) {
		char numchar=num.charAt(index);
		if (numchar=='0'||numchar=='1'||numchar=='2'||numchar=='3'||numchar=='4'||numchar=='5'||numchar=='6'||numchar=='7'||numchar=='8'||numchar=='9'||numchar=='.') {
			
		}
		else {
			validate=false;
			System.out.println("Invalid Input");
			break;
		}
	}
	
	return validate;
}

public boolean validateint(String num) {
	boolean validate=true;
	int size =num.length();
	for(int index=0;index<size;index++) {
		char numchar=num.charAt(index);
		if (numchar=='0'||numchar=='1'||numchar=='2'||numchar=='3'||numchar=='4'||numchar=='5'||numchar=='6'||numchar=='7'||numchar=='8'||numchar=='9') {
			
		}
		else {
			validate=false;
			System.out.println("Wrong input");
			break;
		}
	}
	
	return validate;
}
}
