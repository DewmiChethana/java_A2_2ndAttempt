package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.JDBCConnection;
import dao.TrialDAO;
import domain.TrialDOMAIN;

public class TrialDAOIMPL implements TrialDAO{
	
	private final String Select="SELECT customer.Cus_name ,trial_calculation.Date ,trial_calculation.Loan_Amount, trial_calculation.No_Of_Months ,trial_calculation.Interest_Rate ,trial_calculation.Rental_Amount FROM customer,trial_calculation WHERE customer.Cus_id=trial_calculation.Cus_id";
	private final String write="INSERT INTO `trial_calculation` (`Trial_id`, `Cus_id`, `Date`, `Loan_Amount`, `No_Of_Months`, `Interest_Rate`, `Rental_Amount`) VALUES (NULL,?,?,?,?,?,?);";
	

	@Override
	public boolean insert_data(TrialDOMAIN trialDOMAIN) {
		boolean verify= true;
		JDBCConnection newjdbc=new JDBCConnection();
		Connection conn= newjdbc.get_connection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.write);
			statement.setInt(1, trialDOMAIN.getCustomer_id());
			statement.setString(2, trialDOMAIN.getDate());
			statement.setBigDecimal(3, trialDOMAIN.getLoan_amount());
			statement.setInt(4, trialDOMAIN.getNo_of_month());
			statement.setDouble(5,trialDOMAIN.getInterest_rate()*100);
			statement.setBigDecimal(6, trialDOMAIN.getRental_amount());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    
			}
			else {
				verify=false;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return verify;
		
	}

	@Override
	public ResultSet select_data() {
		JDBCConnection newjdbc=new JDBCConnection();
		Connection conn= newjdbc.get_connection();
		PreparedStatement statement;
		ResultSet result=null;
		try {
			statement = conn.prepareStatement(this.Select);
			result = statement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
       

