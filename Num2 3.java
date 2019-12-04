package BaseBall;

import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Num2 {
	static Scanner scan = new Scanner(System.in);
	static String[] TeamName = new String[2];
	static String[][] MemberName = new String[2][9];
	static double[][] HitRate = new double[2][9];
	static String[] ArrayAbc;
	static int[] count = {0,0,0,0}; //안타,스트라이크,볼,아 	
	static int[] HitNumber = {0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Execute();
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
				for(int b=0;b<9;b++) {
					ExceptionInput(a,b);
				}
		}
	}
	public static void ExceptionInput(int a,int b) {	
		try {
			Input(a,b);
		}catch(IndexOutOfBoundsException e) {
			System.out.print(" ,를 다시 입력해주세요.");
			Input(a,b);
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
			for(int b=0;b<9;b++) {
				System.out.println(b+1 + "번,"+ MemberName[a][b]+","+HitRate[a][b]);	
			}
		}
	}
	
	public static void Match() {
		for(int number=0;number<6;number++){
					SetCountZero();
					AttackFirstTeam(0,number);
					SetCountZero();
					AttackSecondTeam(1,number);
			}
		PrintHitNumber();
	}
	public static void SetCountZero() {
		for(int number=0;number<4;number++) {
				count[number]=0;
			}
	}
/*	public static void SetCount() {
		for(int number=0;number<3;number++) {
				count[number]=0;
			}
	}*/
	public static void PrintHitNumber() {
		if((HitNumber[0]/4)!=HitNumber[1]/4){
			System.out.println(TeamName[0]+"VS"+TeamName[1]);
			System.out.println(HitNumber[0]/4+" : "+HitNumber[1]/4);
		}else{
			System.out.println("무승부입니다.");
		}
	}
	
	 private static void AttackFirstTeam(int a,int number) {
		 System.out.println(number+1+"회초 "+TeamName[a]+"의 공격");
			for(int b=0;b<9;b++) {
				System.out.println(b+1+"번 "+MemberName[a][b]);
				Run(HitRate[a][b],0);					
					if(count[3]==3) {
						break;
					}
					if(b==8) {
						b=-1;;
					}
			}
	}
	 private static void AttackSecondTeam(int a,int number) {
		 System.out.println(number+1+"회말 "+TeamName[a]+"의 공격");
		 for(int b=0;b<9;b++) {
			 System.out.println(b+1+"번"+MemberName[a][b]);
			 Run(HitRate[a][b],1);					
				if(count[3]==3) {
					break;
				}
				if(b==8) {
					b=-1;;
				}
			}
	 }
	private static void Run(double HitRate,int a) {
			while(true) {	
				double RandomNumber = Math.random();  //static int[] count = {0,0,0,0}; //안타,스트라이크,볼,아웃순서
				double BallOrStrike= (1-HitRate)/2 - 0.05;
					if(RandomNumber<=HitRate) {   
						Hit(a);
						print(); break;   
					}else if(RandomNumber>HitRate && RandomNumber<=(HitRate+BallOrStrike)){
						Strike();
						print();
						if(count[1]==3) {count[1]=0; count[3]++; break;}
						else {continue;}
					}else if(RandomNumber>(HitRate+BallOrStrike) && RandomNumber<=HitRate+BallOrStrike*2) {	
						Ball();
						print();  
						if(count[2]==4){count[2]=0; count[0]++; HitNumber[a]++; break;}
						else {continue;}
					}else if(RandomNumber>=HitRate+BallOrStrike*2 && RandomNumber<1) {
						Out();
						print(); break;   
					}
			} 
	}
	
	private static void Ball() {
		System.out.println("볼");
		count[2]++; 
	}
	private static void Hit(int a) {
		System.out.println("안타!");
		count[1]=0; 
		count[2]=0; 
		count[0]++;
		HitNumber[a]++;
	}
	private static void Strike() {
		System.out.println("스트라이크"); 
		count[1]++;
	}
	private static void Out() {
		System.out.println("아웃!");
		count[1]=0; 
		count[3]++;
	}
	
	private static void print() {
		System.out.println(count[1]+"S "+count[2]+"B "+count[3]+"O");
	}
}
		



