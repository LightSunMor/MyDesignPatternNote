package Pattern.Decorate.CoffeeDecorate;

import Pattern.Decorate.Drink;

/**
 * @package_name: Pattern.Decorate.CoffeeDecorate
 * @date: 2023/1/21
 * @week: 星期六
 * @message: 牛奶装饰
 * @author: morSun
 */
public class Milk extends DrinkDecorate{

    public Milk(Drink drink) {
        super(drink);
        setDes("牛奶");
        setPrice(2);
    }
}
