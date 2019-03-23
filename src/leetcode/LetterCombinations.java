package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 示例:
 * 
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 * @author stick
 *
 */
public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() == 0) {
			return result;
		}

		char[] digitsChar = digits.toCharArray();
		for (char c : digitsChar) {
			result = getNewList(result, c);
		}
		return result;
	}

	private List<String> getNewList(List<String> list, char num) {
		List<String> result = new ArrayList<>();
		List<String> numList = new ArrayList<>();
		if (num < '7') {
			numList.add((char) ('a' + (num - '2') * 3) + "");
			numList.add((char) ('b' + (num - '2') * 3) + "");
			numList.add((char) ('c' + (num - '2') * 3) + "");
		} else if (num == '7') {
			numList.add("p");
			numList.add("q");
			numList.add("r");
			numList.add("s");
		} else if (num == '8') {
			numList.add("t");
			numList.add("u");
			numList.add("v");
		} else {
			numList.add("w");
			numList.add("x");
			numList.add("y");
			numList.add("z");
		}
		for (String s : numList) {
			if (list.isEmpty()) {
				result.add(s);
			} else {
				for (String ss : list) {
					result.add(ss + s);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LetterCombinations test = new LetterCombinations();
		System.out.println(test.letterCombinations("23").toString());
	}
}
