package db연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB연결하기 {

	public static void main(String[] args) {
		try {
			//1. 드라이버 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Success");
			
			//2. 1번 설정을 커넥터로 db연결하고 승인
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. Success");
			
			//3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into hobby values (400, 'health', 'Incheon')";
			
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. Success");
			
			//4. 3번에서 생성된 sql문을 MySQL로 전송
			ps.execute();
			System.out.println("4. Success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
