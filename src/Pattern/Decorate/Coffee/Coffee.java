package Pattern.Decorate.Coffee;

import Pattern.Decorate.Drink;

/**
 * @package_name: Pattern.Decorate.Coffee
 * @date: 2023/1/21
 * @week: 星期六
 * @message: 咖啡产品大类
 * @author: morSun
 */
public class Coffee extends Drink {
    @Override
    public Integer cost() {
        return getPrice(); //拿到单品咖啡的钱
    }
}
