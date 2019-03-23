package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		int subMaxLength;
		if (s.length() > 0) {
			subMaxLength = 1;
		} else {
			return 0;
		}
		int maxLength = s.length();
		Set<Character> subSet = new HashSet<>();
		for (int i = 0; i + subMaxLength < maxLength; i++) {
			subSet.add(s.charAt(i));
			for (int j = i + 1; j < maxLength; j++) {
				if (subSet.contains(s.charAt(j))) {
					if (subMaxLength < subSet.size()) {
						subMaxLength = subSet.size();
					}
					subSet.clear();
				} else {
					subSet.add(s.charAt(j));
					if (subMaxLength < subSet.size()) {
						subMaxLength = subSet.size();
					}
				}
			}

		}
		return subMaxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
	}
}
