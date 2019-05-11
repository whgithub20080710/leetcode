package leetcode2;

public class SortColors {

	public void sortColors(int[] nums) {
        // 三指针
        int i=0, l=0, r=nums.length-1;
        while(i<=r){
            if(i<l || nums[i]==1)
                i++;
            else if(nums[i]==0)
                swap(nums,i,l++);
            else if(nums[i]==2)
                swap(nums,i,r--);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        if(i==j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
