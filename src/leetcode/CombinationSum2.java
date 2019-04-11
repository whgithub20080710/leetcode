package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.数组总和2
 * 
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。
 * 
 * @author stick
 *
 */
public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combinationSum2DFS(result, new ArrayList<Integer>(), 0, candidates, target);
        return result;
	}
	
	private void combinationSum2DFS(List<List<Integer>> result, ArrayList<Integer> levelList, int index, int[] candidates, int target) {
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int cur = candidates[i];
            levelList.add(cur);
            int remain = target - cur;
            if (remain == 0) {
                result.add(new ArrayList<>(levelList));
            } else if (remain > 0) {
                combinationSum2DFS(result, levelList, i + 1, candidates, remain);
            }
            levelList.remove(levelList.size() - 1);
        }
    }
	
	public static void main(String[] args) {
		CombinationSum2 test = new CombinationSum2();
		System.out.println(test.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8).toString());
	}
}
