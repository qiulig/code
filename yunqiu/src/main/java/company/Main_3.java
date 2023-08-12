package company;
import java.util.Scanner;
import java.util.Stack;
public class Main_3 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        String str = sr.nextLine();
        solution(str);
    }

    public static void solution(String str) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> operStack = new Stack<>();
        int mark = 0;
        int paramOne = 0;
        int paramTwo = 0;
        for(int i = 0;i<str.length();i++){
            char chas = str.charAt(i);
            if(chas == '('){
                //截取符号位
                operStack.push(str.substring(i+1,i+4));
                //这里为空格的索引位置
                i = i + 4;
                //符号位后第一个数字的索引坐标
                mark = i+1;
            }else if(chas == ')'){
                if(mark < i){
                    //所有数字的截取
                    numStack.push(Integer.valueOf(str.substring(mark,i)));
                    i++;
                    mark = i+1;
                }
                //得到一次（）的对应，就进行一次计算
                paramOne = numStack.pop();
                paramTwo = numStack.pop();
                calc(numStack,operStack,paramOne,paramTwo);
            }else{
                //空格位将数字进行区分
                if(chas == ' '){
                    if(mark < i ){
                        numStack.push(Integer.valueOf(str.substring(mark,i)));
                        //下一个数字的索引为空格后面一位，故mark = i+1;
                        mark = i + 1;
                    }
                }
            }
        }
        //如果还有没计算完的，就进行再次计算
        while (!operStack.isEmpty()){
            paramTwo = numStack.pop();
            paramOne = numStack.pop();
            calc(numStack,operStack,paramOne,paramTwo);
        }
    }

    private static void calc(Stack<Integer> numStack, Stack<String> operStack, int paramOne, int paramTwo) {
        switch(operStack.pop()){
            case "add":
                numStack.push(paramOne + paramTwo);
                break;
            case "sub":
                numStack.push(paramOne - paramTwo);
                break;
            case "mul":
                numStack.push(paramOne * paramTwo);
                break;
            case "div":
                if(paramTwo == 0)
                    System.out.println("error");
                else
                    numStack.push(paramOne / paramTwo);
                break;
        }
    }
}
