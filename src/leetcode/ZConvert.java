package leetcode;

/**
 * 6.Z字形变换 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L C I R E T O E S I I G E D H N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * @author stick
 *
 */
public class ZConvert {

	public static String convert(String s, int numRows) {
		StringBuffer begin = new StringBuffer();
		StringBuffer end = new StringBuffer();
		int length = s.length();
		if (length <= numRows || numRows == 1) {
			return s;
		}
		for (int i = 0; i <= length / numRows; i++) {
			int beginIndex = i * (numRows - 1) * 2;
			int endIndex = beginIndex + numRows - 1;
			if (beginIndex < length) {
				begin.append(s.charAt(beginIndex));
			}
			if (endIndex < length) {
				end.append(s.charAt(endIndex));
			}

		}
		StringBuffer middle = new StringBuffer();
		int x = (numRows - 1) * 2;
		for (int j = 1; j < numRows - 1; j++) {
			int middleIndex1 = j;
			int middleIndex2 = j + (numRows - 1 - j) * 2;
			while (middleIndex1 < length || middleIndex2 < length) {
				if (middleIndex1 < length) {
					middle.append(s.charAt(middleIndex1));
				}
				if (middleIndex2 < length) {
					middle.append(s.charAt(middleIndex2));
				}
				middleIndex1 = middleIndex1 + x;
				middleIndex2 = middleIndex2 + x;
			}

		}
		return begin.append(middle).append(end).toString();
	}

	public static void main(String[] args) {
		// System.out.println(convert("ABC",2));
		System.out.println(convert2("LEETCODEISHIRING", 4));
	}

	public static String convert2(String s, int numRows) {

		if (numRows == 1)
			return s;

		StringBuilder ret = new StringBuilder();
		int n = s.length();
		int cycleLen = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += cycleLen) {
				ret.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
					ret.append(s.charAt(j + cycleLen - i));
			}
		}
		return ret.toString();
	}
}
