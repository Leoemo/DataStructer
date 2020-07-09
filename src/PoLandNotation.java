import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 利用栈实现后缀表达式计算
 */
public class PoLandNotation {

    public static void main(String[] args) {
        String s1 = "3 4 + 5 * 6 -";
        //"7*7-12/6";
        String s2 = "7 7 * 12 6 / -";

        ArrayList<String> listString = getListString(s2);
        System.out.println(listString);
        System.out.println(getPolandNotationValue(listString));

    }

    //计算后缀表达式的计算值
    private static int getPolandNotationValue(ArrayList<String> listString) {
        Stack<String> stack = new Stack<>();
        for(String elem : listString){
            if(elem.matches("\\d+")){//正则表达式，通配多位数字的字符串，数字则压栈
                stack.push(elem);
            }
            //操作符则弹出栈顶两元素，并判断当前操作符类型，再进行计算
            else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if(elem.equals("+")){
                    res = num1 + num2;
                }
                else if(elem.equals("-")){
                    res = num2- num1;
                }
                else if(elem.equals("*")){
                    res = num1*num2;
                }
                else if(elem.equals("/")){
                    res = num2/num1;
                }
                //结果压回栈中
                stack.push(res+"");
            }

        }
        //遍历结束后栈中只有最终的结果，弹出即可
        return Integer.parseInt(stack.pop());
    }

    //将后缀表达式分隔为数字或者操作符，存放在list
    public static ArrayList<String> getListString(String s){
        ArrayList<String> list = new ArrayList();
        String[] split = s.split(" ");
        for(String elem : split){
            list.add(elem);
        }
        return list;
    }
}
