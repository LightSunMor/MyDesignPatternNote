package Pattern.Factory.simpleFactory.Factory;

import Pattern.Factory.simpleFactory.Milk.Milk;
import Pattern.Factory.simpleFactory.Milk.mengNiuMilk;
import Pattern.Factory.simpleFactory.Milk.yiLiMilk;

/**
 * @package_name: Pattern.Factory.simpleFactory.Factory
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 静态方法工厂类
 * @author: morSun
 */
public class StaticMethodFactory {
    //提供牛奶大类产品， 如何创建不同的品牌的产品完全取决于这里面的逻辑
    public static Milk createMilk(String band)
    {
        if ("yili".equals(band))
            return new yiLiMilk();
        else if ("mengniu".equals(band))
            return new mengNiuMilk();
        else
            return null;
    }
}
