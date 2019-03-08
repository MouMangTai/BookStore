package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import Bean.Product;

public class ProductDao {
	public ProductDao(){
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
	public void addProduct(Product p){
		String sql = "insert into product values(?,?,?,?,?,?)";
		try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getValue());
			ps.setInt(4, p.getLeft_number());
			ps.setString(5, p.getMessage());
			ps.setString(6, p.getImage_src());
			ps.execute();
			ps.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Product getProduct(int id){
		Product p = null;
		String sql = "select * from product where id = "+id;
		try(Connection c = getConnection();Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				p = new Product();
				p.setId(id);
				p.setName(rs.getString(2));
				p.setValue(rs.getDouble(3));
				p.setLeft_number(rs.getInt(4));
				p.setMessage(rs.getString(5));
				p.setImage_src(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	public List<Product> listProduct(int start,int end){
		List<Product> L = new ArrayList<Product>();
		String sql = "select * from product order by id limit "+start+","+end;
		try(Connection c = getConnection();Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setValue(rs.getDouble(3));
				p.setLeft_number(rs.getInt(4));
				p.setMessage(rs.getString(5));
				p.setImage_src(rs.getString(6));
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
	public List<Product> listProduct(){
		return listProduct(0,Short.MAX_VALUE);
	}
	public static void main(String[] args) {
		System.out.println(new ProductDao().listProduct().size());
	}
}
