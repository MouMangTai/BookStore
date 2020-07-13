package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Product;
import Bean.Type;

public class TypeDao {
	public TypeDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shoppingcartsystem"
				+ "?characterEncoding=UTF-8","root","admin");
	}
	public int getTotal(){
		int total = 0;
		try(Connection c = getConnection();
				Statement s = c.createStatement();){
			String sql = "select count(*) from product";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	public void addType(Type p){
		String sql = "insert into types(typename) values(?)";
		try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, p.getTypeName());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteType(int id){
		String sql = "delete from types where id="+id;
		try(Connection c = getConnection();Statement s = c.createStatement()){
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Type getType(int id){
		Type p = null;
		String sql = "select * from types where id = "+id;
		try(Connection c = getConnection();Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				p = new Type();
				p.setId(id);
				p.setTypeName(rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	public List<Type> listType(){
		List<Type> L = new ArrayList<Type>();
		String sql = "select * from types ";
		try(Connection c = getConnection();Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				Type p = new Type();
				p.setId(rs.getInt(1));
				p.setTypeName(rs.getString(2));
				L.add(p);
			}
			rs.close();
			s.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return L;
	}
	
}
