package 예외처리;

public class 문제발생클래스 {
	public static void main(String[] args) {
		System.out.println("1. 나는 실행됨.");
		
		try {
			System.out.println("2. 0으로 나누기 >> " + 10/0);
		} catch (Exception e) {
			//e.printStackTrace();
			//서버관리자에게 이메일을 보내는 처리
			//서버관리자에게 문자를 보내는 처리
			// git History 처리
			// Jira History 처리
			System.out.println("0으로 나누는 것은 실패.");
		}
		
		System.out.println("3. 나는 실행될까요?");
	}
}
