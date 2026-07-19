class Solution {
    public int removeElement(int[] nums, int val) {
        int target=-1;
        int count =nums.length;
    
    for(int i=0;i<count;i++){
            if(nums[i]==val){
                target=i;
            
            
        
        
            for(int j = target;j<count-1;j++){
                nums[j]=nums[j+1];
            }   

            count--;
            i--;
    
    }
    }
        return count;   

}
}