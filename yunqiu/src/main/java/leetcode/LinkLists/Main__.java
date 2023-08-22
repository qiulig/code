package leetcode.LinkLists;

import java.util.ArrayList;
import java.util.HashMap;

public class Main__ {

    public static void solution(int n, int target) {
        HashMap map = new HashMap();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(target - i)) {
                ArrayList tmp = new ArrayList();
                tmp.add(i);
                tmp.add(target - i);
                res.add(tmp);
            } else {
                map.put(target - i, i - 1);
            }
            if (i == target) {
                System.out.println(target);
            }
        }
    }

    public static void main(String args[]) {
        String str = "";
        String[] strr = str.split(",");
        System.out.print(str.length());
    }

}
