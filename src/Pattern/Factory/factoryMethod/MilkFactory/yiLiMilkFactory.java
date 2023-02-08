package Pattern.Factory.factoryMethod.MilkFactory;

import Pattern.Factory.factoryMethod.Milk.Milk;
import Pattern.Factory.factoryMethod.Milk.yiLiMilk;

import java.util.Collection;

/**
 * @package_name: Pattern.Factory.factoryMethod.MilkFactory
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 伊利牛奶工厂
 * @author: morSun
 */
public class yiLiMilkFactory implements MilkFactory{

    @Override
    public  Milk createMilk() {
        return new yiLiMilk();
    }
}
