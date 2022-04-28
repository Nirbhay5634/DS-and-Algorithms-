/*

Given an array of elements. Your task is to find the second maximum element in the array.

Example 1:

Input:
N=5
arr[] = { 2, 4, 5, 6, 7 }
Output:  6
Explanation:
The largest element is 7 and 
the second largest element is 6.
 

Example 2:

Input:
N=6
arr[] = { 7, 8, 2, 1, 4, 3 }
Output:  7

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function print2largest() that takes array A and integer N as parameters and returns the second maximum element in the array. If there does not exist any second largest element, then return -1.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 106

*/


//Initial Template for Java


import java.io.*;
import java.util.*;


class Array {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.print2largest(a,n));
        }
        
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    public static int print2largest(int A[],int N) 
    {
        //CODE HERE
        int first=0,second = 0;
        for(int i=0;i<N;i++){
            if(A[i]>first){
                first = A[i];
            }
        }
        for(int i=0;i<N;i++){
            if(A[i]>second && A[i]<first){
                second = A[i];
            }
        }
        if(second==0 || N<2){
            return -1;
        }
        return second;
    }
}
        
