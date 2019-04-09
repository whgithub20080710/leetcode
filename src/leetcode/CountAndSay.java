package leetcode;

/**
 * 38. 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * @author stick
 *
 */
public class CountAndSay {
	
	public String countAndSay(int n) {
        String str = "1";
        char index; // 当前值
        int count = 1; // 计数器，当前值重复次数

        for (int i = 1; i < n; i++, count = 1) {
            StringBuilder sBuilder = new StringBuilder();
            index = str.charAt(0);
            // 生成字符串
            for (int j = 1; j < str.length(); j++) {
                // 逐个对比，相同增加次数，否则添加内容并清空计数器，更改index
                if (index == str.charAt(j)) {
                    count++;
                } else {
                    sBuilder.append(count).append(index);
                    index = str.charAt(j);
                    count = 1;
                }
            }
            // 导出字符串
            sBuilder.append(count).append(index);
            str = sBuilder.toString();
        }

        return str;
    }
	
	public static void main(String[] args) {
		CountAndSay test= new CountAndSay();
		System.out.println(test.countAndSay(4));
	}
}
