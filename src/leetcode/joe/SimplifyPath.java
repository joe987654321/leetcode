package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2017/7/24.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return null;
        }

        List<String> paths = new ArrayList<>();

        int index = 0;
        int next = path.indexOf('/', index+1);
        while (next != -1) {
            String tmp = path.substring(index, next);
            if (tmp.equals("/..")) {
                if (paths.size() > 0) {
                    paths.remove(paths.size()-1);
                }
            } else if (!tmp.equals("/.") && !tmp.equals("/")) {
                paths.add(tmp);
            }
            index = next;
            next = path.indexOf('/', index+1);
        }

        String tmp = path.substring(index, path.length());
        if (tmp.equals("/..")) {
            if (paths.size() > 0) {
                paths.remove(paths.size()-1);
            }
        } else if (!tmp.equals("/.") && !tmp.equals("/")) {
            paths.add(tmp);
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < paths.size(); i++) {
            sb.append(paths.get(i));
        }

        String ret = sb.toString();
        if (ret.isEmpty()) {
            return "/";
        }
        return ret;
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/abc/def/../uio"));
        System.out.println(simplifyPath.simplifyPath("/"));
        System.out.println(simplifyPath.simplifyPath("/.."));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/abc//def"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
    }
}
