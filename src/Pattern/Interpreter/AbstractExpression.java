package Pattern.Interpreter;

import java.util.HashMap;

/**
 * @package_name: Pattern.Interpreter
 * @date: 2023/2/4
 * @week: 星期六
 * @message: 抽象表达式 解释器
 * @author: morSun
 */
public abstract class AbstractExpression {
    //hashmap 获得变量的值 ； a=10,b=20

    //这个方法的意义是：表达式通过解释得到结果，所以确定返回值为int
    abstract int interpreter(HashMap<String,Integer> var);
}
