package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import bean.MemoBean;

public class MemoDAO {
	
	final String URL="jdbc:mysql://localhost:3306/memo_app";
	final String USER="root";
	final String PASS="pass";
	
	public void insertMemo(MemoBean mb) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("memo 接続OK");
			sql="insert into memos(user_id,title,content) values(?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, mb.getMemoUserId());
			ps.setString(2, mb.getMemoTitle());
			ps.setString(3, mb.getMemoContent());
			
			System.out.print("ps:" + mb.getMemoUserId() + ":");
			System.out.print(mb.getMemoTitle() + ":");
			System.out.println(mb.getMemoContent());
			
			ps.executeUpdate();
			
			System.out.println("insertMemoメソッド ps update OK");

			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
	    	try{
    		if(ps != null) ps.close();
    		if(con != null) con.close();
    		} catch(Exception e){
    		e.printStackTrace();
    	}
    }
	}
	

}
