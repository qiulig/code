package yunqiu.leetcode.Strings;

import java.util.LinkedList;
import java.util.List;


/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     例如，给出 n = 3，生成结果为：
     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
 */
public class Main_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backtrack(res,"",0,0,n);
        return res;
    }

    private static void backtrack(List<String> res, String cur, int left, int right, int n) {
        if(cur.length()==n*2){
            res.add(cur);
            return ;
        }
        if(left<n){
            backtrack(res,cur+"(",left+1,right,n);
        }
        if(right<left)
            backtrack(res,cur+")",left,right+1,n);
    }

    public static void main(String[] args) {
        List<String> s = generateParenthesis(3);
        for(String ss:s){
            System.out.println(ss);
        }
    }
}
