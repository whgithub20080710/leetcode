package leetcode3;

/**
 * 171. Excel 表序列号
 * @author stick
 *
 */
public class TitleToNumber {

	public int titleToNumber(String s) {
		int ans = 0;
        for(int i=0;i<s.length();i++) {
        	int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		TitleToNumber test = new TitleToNumber();
		System.out.println(test.titleToNumber("QC"));
	}
}
