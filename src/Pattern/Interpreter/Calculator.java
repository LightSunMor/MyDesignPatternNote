package Pattern.Interpreter;

import java.awt.desktop.AboutHandler;
import java.util.*;

/**
 * @package_name: Pattern.Interpreter
 * @date: 2023/2/4
 * @week: 星期六
 * @message: 计算器
 * @author: morSun
 */
//指定计算原理，拿到一个表达式如何进行拆分
public class Calculator {
    //定义表达式
    private AbstractExpression expression;

    //构造函数传参，并解析
    public Calculator(String expStr)
    {
        //使用栈安排运算先后顺序
        Stack<AbstractExpression> stack=new Stack<>();
        //表达式拆分成字符数组
        char[] chars=expStr.toCharArray();

        //解析表达式，分别应该是什么解释器来解释，最后还要进行正确的运算
        AbstractExpression left=null;
        AbstractExpression right=null;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i])
            {
                case '+':
                    //如果是符号，前面必定有值表达式解释器已经加入stack
                    left=stack.pop();
                    right=new VarExpression(String.valueOf(chars[++i])); //因为当前i是符号，要++才是右边的值
                    stack.push(new AddExpression(left,right)); //将新的解释后的表达式解释器加入栈中，留着后面调用interpreter方法解释
                    break;
                case'-':
                    left=stack.pop();
                    right=new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(chars[i])));
                    break;
            }

        }
        this.expression=stack.pop();//最终组合出来的半解释表达式
    }

    //var由client获得
    public int run(HashMap<String,Integer> var)
    {
        //调用解释方法，得到结构
        return this.expression.interpreter(var);
    }
}
