package leetcode3;

public class IsPalindrome {
	public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                ic += ' ';
            }
            if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                jc += ' ';
            }
            if (!(ic >= 'a' && ic <= 'z' || ic >= '0' && ic <= '9')) {
                i++;
                continue;
            }
            if (!(jc >= 'a' && jc <= 'z' || jc >= '0' && jc <= '9')) {
                j--;
                continue;
            }
            if (jc != ic) return false;
            i++;
            j--;
        }
        return true;
    }
}
