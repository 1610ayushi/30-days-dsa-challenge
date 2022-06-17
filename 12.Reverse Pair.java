/*
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
*/
class Solution {
    public int merge(int[]nums,int low,int mid,int high){
        int count=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high  && nums[i]>(2*(long)nums[j])){
                j++;
            }
            count+=(j-(mid+1));
        }
        //make a temp arraylist 
        ArrayList<Integer>temp=new ArrayList<>();
        int left= low, right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        }
        while(left<=mid){
            temp.add(nums[left++]);
        }
        while(right<=high){
            temp.add(nums[right++]);
        }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
        return count;
        
    }
    
    
    
    //merge sort
    public int  mergeSort(int[]nums,int low,int high){
        if(low>=high)return 0;
        int mid=(low+(high-low)/2);
        int inv= mergeSort(nums,low,mid);
        inv+=mergeSort(nums,mid+1,high);
        inv+=merge(nums,low,mid,high);
        return inv;
    } 
    public int reversePairs(int[] nums) {
        return mergeSort(nums,  0,nums.length-1);
        
    }
}
