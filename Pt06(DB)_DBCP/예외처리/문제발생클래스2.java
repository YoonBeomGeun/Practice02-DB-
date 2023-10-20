package 예외처리;

public class 문제발생클래스2 {
	public static void main(String[] args) {
		System.out.println("1. 나는 실행됨.");

		try {
			System.out.println("2. 0으로 나누기 >> " + 10 / 0);
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[3]);
		} catch (ArithmeticException e1) { // import java.lang.*
			e1.printStackTrace();
			System.out.println("수학연산 에러 발생함.");
		} catch (ArrayIndexOutOfBoundsException e2) {
			e2.printStackTrace();
			System.out.println("배열 인덱스 에러 발생함.");
		} catch (Exception e) { // 수학연산에러, 배열에러도 아닌 경우 처리
			System.out.println("기타 에러 발생함.");
		}
		// catch문 쓸 때 에러 범위가 디테일한 것부터 큰 범위로 흘러가도록 작성.

		System.out.println("3. 나는 실행될까요?");
	}
}
