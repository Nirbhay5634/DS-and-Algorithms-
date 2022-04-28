/*

Given an array consisting of only prime numbers, remove all duplicate numbers from it. 

Example 1:

Input:
N = 6
A[] = {2,2,3,3,7,5}
Output: 2 3 7 5
Explanation: After removing the duplicate
2 and 3 we get 2 3 7 5.
Your Task:

Complete the function removeDuplicate() that takes the array of integers and N as input parameters and returns the modified array which has no duplicates. Retain only the first occurrence of the duplicate element. The elements in the returning array should be in the same order as they appear in the original array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1<=N=106
2<=A[i]<100

*/


import java.util.*;
import java.util.Scanner;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            Solution g = new Solution();
            ArrayList<Integer> result = new ArrayList<Integer>();
            result = g.removeDuplicate(arr,n);
            
            for(int i=0;i<result.size();i++)
                System.out.print(result.get(i) + " ");
            System.out.println();
        t--;
        }
    }
}


// } Driver Code Ends


class Solution
{
    ArrayList<Integer> removeDuplicate(int arr[], int n)
    {
        // code here 
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!al.contains(arr[i])){
                al.add(arr[i]);
            }
        }
        return al;
    }
}
