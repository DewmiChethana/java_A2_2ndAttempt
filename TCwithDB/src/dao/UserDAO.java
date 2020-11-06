package dao;

import java.sql.ResultSet;

import domain.UserDOMAIN;

public interface UserDAO {

	 boolean insert_data(UserDOMAIN userDOMAIN);
	
	 ResultSet select_data(UserDOMAIN userDOMAIN);
	
	 ResultSet select_cid(UserDOMAIN userDOMAIN);

}
