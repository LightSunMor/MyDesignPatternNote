package Pattern.Interpreter;

import java.util.HashMap;

/**
 * @package_name: Pattern.Interpreter
 * @date: 2023/2/4
 * @week: 星期六
 * @message: 符号表达式
 * @author: morSun
 */
//需要注意这里的SymbolExpression属于非终结符号表达式的解释器，它需要聚合其他表达式一起使用
public class SymbolExpression extends AbstractExpression{

    //为什么要这两个表达式解释器？
        //因为符号表达式和自己的左右两个值有关，所以需要得到他们（他们可能是值表达式也可能是带符号的表达式）
    AbstractExpression left;
    AbstractExpression right;

    public SymbolExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }


    //继续交给子类实现
    @Override
    int interpreter(HashMap<String, Integer> var) {
        throw new UnsupportedOperationException();
    }



}
