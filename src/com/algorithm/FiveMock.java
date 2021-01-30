package com.algorithm;

import java.util.Scanner;
public class FiveMock {
	    static int[][] arr = new int[19][19];
	    static int[] dx = {-1, 0, 1, 1};
	    static int[] dy = {1, 1, 1, 0};
	    
	    public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int winnerX=0, winnerY=0, winner = 0;
	        for(int i = 0; i<19; i++){
	            for(int j = 0; j<19; j++){
	                arr[i][j] = sc.nextInt();
	            }
	        }
	        
	        a:for(int i = 0; i<19; i++){
	            for(int j = 0; j<19; j++){
	                if(arr[i][j] == 0)
	                    continue;
	                else{
	                    for(int k = 0; k<4; k++){ // k = 방향
	                        int tmp = find(i, j, k, arr[i][j]);
	                        if(tmp == 5){
	                            // 그 전 방향이 1/2인지 체크
	                            if(check(i, j, k, arr[i][j])){    // 그냥5
	                                winner = arr[i][j];
	                                winnerX = i+1;
	                                winnerY = j+1;
	                                break a;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        System.out.println(winner);
	        if(winner!=0){
	            System.out.println(winnerX+" "+winnerY);
	        }
	    }  
	    static boolean check(int i, int j, int dir, int num){     
	        int nextI = i - dx[dir];
	        int nextJ = j - dy[dir];
	        
	        if(nextI>=0 && nextJ>=0 && nextI<19 && nextJ<19){
	            if(arr[nextI][nextJ] == num)
	                return false;
	        }
	        return true;
	    }
	    
	    static int find(int i, int j, int dir, int num){
	        if( i<0 || j < 0 || i>=19 || j>=19 || arr[i][j] != num ){
	            return 0;
	        }
	        int nextI = i + dx[dir];
	        int nextJ = j + dy[dir];
	        
	        return find(nextI, nextJ, dir, num)+1;
	        
	    }
}