package db연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB테스트 {

	public static void main(String[] args) {
		// Java-DB연결(JDBC)
		// 1.연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	//외부자원 연결(db, network, cpu, file) - 위험한 상황.
			System.out.println("1. 커넥터 연결 성공");
			
			// 2.1번 설정을 커넥터로 db연결하고 승인
			// 		1) url - ip + port + db명
			// 		2) id, pw //승인을 받기위해 필요
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String  password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공");
			
			// 3. 2번에서 연뎔된 것을 가지고 sql문 생성
			String sql = "insert into member values ('star2', '1234', 'star', '011')";
			String site = "http://www.naver.com";
			// 해당 부품으로 만들어줘야 한다.
			// sql ==> PreparedStatement, site ==> URL
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. sql문 생성 성공");
			//URL site = new URL(site);
			
			// 4. 3번에서 생성된 sql문을 MySQL로 전송
			ps.execute();
			System.out.println("4. SQL문 MySQL로 전송 성공");
			
		} catch (Exception e) {	// 전체 에러 잡기
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		
		
		

	}

}
