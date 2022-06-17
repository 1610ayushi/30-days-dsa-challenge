class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>hashset=new HashSet<Integer>();
        for(int n:nums){
            hashset.add(n);
        }
        int longest=0;
        for(int n:nums){
            if(!hashset.contains(n-1)){
                int currentnum=n;
                int current=1;
                while(hashset.contains(currentnum+1)){
                    currentnum++;
                current++;
            }
            longest=Math.max(longest,current);
        }
        
    }
        return longest;
}
}
