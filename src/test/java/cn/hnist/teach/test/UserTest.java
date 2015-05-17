package cn.hnist.teach.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class UserTest {
	
	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://127.0.0.1:3306/teach";
		String user = "morris";
		String password = "morris";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into user(username,password) values('admin','admin')";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		int i = prepareStatement.executeUpdate(sql);
		
		if(i>0){
			System.out.println("新增admin用户成功");
		}
		
		sql = "insert into user(username,password) values('user','user')";
		i = prepareStatement.executeUpdate(sql);
		if(i>0){
			System.out.println("新增user用户成功");
		}
		
		prepareStatement.close();
		connection.close();
		
		
		
	}

}



