package leetcode3;

public class CountPrimes {

	public int countPrimes(int n) {
		int res = 0;
        //申请一个足够空间的数组，进行标记
        boolean[] nums = new boolean[n];
        for (int i = 2; i < nums.length; i++) {  //首先标记全部标记为true
            nums[i] = true;
        }

        //遍历数组，采用上述算法，标记是倍数的为false
        for(int i = 2; i*i < nums.length; i++) {
            if (nums[i]) {
                for(int j = i*i; j < nums.length; j+=i) {
                    nums[j] = false;
                }
            }
        }

      //统计出为true的，就是质数的总数
        for(boolean bool : nums) {
           res += bool ? 1 : 0;
        }
        
        return res; 
    }
}
