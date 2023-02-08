package Pattern.Factory.abstractFactory.shop;

import Pattern.Factory.abstractFactory.Cheese.cheese;
import Pattern.Factory.abstractFactory.Factory.mengniuFactory;
import Pattern.Factory.abstractFactory.Factory.yiliFactory;
import Pattern.Factory.abstractFactory.Milk.Milk;

/**
 * @package_name: Pattern.Factory.abstractFactory.shop
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 超市
 * @author: morSun
 */
public class shop {
    public static void main(String[] args) {
        //想要购买伊利的奶酪
        cheese cheese = new yiliFactory().createCheese();
        cheese.introduce();

        //想要购买蒙牛牛奶
        Milk milk = new mengniuFactory().createMilk();
        milk.introduce();
    }
}
