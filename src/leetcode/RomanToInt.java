package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13.罗马数字转整数 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12
 * 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 * 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999
 * 的范围内。
 * 
 * @author stick
 *
 */
public class RomanToInt {

	public int romanToInt(String s) {
		int result = 0;
		Map<String, Integer> romanMap = new HashMap<>();
		romanMap.put("M", 1000);
		romanMap.put("CM", 900);
		romanMap.put("D", 500);
		romanMap.put("CD", 400);
		romanMap.put("C", 100);
		romanMap.put("XC", 90);
		romanMap.put("L", 50);
		romanMap.put("XL", 40);
		romanMap.put("X", 10);
		romanMap.put("IX", 9);
		romanMap.put("V", 5);
		romanMap.put("IV", 4);
		romanMap.put("I", 1);
		int i = s.length();
		while (i > 0) {
			if (i > 1 && romanMap.containsKey(s.substring(i - 2, i))) {
				result += romanMap.get(s.substring(i - 2, i));
				i -= 2;
			} else {
				result += romanMap.get(s.substring(i - 1, i));
				i--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RomanToInt test = new RomanToInt();
		System.out.println(test.romanToInt("MCMXCIV"));
	}

}
