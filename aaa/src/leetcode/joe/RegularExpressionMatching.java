package leetcode.joe;

import java.util.ArrayList;

public class RegularExpressionMatching {
    public static class Solution {
        public class State {
            ArrayList<Character> toSelf = new ArrayList<Character>();
            Character toNext = null;
            boolean alwaysToNext = false;
            boolean alwaysToSelf = false;
        }

/*
        public boolean isMatch2(String s, String p) {
            if (p.length() == 0) {
                if (s.length() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            ArrayList<State> diagram = new ArrayList<State>();
            int plength = p.length();
            int pIndex = 0;
            //int stateIndex = 0;
            State st = new State();
            while (pIndex < plength) {
                if (pIndex + 1 == plength || p.charAt(pIndex + 1) != '*') {
                    //no * match
                    if (p.charAt(pIndex) != '.') {
                        st.toNext = p.charAt(pIndex);
                    } else {
                        st.alwaysToNext = true;
                    }
                    diagram.add(st);
                    st = new State();
                    pIndex++;
                } else {
                    //next is *
                    if (p.charAt(pIndex) != '.') {
                        st.toSelf.add(p.charAt(pIndex));
                    } else {
                        st.alwaysToSelf = true;
                    }
                    diagram.add(st);
                    st = new State();
                    pIndex+=2;
                }
            }

            if (p.charAt(plength-1) != '*') {
                //boundary case, add state
                diagram.add(st);
            }

            int dsize = diagram.size();
            System.out.println("diagram length is " + dsize);
            for (int i=0;i<dsize;i++) {
                State a = diagram.get(i);
                System.out.println("##");
                System.out.println("always to next: " + a.alwaysToNext);
                System.out.println("always to self: " + a.alwaysToSelf);
                System.out.println("to next character: " + a.toNext);
                System.out.print("to self character, size " + a.toSelf.size() + ", member : ");
                for (Character c: a.toSelf) {
                    System.out.print(c + " ");
                }
                System.out.println("");
            }

            int slength = s.length();
            boolean [][] tracePath = new boolean[slength+1][dsize];
            //start from 0 state
            tracePath[0][0] = true;

            for (int i=1;i<=slength;i++) {
                for (int j=0;j<dsize;j++) {
                    if (tracePath[i-1][j]) {
                       // System.out.println("i is " + i +  " j is " + j);

                        if (diagram.get(j).alwaysToNext) {
                            tracePath[i][j+1] = true;
                        } else if (diagram.get(j).toNext != null && diagram.get(j).toNext.equals(s.charAt(i-1))) {
                            tracePath[i][j+1] = true;
                        }

                        if (diagram.get(j).alwaysToSelf) {
                            tracePath[i][j] = true;
                        } else if (diagram.get(j).toSelf.contains(s.charAt(i-1))){
                            tracePath[i][j] = true;
                        }
                    }
                }
            }

            return tracePath[slength][dsize-1];
        }
*/

        public boolean isMatch(String s, String p) {
            int plength = p.length();
            StringBuilder sb = new StringBuilder();

            char lastCharWithStar = ' ';
            int putStart = 0;
            for (int i=0;i<plength;i++) {
                if (i<plength-1 && p.charAt(i+1) == '*') {
                    if (lastCharWithStar != p.charAt(i) && p.charAt(i) != '.') {
                        sb.append(p.substring(putStart, i));
                    //    System.out.println("append " + p.substring(putStart, i));
                    }

                    lastCharWithStar = p.charAt(i);
                    //System.out.println("last char is " + lastCharWithStar);
                    putStart = i;
                    i++;
                } else {
                   //System.out.println("aaaappend " + p.substring(putStart, i+1));
                    sb.append(p.substring(putStart, i+1));
                    putStart = i+1;
                    lastCharWithStar = ' ';
                }
            }
            sb.append( p.substring(putStart, plength));

            //System.out.println("#" +sb.toString());
            return isMatch2(s, sb.toString());
        }

        public boolean isMatch2(String s, String p) {
            if (p.length() == 0) {
                return s.length()==0;
            } else if (s.length() == 0) {
                int plength = p.length();
                if (plength %2 != 0 ) {
                    return false;
                }
                int i = 0;
                while (i< p.length()) {
                    if (p.charAt(i+1) != '*') {
                        return false;
                    }
                    i+=2;
                }
                return true;
            }

            if (p.length() == 1 || p.charAt(1) != '*') {
                //no * match
                if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                    return isMatch2(s.substring(1), p.substring(1));
                }
            } else {
                //* match
                if (isMatch2(s, p.substring(2))) {
                    return true;
                }
                if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                    return (isMatch2(s.substring(1), p.substring(2)) || isMatch2(s.substring(1), p));
                } else {
                    return false;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("a", "ab*c*"));
    }
}
