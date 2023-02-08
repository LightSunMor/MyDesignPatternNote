package Pattern.Factory.abstractFactory.Factory;

import Pattern.Factory.abstractFactory.Cheese.cheese;
import Pattern.Factory.abstractFactory.Cheese.mengniuCheese;
import Pattern.Factory.abstractFactory.Milk.Milk;
import Pattern.Factory.abstractFactory.Milk.mengNiuMilk;

/**
 * @package_name: Pattern.Factory.abstractFactory.Factory
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 蒙牛工厂
 * @author: morSun
 */
public class mengniuFactory implements Factory{
    @Override
    public Milk createMilk() {
        return new mengNiuMilk();
    }

    @Override
    public cheese createCheese() {
        return new mengniuCheese();
    }
}
