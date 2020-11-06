package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.JDBCConnection;
import dao.UserDAO;
import domain.UserDOMAIN;

public class UserDAOIMPL implements UserDAO {
	
	private  String Read="SELECT * FROM `customer` WHERE `NIC`=?";
	private  String cid="SELECT Cus_id FROM `customer` WHERE `NIC`=?";
	private  String write="INSERT INTO `customer` (`Cus_id`, `Cus_name`, `NIC`) VALUES (NULL, ?, ?);";



	@Override
	public boolean insert_data(UserDOMAIN userDOMAIN) {
		JDBCConnection newjdbc=new JDBCConnection();
		Connection conn= newjdbc.get_connection();
		boolean insert=true;
		PreparedStatement statement;
		int count=0;
		try {
			statement = conn.prepareStatement(this.write);
			statement.setString(1,userDOMAIN.getName());
			statement.setString(2, userDOMAIN.getNic());
			count=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0) {
			
		}
		else {
			insert=false;
		}
		return insert;
	}



	@Override
	public ResultSet select_data(UserDOMAIN userDOMAIN) {
		JDBCConnection newjdbc=new JDBCConnection();
		Connection conn= newjdbc.get_connection();
		PreparedStatement statement;
		ResultSet result=null;
		try {
			statement = conn.prepareStatement(this.Read);
			statement.setString(1, userDOMAIN.getNic());
			result = statement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}



	@Override
	public ResultSet select_cid(UserDOMAIN userDOMAIN) {
		JDBCConnection newjdbc=new JDBCConnection();
		Connection conn= newjdbc.get_connection();
		PreparedStatement statement;
		ResultSet result=null;
		try {
			statement = conn.prepareStatement(this.cid);
			statement.setString(1, userDOMAIN.getNic());
			result = statement.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
