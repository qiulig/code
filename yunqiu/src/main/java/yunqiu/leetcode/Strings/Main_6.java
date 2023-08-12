package yunqiu.leetcode.Strings;

public class Main_6 {
//    public static String convert(String s, int numRows) {
//       if(s.length()<=numRows){
//           return s;
//       }
//       StringBuilder sb = new StringBuilder();
//       for(int i = 0;i<s.length();i += (2*numRows-2)){
//           sb.append(s.charAt(i));
//       }
//       for(int i = 1;i<numRows;i++){
//           for(int j = i;j< s.length();j++){
//               if((j-i)%(2*numRows-2)==0||(j+i)%(2*numRows-2)==0)
//                    sb.append(s.charAt(j));
//           }
//       }
//
//    return sb.toString();
//    }
//    假设当前行数是r，总行数R，I(n)表示某行第n个字母在原字符串中的index，n从0开始：
//    r=1,R时，I(n+1) = I(n)+2(R-1)
//            1<r<R时，
//    I(n+1) = I(n)+2(R-r) n为偶数时，
//    I(n+1) = I(n)+2(r-1) n为奇数
    public static String convert(String s, int numRows) {

            if(s==null||s.length()==0||numRows==1||numRows>=s.length()) {
                return s;
            }
            StringBuilder sb = new StringBuilder();

            for(int i=1;i<s.length()+1;i+=2*(numRows-1)) {
                sb.append(s.charAt(i-1));
            }
            for(int i=2;i<numRows;i++) {
                boolean flag = true;
                for(int j=i;j<s.length()+1;j+=(flag)?2*(numRows-i):2*(i-1),flag=!flag) {
                    sb.append(s.charAt(j-1));
                }
            }
            for(int i=numRows;i<s.length()+1;i+=2*(numRows-1)) {
                sb.append(s.charAt(i-1));
            }
            return sb.toString();
        }
    public static void main(String[] args) {

        System.out.println(convert("LEETCODEISHIRING",3));
    }
}
