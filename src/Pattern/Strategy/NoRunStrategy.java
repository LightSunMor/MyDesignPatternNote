package Pattern.Strategy;

/**
 * @package_name: Pattern.Strategy
 * @date: 2023/2/6
 * @week: 星期一
 * @message:
 * @author: morSun
 */
public class NoRunStrategy implements RunStrategy{
    @Override
    public void run() {
        System.out.println("不能跑步");
    }
}
