/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
*/
class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
    
       ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0)
            return res;
        
        int n = nums.length;
        long target1 =(long)target;
    
        Arrays.sort(nums); 
    
        for (int i = 0; i < n; i++) {
        
            long target_3 = target1 - nums[i];
        
            for (int j = i + 1; j < n; j++) {
            
                long target_2 = target_3 - nums[j];
            
                int front = j + 1;
                int back = n - 1;
            
                while(front < back) {
                
                    int two_sum = nums[front] + nums[back];
                
                    if (two_sum < target_2) front++;
                
                    else if (two_sum > target_2) back--;
                
                    else {
                    
                        List<Integer> quad = new ArrayList<>(); 
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);
                    
                        // Processing the duplicates of number 3
                        while (front < back && nums[front] == quad.get(2)) front++;
                    
                        // Processing the duplicates of number 4
                        while (front < back && nums[back] == quad.get(3)) back--;
                
                    }
                }
                
                // Processing the duplicates of number 2
                while(j + 1 < n && nums[j + 1] == nums[j]) j++;
            }
        
            // Processing the duplicates of number 1
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        
        }
        
    
        return res;
    }
}
