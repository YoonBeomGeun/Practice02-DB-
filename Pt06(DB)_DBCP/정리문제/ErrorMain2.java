package 정리문제;

public class ErrorMain2 {
	public static void main (String[] s) {
		
		Error2 e = new Error2();
		try {
			e.arr2();	//실행에러
		} catch (Exception e1) {
			System.out.println("main()에서 배열 인덱스 에러를 예외처리함");
		}
		System.out.println("여기는 실행되어야만 해.");
	}
}