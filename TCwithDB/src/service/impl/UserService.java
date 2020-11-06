package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.impl.UserDAOIMPL;
import domain.UserDOMAIN;

public class UserService {
	UserDAOIMPL userDAOIMPL = new UserDAOIMPL();
		
	public void checkUser(UserDOMAIN userDOMAIN) {
		ResultSet resultSet =userDAOIMPL.select_data(userDOMAIN);
		try {
			if(resultSet.next()) {
				
			}
			else {
				userDAOIMPL.insert_data(userDOMAIN);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UserDOMAIN getcid(UserDOMAIN userDOMAIN) {
		ResultSet resultSet = userDAOIMPL.select_cid(userDOMAIN);
		try {
			if(resultSet.next()) {
				userDOMAIN.setCid(resultSet.getInt(1));
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userDOMAIN;
	}
}
