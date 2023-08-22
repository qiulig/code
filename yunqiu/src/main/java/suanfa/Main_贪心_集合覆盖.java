package suanfa;

import java.util.*;

//集合覆盖
//假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 如何选择最少的广播台，让所有的地区都可以接收到信号。
//        广播台	覆盖地区
//        K1	     ID,NV,UT
//        K2	     WA,ID,MT
//        K3	     OR,NV,CA
//        K4	     NV,UT
//        K5	     CA,AZ
//
public class Main_贪心_集合覆盖 {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        broadcasts.put("K1", new HashSet(Arrays.asList(new String[]{"ID", "NV", "UT"})));
        broadcasts.put("K2", new HashSet(Arrays.asList(new String[]{"WA", "ID", "MT"})));
        broadcasts.put("K3", new HashSet(Arrays.asList(new String[]{"OR", "NV", "CA"})));
        broadcasts.put("K4", new HashSet(Arrays.asList(new String[]{"NV", "UT"})));
        broadcasts.put("K5", new HashSet(Arrays.asList(new String[]{"CA", "AZ"})));

        //需要覆盖的全部地区
        HashSet<String> allAreas = new HashSet<>(Arrays.asList(new String[]{"ID", "NV", "UT", "WA", "MT", "OR", "CA", "AZ"}));
        //所选择的广播台列表
        List<String> lists = new ArrayList<>();
        //(1) 选出一个广播台，即它覆盖了最多未覆盖的地区即便包含一些已覆盖的地区也没关系
        // (2) 重复第一步直到可以覆盖了全部的地区
        HashSet<String> tempSet = new HashSet<>();
        String maxKey = null;
        while (allAreas.size() != 0) {
            maxKey = null;
            //一轮轮选出（之前未覆盖的）数量最多的电台
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出2个集合的交集，得到的交集的电台存在tempSet里面
                tempSet.retainAll(allAreas);
                //如果该集合包含的地区数量比原本的集合多
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    //得到要存入的电台key
                    maxKey = key;
                }

            }
            //找到未覆盖电台数的最大的那个电台
            if (maxKey != null) {
                lists.add(maxKey);
                //将覆盖地区移除allAreas
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.print("selects:" + lists);

    }
}
