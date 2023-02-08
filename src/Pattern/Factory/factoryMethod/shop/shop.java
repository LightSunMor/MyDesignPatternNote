package Pattern.Factory.factoryMethod.shop;

import Pattern.Factory.factoryMethod.Milk.Milk;
import Pattern.Factory.factoryMethod.MilkFactory.mengNiuMilkFactory;
import Pattern.Factory.factoryMethod.MilkFactory.yiLiMilkFactory;

/**
 * @package_name: Pattern.Factory.factoryMethod.shop
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 超市
 * @author: morSun
 */
public class shop {
    public static void main(String[] args) {
        String band="mengniu";
        Milk milk =null;
        if (band.equals("yili")) {
           milk=new yiLiMilkFactory().createMilk();
        }
        else if (band.equals("mengniu"))
            milk=new mengNiuMilkFactory().createMilk();
        else
            milk=null;
        milk.introduce();
    }
}
