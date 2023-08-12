package company.zhaoyin;

import java.util.*;

public class Main_2 {
    static HashMap<String,List<String>> map = new HashMap<>();
    public static void main(String[] args) {
    }
    //根据值获取键
    public static String getType(String url){
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            if(entry.getValue().equals(url)){
               return entry.getKey();
            }
        }
        return "";
    }
    //根据键获取值
    public static List<String> getUrl(String url){
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            if(entry.getKey().equals(url)){
               return  entry.getValue();
            }
        }
        //不存在返回空
        return new ArrayList<>();
    }
}
