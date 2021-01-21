package com.algorithm;

import java.util.Scanner;

public class Onoff {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int switNum = sc.nextInt();			// 스위치개수
		int[] switchs = new int[switNum+1];	// index0: dummy

		for(int i = 1; i<switNum+1; i++) {	// 스위치 상태 입력
			switchs[i] = sc.nextInt();
		}
		
		int stuNum = sc.nextInt();		// 학생 수
		Student[] students = new Student[stuNum];
		
		for(int i = 0; i<stuNum; i++) {	// 학생 입력
			int sex = sc.nextInt();
			int num = sc.nextInt();
			students[i] = new Student(sex, num);
		}
		
		for(int i = 0; i<stuNum; i++) {	// 스위치 조작
			if(students[i].sex == 1) {
				// 남학생
				switchs = boy(switchs, students[i].num);
			}
			else {
				// 여학생
				switchs = girl(switchs, students[i].num);
			}
		}
		
		// 출력
		for(int i = 1; i<switchs.length; i++) {
			System.out.print(switchs[i]+" ");
		}
	}
	
	static int[] girl(int[] origin, int num) {
		int[] res = new int[origin.length];
		int size = origin.length;
		// copy
		for(int i = 0; i<size; i++) {
			res[i] = origin[i];
		}
		
		// 구간 찾기
		int range = 0;
		for(int i = 1; i<size/2; i++) {
			if(num-i>0 && num+i<size) {	// 범위 체크
				if(res[num-i] != res[num+i]) {
					break;
				}		
				else range++;
			}
		}
		
		// 스위치 값 바꾸기
		for(int i = num-range; i<=num+range; i++) {
			if(res[i] == 0) res[i] = 1;
			else if(res[i] == 1) res[i] = 0;
		}
		return res;
	}
	
	static int[] boy(int[] origin, int num) {
		int[] res = new int[origin.length];
		// copy
		for(int i = 0; i<origin.length; i++) {
			res[i] = origin[i];
		}
		
		for(int i = 1; i*num<origin.length; i++) {
			if(res[i*num] == 0) res[i*num] = 1;
			else if(res[i*num] == 1) res[i*num] = 0;
		}
		return res;
	}
	
	static class Student{
		int sex;
		int num;
		Student(int sex, int num){
			this.sex = sex;
			this.num = num;
		}
	}

}
