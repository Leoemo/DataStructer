import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 利用栈实现后缀表达式计算
 */
public class PoLandNotation {

    public static void main(String[] args) {

        //将中缀先转换为后缀表达式
        String infix = "324 / ( ( 30 - 12 ) * ( 6 + 12 ) )";
        System.out.println("中缀表达式："+ infix);
        ArrayList<String> arrayList = infixToSuffix(infix);
        System.out.println("后缀表达式："+arrayList);
        //利用后缀表达式计算结果
        System.out.println("计算结果为："+getPolandNotationValue(arrayList));


    }

    //判断是否是操作符
    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")");
    }

    //获取操作符的优先级别
    private static int getPriority(String elem) {
        if (elem.equals("+") || elem.equals("-")) {
            return 0;
        }
        if (elem.equals("*") || elem.equals("/")) {
            return 1;
        }
        if (elem.equals("(") || elem.equals(")")) {
            return 2;
        }
        throw new RuntimeException("操作符有误");
    }

    //将中缀表达式转换为后缀表达式，返回后缀表达式
    private static ArrayList<String> infixToSuffix(String suffix) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] s = suffix.split(" ");

        //num代表操作数栈，operator代表操作符栈
        Stack<String> num = new Stack<>();
        Stack<String> operator = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            String elem = s[i];
            if (elem.matches("\\d+")) {//匹配是否是操作数类型
                num.push(elem);
                continue;
            } else if (isOperator(elem)) { //类型为操作符
                //当前操作符为左括号或者当前操作符栈为空时，直接将当前遍历到的操作符压入符号栈
                if (operator.isEmpty() || "(".equals(operator.peek())) {
                    operator.push(elem);
                    continue;
                }
                //当前操作符为右括号时，将符号栈元素依次压入操作数栈，直到出现左括号
                if (")".equals(operator.peek())) {
                    while (true) {
                        num.push(operator.pop());
                        if ("(".equals(operator.peek()))
                            break;
                    }
                }

                int stackTopPriority = getPriority(operator.peek());
                int curElemPriority = getPriority(elem);
                //当前操作符优先级大于栈顶符号优先级时，将当前操作符压入符号栈
                if (curElemPriority > stackTopPriority) {
                    operator.push(elem);
                    continue;
                }
                //否则将符号栈顶元素压入操作数栈，并回退到当前操作符重新判断其与新符号栈顶部元素优先级
                else {
                    num.push(operator.pop());
                    i--;
                }
            }
        }
        //遍历完成后，将符号栈元素依次取出压入操作数栈
        while (!operator.isEmpty()) {
            num.push(operator.pop());
        }
        //添加栈元素至list，再反转输出
        while (!num.isEmpty()) {
            String pop = num.pop();
            if(pop.equals("(") || pop.equals(")"))
                continue;
            arrayList.add(pop);
        }
        Collections.reverse(arrayList);
        return arrayList;
    }


    //计算后缀表达式的计算值
    private static int getPolandNotationValue(ArrayList<String> listString) {
        Stack<String> stack = new Stack<>();
        for (String elem : listString) {
            if (elem.matches("\\d+")) {//正则表达式，通配多位数字的字符串，数字则压栈
                stack.push(elem);
            }
            //操作符则弹出栈顶两元素，并判断当前操作符类型，再进行计算
            else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (elem.equals("+")) {
                    res = num1 + num2;
                } else if (elem.equals("-")) {
                    res = num2 - num1;
                } else if (elem.equals("*")) {
                    res = num1 * num2;
                } else if (elem.equals("/")) {
                    res = num2 / num1;
                }
                //结果压回栈中
                stack.push(res + "");
            }

        }
        //遍历结束后栈中只有最终的结果，弹出即可
        return Integer.parseInt(stack.pop());
    }

    //将后缀表达式分隔为数字或者操作符，存放在list
    public static ArrayList<String> getListString(String s) {
        ArrayList<String> list = new ArrayList();
        String[] split = s.split(" ");
        for (String elem : split) {
            list.add(elem);
        }
        return list;
    }
}
