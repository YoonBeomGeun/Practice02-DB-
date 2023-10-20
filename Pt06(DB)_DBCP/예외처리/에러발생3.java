package 예외처리;

public class 에러발생3 {

	// 메서드를 만드는 사람이 예외처리를 하는 것이 아니고
	// 이 메서드를 부른 곳에서 각각 알아서 예외처리를 하도록 떠넘길 수 있음

	public void call() throws Exception {

		System.out.println(3 / 0);

	}
}
