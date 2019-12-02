package BaseBall;

import java.util.*;

public class Num2 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Run();
	}
	public static void Run() {
		System.out.println("신나는 야구시합");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 출력");
		System.out.println("3. 시합 시작");
		System.out.println("메뉴선택( 1 - 3 )");
		
		int a = scan.nextInt();
		if(a==1) { DataInput();	System.out.println("데이터 입력이 완료되었습니다.");}
		if(a==2) { DataOut();}
		if(a==3) {  		 }
	}
	public static void DataInput() {
		String[] TeamName = new String[2];
		String[][] MemberInformation = new String[2][20];
		Float[][] HitRate = new Float[2][20];
		scan.nextLine();
		for(int a=1;a<3;a++){
			System.out.print(a +"팀의 이름을 입력하세요>");
			TeamName[a-1] = scan.nextLine();
				for(int b=0;b<3;b++) {
					System.out.print(b+1 +"번 타자 정보 입력>");
					MemberInformation[a][b]=scan.nextLine();
					String[] ArrayAbc = MemberInformation[a][b].split(",");
					MemberInformation[a][b]=ArrayAbc[0];
					HitRate[a][b]=Float.parseFloat(ArrayAbc[1]);
				}
		}
}
		
	public static void DataOut() {
		
	//	System.out.println(TeamName[a]+"팀 정보");
		
		
	}

}
