package com.eriri.DataStructures01_;

import java.util.concurrent.TimeoutException;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class Calculator {
    public static void main(String[] args) {
        String exp = "13+2*6-2";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepnNum = "";

        while (true){
            ch = exp.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else {
                keepnNum += ch;
                if (index == exp.length()-1){
                    numStack.push(Integer.parseInt(keepnNum));
                }else {
                    if (operStack.isOper(exp.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepnNum));
                        keepnNum = "";
                 }
                }
            }
            index++;
            if (index >= exp.length()){
                break;
            }
        }
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("%s = %d", exp, res2);
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public int peek(){
        return stack[top];
    }

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("man");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("kong");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("kong");
            return;
        }
        for (int i=top; i>=0 ;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}