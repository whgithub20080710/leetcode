package leetcode2;

/**
 * 58.最后一个单词长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * @author stick
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				if (count == 0)
					continue;
				else
					break;
			} else
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		LengthOfLastWord test = new LengthOfLastWord();
		System.out.println(test.lengthOfLastWord("hellow world"));
	}
}
