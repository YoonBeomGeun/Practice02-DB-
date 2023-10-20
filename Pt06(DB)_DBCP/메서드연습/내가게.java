package 메서드연습;

public class 내가게 {

	public static void main(String[] args) {
		int coffeePrice = 5000;
		int coffeeCount = 15;

		// 50000원 이상이면 5000원 할인
		계산기 cal = new 계산기();
		int result = cal.mul(coffeePrice, coffeeCount);
		if (result >= 50000) {
			System.out.println("최종 계산금액은 " + (result - 5000) + "입니다.");
		}
		
		int[] x = cal.array();
		int x2 = x[0] + 100;
		System.out.println(x2);
		
		MemberVO bag = cal.get2("win2", "1234", "win2", "010");
		bag.setPw("1111");
		System.out.println(bag);
		
		String s = cal.get4("홍길동", 100);
		System.out.println(s + "입니다. 환영해 주세요~");
	}

}
