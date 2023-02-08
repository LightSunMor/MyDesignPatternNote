package Pattern.Decorate.CoffeeDecorate;

import Pattern.Decorate.Drink;

/**
 * @package_name: Pattern.Decorate.CoffeeDecorate
 * @date: 2023/1/21
 * @week: 星期六
 * @message: 糖装饰
 * @author: morSun
 */
public class Sugar extends DrinkDecorate{
    public Sugar(Drink drink) {
        super(drink);
        setDes("糖");
        setPrice(1);
    }

}
