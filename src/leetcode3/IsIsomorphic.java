package leetcode3;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		if (s.length() != t.length())
			return false;

		for (int i = 0; i < s.length(); i++) {
			char ss = s.charAt(i);
			char tt = t.charAt(i);
			if (map.containsKey(ss)) {
				if (map.get(ss) != tt)
					return false;
			} else {
				if (map.containsValue(tt))
					return false;
				map.put(ss, tt);
			}

		}
		return true;
	}
	
	public static void main(String[] args) {
		IsIsomorphic test = new IsIsomorphic();
		System.out.println(test.isIsomorphic("abccda", "qczzdq"));
	}
}
