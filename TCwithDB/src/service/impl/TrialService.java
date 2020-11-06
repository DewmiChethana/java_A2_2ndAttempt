package service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import dao.impl.TrialDAOIMPL;
import domain.TrialDOMAIN;
import domain.UserDOMAIN;

public class TrialService {
	
	TrialDAOIMPL trialDAOIMPL=new TrialDAOIMPL();

	public TrialDOMAIN DoTrialCalculation(TrialDOMAIN trialDOMAIN) {
		BigDecimal x1, x2, x3;
		x1=new BigDecimal(trialDOMAIN.getInterest_rate()/12).multiply(trialDOMAIN.getLoan_amount());
		x2=new BigDecimal((1-(1/Math.pow((1+trialDOMAIN.getInterest_rate()/12), trialDOMAIN.getNo_of_month()))));
		x3=x1.divide(x2,2, RoundingMode.CEILING);
		trialDOMAIN.setRental_amount(x3);
		
		System.out.println();
		System.out.println("Loan Amount : Rs."+trialDOMAIN.getLoan_amount());
		System.out.println("Repayment Period : "+trialDOMAIN.getNo_of_month()+" months");
		System.out.println("Annum Interest Rate : "+trialDOMAIN.getInterest_rate()*100+"%");
		System.out.println("Rental Value : Rs."+trialDOMAIN.getRental_amount());
		
		return trialDOMAIN;
	}
	
	public void saveTrial(UserDOMAIN userDOMAIN,TrialDOMAIN trialDOMAIN) {
		trialDOMAIN.setCustomer_id(userDOMAIN.getCid());
		LocalDate date = LocalDate.now();
		trialDOMAIN.setDate(date.toString());
		boolean savedata=trialDAOIMPL.insert_data(trialDOMAIN);
		if(savedata) {
			System.out.println("");
			System.out.println("Trial Calculation is saved ");
		}else {
			System.out.println("");
			System.out.println("Trial Calculation isn't saved ");
		}
	}
	
	public void printTrial()  {
		TrialDAOIMPL t1= new TrialDAOIMPL();
		ResultSet rs=null;
		try {
			 System.out.println("----------------------------------------------------------------------------------------------------------");
             System.out.println("| Customer Name |     Date        | Loan Amount    | No Of Periods  |  Interest Rate     | Rental Amount |");
			 System.out.println("|---------------|-----------------|----------------|----------------|--------------------|---------------|");
			 rs=t1.select_data();
				while (rs.next()){
					System.out.println("| "+rs.getString(1)+" \t|   "+rs.getString(2)+"    |   "+rs.getString(3)+"     |       "+rs.getString(4)+"       | \t  "+rs.getString(5)+" \t\t |   "+rs.getString(6)+" \t |");
				}
				 System.out.println("----------------------------------------------------------------------------------------------------------");

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
