package leetcode2;

import java.util.Stack;

/**
 * 71.简化路径 
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 
 * @author stick
 *
 */
public class SimplifyPath {

	public String simplifyPath(String path) {
		int len = path.length();
		Stack<String> stack = new Stack<>();
		int i = 0;
		while (i < len) {
			while (i != len - 1 && path.charAt(i + 1) == '/') {
				i++;
			}
			i++;
			if (i == len)
				break;
			StringBuilder a = new StringBuilder();
			while (i < len && path.charAt(i) != '/') {
				a.append(path.charAt(i));
				i++;
			}
			if (a.toString().equals("."))
				continue;
			else if (a.toString().equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.push(a.toString());
		}
		StringBuilder b = new StringBuilder();
		while (!stack.isEmpty()) {
			b.insert(0, stack.pop());
			b.insert(0, '/');
		}
		if (b.toString().equals(""))
			b.append("/");
		return b.toString();
	}

	public static void main(String[] args) {
		SimplifyPath test = new SimplifyPath();
		System.out.println(test.simplifyPath("/a/../../b/../c//.//"));
	}
}
