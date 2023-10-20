package 정리문제;

public class TourMain {

	public static void main(String[] args) {
		Tour tour = new Tour();

		//1. 가고 싶은 여행목록을 가지고 와서 다음과 같이 출력 
		//    내가 가고 싶은 여행지는 제주도와 부산, 울릉도이다. 빨리가자!
		String[] s = tour.가고싶은여행지목록();
		System.out.println("내가 가고싶은 여행지는 " + s[0] + "와 " + s[1] + ", " + s[2] + "이다. 빨리가자!");
		
		//2. 제일 가고 싶은 여행지를 가지고 와서 다음과 같이 출력
		//    제일 가고 싶은 여행지는 울릉도인데 가기 쉽지 않다.
		String s1 = tour.제일가고싶은여행지();
		System.out.println("제일 가고 싶은 여행지는 " + s1 + "인데 가기 쉽지 않다.");
		
		//3. 여행지경비(2, 50000)을 호출하여 다음과 같이 출력
		//    여행경비가 20만원이 넘으면   "더 모아야한다."
		//    여행경비가 20만원 미만이면 "이제 여행을 떠나도 된다."
		int k = tour.여행지경비(2, 50000);
		if(k>=200000) {
			System.out.println("이제 여행을 떠나도 된다.");
		}else {
			System.out.println("더 모아야한다.");
		}
	}

}
