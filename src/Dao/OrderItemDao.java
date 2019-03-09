package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.OrderItem;
import Bean.Product;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class OrderItemDao {
	public OrderItemDao(){
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
	public List<OrderItem> getOrderItem(int user_id){
		List<OrderItem> L = new ArrayList<OrderItem>();
		String sql = "select * from orderitem where user_id = "+user_id;
		try(Connection c = getConnection();Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				OrderItem oi = new OrderItem();
				Product p = new ProductDao().getProduct(rs.getInt(1));
				oi.setProduct(p);
				oi.setNumber(rs.getInt(2));
				oi.setUser_id(rs.getInt(3));
				L.add(oi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return L;
	}
	public void deleteOrderItem(int product_id,int user_id){
		String sql = "delete from orderitem where product_id='"+product_id+"' and user_id='"+user_id+"'";
		try(Connection c = getConnection();Statement s = c.createStatement()){
			s.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public OrderItem getOrderItem(int product_id,int user_id){
		OrderItem oi = null;
		String sql = "select * from orderitem where product_id = ? and user_id = ?";
		try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, product_id);
			ps.setInt(2, user_id);
			
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				oi = new OrderItem();
				Product p = new ProductDao().getProduct(product_id);
				oi.setProduct(p);
				oi.setNumber(rs.getInt(2));
				oi.setUser_id(user_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oi;
	}
	public List<OrderItem> listOrderItem(){
		List<OrderItem> L = new ArrayList<OrderItem>();
		String sql = "select * from orderitem";
		try(Connection c = getConnection();Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				OrderItem oi = new OrderItem();
				Product p = new ProductDao().getProduct(rs.getInt(1));
				oi.setProduct(p);
				oi.setNumber(rs.getInt(2));
				oi.setUser_id(rs.getInt(3));
				L.add(oi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return L;
	}
	public void updateOrderItem(int product_id,int num,int user_id){
		String sql = "update orderitem set number = ? where product_id=? and user_id = ?";
		try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, num);
			ps.setInt(2, product_id);
			ps.setInt(3, user_id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addOrderItem(int product_id,int num,int user_id){
		String sql = "insert into orderitem values(?,?,?)";
		try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, product_id);
			ps.setInt(2, num);
			ps.setInt(3, user_id);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
