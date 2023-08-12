package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * ������ʽƥ��
 * ����һ���ַ���s��һ���ַ�����p��������ʵ��һ��֧�� '.'��'*'��������ʽƥ�䡣
 *
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 * ��νƥ�䣬��Ҫ���������ַ���s�ģ������ǲ����ַ�����
 */
public class Main_10_regular_expression_matching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a*"));
    }
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //i= 0��j= 0��ʾstr��patternΪ�մ���ƥ��ɹ���true
        dp[0][0] = true;
        //strΪ�մ���pattern��Ϊ�մ������
        for (int i = 0; i < p.length(); i++) {
            //ǰһ��Ϊtrue��һ��Ϊ*��*ƥ��0����������һ��Ϊtrue
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //��ǰ��ĸƥ�䣬�ַ�str��pattern�����ƶ�һλ
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                //��һ���ַ���*
                if (p.charAt(j) == '*') {
                    //str��pattern��ƥ��
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        //str���䣬pattern���ƶ���λ
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        //ƥ��0�Σ�str������pattern����2λ��ƥ��һ�Σ�str�ƶ�һλ��pattern�ƶ�2λ��ƥ���Σ�str�ƶ�1�Σ�pattern����
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1]);
                    }
                }
            }

        }
        return dp[s.length()][p.length()];
    }
}
