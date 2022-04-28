/*

Given an array A of N integers, find any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k.

Example 1:

Input:
N = 5
A[] = {1,2,1,1,3}
Output: 1
Explanation: a sub-sequence 1 2 3 exist.
Example 2:

Input:
N = 3
A[] = {1,1,3}
Output: 0
Explanation: no such sub-sequence exist.
Your Task:
Your task is to complete the function find3Numbers which finds any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k. You need to return them as a vector/ArrayList/array (depending on the language cpp/Java/Python), if no such element is present then return the empty vector of size 0.

Note: The output will be 1 if the sub-sequence returned by the function is present in array A else 0. If the sub-sequence returned by the function is not in the format as mentioned then the output will be -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
1 <= A[i] <= 106, for each valid i

*/

import java.util.*;
import java.io.*;
class SubSeq {
    public static boolean isSubSequence(ArrayList<Integer> v1, ArrayList<Integer> v2,
                                 int n, int m) {

        if (m == 0) return true;
        if (n == 0) return false;

        if (v1.get(n - 1).equals(v2.get(m - 1)))
            return isSubSequence(v1, v2, n - 1, m - 1);

        return isSubSequence(v1, v2, n - 1, m);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(str[i]));
            }
            Solution g = new Solution();
            ArrayList<Integer> res = g.find3Numbers(a, n);

            // wrong format output
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            }

            if (res.isEmpty()) {
                System.out.println(0);
            } else if ((res.get(0) < res.get(1)) && (res.get(1) < res.get(2)) &&
                       isSubSequence(a, res, n, res.size())) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        ArrayList<Integer> al = new ArrayList<>();
        int min = 0,max=n-1;
        int mina[]  = new int[n];
        int maxa[] = new int[n];
        mina[0] = -1;
        maxa[n-1] = -1;
        for(int i=1;i<n;i++){
            if(arr.get(i)<=arr.get(min))
            {
                mina[i] = -1;
                min = i;
            }
            else{
                mina[i] = min;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr.get(i)>=arr.get(max))
            {
                maxa[i] = -1;
                max = i;
            }
            else{
                maxa[i] = max;
            }
        }
        for(int i=0;i<n;i++){
            if(mina[i]!=-1 && maxa[i]!=-1){
                al.add(arr.get(mina[i]));
                al.add(arr.get(i));
                al.add(arr.get(maxa[i]));
                break;
            }
        }
        return al;
    }
}
