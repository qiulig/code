package jianzhi_offer.Stack;

import java.util.Stack;

/**
 *����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 */

/**
 * ����˼·�����ø���ջ���洢����ջ����Сֵ������ջ�ͳ�ջ��ʱ������ջ����Сֵջ���бȽϡ�
 ��ջʱ������ֵ����Сֵջ��ջ����С���򽫸�ֵͬʱpush����Сֵջ��
 ��ջʱ��������ջ��ջ������Сֵջջ��һ�£���ͬʱ��ջ��
 ���򣬽�������ջpop��ͨ����һ��������Сֵջ��ջ������Զ������ջԪ���е���Сֵ��
 */
public class Main_20_����min������ջ {

    public class Solution {
        // ���ڴ洢���е����ݣ�ѹ��push,����pop
        Stack<Integer> data_stack =new Stack<>();
        //���ڴ洢ջ��С��ֵ
        Stack<Integer> min_stack = new Stack<>();
        public void push(int node) {
            //�����СֵջΪ�ջ���ջ��ֵ�������nodeֵ��
            if(min_stack.isEmpty()||min_stack.peek()>=node){
                //ѹ��node������ջ��Ϊջ����Сֵ
                min_stack.push(node);
            }else {
                //�����ٴ�ѹ��ջ��ֵ
                min_stack.push(min_stack.peek());
            }
            //���ݶ�ѹ��data_stack
            data_stack.push(node);
        }
        //��ջ
        public void pop() {
            if(data_stack.empty()||min_stack.empty())
            {
                return;
            }
            //��������
            data_stack.pop();
            //����minջ������ʱmin_stack��ջ��Ϊ����ĳ��ʣ��������Сֵ
            min_stack.pop();
        }
        //�鿴ջ��ջ��Ԫ��
        public int top() {
            if(!data_stack.isEmpty())
            {
                return data_stack.peek();
            }
            return 0;
        }
        //�鿴��С��Ԫ�أ���min_stack��ջ��
        public int min() {
            if(!min_stack.empty())
            {
                return min_stack.peek();
            }
            return 0;
        }
    }
}
