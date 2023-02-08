package Pattern.Factory.abstractFactory.Factory;

import Pattern.Factory.abstractFactory.Cheese.cheese;
import Pattern.Factory.abstractFactory.Cheese.yiliCheese;
import Pattern.Factory.abstractFactory.Milk.Milk;
import Pattern.Factory.abstractFactory.Milk.yiLiMilk;

/**
 * @package_name: Pattern.Factory.abstractFactory.Factory
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 伊利工厂
 * @author: morSun
 */
public class yiliFactory implements Factory{
    //创建伊利牛奶
    @Override
    public Milk createMilk() {
        return new yiLiMilk();
    }

    //创建伊利奶酪
    @Override
    public cheese createCheese() {
        return new yiliCheese();
    }
}
