package Pattern.Factory.abstractFactory.Factory;

import Pattern.Factory.abstractFactory.Cheese.cheese;
import Pattern.Factory.abstractFactory.Milk.Milk;

/**
 * @package_name: Pattern.Factory.abstractFactory.Factory
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 产品工厂，既生产牛奶也生产奶酪 （解除了工厂产品一对一的情况）一个工厂可以完成多个大类的产品生产
 * @author: morSun
 */
public interface Factory {
    Milk createMilk();
    cheese createCheese();
}
