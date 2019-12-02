package BaseBall;

public class Check {
	
	Check(){
		
		int[] count = {0,0,0,0}; //스트라이크,볼,아웃,안타. 	
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

}
