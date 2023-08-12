package jianzhi_offer.Stack;

import java.util.Stack;

/**
 *定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

/**
 * 解题思路：利用辅助栈来存储现有栈的最小值。在入栈和出栈的时候将现有栈和最小值栈进行比较。
 入栈时，若新值比最小值栈的栈顶还小，则将该值同时push到最小值栈；
 出栈时，若现有栈的栈顶和最小值栈栈顶一致，则同时出栈，
 否则，仅仅现有栈pop；通过这一操作，最小值栈的栈顶将永远是现有栈元素中的最小值。
 */
public class Main_20_包含min函数的栈 {

    public class Solution {
        // 用于存储所有的数据，压入push,弹出pop
        Stack<Integer> data_stack =new Stack<>();
        //用于存储栈最小的值
        Stack<Integer> min_stack = new Stack<>();
        public void push(int node) {
            //如果最小值栈为空或者栈顶值比新入的node值大
            if(min_stack.isEmpty()||min_stack.peek()>=node){
                //压入node，保持栈顶为栈的最小值
                min_stack.push(node);
            }else {
                //否则再次压入栈顶值
                min_stack.push(min_stack.peek());
            }
            //数据都压入data_stack
            data_stack.push(node);
        }
        //出栈
        public void pop() {
            if(data_stack.empty()||min_stack.empty())
            {
                return;
            }
            //弹出数据
            data_stack.pop();
            //弹出min栈顶，此时min_stack的栈顶为弹出某数剩下数的最小值
            min_stack.pop();
        }
        //查看栈的栈顶元素
        public int top() {
            if(!data_stack.isEmpty())
            {
                return data_stack.peek();
            }
            return 0;
        }
        //查看最小的元素，即min_stack的栈顶
        public int min() {
            if(!min_stack.empty())
            {
                return min_stack.peek();
            }
            return 0;
        }
    }
}
