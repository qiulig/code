package yunqiu.leetcode.Strings;

/**
 * 字符串转换成整数
 */
public class Main_8 {
    public static int myAtoi(String s) {
        String str = s.trim();
        if(str.length()==0||str == null)
            return 0;
        if(str.length()==1&&(str.charAt(0)=='+'||str.charAt(0)=='-'))
            return 0;
        int flag = 1;
        if(str.charAt(0)=='+'&& (str.charAt(1)>='0'&&str.charAt(1)<='9')){
            return Cal(flag,str,1,str.length());
        }else if(str.charAt(0)=='-'&&(str.charAt(1)>='0'&&str.charAt(1)<='9')){
            flag = -1;
            return Cal(flag,str,1,str.length());
        }else if((str.charAt(0)>='0'&&str.charAt(0)<='9')){
            return Cal(flag,str,0,str.length());
        }else{
            return 0;
        }
    }
    private static int Cal(int flag,String str, int start, int end) {
        int res = 0;
        for(int i = start;i<end;i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
                int pop = str.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                    if(flag==1) {
                        return Integer.MAX_VALUE;
                    }else{
                        return Integer.MIN_VALUE;
                    }
                }
                res = res*10 +pop;
            }else{
                break;
            }
        }
        return flag*res;
    }
    public static int myAtoi2(String str) {
        int i = 0, j = 0, len = str.length();
        boolean negative = false;
        for (i = 0; i < len; i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j = i; j < len; j++) {
            if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
                break;
            }
        }
        int ret = 0;
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                //这里判断溢出的情况和第7题一样
                if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && cur < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && cur > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("  -91283472332 "));
        System.out.println(myAtoi2("  -91283472332 "));
    }
}
