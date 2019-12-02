package BaseBall;

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Num2 {
	static Scanner scan = new Scanner(System.in);
	static String[] TeamName = new String[2];
	static String[][] MemberInformation = new String[2][20];
	static Float[][] HitRate = new Float[2][20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Run();
	}
	public static void Run() {
	while(true) {	
		System.out.println("신나는 야구시합");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 출력");
		System.out.println("3. 시합 시작");
		System.out.println("메뉴선택( 1 - 3 )");
		int a = scan.nextInt();
		if(a==1) { 
			DataInput();	System.out.println("데이터 입력이 완료되었습니다.");
		}
		else if(a==2) { DataOut();}
		else if(a==3) {  		 }
		else {
			System.out.println("잘못 입력하였습니다.");
			continue;
		}
	}
	
	
	}
	
	public static void DataInput() {
		
		scan.nextLine();
		for(int a=0;a<2;a++){
			System.out.print(a+1 +"팀의 이름을 입력하세요>");
			TeamName[a] = scan.nextLine();
				for(int b=0;b<3;b++) {
					System.out.print(b+1 +"번 타자 정보 입력>");
					MemberInformation[a][b]=scan.nextLine();
					String[] ArrayAbc = MemberInformation[a][b].split(",");
					MemberInformation[a][b]=ArrayAbc[0];
					try {
					HitRate[a][b]=Float.parseFloat(ArrayAbc[1]);
					}catch(IndexOutOfBoundsException e) {
						System.out.println("데이터 입력 형식이 잘못었습니다. 정보를 다시 입력해주세요.");
						MemberInformation[a][b]=scan.nextLine();
						ArrayAbc = MemberInformation[a][b].split(",");
						MemberInformation[a][b]=ArrayAbc[0];
						HitRate[a][b]=Float.parseFloat(ArrayAbc[1]);
						
					}
				}
					
		}
	}

		
	public static void DataOut() {
		
	for(int a=0;a<2;a++) {
		System.out.println(TeamName[a]+" 팀 정보");
			for(int b=0;b<3;b++) {
				System.out.println(b+1 + "번,"+ MemberInformation[a][b]+","+HitRate[a][b]);
		
		}
	}
}
		
	}


