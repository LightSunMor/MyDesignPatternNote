package Pattern.Interpreter;

import java.util.HashMap;

/**
 * @package_name: Pattern.Interpreter
 * @date: 2023/2/4
 * @week: 星期六
 * @message: 加法 表达式
 * @author: morSun
 */
public class AddExpression extends SymbolExpression{


    public AddExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    @Override
    int interpreter(HashMap<String, Integer> var) {
        return left.interpreter(var)+ right.interpreter(var);
    }
}
