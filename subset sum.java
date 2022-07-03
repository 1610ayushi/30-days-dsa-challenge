class Solution{
    void func(int ind, int sum, ArrayList<Integer>arr,int N, ArrayList<Integer>sumsubset){
        if(ind==N){
            sumsubset.add(sum);
            return ;
        }
        func(ind+1,sum+arr.get(ind),arr,N,sumsubset);
        func(ind+1,sum,arr,N,sumsubset);
        
    }
    
    
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer>sumsubset=new ArrayList<>();
        Collections.sort(sumsubset);
        func(0,0,arr,N,sumsubset);
        return sumsubset;
        
    }
}
