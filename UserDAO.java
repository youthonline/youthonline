package com.java101.microblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java101.microblog.untitybean.User;
import com.java101.microblog.util.DBConnection;

public class UserDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =;
	
	/**
	 * 根据用户id返回一个用户对象，如果id不存在则返回null
	 * @param 用户id
	 * @return User对象
	 */
	public User getUserById(int id){
		User u = new User();
		con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement("select * from t_user where id=? limit 1");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setTruename(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setComefrom(rs.getString(6));
				u.setBirthday(rs.getDate(7));
				u.setEmail(rs.getString(8));
				u.setAttention(rs.getInt(9));
				u.setBeattention(rs.getInt(10));
				
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close();
		}
		
		return u;
	}
	
	/**
	 * 根据用户名username返回一个用户对象，如果用户不存在则返回null
	 * @param username用户名
	 * @return User对象
	 */
	public User getUserByUsername(String username){
		
	
		User u = n
		con = DBConnection.getConnection();
		/*try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java101_microblog?useUnicode=true&characterEncoding=UTF-8", "root", "2321456zlq");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		
		
		try {
			ps = con.prepareStatement("select * from t_user where username=? limit 1");
			ps.setString(1, username);
			rs = ps.executeQuery();

			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setTruename(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setComefrom(rs.getString(6));
				u.setBirthday(rs.getDate(7));
				u.setEmail(rs.getString(8));
				u.setAttention(rs.getInt(9));
				u.setBeattention(rs.getInt(10));
				
				system.out.print("hello");
 				system.out.print("hello123");
				
			}
			
			
			/*ps = con.prepareStatement("insert into t_user values(null,'是','2321456zlq','吴操33','M','安徽六安皖西学院', '1991-06-06 00:00:00', '806223819@qq.com',0,0)");
			ps.executeUpdate();*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			close();
		}
		
		return u;
	}
	
	
	
	
	
	public List<User> getTop10Users(){
		
		List<User> l = new ArrayList<User>();
		
		con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement("select * from t_user order by beattention desc limit 10");
			rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setTruename(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setComefrom(rs.getString(6));
				u.setBirthday(rs.getDate(7));
				u.setEmail(rs.getString(8));
				u.setAttention(rs.getInt(9));
				u.setBeattention(rs.getInt(10));
				l.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close();
		}
		
		return l;
		
	}
	
	public int add(User u,String birthday){
		
		int i = 0;
		
		con = DBConnection.getConnection();
		
		String username = u.getUsername();
		String password = u.getPassword();
		String truename = u.getTruename();
		String sex = u.getSex();
		String comefrom = u.getComefrom();
		String email = u.getEmail();
		
		try{
			ps = con.prepareStatement("insert into t_user values(null,?,?,?,?,?,?,?,0,0)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, truename);
			ps.setString(4, sex);
			ps.setString(5, comefrom);
			ps.setString(6, birthday);
			ps.setString(7, email);
			i = ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return i;
		
	}
	
	private void close(){
		
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(con!=null) con.close();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
