package leetcode.joe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by joe321 on 2017/1/28.
 */
public class FlattenNestedListIterator {

    public static interface NestedInteger {

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
    }

    public static class NestedIntegerImpl implements NestedInteger {

        Integer integer;
        boolean isInteger;
        List<NestedInteger> list;

        NestedIntegerImpl(Integer i) {
            integer = i;
            isInteger = true;
        }

        NestedIntegerImpl(List<NestedInteger> list0) {
            list = list0;
            isInteger = false;
        }

        @Override
        public boolean isInteger() {
            return isInteger;
        }

        @Override
        public Integer getInteger() {
            return integer;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }

        public String toString() {
            if (isInteger) {
                return integer.toString();
            } else {
                StringBuilder sb = new StringBuilder("[");
                for(NestedInteger n: list) {
                    sb.append(n.toString());
                    sb.append(",");
                }
                sb.append("]");
                return sb.toString();
            }
        }
    }

    public static class NestedIterator implements Iterator<Integer> {

        private void fillIn(ArrayList<Integer> list, List<NestedInteger> input) {
            if (input.isEmpty()) {
                return;
            }
            for (NestedInteger ni : input) {
                if (ni.isInteger()) {
                    list.add(ni.getInteger());
                } else {
                    fillIn(list, ni.getList());
                }
            }
        }

        Integer [] innerArray;
        int index = 0;
        int size;

        public NestedIterator(List<NestedInteger> nestedList) {
            ArrayList<Integer> list = new ArrayList<>();
            fillIn(list, nestedList);
            innerArray = list.toArray(new Integer[0]);
            size = list.size();
        }

        @Override
        public Integer next() {
            Integer integer = innerArray[index];
            index++;
            return integer;
        }

        @Override
        public boolean hasNext() {
            if (index < size) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        NestedInteger a1 = new NestedIntegerImpl(1);
        NestedInteger a2 = new NestedIntegerImpl(2);
        NestedInteger a3 = new NestedIntegerImpl(3);
        NestedInteger a4 = new NestedIntegerImpl(4);
        NestedInteger a5 = new NestedIntegerImpl(5);

        List<NestedInteger> tmp = new ArrayList<NestedInteger>();
        tmp.add(a4);
        NestedInteger c4 = new NestedIntegerImpl(tmp);

        tmp = new ArrayList<NestedInteger>();
        tmp.add(a2);
        tmp.add(a3);
        tmp.add(c4);
        NestedInteger b2 = new NestedIntegerImpl(tmp);

        tmp = new ArrayList<NestedInteger>();
        tmp.add(a1);
        tmp.add(b2);
        tmp.add(a5);

//        NestedInteger out = new NestedIntegerImpl(tmp);
//        System.out.println(out.toString());

        NestedIterator it = new NestedIterator(tmp);
        while(it.hasNext()) {
            System.out.println(it.next());
        }
     }
}
