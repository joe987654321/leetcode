package leetcode.joe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Joe on 2017/6/4.
 */
public class FindDuplicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ret = new ArrayList<>();
        if (paths.length == 0) {
            return ret;
        }
        Map<String, List<String>> contentToNames = new HashMap<>();
        for (String path: paths) {
            int indexSpace = path.indexOf(" ");

            String dirname = path.substring(0, indexSpace) + "/";
            while(indexSpace != -1) {
                int indexLeft = path.indexOf("(", indexSpace);
                int indexRight = path.indexOf(")", indexSpace);

                String fileName = dirname + path.substring(indexSpace + 1, indexLeft);

                String content = path.substring(indexLeft + 1, indexRight);

                List<String> tmpList = contentToNames.get(content);
                if (tmpList == null) {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(fileName);
                    contentToNames.put(content, tmp);
                } else {
                    tmpList.add(fileName);
                }

                indexSpace = path.indexOf(" ", indexRight);

            }
        }
        for (List<String> list: contentToNames.values()) {
            if (list.size() >= 2) {
                ret.add(list);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        FindDuplicateFileinSystem findDuplicateFileinSystem = new FindDuplicateFileinSystem();
        String [] s = {"root/a 1.txt(abcd) 2.txt(efghe)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicateFileinSystem.findDuplicate(s));
    }
}
