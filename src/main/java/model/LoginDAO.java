package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.AccountBean;

public class LoginDAO {
	
	final String URL="jdbc:mysql://localhost:3306/memo_app";
	final String USER="root";
	final String PASS="pass";
	
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public AccountBean findAccount(AccountBean ab) {
    	// 戻り値用
    	AccountBean returnAb = new AccountBean();
    	
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection(URL, USER, PASS);
    		System.out.println("接続OK");
    		String sql="SELECT * FROM users WHERE id = ? and pass = ? ";
    		
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, ab.getLoginId());
    		ps.setString(2, ab.getLoginPass());
    		rs = ps.executeQuery();

    		// アカウントの有無
    		if(rs.next()) {
    			returnAb.setLoginId(rs.getString("id"));
    			returnAb.setLoginPass(rs.getString("pass"));
    			returnAb.setLoginUserName(rs.getString("user_name"));
    		} else {
    			return null;
    		}
    	} catch(Exception e){
    		e.printStackTrace();
    		return null;
	    } 
    	return returnAb;
//    	finally {
//	    	try{
//	    		if(rs != null) rs.close();
//	    		if(stmt != null) stmt.close();
//	    		if(con != null) con.close();
//	    	} catch(Exception e){
//	    		e.printStackTrace();
//	    	}
//	    }
    }
}
