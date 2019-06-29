package leetcode3;

import java.util.Arrays;

public class RotateArray {

	public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        System.out.println(Arrays.toString(nums));
    }
	
	public static void main(String[] args) {
		RotateArray test = new RotateArray();
		test.rotate(new int[] {1,2,3,4,5,6}, 2);
	}
}
