package 회원정보;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	// DAO: Db Access Object
	//shop db member table에 접근해서 처리하는 객체
	int result = 0;
	public int insert(MemberVO bag) { // member 테이블에 crud를 하고싶으면 MemberDAO를 사용
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
			ps.setString(1, bag.getId());	// 물음표 번호 1번에 id를 넣어줘.
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());
			System.out.println("3. sql문 생성 성공");
			//URL site = new URL(site);
			
			// 4. 3번에서 생성된 sql문을 MySQL로 전송
			result = ps.executeUpdate();	// 결과는 int
			System.out.println("4. SQL문 MySQL로 전송 성공");
			
			con.close();
			ps.close();
		} catch (Exception e) {	// 전체 에러 잡기
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		return result;
	}
	
	//delete
	public int delete(MemberVO bag) {
		int result = 0;
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
			ps.setString(1, bag.getId());
			System.out.println("3. sql문 생성 성공");
			
			// 4. 3번에서 생성된 sql문을 MySQL로 전송
			result = ps.executeUpdate();
			System.out.println("4. SQL문 MySQL로 전송 성공");
			
			con.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		return result;
	}
	
	//update
	public int update(MemberVO bag) {
		int result = 0;
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
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			System.out.println("3. sql문 생성 성공");
			
			// 4. 3번에서 생성된 sql문을 MySQL로 전송
			result = ps.executeUpdate();
			System.out.println("4. SQL문 MySQL로 전송 성공");
			
			con.close();
			ps.close();
		} catch (Exception e) {	// 전체 에러 잡기
			e.printStackTrace();
			System.out.println("에러 발생");
		}
		return result;
	}

	//select - select의 결과는 테이블, 검색결과가 없어도 테이블. 단 이때는 데이터가 없음
	public MemberVO one(String id) {
		MemberVO bag = new MemberVO();
		
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
			String sql = "select * from member where id = ?";
			//String site = "http://www.naver.com";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. sql문 생성 성공");
			
			// 4. 3번에서 생성된 sql문을 MySQL로 전송
			ResultSet table = ps.executeQuery();
			System.out.println("4. SQL문 MySQL로 전송 성공");
			//System.out.println(table.next());	// table 안에 데이터가 있으면 true
			if(table.next()) {	//table 안에 검색결과인 row가 있는지 체크
				String id2 = table.getString("id");	//id는 컬럼명
				String pw = table.getString("pw");
				String name = table.getString("name");
				String tel = table.getString("tel");
				System.out.println(id2);
				System.out.println(pw);
				System.out.println(name);
				System.out.println(tel);
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
			} else {
				System.out.println("검색결과 없음.");
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
