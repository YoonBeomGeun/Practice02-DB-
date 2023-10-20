package 정리문제;

public class Error {
	public void arr() {
		int[] array = {10, 20, 30};
		try {
			array[3] = 100;
		} catch (Exception e) {
			System.out.println("에러에러");
		}
	}
}
