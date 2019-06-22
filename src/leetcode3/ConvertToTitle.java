package leetcode3;

/**
 * 168. Excel 列表名称
 * @author stick
 *
 */
public class ConvertToTitle {

	public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
		while(n!=0){
			n-=1;
			sb.append((char)(n%26+'A'));
			n/=26;
		}
		return sb.reverse().toString();

    }
	
	public static void main(String[] args) {
		ConvertToTitle test = new ConvertToTitle();
		System.out.println(test.convertToTitle(444));
	}
}
