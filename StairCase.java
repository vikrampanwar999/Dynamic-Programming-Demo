package com;

import java.util.HashMap;
import java.util.Map;

public class StairCase {

	public static void main(String[] args) {
		int ans=stepPerms(5);
		System.out.println(ans);
		

	}
    static int stepPerms(int n) {
     int d=0;
     Map<Integer,Integer> m=new HashMap<>();
         return TotalPerms(n,d,m);
            
 }
 static int TotalPerms(int n , int perms,Map m){
         if(n<0)return 0;
         if(n==1||n==0)return 1;
         if(m.containsKey(n))return (int)m.get(n);
         perms=TotalPerms(n-1,perms,m)+TotalPerms(n-2,perms,m)+TotalPerms(n-3,perms,m);
         m.put(n,perms);
         return perms;
 }

}
/*Davis has a number of staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase, module  on a new line.

*For example, there is s=1 staircase in the house that is n=5 steps high. Davis can step on the following sequences of steps:
1 1 1 1 1
1 1 1 2
1 1 2 1 
1 2 1 1
2 1 1 1
1 2 2
2 2 1
2 1 2
1 1 3
1 3 1
3 1 1
2 3
3 2
There are 13 possible ways he can take these 5 steps
*/
