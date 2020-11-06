package dao;

import java.sql.ResultSet;

import domain.TrialDOMAIN;


public interface TrialDAO {
	
	boolean insert_data(TrialDOMAIN trialDOMAIN);
	ResultSet select_data();
	
	

}
