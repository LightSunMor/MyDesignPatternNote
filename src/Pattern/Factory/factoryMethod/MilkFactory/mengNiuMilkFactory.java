package Pattern.Factory.factoryMethod.MilkFactory;

import Pattern.Factory.factoryMethod.Milk.Milk;
import Pattern.Factory.factoryMethod.Milk.mengNiuMilk;

/**
 * @package_name: Pattern.Factory.factoryMethod.MilkFactory
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 蒙牛牛奶工厂
 * @author: morSun
 */
public class mengNiuMilkFactory implements MilkFactory{
    @Override
    public Milk createMilk() {
        return new mengNiuMilk();
    }// 直接创建目标对象，不关心实现过程
}
