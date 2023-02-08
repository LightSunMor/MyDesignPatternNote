package Pattern.Interpreter;

import java.util.HashMap;

/**
 * @package_name: Pattern.Interpreter
 * @date: 2023/2/4
 * @week: 星期六
 * @message: 值 表达式 解释器
 * @author: morSun
 */
public class VarExpression extends AbstractExpression{

    private String key;
    public VarExpression(String key)
    {
    this.key=key;
    }

    //根据变量的名称返回对应的值
    @Override
    int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
