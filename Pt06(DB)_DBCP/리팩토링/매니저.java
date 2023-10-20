package 리팩토링;

public class 매니저 extends 직원 {
	// 멤버변수 4개, 메서드 1개 포함.
	private int bonus;

	public void test() {
		System.out.println("관리할 사람 이름: " + name);
		System.out.println("관리할 사람 월급: " + salary);
		System.out.println("관리할 사람 주소: " + address);
		//System.out.println("관리할 사람 주민번호: " + rrn);
		System.out.println("관리감독하다.");
	}
}
