package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @author stick
 *
 */
public class PermuteII {
	
	List<List<Integer>> results;
    public List<List<Integer>> permuteUnique(int[] nums) {
        results=new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        build(nums,used,new ArrayList<Integer>(nums.length));
        return results;
    }
    
    private void build(int[] nums,boolean[] used,List<Integer> result){
         if(result.size()==nums.length){
            results.add(new ArrayList(result));
            return;
            }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                if(i!=0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
                }
                result.add(nums[i]);
                used[i]=true;
                build(nums,used,result);
                used[i]=false;
                result.remove(result.size()-1);
            }   
        }
    } 
    
    public static void main(String[] args) {
    	PermuteII test = new PermuteII();
    	System.out.println(test.permuteUnique(new int[] { 1, 1, 3 }).toString());
	}
}
