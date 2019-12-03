package BaseBall;

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Num2 {
	static Scanner scan = new Scanner(System.in);
	static String[] TeamName = new String[2];
	static String[][] MemberName = new String[2][3];
	static double[][] HitRate = new double[2][3];
	static String[] ArrayAbc;
	static int[] count = {0,0,0,0}; //안타,스트라이크,볼,아 	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Execute();
		Num2 num2 = new Num2();
	}
	public static void Execute() {
	while(true) {	
		System.out.println("신나는 야구시합");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 출력");
		System.out.println("3. 시합 시작");
		System.out.println("메뉴선택( 1 - 3 )");
		int a = scan.nextInt();
			if(a==1) { 
				DataInput(); System.out.println("데이터 입력이 완료되었습니다.");
			}
			else if(a==2) { DataOut();}
			else if(a==3) { Match(); break;}
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
					try {
						Input(a,b);
					}catch(IndexOutOfBoundsException e) {
						System.out.print(" ,를 다시 입력해주세요.");
						Input(a,b);
					}
				}
		}
	}
	public static void Input(int a, int b) {
		System.out.print(b+1 +"번 타자 정보 입력>");
		MemberName[a][b]=scan.nextLine();
		String[] ArrayAbc = MemberName[a][b].split(",");
		MemberName[a][b]=ArrayAbc[0];
		HitRate[a][b]=Float.parseFloat(ArrayAbc[1]);
			if( HitRate[a][b]<0.1 || HitRate[a][b]>=0.5) {
				System.out.print("타율 범위가 잘못 입력되었습니다. 다시 입력해주세요.");
				Input(a,b);
			}
	}
		
	public static void DataOut() {
		
	for(int a=0;a<2;a++) {
		System.out.println(TeamName[a]+" 팀 정보");
			for(int b=0;b<3;b++) {
				System.out.println(b+1 + "번,"+ MemberName[a][b]+","+HitRate[a][b]);
		
			}
		}
	}
	
	public static void Match() {
			for(int number=0;number<6;number++) {
					SetCount();
					AttackFirstTeam(0,number);
					SetCount();
					AttackSecondTeam(1,number);
				}
		}
	public static void SetCount() {
		for(int number=0;number<4;number++) {
				count[number]=0;
			}
	}
		
	
	 private static void AttackFirstTeam(int a,int number) {
		 System.out.println(number+1+"회초 "+TeamName[a]+"의 공격");
		 while(count[3]<3) {
			for(int b=0;b<3;b++) {
			System.out.println(b+1+"번"+MemberName[a][b]);
			Run(HitRate[a][b]);
			}
		}
	}
	 private static void AttackSecondTeam(int a,int number) {
		 System.out.println(number+1+"회말 "+TeamName[a]+"의 공격");
		 while(count[3]<3) {
			for(int b=0;b<3;b++) {
			System.out.println(b+1+"번"+MemberName[a][b]);
			Run(HitRate[a][b]);
			}
		}
	}
	
/*	private static void Play(double HitRate){
		while(count[3]==3){    //static int[] count = {0,0,0,0}; //안타,스트라이크,볼,아웃순서
			 Run(HitRate);
			if(count[1]==3) {
					count[1]=0;
					count[2]=0;
					count[3]++;  // 스트라이크3개 아웃+1 
				System.out.println(" 스트라이크 3개 됬습니다. 아웃 + 1"); break;
			}	
			if(count[3]==3) { //아웃 3개면 함수 종료.
				System.out.println("아웃 3개 최종 안타수:"+ count[0]);
				break;
			}
			System.out.println("선수 한명 play함수 종료.");
			break;
		}
	}*/

	private static void Run(double HitRate) {
			while(true) {	
				double RandomNumber = Math.random();  //static int[] count = {0,0,0,0}; //안타,스트라이크,볼,아웃순서
				double BallOrStrike= (1-HitRate)/2 - 0.05;
				if(RandomNumber<=HitRate) {   //check 함수 
					System.out.println("안타! 다음타자가 나와야 합니다.");
					count[1]=0; count[2]=0; count[0]++; print(); break;   //스트라이크,볼 0으로 셋업하고 안타 개수 +1
				}else if(RandomNumber>HitRate && RandomNumber<=(HitRate+BallOrStrike)){
					System.out.println("스트라이크"); 
					count[1]++;  
					print();
					if(count[1]==3) {
						break;
						}else {
							continue; // 스트라이크 +1
						}
				}else if(RandomNumber>(HitRate+BallOrStrike) && RandomNumber<=HitRate+BallOrStrike*2) {
					System.out.println("볼");
					count[2]++;  print();  
					if(count[2]==4) {break;}
					else {
					continue;
					}
				}else if(RandomNumber>=HitRate+BallOrStrike*2 && RandomNumber<1) {
					System.out.println("아웃!");
					count[1]=0; count[3]++;
					print(); 
					break;   //
				}
			}Check();
	}
	private static void Check() {
		if(count[1]==3) {
			count[1]=0;
			count[2]=0;
			count[3]++;  // 스트라이크3개 아웃+1
			System.out.println("스트라이크 3개가되어 아웃이 +1 됬습니다.");
		}
		if(count[2]==4) {
			count[1]=0;
			count[2]=0;
			count[0]++;  // 볼4 안타+1
			System.out.println("볼이 4개가 되어 안타가 +1 됬습니다.");
		}
		if(count[3]==3) {   //아웃3개.
			System.out.println("아웃 3개. 최종 안타수:"+ count[0]);
			System.out.println("GAME OVER");
			
		}
	}
	private static void print() {
		System.out.println(count[1]+"S "+count[2]+"B "+count[3]+"O");
		System.out.println("\n");
	}
}
		



