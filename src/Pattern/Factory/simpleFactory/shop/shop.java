package Pattern.Factory.simpleFactory.shop;

import Pattern.Factory.simpleFactory.Factory.StaticMethodFactory;
import Pattern.Factory.simpleFactory.Milk.Milk;

/**
 * @package_name: Pattern.Factory.simpleFactory.shop
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 超市
 * @author: morSun
 */
public class shop {
    public static void main(String[] args) {
        Milk milk = StaticMethodFactory.createMilk("yili");
        milk.introduce();
    }
}
