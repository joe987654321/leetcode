package leetcode.practice;

import java.util.Stack;

public class _071SimplifyPath {
    public static void main(String[] args) {
        _071SimplifyPath simplifyPath = new _071SimplifyPath();
        String ret = simplifyPath.simplifyPath("/a/../../b/../c//.//");
        System.out.println(ret);
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (s.length() == 0 || ".".equals(s)) continue;
            if ("..".equals(s)) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
