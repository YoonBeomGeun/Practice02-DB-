package 상정;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {
	public int insert(ProductDTO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Success");
			
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. Success");
			
			String sql = "insert into product values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getName());
			ps.setString(3, bag.getContent());
			ps.setInt(4, bag.getPrice());
			ps.setString(5, bag.getCompany());
			ps.setString(6, bag.getImg());
			System.out.println("3. Success");
			
			result = ps.executeUpdate();
			System.out.println("4. Success");
			
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		return result;
	}
	
	// delete
	public int delete(ProductDTO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Success");
			
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. Success");
			
			String sql = "delete from product where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			System.out.println("3. Success");
			
			result = ps.executeUpdate();
			System.out.println("4. Success");
			
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		return result;
	}
	
	//update
	public int update(ProductDTO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Success");
			
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. Success");
			
			String sql = "update product set content = '품절' where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			System.out.println("3. Success");
			
			result = ps.executeUpdate();
			System.out.println("4. Success");
			
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		return result;
	}
	
	//select
	public ProductDTO select(String id) {
		ProductDTO bag = new ProductDTO();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Success");
			
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. Success");
			
			String sql = "select * from product where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. Success");
			
			ResultSet table = ps.executeQuery();
			System.out.println("4. Success");
			if(table.next()) {
				String id2 = table.getString("id");
				String name = table.getString("name");
				String content = table.getString("content");
				int price = Integer.parseInt(table.getString("id"));
				String company = table.getString("company");
				String img = table.getString("img");
				System.out.println(id2);
				System.out.println(name);
				System.out.println(content);
				System.out.println(price);
				System.out.println(company);
				System.out.println(img);
			} else {
				System.out.println("결과 없음.");
			}
			
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		return bag;
	}
}
