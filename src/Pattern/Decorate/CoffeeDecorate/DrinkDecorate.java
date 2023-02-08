package Pattern.Decorate.CoffeeDecorate;

import Pattern.Decorate.Drink;

/**
 * @package_name: Pattern.Decorate.CoffeeDecorate
 * @date: 2023/1/21
 * @week: 星期六
 * @message: 抽象装饰器类
 * @author: morSun
 */
public abstract class DrinkDecorate extends Drink {
    protected Drink obj;

    public DrinkDecorate(Drink drink) {
        this.obj = drink;
    }
    @Override
    public Integer cost() {
        return obj.cost()+getPrice(); //被装饰的原本消费+单品咖啡的钱 （用到了cost递归）
    }

    //为了信息打印全面，需要重写getDes()
    @Override
    public String getDes() {
        return des+"--"+getPrice()+" & "+obj.getDes(); //输出被装饰
//        return super.getDes()+" "+getPrice()+" & "+obj.getDes(); //注意这里的getDes要用super修饰，否则造成死循环
    }
}