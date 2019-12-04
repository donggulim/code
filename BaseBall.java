package BaseBall;
import java.util.*;

public class BaseBall {
	static Random generator = new Random(); 
	public static void main(String[] args) {
		Play();
	}
	
	
	static int[] count = {0,0,0,0}; //스트라이크,볼,아웃,안타. 	
	
	static void Play() {
		Run();
		Check();
	}
	
	private static void Run() {
		while(count[2]<3) { 
		int a = generator.nextInt(4);  //  0~3 랜덤넘버 생성.
			if(a==0) {
				System.out.println("스트라이크!");
				count[0]++; print();
			}else if(a==1){
				System.out.println("볼");
				count[1]++; print();
			}else if(a==2) {
				System.out.println("아웃! 다음 타자가 타석에 입장했습니다.");
				count[0]=0; count[1]=0;count[2]++; print();
			}else if(a==3) {
				System.out.println("안타! 다음 타자가 타석에 입장했습니다.");
				count[0]=0; count[1]=0;count[3]++; print();
		}	
	}
}
	
	private static void Check() {
		if(count[0]==3) {
			count[0]=0;
			count[2]++;  // 스트라이크3개 아웃+1
		}
		if(count[1]==4) {
			count[1]=0;
			count[3]++;  // 볼4 안타+1
			count[3]++;  // 볼4 안타+1
		}

		if(count[2]==3) {
				System.out.println("최종 안타수:"+ count[3]);
				System.out.println("GAME OVER");
		}
		
	}
	
	private static void print() {
		System.out.println(count[0]+"S "+count[1]+"B "+count[2]+"O");
	}
}
	


			
		
	


