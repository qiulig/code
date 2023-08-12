package yunqiu.leetcode.Strings;
public class Mian_434 {
        public static int countSegments(String s) {
            int count = 0;
            boolean lastIsBlank = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    lastIsBlank = true;
                } else {
                    if (lastIsBlank) {
                        count++;
                    }
                    lastIsBlank = false;
                }
            }
            return count;
        }

    public static void main(String[] args) {
        String s = "";
        System.out.println(countSegments(s));
        System.out.println("".length());
    }
}
