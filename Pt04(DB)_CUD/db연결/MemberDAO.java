package db연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {
	// DAO: Db Access Object
	//shop db member table에 접근해서 처리하는 객체

	public void insert(String id, String pw, String name, String tel) { // member 테이블에 crud를 하고싶으면 MemberDAO를 사용
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
			
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "insert into member values (?, ?, ?, ?)";
			//String site = "http://www.naver.com";
			// 해당 부품으로 만들어줘야 한다.
			// sql ==> PreparedStatement, site ==> URL
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);	// 물음표 번호 1번에 id를 넣어줘.
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, tel);
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
	
	//delete
	public void delete(String id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공");
			
			// 2.1번 설정을 커넥터로 db연결하고 승인
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String  password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공");
			
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "delete from member where id = ?";
			//String site = "http://www.naver.com";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. sql문 생성 성공");
			
			// 4. 3번에서 생성된 sql문을 MySQL로 전송
			ps.execute();
			System.out.println("4. SQL문 MySQL로 전송 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
	}
	
	//update
	public void update(String tel, String id) {
		// 1.연결할 부품(커넥터, driver, 드라이버) 설정
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 커넥터 연결 성공");
			
			// 2.1번 설정을 커넥터로 db연결하고 승인
			String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&serverTimezone=Asia/Seoul";
			String user = "root";
			String  password = "1234";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. shop db연결 성공");
			
			// 3. 2번에서 연결된 것을 가지고 sql문 생성
			String sql = "update member set tel = ? where id = ?";
			//String site = "http://www.naver.com";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setString(2, id);
			System.out.println("3. sql문 생성 성공");
			
			// 4. 3번에서 생성된 sql문을 MySQL로 전송
			ps.execute();
			System.out.println("4. SQL문 MySQL로 전송 성공");
			
		} catch (Exception e) {	// 전체 에러 잡기
			e.printStackTrace();
			System.out.println("에러 발생");
		}
	}

}
