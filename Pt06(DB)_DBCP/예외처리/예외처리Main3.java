package 예외처리;

public class 예외처리Main3 {

	public static void main(String[] args) {
		에러발생3 error = new 에러발생3();
		//에러가 발생할 것 같은 코드가 있는 경우
		//call() 메서드 만든 사람이 예외처리를 결정할 수 있
		try {
			error.call();
		} catch (Exception e) {
			System.out.println("함수를 호출한 곳에서 예외처리함2.");
			System.out.println("관리자에게 전화를 함.");
		}	//예외처리를 넘겨받음
	}

}
