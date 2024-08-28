package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.AccountBean;

public class RegisterDAO {
	final String URL="jdbc:mysql://localhost:3306/memo_app";
	final String USER="root";
	final String PASS="pass";
	
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public void registerAccount(AccountBean ab) {
    	
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection(URL, USER, PASS);
    		System.out.println("接続OK");
    		String sql="insert into users (id,pass,user_name) values (?,?,?)";
    		
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, ab.getLoginId());
    		ps.setString(2, ab.getLoginPass());
    		ps.setString(3, ab.getLoginUserName());
    		int r = ps.executeUpdate();
    		
    		if(r!=0) {
    			System.out.println("登録完了");
    		}else {
    			System.out.println("登録できませんでした");
    		}
    		
    	} catch(Exception e){
    		e.printStackTrace();
	    } 
    }
}
