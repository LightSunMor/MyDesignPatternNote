package Pattern.Factory.abstractFactory.Cheese;

/**
 * @package_name: Pattern.Factory.abstractFactory.Cheese
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 蒙牛奶酪
 * @author: morSun
 */
public class mengniuCheese implements cheese{
    @Override
    public void introduce() {
        System.out.println("蒙牛奶酪");
    }
}
