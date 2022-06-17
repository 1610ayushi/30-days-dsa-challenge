/*
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.
*/
class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer>sumze=new HashMap<Integer,Integer>();
        int maxi=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                maxi=i+1;
            }
            else{
                if(sumze.get(sum)!=null){
                    maxi=Math.max(maxi,i-sumze.get(sum));
                }
                else{
                    sumze.put(sum ,i);
                }
            }
            
        }
        return maxi;
        
    }
}
