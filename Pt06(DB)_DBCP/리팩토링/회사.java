package 리팩토링;

public class 회사 {
	public static void main(String[] args) {
		직원 e1 = new 직원();
		e1.name = "홍길동";
		e1.address = "삼성역";
		e1.salary = 100;
		//public --> protected --> default --> private
	}
}
