package Pattern.Decorate;

import Pattern.Decorate.Coffee.LongBlack;
import Pattern.Decorate.CoffeeDecorate.Milk;
import Pattern.Decorate.CoffeeDecorate.Sugar;

/**
 * @package_name: Pattern.Decorate
 * @date: 2023/1/21
 * @week: 星期六
 * @message: 咖啡馆
 * @author: morSun
 */
public class CoffeeBar {
    public static void main(String[] args) {
        //初始对象
        Drink order = new LongBlack();
        System.out.println(order.cost()+"￥");
        System.out.println(order.getDes());
        // 这对order扩展后的对象
        order =new Milk(order);
        System.out.println(order.cost()+"￥");
        System.out.println(order.getDes());
         // 继续扩展order对象
        order=new Sugar(order);
        System.out.println(order.cost()+"￥");
        System.out.println(order.getDes());
    }
}
